# **Project TicTacToeGame**
____________________________________________________________________
## Project idea:
Creating a  final project on the topic:
Console-based Tic-Tac-Toe game as part of the basic JAVA programming course.
---
## Technical Requirements:
* Language Version: JAVA 8.
* IntelliJ IDEA, openjdk-20.0.2.
* The program has been tested with JUnit 5.
* Entry Point: [Andreas Lamert](https://github.com/AndreasLamert/TicTacToeGame/Main.git)
---
## Functions:
* Run the 'Main' class to start the game.
* Take Turns: Players alternative turns,with 'X' and 'O' symbols.
* Winning: Get three of your symbols in a row horizontally,vertically,or diagonally to win.
* Draw: If all cells are filled and no one wins, it's a draw.
* Restart: After the game ends,restart and play again.

---
## Function and Structure:
#### *Main:*
* The Main class contains the main method, 
* which creates an instance of the TicTacToeGame and starts the game loop using the play() method.

* for example:


* public class Main {
* public static void main(String[] args) {
* TicTacToeGame game = new TicTacToeGame();
* game.play();
  }
}
___
## It s important:


* In the TicTacToeGame class, 
* the try-catch block is used within the play() method to handle potential errors when the player enters data. 
* If the player enters incorrect values (e.g., text instead of numbers), 
* the try-catch block catches the InputMismatchException and displays an error message, 
* indicating the need to input valid integers for the row and column.


___

* *Class Methods TicTacToeGame*
    * public  void play(): Starts the game loop,allowing players to take turns until the game is over.
    * private void initializeBoard(): Initializes the game board with empty spaces.
    * private void printBoard(): Prints the current state of the game board.
    * private boolean isValidMove(int row,int col):Checks if a move is valid at the specified row and column.
    * private void switchPlayer():Switches the current player between 'X' and 'O'.
    * private boolean checkWin(): Checks if the current player has won the game.
    * private boolean checkDraw(): Checks if the game board to find any empty cells('-').
#### *TicTacToeGameTest:*
the class contains Junit tests for the TicTacToeGame class:
* public void testValidMove(): Tests the isValidMove method to check if moves are valid.
* public void testCheckWinHorizontal(): Tests the checkWin method for horizontal wins.
* public void testCheckWinVertical(): Tests the checkWin method for vertical wins.
* public void testsCheckWinDiagonal(): Tests the checkWin method diagonal wins.
---
## Download:
https://github.com/a-lamert/prg03.git
---
## Author
* [Andreas Lamert]
## License
* [Mit Licence]
  * this file is written using the **Markdown** text markup language.