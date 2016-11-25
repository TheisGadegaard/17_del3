package diceGameTest;

import static org.junit.Assert.*;
import org.junit.Test;

import desktop_resources.GUI;
import diceGame.Ownable;
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
		assertEquals(game.getPlayers()[1].getBalance(), startBalance);
		
	//Second case we let the second player pay rent to owner
		dice.setValues(diceValues);
		nextPlayer = game.playTurn(game.getPlayers()[1], dice);
		
		assertEquals(nextPlayer, game.getPlayers()[0]);
		assertEquals(game.getPlayers()[0].getBalance(), startBalance-price+rent);
		assertEquals(game.getPlayers()[1].getBalance(), startBalance-rent);

		GUI.showMessage("");
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
		assertEquals(game.getPlayers()[1].getBalance(), startBalance);
		
	//Second case we let the second player pay rent to owner
		dice.setValues(diceValues);
		nextPlayer = game.playTurn(game.getPlayers()[1], dice);
		
		assertEquals(nextPlayer, game.getPlayers()[0]);
		assertEquals(game.getPlayers()[0].getBalance(), startBalance-price+rent);
		assertEquals(game.getPlayers()[1].getBalance(), startBalance-rent);

		GUI.showMessage("");
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
		assertEquals(game.getPlayers()[1].getBalance(), startBalance);

		GUI.showMessage("");
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
		assertEquals(game.getPlayers()[1].getBalance(), startBalance);
		
	//Second case we let the second player pay rent to owner
		dice.setValues(diceValues);
		nextPlayer = game.playTurn(game.getPlayers()[1], dice);

		assertEquals(nextPlayer, game.getPlayers()[0]);
		assertEquals(game.getPlayers()[0].getBalance(), startBalance-price+rent);
		assertEquals(game.getPlayers()[1].getBalance(), startBalance-rent);

		GUI.showMessage("");
		GUI.close();
	}

	/**
	 * UC05: Land on Tax
	 * Player lands on field 2 + 13
	 */
	@Test
	public void TC05() {
		int startBalance = 7000;
		int[] diceValues = new int[]{1,1};
		int taxAmount = 2000;
		
	//First case player lands on field 2
		GameTestMode game = new GameTestMode();
		game.resetGame(2, 7000);
		DiceCupTestMode dice = new DiceCupTestMode(2,6);
		dice.setValues(diceValues);
		Player nextPlayer = game.playTurn(game.getPlayers()[0], dice);

		assertEquals(nextPlayer, game.getPlayers()[1]);
		assertEquals(game.getPlayers()[0].getBalance(), startBalance-taxAmount);
		assertEquals(game.getPlayers()[1].getBalance(), startBalance);
		
	//Second case player lands on field 13
		double taxRate = 0.1;
		diceValues = new int[]{5,6};
		dice.setValues(diceValues);
		nextPlayer = game.playTurn(game.getPlayers()[0], dice);

		assertEquals(nextPlayer, game.getPlayers()[1]);
		if(game.getPlayers()[0].getBalance()==1000){
			assertEquals((int)(game.getPlayers()[0].getBalance()),(int)(startBalance-taxAmount-4000));
		}
		else{
			assertEquals((int)(game.getPlayers()[0].getBalance()),(int)(startBalance-taxAmount-(taxRate*(startBalance-taxAmount))));
		}
		
		assertEquals(game.getPlayers()[1].getBalance(), startBalance);

		GUI.showMessage("");
		GUI.close();
	}

	/**
	 * UC06: Win Game
	 * Player wins game, because first player lands on field 1
	 */
	@Test
	public void TC06() {
		int startBalance = 1000;
		int playerAmount = 2;
		int[] diceValues = new int[]{1,1};
		
	//Player lands on field 2
		GameTestMode game = new GameTestMode();
		game.resetGame(playerAmount, startBalance);
		DiceCupTestMode dice = new DiceCupTestMode(2,6);
		dice.setValues(diceValues);
		Player currentPlayer = game.getPlayers()[0];
		Player nextPlayer = game.playTurn(currentPlayer, dice);

		assertEquals(nextPlayer, game.getPlayers()[0]);
		assertEquals(currentPlayer.getBalance(), 0);
		assertEquals(game.getPlayerArrayLength(),1);

		GUI.showMessage("");
		GUI.close();
	}

	/**
	 * UC07: Lose Game
	 * Player loses game, because he lands on field 2
	 */
	@Test
	public void TC07() {
		int startBalance = 2000;
		int playerAmount = 3;
		int[] diceValues = new int[]{1,1};
		
	//Player lands on field 2
		GameTestMode game = new GameTestMode();
		game.resetGame(playerAmount, startBalance);
		DiceCupTestMode dice = new DiceCupTestMode(2,6);
		dice.setValues(diceValues);
		Player currentPlayer = game.getPlayers()[0];
		Player nextPlayer = game.playTurn(currentPlayer, dice);

		assertEquals(nextPlayer, game.getPlayers()[0]);
		assertEquals(currentPlayer.getBalance(), 0);
		assertEquals(game.getPlayerArrayLength(),playerAmount-1);

		GUI.showMessage("");
		GUI.close();
	}

	/**
	 * UC08: Purchase field
	 * Player purchases field 5
	 */
	@Test
	public void TC08() {
		int startBalance = 5000;
		int price = 1500;
		int playerAmount = 3;
		int[] diceValues = new int[]{4,1};
		
	//Player lands on field 5
		GameTestMode game = new GameTestMode();
		game.resetGame(playerAmount, startBalance);
		DiceCupTestMode dice = new DiceCupTestMode(2,6);
		dice.setValues(diceValues);
		Player currentPlayer = game.getPlayers()[0];
		Player nextPlayer = game.playTurn(currentPlayer, dice);

		assertEquals(nextPlayer, game.getPlayers()[1]);
		assertEquals(currentPlayer.getBalance(), startBalance-price);
		assertEquals(currentPlayer,((Ownable) game.getBoard().getFields()[4]).getOwner());
		
		GUI.showMessage("");
		GUI.close();
	}
}
