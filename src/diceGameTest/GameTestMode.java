package diceGameTest;

import diceGame.Game;

public class GameTestMode extends Game {

	public GameTestMode(){
		super();
		super.resetGame(3, 5000);
	}
	
	public int getPlayerArrayLength(){
		return 0;
	}
}
