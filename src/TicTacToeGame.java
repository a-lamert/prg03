import java.util.Scanner;

public class TicTacToeGame {

  private char[][] board;
  private char currentPlayer;
  private boolean gameOver;

  public TicTacToeGame() {
    board = new char[3][3];
    currentPlayer = 'X';
    initializeBoard();
  }

  /**
   * Initializes the game board with empty spaces.
   */
  private void initializeBoard() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        board[i][j] = '-';
      }
    }
  }

  /**
   * Starts the game loop, allowing players to take turns until the game is over. Prompts the
   * current player to enter their move
   */


  public void play() {
    Scanner scanner = new Scanner(System.in);
    while (!gameOver) {
      printBoard();
      System.out.println("Player: " + currentPlayer
          + ", Enter the line number (0-2) and column (0-2), space separation: ");
      int row, col;
      while (true) {
        try {
          row = scanner.nextInt();
          col = scanner.nextInt();
          break;
        } catch (java.util.InputMismatchException e) {
          System.out.println("Invalid input. Enter valid integer values for row and column.");
          scanner.nextLine();
        }
      }

      if (isValidMove(row, col)) {
        board[row][col] = currentPlayer;
        if (checkWin()) {
          System.out.println("Player: " + currentPlayer + "wins! ");
          gameOver = true;
        } else if (checkDraw()) {
          System.out.println(" It'S a tie!");
          gameOver = true;
        } else {
          switchPlayer();
        }

      } else {
        System.out.println("Invalid move. Try again: ");
      }
    }
  }


  /**
   * Prints the current state of the game board.
   */
  private void printBoard() {
    System.out.println("_____________");
    for (int i = 0; i < 3; i++) {
      System.out.print("| ");
      for (int j = 0; j < 3; j++) {
        System.out.print(board[i][j] + " | ");
      }
      System.out.println();
      System.out.println("\n_____________");
    }
  }

  /**
   * Checks if a move is valid at the specified row and column.
   *
   * @param row The row index.
   * @param col the column index.
   * @return True if the move is valid, false otherwise.
   */
  private boolean isValidMove(int row, int col) {
    return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
  }

  private void switchPlayer() {
    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
  }

  /**
   * Checks if the current player has won the game.
   *
   * @return True if the current player has won, false otherwise.
   */
  private boolean checkWin() {
    for (int i = 0; i < 3; i++) {
      if (board[i][0] == currentPlayer && board[i][1] == currentPlayer
          && board[i][2] == currentPlayer) {
        return true;
      }
      if (board[0][i] == currentPlayer && board[1][i] == currentPlayer
          && board[2][i] == currentPlayer) {
        return true;
      }
    }
    if (board[0][0] == currentPlayer && board[1][1] == currentPlayer
        && board[2][2] == currentPlayer) {
      return true;
    }
    return board[0][2] == currentPlayer && board[1][1] == currentPlayer
        && board[2][0] == currentPlayer;
  }

  /**
   * Checks if the  game is a draw  by iterating through the game board to find
   * any empty cells ('-').
   *
   * @return true if the game is  a draw, false otherwise.
   */
  private boolean checkDraw() {

    boolean hasEmptyCell = false;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[i][j] == '-') {
          hasEmptyCell = true;
          break;
        }
      }
      if (hasEmptyCell) {
        break;
      }

    }
    if (!hasEmptyCell && !checkWin()) {
      gameOver = true;
      return true;
    } else {
      return false;
    }
  }
}


