/* This class can add the player amount and creates the game.
 * Currently this needs to be re-evaluated as it creates a game of 2, and then adds a game.! */

package diceGame;

public class CreateGame {

	private int playerAmount = 2;					           // Minimum required players to play the game is 2
	private Game game;		// Create the game with the minimum required playerAmount
	
	public CreateGame(){
		game = new Game(); //Initialiser spil
		//Vil du spille et nyt spil eller ændre antallet af spillere?
		setPlayerAmount(3);//Vis + og - knapper og ændr på antal spillere
		//Evt. mulighed for at give navne
		game.resetGame(playerAmount); //Angiv antallet af spillere til game
		game.playGame();
	}
	
	// adds one player to the game
	private void setPlayerAmount(int playerAmount) {
		this.playerAmount = playerAmount;
	}
	
}
