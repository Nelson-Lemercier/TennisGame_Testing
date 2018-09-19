import static org.junit.Assert.*;

import org.junit.Test;


public class TennisGameTest {
	
// Here is the format of the scores: "player1Score - player2Score"
// "love - love"
// "15 - 15"
// "30 - 30"
// "deuce"
// "15 - love", "love - 15"
// "30 - love", "love - 30"
// "40 - love", "love - 40"
// "30 - 15", "15 - 30"
// "40 - 15", "15 - 40"
// "player1 has advantage"
// "player2 has advantage"
// "player1 wins"
// "player2 wins"
	@Test
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		
	}
	
	@Test
	public void testTennisGame_EachPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		// This statement should cause an exception
		game.player1Scored();			
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player2WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		// This statement should cause an exception
		game.player2Scored();			
	}
	
	@Test
	public void testTennisGame_Player1HasAdvantage() throws TennisGameException {
		
		//Arrange
		TennisGame game = new TennisGame();
	
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		
		//Act
		
		String score = game.getScore();
		
		//Assert
		
		assertEquals("Advantage player 1 incorrect", "player1 has advantage", score);
		
	}
	
	@Test
	public void testTennisGame_Player2HasAdvantage() throws TennisGameException {
		
		//Arrange
		TennisGame game = new TennisGame();
	
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player2Scored();
		
		//Act
		
		String score = game.getScore();
		
		//Assert
		
		assertEquals("Advantage player 2 incorrect", "player2 has advantage", score);
		
	}
	
	@Test
	public void testTennisGame_Player1BackToDeuce() throws TennisGameException {
		
		//Arrange
		TennisGame game = new TennisGame();
	
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		
		game.player2Scored();
		
		//Act
		
		String score = game.getScore();
		
		//Assert
		
		assertEquals("Player 1 back to deuce is incorrect", "deuce", score);
		
	}
	
	@Test
	public void testTennisGame_Player2BackToDeuce() throws TennisGameException {
		
		//Arrange
		TennisGame game = new TennisGame();
	
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		
		//Act
		
		String score = game.getScore();
		
		//Assert
		
		assertEquals("Player 2 back to deuce is incorrect", "deuce", score);
		
	}
	
	@Test
	public void testTennisGame_Player1AdvantageThenPlayer2() throws TennisGameException {
		
		//Arrange
		TennisGame game = new TennisGame();
	
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();	
		
		//Act
		
		String score = game.getScore();
		
		//Assert
		
		assertEquals("Player 1 advantage then player 2 advantage incorrect", "player2 has advantage", score);
		
	}
	
	@Test
	public void testTennisGame_Player2AdvantageThenPlayer1() throws TennisGameException {
		
		//Arrange
		TennisGame game = new TennisGame();
	
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player1Scored();	
		
		//Act
		
		String score = game.getScore();
		
		//Assert
		
		assertEquals("Player 2 advantage then player 1 advantage incorrect", "player1 has advantage", score);
		
	}
	
	@Test
	public void testTennisGame_Player1_15Player2_0() throws TennisGameException {
		
		//Arrange
		TennisGame game = new TennisGame();
	
		game.player1Scored();
		
		//Act
		
		String score = game.getScore();
		
		//Assert
		
		assertEquals("15 - 0 incorrect", "love - 15", score);
		
	}
	
	@Test
	public void testTennisGame_Player1_0Player2_15() throws TennisGameException {
		
		//Arrange
		TennisGame game = new TennisGame();
	
		game.player2Scored();
		
		//Act
		
		String score = game.getScore();
		
		//Assert
		
		assertEquals("0 - 15 incorrect", "15 - love", score);
		
	}
	
	@Test
	public void testTennisGame_Player1_30Player2_0() throws TennisGameException {
		
		//Arrange
		TennisGame game = new TennisGame();
	
		game.player1Scored();
		game.player1Scored();
		
		//Act
		
		String score = game.getScore();
		
		//Assert
		
		assertEquals("30 - 0 incorrect", "love - 30", score);
		
	}
	
	@Test
	public void testTennisGame_Player1_0_Player2_30() throws TennisGameException {
		
		//Arrange
		TennisGame game = new TennisGame();
	
		game.player2Scored();
		game.player2Scored();
		
		//Act
		
		String score = game.getScore();
		
		//Assert
		
		assertEquals("0 - 30 incorrect", "30 - love", score);
		
	}

	@Test
	public void testTennisGame_Player1_40_Player2_0() throws TennisGameException {
		
		//Arrange
		TennisGame game = new TennisGame();
	
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		//Act
		
		String score = game.getScore();
		
		//Assert
		
		assertEquals("40 - 0 incorrect", "love - 40", score);
	}
	
	@Test
	public void testTennisGame_Player1_0_Player2_40() throws TennisGameException {
		
		//Arrange
		TennisGame game = new TennisGame();
	
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		//Act
		
		String score = game.getScore();
		
		//Assert
		
		assertEquals("0 - 40 incorrect", "40 - love", score);
	}
	
	@Test
	public void testTennisGame_Player1_15_Player2_15() throws TennisGameException {
		
		//Arrange
		TennisGame game = new TennisGame();
	
		game.player1Scored();
		game.player2Scored();
		
		//Act
		
		String score = game.getScore();
		
		//Assert
		
		assertEquals("15 - 15 incorrect", "15 - 15", score);
	}
	
	@Test
	public void testTennisGame_Player1_30_Player2_30() throws TennisGameException {
		
		//Arrange
		TennisGame game = new TennisGame();
	
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		
		//Act
		
		String score = game.getScore();
		
		//Assert
		
		assertEquals("30 - 30 incorrect", "30 - 30", score);
	}
	
	@Test
	public void testTennisGame_deuce() throws TennisGameException {
		
		//Arrange
		TennisGame game = new TennisGame();
	
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		//Act
		
		String score = game.getScore();
		
		//Assert
		
		assertEquals("deuce incorrect", "deuce", score);
	}
	
	@Test
	public void testTennisGame_Player1_30_Player2_15() throws TennisGameException {
		
		//Arrange
		TennisGame game = new TennisGame();
	
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		
		//Act
		
		String score = game.getScore();
		
		//Assert
		
		assertEquals("30 - 15 incorrect", "15 - 30", score);
	}
	
	@Test
	public void testTennisGame_Player1_15_Player2_30() throws TennisGameException {
		
		//Arrange
		TennisGame game = new TennisGame();
	
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		
		//Act
		
		String score = game.getScore();
		
		//Assert
		
		assertEquals("15 - 30 incorrect", "30 - 15", score);
	}
	
	@Test
	public void testTennisGame_Player1_40_Player2_15() throws TennisGameException {
		
		//Arrange
		TennisGame game = new TennisGame();
	
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		
		//Act
		
		String score = game.getScore();
		
		//Assert
		
		assertEquals("40 - 15 incorrect", "15 - 40", score);
	}
	
	@Test
	public void testTennisGame_Player1_15_Player2_40() throws TennisGameException {
		
		//Arrange
		TennisGame game = new TennisGame();
	
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		//Act
		
		String score = game.getScore();
		
		//Assert
		
		assertEquals("15 - 40 incorrect", "40 - 15", score);
	}
	
	@Test
	public void testTennisGame_Player1_wins() throws TennisGameException {
		
		//Arrange
		TennisGame game = new TennisGame();
	
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		//Act
		
		String score = game.getScore();
		
		//Assert
		
		assertEquals("Player1 wins incorrect", "player1 wins", score);
	}
	
	@Test
	public void testTennisGame_Player2_wins() throws TennisGameException {
		
		//Arrange
		TennisGame game = new TennisGame();
	
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		//Act
		
		String score = game.getScore();
		
		//Assert
		
		assertEquals("Player2 wins incorrect", "player2 wins", score);
	}
	
	
}
