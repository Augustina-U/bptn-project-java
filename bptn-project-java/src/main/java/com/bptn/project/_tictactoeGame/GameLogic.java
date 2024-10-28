package com.bptn.project._tictactoeGame;

import java.util.Arrays;

public class GameLogic {
	// 2D array representing the Tic-Tac-Toe board
	private final String[][] board;
	// Boolean to track whose turn it is (true for X's turn, false for O's turn)
	private boolean xTurn;
	// Scores for both players and tie count
	private int xScore;
	private int oScore;
	private int tieCount;

	// Constructor initializes the game state
	public GameLogic() {
		this.board = new String[3][3]; // Create a 3x3 board
		this.xTurn = true; // X starts first
		resetBoard(); // Reset the board to empty state
	}

	// Check if it's X's turn
	public boolean isXTurn() {
		return xTurn;
	}

	// Switch turn between players
	public void switchTurn() {
		xTurn = !xTurn; // Toggle the turn
	}

	// Reset the board to empty state for a new game
	public void resetBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = ""; // Clear each cell
			}
		}
		xTurn = true; // Reset to X's turn
	}

	// Reset the board to empty state for a new game
	public void resetScores() {
		xScore = 0; // Reset X's score
		oScore = 0; // Reset O's score
		tieCount = 0; // Reset tie count
	}

	// Check for a winner in the game
	public String getWinner() {
		// Check each row for a winner
		for (int i = 0; i < 3; i++) {
			if (Arrays.stream(board[i]).distinct().count() == 1 && !board[i][0].isEmpty()) {
				return board[i][0]; // Return the winner if found
			}
		}

		// Check each column for a winner
		for (int i = 0; i < 3; i++) {
			String[] column = { board[0][i], board[1][i], board[2][i] };
			if (Arrays.stream(column).distinct().count() == 1 && !column[0].isEmpty()) {
				return column[0]; // Return the winner if found
			}
		}

		// Check the first diagonal for a winner
		String[] diagonal1 = { board[0][0], board[1][1], board[2][2] };
		if (Arrays.stream(diagonal1).distinct().count() == 1 && !diagonal1[0].isEmpty()) {
			return diagonal1[0]; // Return the winner if found
		}

		// Check the second diagonal for a winner
		String[] diagonal2 = { board[0][2], board[1][1], board[2][0] };
		if (Arrays.stream(diagonal2).distinct().count() == 1 && !diagonal2[0].isEmpty()) {
			return diagonal2[0]; // Return the winner if found
		}

		return null; // Return null if no winner is found
	}

	// Check if the board is full (i.e., no empty cells)
	public boolean isBoardFull() {
		for (String[] row : board) {
			for (String cell : row) {
				if (cell.isEmpty()) {
					return false; // Return false if any cell is empty
				}
			}
		}
		return true; // Return true if all cells are filled
	}

	// Set the value of a specific cell on the board
	public void setBoardValue(int row, int col, String value) {
		board[row][col] = value; // Update the board cell with the player's move
	}

	// Get the current score of player X
	public int getXScore() {
		return xScore;
	}

	// Get the current score of player O
	public int getOScore() {
		return oScore;
	}

	// Get the count of ties
	public int getTieCount() {
		return tieCount;
	}

	// Update the scores based on the winner of the game
	public void updateScores(String winner) {
		if (winner.equals("X")) {
			xScore++; // Increment X's score if X wins
		} else if (winner.equals("O")) {
			oScore++; // Increment O's score if O wins
		} else {
			tieCount++; // Increment tie count if there is no winner
		}
	}
}
