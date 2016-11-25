package diceGameTest;

import static org.junit.Assert.*;
import diceGame.*;

import org.junit.Test;

import desktop_resources.GUI;

public class FieldTest {
	/*
	 * Unit tests of the class Field and each of the classes in its inheritance hierarchy
	 */
	@Test
	public void fleetTest() {
		int[] diceValues = {1,3};
		int price = 4000;

	//Field not owned, player has high enough balance to buy
		int startBalance = 5000;
		GameTestMode game = new GameTestMode();
		DiceCupTestMode dice = new DiceCupTestMode(2,6);
		dice.setValues(diceValues);
		Player currentPlayer = game.getPlayers()[0];
		game.playTurn(currentPlayer, dice);
		//choose yes
		assertEquals(currentPlayer,((Ownable) game.getBoard().getFields()[3]).getOwner()); //player is owner
		assertEquals(currentPlayer.getBalance(), startBalance-price);//player has reduced balance

		
	//Field owned by player self
		startBalance = currentPlayer.getBalance();
		diceValues = new int[]{0,0};
		dice.setValues(diceValues);
		game.playTurn(currentPlayer, dice);
		GUI.close();
		assertEquals(currentPlayer,((Ownable) game.getBoard().getFields()[3]).getOwner()); //player is owner
		assertEquals(currentPlayer.getBalance(), startBalance);//player has same balance
		
		
	//Field owned by other player, who is not bankrupt
		startBalance = 3000;
		diceValues = new int[]{1,3};
		game.resetGame(2, startBalance);
		((Ownable) game.getBoard().getFields()[3]).setOwner(game.getPlayers()[1]);
		game.getPlayers()[1].setOwnedField((Ownable) game.getBoard().getFields()[3]);
		int rent = ((Fleet) game.getBoard().getFields()[3]).getRent();
		dice.setValues(diceValues);
		currentPlayer = game.getPlayers()[0];
		game.playTurn(currentPlayer, dice);
		assertEquals(currentPlayer.getBalance(), startBalance-rent); //player has reduced balance
	
		
	//Field owned by other player, who is bankrupt
		startBalance = 3000;
		diceValues = new int[]{1,3};
		game.resetGame(2, startBalance);
		((Ownable) game.getBoard().getFields()[3]).setOwner(game.getPlayers()[1]);
		game.getPlayers()[1].setOwnedField((Ownable) game.getBoard().getFields()[3]);
		game.getPlayers()[1].setBalance(0);
		rent = ((Fleet) game.getBoard().getFields()[3]).getRent();
		dice.setValues(diceValues);
		currentPlayer = game.getPlayers()[0];
		game.playTurn(currentPlayer, dice);
		assertEquals(currentPlayer.getBalance(), startBalance); //player has reduced balance
		
		
	//Field not owned, player does not have high enough balance to buy
		startBalance = 3000;
		diceValues = new int[]{1,3};
		game.resetGame(2, startBalance);
		dice.setValues(diceValues);
		currentPlayer = game.getPlayers()[0];
		game.playTurn(currentPlayer, dice);
		assertEquals(((Ownable) game.getBoard().getFields()[3]).getOwner(),null); //no owner
		assertEquals(currentPlayer.getBalance(), startBalance); //player has same balance
		
		GUI.close();
	}

	@Test
	public void territoryTest() {
		int[] diceValues = {1,2};
		GameTestMode game = new GameTestMode();
		DiceCupTestMode dice = new DiceCupTestMode(2,6);
		
	//Field owned by other player, who is not bankrupt
		int startBalance = 5000;
		((Ownable) game.getBoard().getFields()[2]).setOwner(game.getPlayers()[1]);
		game.getPlayers()[1].setOwnedField((Ownable) game.getBoard().getFields()[2]);
		int rent = ((Territory) game.getBoard().getFields()[2]).getRent();
		dice.setValues(diceValues);
		Player currentPlayer = game.getPlayers()[0];
		game.playTurn(currentPlayer, dice);
		assertEquals(currentPlayer.getBalance(), startBalance-rent); //player has reduced balance
		
		GUI.close();
	}

	@Test
	public void refugeTest() {
		
		fail("Not yet implemented");
		GUI.close();
	}

	@Test
	public void laborCampTest() {

		fail("Not yet implemented");
		GUI.close();
	}

	@Test
	public void taxTest() {

		fail("Not yet implemented");
		GUI.close();
	}


}
