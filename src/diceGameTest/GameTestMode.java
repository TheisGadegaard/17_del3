package diceGameTest;

import desktop_resources.GUI;
import diceGame.*;

public class GameTestMode extends Game {
	DiceCupTestMode dice;
	
	public GameTestMode(){
		super();
		super.resetGame(2, 5000);
	}
	
	public int getPlayerArrayLength(){
		return super.players.length;
	}
	
	public Player[] getPlayers(){
		return players;
	}
	
	public Player playTurn(Player currentPlayer, DiceCupTestMode dice){
//		GUI.getUserButtonPressed(Messages.getGMessages()[11] + currentPlayer.getName() + Messages.getGMessages()[12], Messages.getGMessages()[7]);
		
		throwDice(currentPlayer, dice);
		super.dice = this.dice;

		movePiece(currentPlayer);

		currentField.landOnField(currentPlayer);

		Player nextPlayer = defineNextPlayer(currentPlayer);
		return nextPlayer;
	}
	
	protected void throwDice(Player currentPlayer, DiceCupTestMode dice){
		this.dice = dice;
		
		currentPlayer.setDiceSum(dice.getSum());
		GUI.setDice(dice.getValues()[0], dice.getValues()[1]);
	}
	
	protected Board getBoard(){
		return board;
	}

}
