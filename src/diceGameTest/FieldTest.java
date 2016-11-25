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
		int[] diceValues = new int[2];
		int fieldArrayIndex = diceValues[0] + diceValues[1] - 1;
		int playerAmount = 2;
		int startBalance = 5000;
		int price = 4000;
		GameTestMode game = new GameTestMode();
		DiceCupTestMode dice = new DiceCupTestMode(2,6);
		Player currentPlayer;
		Ownable field;

	//Field not owned, player has high enough balance to buy
		game.resetGame(playerAmount, startBalance);
		currentPlayer = game.getPlayers()[0];
		diceValues = new int[]{1,3};
		fieldArrayIndex = diceValues[0] + diceValues[1] - 1;
		field = (Ownable) game.getBoard().getFields()[fieldArrayIndex];
		
		GUI.showMessage("Vælg 'Ja'");
		
		dice.setValues(diceValues);
		game.throwDice(currentPlayer, dice);
		game.movePiece(currentPlayer);
		field.landOnField(currentPlayer); //choose yes to buy
		
		assertEquals(currentPlayer,field.getOwner()); //player is owner
		assertEquals(currentPlayer.getBalance(), startBalance-price);//player has reduced balance
	
	//Field owned by player self
		startBalance = currentPlayer.getBalance();
		diceValues = new int[]{0,0};
		
		dice.setValues(diceValues);
		game.throwDice(currentPlayer, dice);
		game.movePiece(currentPlayer);
		field.landOnField(currentPlayer);
		
		assertEquals(currentPlayer.getBalance(), startBalance);//player has same balance

		GUI.close();
		
	//Field owned by other player, who is not bankrupt
		game.resetGame(playerAmount, startBalance);
		currentPlayer = game.getPlayers()[0];
		diceValues = new int[]{1,3};
		field = (Ownable) game.getBoard().getFields()[fieldArrayIndex];
		
		field.setOwner(game.getPlayers()[1]);
		game.getPlayers()[1].setOwnedField(field);
		int rent = field.getRent();
		
		dice.setValues(diceValues);
		game.throwDice(currentPlayer, dice);
		game.movePiece(currentPlayer);
		field.landOnField(currentPlayer);
		
		assertEquals(field.getOwner().getBalance(), startBalance+rent); //owner has increased balance
		assertEquals(currentPlayer.getBalance(), startBalance-rent); //player has reduced balance

		GUI.close();
		
	//Field owned by other player, who is bankrupt
		game.resetGame(playerAmount, startBalance);
		currentPlayer = game.getPlayers()[0];
		diceValues = new int[]{1,3};

		field.setOwner(game.getPlayers()[1]);
		game.getPlayers()[1].setOwnedField(field);
		game.getPlayers()[1].setBalance(0);

		game.throwDice(currentPlayer, dice);
		game.movePiece(currentPlayer);
		field.landOnField(currentPlayer);
		
		assertEquals(currentPlayer.getBalance(), startBalance); //player has same balance

		GUI.close();
		
	//Field not owned, player does not have high enough balance to buy
		game.resetGame(playerAmount, startBalance);
		currentPlayer = game.getPlayers()[0];
		diceValues = new int[]{1,3};

		game.throwDice(currentPlayer, dice);
		game.movePiece(currentPlayer);
		field.landOnField(currentPlayer);
		
		assertEquals(field.getOwner(),null); //no owner
		assertEquals(currentPlayer.getBalance(), startBalance); //player has same balance
		
		GUI.close();
		
	}

	@Test
	public void territoryTest() {
		int[] diceValues = new int[2];
		int playerAmount = 2;
		int startBalance = 5000;
		GameTestMode game = new GameTestMode();
		DiceCupTestMode dice = new DiceCupTestMode(2,6);
		Player currentPlayer;
		Ownable field;
		
	//Field owned by other player, who is not bankrupt
		game.resetGame(playerAmount, startBalance);
		currentPlayer = game.getPlayers()[0];
		diceValues = new int[]{1,2};
		int fieldArrayIndex = diceValues[0] + diceValues[1] - 1;
		field = (Ownable) game.getBoard().getFields()[fieldArrayIndex];

		field.setOwner(game.getPlayers()[1]);
		game.getPlayers()[1].setOwnedField(field);
		int rent = ((Territory) game.getBoard().getFields()[fieldArrayIndex]).getRent();

		game.throwDice(currentPlayer, dice);
		game.movePiece(currentPlayer);
		field.landOnField(currentPlayer);
		
		assertEquals(currentPlayer.getBalance(), startBalance-rent); //player has reduced balance
		assertEquals(field.getOwner().getBalance(), startBalance+rent); //owner has increased balance
		
		GUI.close();
	}

	@Test
	public void refugeTest() {
		int[] diceValues = new int[2];
		int playerAmount = 2;
		int startBalance = 5000;
		GameTestMode game = new GameTestMode();
		DiceCupTestMode dice = new DiceCupTestMode(2,6);
		Player currentPlayer;
		Refuge field;
		
		game.resetGame(playerAmount, startBalance);
		currentPlayer = game.getPlayers()[0];
		diceValues = new int[]{6,6};
		int fieldArrayIndex = diceValues[0] + diceValues[1] - 1;
		field = (Refuge) game.getBoard().getFields()[fieldArrayIndex];
		
		int bonus = field.getBonus();

		dice.setValues(diceValues);
		game.throwDice(currentPlayer, dice);
		game.movePiece(currentPlayer);
		field.landOnField(currentPlayer);
		
		assertEquals(currentPlayer.getBalance(), startBalance+bonus); //player has increased balance
		
		GUI.close();
	}

	@Test
	public void laborCampTest() {
		int[] diceValues = new int[2];
		int playerAmount = 2;
		int startBalance = 5000;
		GameTestMode game = new GameTestMode();
		DiceCupTestMode dice = new DiceCupTestMode(2,6);
		Player currentPlayer;
		Ownable field;
		
	//Field owned by other player, who is not bankrupt
		game.resetGame(playerAmount, startBalance);
		currentPlayer = game.getPlayers()[0];
		diceValues = new int[]{1,6};
		int fieldArrayIndex = diceValues[0] + diceValues[1] - 1;
		field = (Ownable) game.getBoard().getFields()[fieldArrayIndex];
		
		field.setOwner(game.getPlayers()[1]);
		game.getPlayers()[1].setOwnedField(field);
		int rent = field.getRent()*(fieldArrayIndex+1);
		
		dice.setValues(diceValues);
		game.throwDice(currentPlayer, dice);
		game.movePiece(currentPlayer);
		field.landOnField(currentPlayer);
		
		assertEquals(currentPlayer.getBalance(), startBalance-rent); //player has reduced balance
		assertEquals(field.getOwner().getBalance(), startBalance+rent); //owner has increased balance
		
		GUI.close();
	}

	@Test
	public void taxTest() {
		int[] diceValues = new int[2];
		int playerAmount = 2;
		int startBalance = 5000;
		GameTestMode game = new GameTestMode();
		DiceCupTestMode dice = new DiceCupTestMode(2,6);
		Player currentPlayer;
		Tax field;
		
	//User chooses taxAmount
		game.resetGame(playerAmount, startBalance);
		currentPlayer = game.getPlayers()[0];
		diceValues = new int[]{7,6};
		int fieldArrayIndex = diceValues[0] + diceValues[1] - 1;
		field = (Tax) game.getBoard().getFields()[fieldArrayIndex];
		
		GUI.showMessage("Vælg 'Betal 4000'");
		
		dice.setValues(diceValues);
		game.throwDice(currentPlayer, dice);
		game.movePiece(currentPlayer);
		field.landOnField(currentPlayer);
	
	//User chooses taxRate
		currentPlayer = game.getPlayers()[1];

		GUI.showMessage("Vælg 'Betal 10%'");
		
		game.throwDice(currentPlayer, dice);
		game.movePiece(currentPlayer);
		field.landOnField(currentPlayer);
		
		int taxAmount = 4000;
		int taxRate = (int) (0.1*startBalance);
		
		assertEquals(game.getPlayers()[0].getBalance(), startBalance-taxAmount); //player has increased balance
		assertEquals(game.getPlayers()[1].getBalance(), startBalance-taxRate); //player has increased balance
		
		GUI.close();
	}
}
