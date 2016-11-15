/* This class can add the player amount and creates the game.
 * Currently this needs to be re-evaluated as it creates a game of 2, and then adds a game.! */

package diceGame;

public class CreateGame {

	private int playerAmount = 2;					           // Minimum required players to play the game is 2
	private Game game = new Game(playerAmount);		// Create the game with the minimum required playerAmount
	
	// adds one player to the game
	public void addPlayers() {
		playerAmount++;
  
  // Change the game to have new playerAmount (This is also where the problem occures, as the game class are getting called several times now)
  game(playerAmount);
	}
}
