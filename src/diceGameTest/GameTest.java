package diceGameTest;

import static org.junit.Assert.*;
import org.junit.Test;

import diceGame.Player;

public class GameTest {

	/**
	 * UC01: Land on Fleet
	 */
	@Test
	public void TC01() {
		int startBalance = 5000;
		
	//First case we let the player buy the field
		GameTestMode game = new GameTestMode();
		
		DiceCupTestMode dice = new DiceCupTestMode(2,6);
		dice.setValues(new int[]{2,2});
		Player nextPlayer = game.playTurn(game.getPlayers()[0], dice);

		assertEquals(nextPlayer, game.getPlayers()[1]);
		assertEquals(game.getPlayers()[0].getBalance(), startBalance-4000);
		
	//Second case we let the second player pay rent to owner
		dice.setValues(new int[]{2,2});
		nextPlayer = game.playTurn(game.getPlayers()[1], dice);

		assertEquals(nextPlayer, game.getPlayers()[0]);
		assertEquals(game.getPlayers()[1].getBalance(), startBalance-500);
	}

}
