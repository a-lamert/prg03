import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicTacToeGameTest {

  private char[][] board;
  private char currentPlayer;
  private boolean gameOver;

  @BeforeEach
  public void setUp() {
    board = new char[3][3];
    currentPlayer = 'X';
    initializeBoard();
    gameOver = false;
  }

  private void initializeBoard() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        board[i][j] = '-';
      }
    }
  }

  private void printBoard() {

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  private boolean isValidMove(int row, int col) {
    return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
  }

  private void makeMove(int row, int col) {
    board[row][col] = currentPlayer;
    switchPlayer();
  }


  private void switchPlayer() {
    currentPlayer = (currentPlayer == 'X') ?'O': 'X';
  }

  private boolean checkWin() {

    for (int i = 0; i < 3; i++) {
      if (board[i][0] == currentPlayer && board[i][1] == currentPlayer
          && board[i][2] == currentPlayer) {
        return true;
      }
    }

    for (int i = 0; i < 3; i++) {
      if (board[0][i] == currentPlayer && board[1][i] == currentPlayer
          && board[2][i] == currentPlayer) {
        return true;
      }
    }

    if (board[0][0] == currentPlayer && board[1][1] == currentPlayer
        && board[2][2] == currentPlayer) {
      return true;
    }

    if (board[0][2] == currentPlayer && board[1][1] == currentPlayer
        && board[2][0] == currentPlayer) {
      return true;
    }
    return false;
  }

  private boolean checkDraw() {

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[i][j] == '-') {
          return false;
        }
      }
    }
    gameOver = true;
    return true;
  }

  @Test
  public void testValidMove() {
    assertTrue(isValidMove(0, 0));
    assertTrue(isValidMove(1, 2));
    assertTrue(isValidMove(2, 1));
    assertFalse(isValidMove(-1, 0));
    assertFalse(isValidMove(0, -1));
    assertFalse(isValidMove(3, 2));
    assertFalse(isValidMove(2, 3));
  }

  @Test
  public void testCheckWinHorizontal() {

    board[0][0] = 'X';
    board[0][1] = 'X';
    board[0][2] = 'X';
    assertTrue(checkWin());
  }

  @Test
  public void testCheckWinVertical() {

    board[0][0] = 'X';
    board[1][0] = 'X';
    board[2][0] = 'X';
    assertTrue(checkWin());
  }

  @Test
  public void testCheckWinDiagonal() {

    board[0][0] = 'X';
    board[1][1] = 'X';
    board[2][2] = 'X';
    assertTrue(checkWin());
  }
}
