package diceGame;

import java.awt.Color;

public class Game {
	private Board board; //An instance of the Board class
	private Player[] players; //An array of Players
	private DiceCup dice; //An instance of the DiceCup class
	private final int diceAmount; //The amount of dice used by the game
	private final int diceSides; //The number of sides the dice can have
	
	public Game(){
		diceAmount = 2;		diceSides = 6;
		dice = new DiceCup(diceSides,diceAmount);
		board = new Board();
		board.showFieldsOnGUI();
	}
	
	public void resetGame(int playerAmount){
		players = new Player[playerAmount];
		for (int i = 0; i < players.length; i++){
			players[i] = new Player(i+1,0, new Piece(Color.white));
		}
	}
	
	public void playGame(){
	}
}
