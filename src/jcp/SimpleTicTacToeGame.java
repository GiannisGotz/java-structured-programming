package jcp;

import java.util.Scanner;

/**
 * Simple Tic-Tac-Toe game for two players
 */
public class SimpleTicTacToeGame {
    public char[][] board = new char[3][3];
    private char currentPlayer;
    private char firstPlayer;
    private char secondPlayer;

    // Default Constructor with board initialization
    public SimpleTicTacToeGame() {
        initializeBoard();
    }

    // Initialize the board with empty cells
    public void initializeBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '\u0000'; // Using Unicode null character to represent an empty cell
            }
        }
    }

    // Checks if there is a win condition
    public boolean isWin() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '\u0000') {
                return true;
            }
        }
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '\u0000') {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '\u0000') {
            return true;
        }
        if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != '\u0000') {
            return true;
        }
        return false; // No win detected
    }

    // Prints board status
    public void printBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + (board[0][0] == '\u0000' ? " " : board[0][0]) + " | " + (board[0][1] == '\u0000' ? " " : board[0][1]) + " | " + (board[0][2] == '\u0000' ? " " : board[0][2]) + " |");
        System.out.println("|-----------|");
        System.out.println("| " + (board[1][0] == '\u0000' ? " " : board[1][0]) + " | " + (board[1][1] == '\u0000' ? " " : board[1][1]) + " | " + (board[1][2] == '\u0000' ? " " : board[1][2]) + " |");
        System.out.println("|-----------|");
        System.out.println("| " + (board[2][0] == '\u0000' ? " " : board[2][0]) + " | " + (board[2][1] == '\u0000' ? " " : board[2][1]) + " | " + (board[2][2] == '\u0000' ? " " : board[2][2]) + " |");
        System.out.println("|---|---|---|");
    }

    // Checks if the board is full
    public boolean isFull() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '\u0000') {
                    return false;
                }
            }
        }
        return true;
    }

    // Place a move on the board
    public boolean placeMove(int row, int col, char player) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '\u0000') {
            board[row][col] = player;
            return true;
        }
        return false;
    }

    // Switch to the other player
    public void changePlayer() {
        currentPlayer = (currentPlayer == firstPlayer) ? secondPlayer : firstPlayer;
    }

    public static void main(String[] args) {
        SimpleTicTacToeGame simpleTicTacToeGame = new SimpleTicTacToeGame();
        Scanner scanner = new Scanner(System.in);
        int cellX = 0;
        int cellY = 0;

        // First player chooses their symbol
        while (true) {
            System.out.println("First player, choose your symbol (X or O):");
            char chosenSymbol = scanner.next().charAt(0);
            if (chosenSymbol == 'X' || chosenSymbol == 'O') {
                simpleTicTacToeGame.firstPlayer = chosenSymbol;
                simpleTicTacToeGame.secondPlayer = (chosenSymbol == 'X') ? 'O' : 'X';
                simpleTicTacToeGame.currentPlayer = simpleTicTacToeGame.firstPlayer;
                break;
            } else {
                System.out.println("Invalid input. Please choose either X or O.");
            }
        }

        // Game loop
        while (!simpleTicTacToeGame.isWin() && !simpleTicTacToeGame.isFull()) {
            simpleTicTacToeGame.printBoard();
            System.out.println("Player " + simpleTicTacToeGame.currentPlayer + ", enter your move (row and column with ranges 0-2):");
            cellX = scanner.nextInt();
            cellY = scanner.nextInt();
            if (simpleTicTacToeGame.placeMove(cellX, cellY, simpleTicTacToeGame.currentPlayer)) {
                simpleTicTacToeGame.changePlayer();
            } else {
                System.out.println("This move is not valid. Try again.");
            }
        }
        simpleTicTacToeGame.printBoard();
        if (simpleTicTacToeGame.isWin()) {
            simpleTicTacToeGame.changePlayer(); // The player who made the winning move is the previous player
            System.out.println("We have a winner! Congratulations, Player " + simpleTicTacToeGame.currentPlayer + "!\nThanks for playing!");
        } else if (simpleTicTacToeGame.isFull()) {
            System.out.println("The board is full. It's a draw!\nThanks for playing!");
        }

    }
}