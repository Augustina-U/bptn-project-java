package com.bptn.project._tictactoeGame;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameLogicTest {

	@Test
	public void testSwitchTurn() {
		GameLogic game = new GameLogic();
		assertTrue(game.isXTurn());
		game.switchTurn();
		assertFalse(game.isXTurn());
	}

	@Test
	public void testUpdateScores() {
		GameLogic game = new GameLogic();
		game.updateScores("X");
		assertEquals(1, game.getXScore());
		game.updateScores("O");
		assertEquals(1, game.getOScore());
	}

	@Test
	public void testResetBoard() {
		GameLogic game = new GameLogic();
		game.setBoardValue(0, 0, "X");
		game.resetBoard();
		assertNull(game.getWinner());
	}

	@Test
	public void testGetWinner() {
		GameLogic game = new GameLogic();
		game.setBoardValue(0, 0, "X");
		game.setBoardValue(0, 1, "X");
		game.setBoardValue(0, 2, "X");
		assertEquals("X", game.getWinner());
	}

	@Test
	public void testIsBoardFull() {
		GameLogic game = new GameLogic();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				game.setBoardValue(i, j, "X");
			}
		}
		assertTrue(game.isBoardFull());
	}
}
