package com.bptn.project._tictactoeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Main class for the Tic Tac Toe game
public class TicTacToe extends JFrame implements ActionListener {
	private JButton[][] buttons = new JButton[3][3]; // 2D array to hold game buttons
	private JLabel xScoreLabel; // Label to display X's score
	private JLabel oScoreLabel; // Label to display O's score
	private JLabel tieLabel; // Label to display number of ties
	private JLabel statusLabel; // Label to show current player's turn
	private JButton winnerButton; // Button to display the winner message
	private JLabel titleLabel; // Title label for the score section
	private JPanel sidePanel; // Panel for scores and controls
	private GameLogic gameLogic = new GameLogic(); // Instance of the game logic class
	private JButton newGameButton;
	private JButton newGameButton_1;

	// Constructor to set up the GUI
	public TicTacToe() {
		setTitle("Tic Tac Toe"); // Set the title of the window
		setSize(800, 500); // Set the window size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit application on close
		getContentPane().setLayout(new BorderLayout()); // Use border layout for main container

		// Side panel setup for displaying scores and controls
		sidePanel = new JPanel();
		sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS)); // Vertical layout for side panel
		sidePanel.setBackground(new Color(31, 31, 31)); // Set background color
		sidePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Border for side panel
		sidePanel.setPreferredSize(new Dimension(200, 400)); // Preferred size for side panel

		// Main panel setup
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBackground(new Color(157, 157, 0)); // Set background color for main panel

		// Control panel setup with a New Game button
		JPanel controlPanel = new JPanel();
		controlPanel.setBackground(new Color(157, 157, 0)); // Match main panel color
		newGameButton = new JButton("New Game"); // Create a New Game button
		newGameButton.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20)); // Set button font
		newGameButton.setBackground(new Color(0, 0, 0)); // Set button background color
		newGameButton.setForeground(Color.WHITE); // Set button text color
		newGameButton.setFocusPainted(false); // Disable focus painting for the button
		newGameButton.setPreferredSize(new Dimension(190, 35)); // Set button size
		newGameButton.addActionListener(e -> newGame());

		// Control panel setup with a Reset Game button
		newGameButton_1 = new JButton("Reset Game");
		newGameButton_1.setPreferredSize(new Dimension(190, 35));
		newGameButton_1.setForeground(Color.WHITE);
		newGameButton_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		newGameButton_1.setFocusPainted(false);
		newGameButton_1.setBackground(Color.BLACK);
		controlPanel.add(newGameButton_1);
		controlPanel.add(newGameButton); // Add button to control panel
		newGameButton_1.addActionListener(e -> resetGame());

		// Game panel setup with buttons for the Tic Tac Toe grid
		JPanel gamePanel = new JPanel(new GridLayout(3, 3)); // 3x3 grid layout for game buttons
		gamePanel.setBackground(new Color(157, 157, 0)); // Set background color for game panel
		initializeButtons(gamePanel); // Initialize buttons for the game panel

		// Image label setup for displaying an image
		JLabel imageLabel = new JLabel();
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/boyGamer.png")); // Load image
		Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Scale image
		ImageIcon scaledIcon = new ImageIcon(scaledImage); // Create new ImageIcon with scaled image
		imageLabel.setIcon(scaledIcon); // Set icon for image label
		imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align the image
		sidePanel.add(imageLabel); // Add image label to side panel
		sidePanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space

		// Setting up score labels and status label
		titleLabel = new JLabel("SCORE COUNT"); // Title label for score section
		titleLabel.setAlignmentX(0.5f); // Center align the title
		xScoreLabel = new JLabel("X: 0"); // Score label for X
		xScoreLabel.setAlignmentX(0.5f); // Center align
		oScoreLabel = new JLabel("O: 0"); // Score label for O
		oScoreLabel.setAlignmentX(0.5f); // Center align
		tieLabel = new JLabel("Ties: 0"); // Label for ties
		tieLabel.setAlignmentX(0.5f); // Center align
		statusLabel = new JLabel("X's Turn"); // Status label for current player's turn
		statusLabel.setAlignmentX(0.5f); // Center align

		// Set font and color for labels
		titleLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		xScoreLabel.setFont(new Font("Arial", Font.BOLD, 18));
		oScoreLabel.setFont(new Font("Arial", Font.BOLD, 18));
		tieLabel.setFont(new Font("Arial", Font.BOLD, 18));
		statusLabel.setFont(new Font("Arial", Font.ITALIC, 16));

		titleLabel.setForeground(Color.WHITE); // Set text color for title
		xScoreLabel.setForeground(Color.WHITE); // Set text color for X score
		oScoreLabel.setForeground(Color.WHITE); // Set text color for O score
		tieLabel.setForeground(Color.WHITE); // Set text color for ties
		statusLabel.setForeground(Color.WHITE); // Set text color for status

		// Adding score labels to the side panel
		sidePanel.add(titleLabel);
		sidePanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add space
		sidePanel.add(xScoreLabel);
		sidePanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add space
		sidePanel.add(oScoreLabel);
		sidePanel.add(Box.createRigidArea(new Dimension(0, 40))); // Add space
		sidePanel.add(tieLabel);
		sidePanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add space
		sidePanel.add(statusLabel);

		// Winner button setup (hidden initially)
		winnerButton = new JButton("Tic Tac Toe!"); // Button to display winner message
		winnerButton.setBorderPainted(false); // Remove border painting
		winnerButton.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15)); // Set button font
		winnerButton.setBackground(new Color(31, 31, 31)); // Set background color
		winnerButton.setForeground(new Color(128, 0, 0)); // Set text color
		winnerButton.setFocusPainted(false); // Disable focus painting
		winnerButton.setVisible(false); // Initially hidden
		winnerButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align
		sidePanel.add(Box.createRigidArea(new Dimension(0, 40))); // Add space
		sidePanel.add(winnerButton); // Add winner button to side panel

		// Add panels to the main panel
		mainPanel.add(controlPanel, BorderLayout.NORTH); // Add control panel at the top
		mainPanel.add(gamePanel, BorderLayout.CENTER); // Add game panel in the center
		mainPanel.add(sidePanel, BorderLayout.EAST); // Add side panel on the right

		getContentPane().add(mainPanel, BorderLayout.CENTER); // Add main panel to the content pane
		setVisible(true); // Make the window visible
	}

	// Initialize buttons for the Tic Tac Toe grid
	private void initializeButtons(JPanel panel) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				buttons[i][j] = new JButton(""); // Create a button with no text
				buttons[i][j].setFont(new Font("Arial", Font.BOLD, 60)); // Set font size for buttons
				buttons[i][j].setFocusPainted(false); // Disable focus painting
				buttons[i][j].setBackground(new Color(156, 156, 0)); // Match button background color
				buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.black, 5)); // Set button border
				buttons[i][j].addActionListener(this); // Add action listener for button clicks
				panel.add(buttons[i][j]); // Add button to the panel
			}
		}
	}

	// Handle button click events
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonClicked = (JButton) e.getSource(); // Get the button that was clicked
		int row = -1, col = -1;

		// Find the row and column of the clicked button
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (buttons[i][j] == buttonClicked) {
					row = i; // Set row index
					col = j; // Set column index
				}
			}
		}

		if (!buttonClicked.getText().equals("")) {
			// Show error message in GUI
			JOptionPane.showMessageDialog(this, "Error: Cell already occupied.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		// Validation 3: Check if New Game button is clicked when no game is ongoing
		if (e.getSource() == newGameButton && (gameLogic.getWinner() != null || gameLogic.isBoardFull())) {
			// Show error message in GUI
			JOptionPane.showMessageDialog(this, "Error: New game cannot be started mid-game.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (buttonClicked.getText().equals("") && row != -1 && col != -1) {
			String symbol = gameLogic.isXTurn() ? "X" : "O";
			buttonClicked.setText(symbol);
			buttonClicked.setForeground(gameLogic.isXTurn() ? Color.GREEN : Color.BLUE);

			gameLogic.setBoardValue(row, col, symbol);
			gameLogic.switchTurn();

			statusLabel.setText(gameLogic.isXTurn() ? "X's Turn" : "O's Turn");
			checkGameStatus();
		}
	}

	private void checkGameStatus() {
		String winner = gameLogic.getWinner();
		if (winner != null) {
			gameLogic.updateScores(winner);
			xScoreLabel.setText("X: " + gameLogic.getXScore());
			oScoreLabel.setText("O: " + gameLogic.getOScore());
			tieLabel.setVisible(false); // Hide the tie message if there is a winner

			// Set the winner message and make it visible
			winnerButton.setText("Tic Tac Toe! " + winner + " Wins!");
			winnerButton.setVisible(true);

			JOptionPane.showMessageDialog(this, winner + " Wins!");
			resetGame();
		} else if (gameLogic.isBoardFull()) {
			gameLogic.updateScores("Tie");
			tieLabel.setText("It's a tie");
			tieLabel.setVisible(true);

			winnerButton.setVisible(false);// Hide the winner button on a tie

			JOptionPane.showMessageDialog(this, "It's a tie!");// Show tie popup
			resetGame();// Reset game board
		}
	}

	private void resetGame() {
		// Clear the game board regardless of the current state
		for (JButton[] row : buttons) {
			for (JButton button : row) {
				button.setText(""); // Clear button text
			}
		}

		// Reset the game logic and scores
		gameLogic.resetBoard(); // Reset game logic to start fresh
		statusLabel.setText("X's Turn"); // Reset the status label
		winnerButton.setVisible(false); // Hide the winner button

	}

	private void newGame() {
		// Reset the game board
		resetGame(); // Reset board

		// Reset the scores
		gameLogic.resetScores(); // Reset scores
		xScoreLabel.setText("X: 0"); // Reset X's score label
		oScoreLabel.setText("O: 0"); // Reset O's score label
		tieLabel.setText("Ties: 0"); // Reset tie count label
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(TicTacToe::new);
	}
}
