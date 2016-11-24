package diceGameTest;

import static org.junit.Assert.*;
import org.junit.Test;

import desktop_resources.GUI;
import diceGame.Player;

public class GameTest {

	/**
	 * UC01: Land on Fleet
	 * Player lands on field 4
	 */
	@Test
	public void TC01() {
		int startBalance = 5000;
		int[] diceValues = new int[]{2,2};
		int price = 4000;
		int rent = 500;
		
	//First case we let the player buy the fleet
		GameTestMode game = new GameTestMode();
		
		DiceCupTestMode dice = new DiceCupTestMode(2,6);
		dice.setValues(diceValues);
		Player nextPlayer = game.playTurn(game.getPlayers()[0], dice);

		assertEquals(nextPlayer, game.getPlayers()[1]);
		assertEquals(game.getPlayers()[0].getBalance(), startBalance-price);
		
	//Second case we let the second player pay rent to owner
		dice.setValues(diceValues);
		nextPlayer = game.playTurn(game.getPlayers()[1], dice);
		
		assertEquals(nextPlayer, game.getPlayers()[0]);
		assertEquals(game.getPlayers()[1].getBalance(), startBalance-rent);
		assertEquals(game.getPlayers()[0].getBalance(), startBalance-price+rent);
		
		GUI.close();
	}

	/**
	 * UC02: Land on Territory
	 * Player lands on field 3
	 */
	@Test
	public void TC02() {
		int startBalance = 5000;
		int[] diceValues = new int[]{2,1};
		int price = 1000;
		int rent = 100;
		
	//First case we let the player buy the territory
		GameTestMode game = new GameTestMode();
		DiceCupTestMode dice = new DiceCupTestMode(2,6);
		dice.setValues(diceValues);
		Player nextPlayer = game.playTurn(game.getPlayers()[0], dice);

		assertEquals(nextPlayer, game.getPlayers()[1]);
		assertEquals(game.getPlayers()[0].getBalance(), startBalance-price);
		
	//Second case we let the second player pay rent to owner
		dice.setValues(diceValues);
		nextPlayer = game.playTurn(game.getPlayers()[1], dice);
		
		assertEquals(nextPlayer, game.getPlayers()[0]);
		assertEquals(game.getPlayers()[1].getBalance(), startBalance-rent);
		assertEquals(game.getPlayers()[0].getBalance(), startBalance-price+rent);
		
		GUI.close();
	}

	/**
	 * UC03: Land on Refuge
	 * Player lands on field 12
	 */
	@Test
	public void TC03() {
		int startBalance = 5000;
		int[] diceValues = new int[]{6,6};
		int bonus = 500;
		
	//Player lands on refuge and receives bonus
		GameTestMode game = new GameTestMode();
		DiceCupTestMode dice = new DiceCupTestMode(2,6);
		dice.setValues(diceValues);
		Player nextPlayer = game.playTurn(game.getPlayers()[0], dice);

		assertEquals(nextPlayer, game.getPlayers()[1]);
		assertEquals(game.getPlayers()[0].getBalance(), startBalance+bonus);
		
		GUI.close();
	}

	/**
	 * UC04: Land on Labor Camp
	 * Player lands on field 7
	 */
	@Test
	public void TC04() {
		int startBalance = 5000;
		int[] diceValues = new int[]{3,4};
		int price = 2500;
		int rent = 100*7;
		
	//First case we let the player buy the territory
		GameTestMode game = new GameTestMode();
		DiceCupTestMode dice = new DiceCupTestMode(2,6);
		dice.setValues(diceValues);
		Player nextPlayer = game.playTurn(game.getPlayers()[0], dice);

		assertEquals(nextPlayer, game.getPlayers()[1]);
		assertEquals(game.getPlayers()[0].getBalance(), startBalance-price);
		
	//Second case we let the second player pay rent to owner
		dice.setValues(diceValues);
		nextPlayer = game.playTurn(game.getPlayers()[1], dice);

		assertEquals(nextPlayer, game.getPlayers()[0]);
		assertEquals(game.getPlayers()[1].getBalance(), startBalance-rent);
		assertEquals(game.getPlayers()[0].getBalance(), startBalance-price+rent);
		
		GUI.close();
	}

	/**
	 * UC05: Land on Tax
	 * Player lands on field 2 + 13
	 */
	@Test
	public void TC05() {
		int startBalance = 5000;
		int[] diceValues = new int[]{1,1};
		int taxAmount = 2000;
		
	//First case player lands on field 2
		GameTestMode game = new GameTestMode();
		DiceCupTestMode dice = new DiceCupTestMode(2,6);
		dice.setValues(diceValues);
		Player nextPlayer = game.playTurn(game.getPlayers()[0], dice);

		assertEquals(nextPlayer, game.getPlayers()[1]);
		assertEquals(game.getPlayers()[0].getBalance(), startBalance-taxAmount);
		
	//Second case player lands on field 13
		double taxRate = 0.1;
		diceValues = new int[]{5,6};
		dice.setValues(diceValues);
		nextPlayer = game.playTurn(game.getPlayers()[0], dice);

		assertEquals(nextPlayer, game.getPlayers()[1]);
		assertEquals((int)(game.getPlayers()[0].getBalance()),(int)(startBalance-taxAmount-(taxRate*(startBalance-taxAmount))));

		GUI.close();
	}

}
