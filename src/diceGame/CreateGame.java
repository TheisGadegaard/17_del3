/* This class can add the player amount and creates the game.
 * Currently this needs to be re-evaluated as it creates a game of 2, and then adds a game.! */

package diceGame;

import desktop_resources.GUI;

public class CreateGame {

	private int playerAmount;	//Number of players in the game
	private Game game;

	public CreateGame(){
		game = new Game(); //Initialize game
		while (GUI.getUserButtonPressed(Messages.getGMessages()[6] //do you want to create new game?
				, Messages.getGMessages()[1] //yes
				, Messages.getGMessages()[2] //no
				) == Messages.getGMessages()[1] //user chooses yes
			){
			playerAmount = Integer.parseInt(GUI.getUserSelection(Messages.getGMessages()[8], "2","3","4","5","6"));
			//Maybe possibility to name players
			game.resetGame(playerAmount);
			game.playGame();
		}
		GUI.close();
	}
}
