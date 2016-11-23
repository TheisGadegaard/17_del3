package diceGame;

import java.awt.Color;

import desktop_codebehind.Car;
import desktop_resources.GUI;

public class Game {
	private Board board; //An instance of the Board class
	private Player[] players; //An array of Players
	private DiceCup dice; //An instance of the DiceCup class
	private final int diceAmount; //The amount of dice used by the game
	private final int diceSides; //The number of sides the dice can have
	private Field currentField;

	public Game(){
		diceAmount = 2;		diceSides = 6;
		dice = new DiceCup(diceSides,diceAmount);
		board = new Board();
		board.showFieldsOnGUI();
	}

	public void resetGame(int playerAmount, int balance){
		final int START_BALANCE = balance;
		players = new Player[playerAmount];
		Color color = null;
		for (int i = 0; i < players.length; i++){
			switch (i){
			case 0: color = Color.red; break;
			case 1: color = Color.green; break;
			case 2: color = Color.yellow; break;
			case 3: color = Color.blue; break;
			case 4: color = Color.white; break;
			case 5: color = Color.black; break;
			default: System.exit(1);
			}
			players[i] = new Player(Messages.getGMessages()[10]+(i+1),i+1,START_BALANCE, new Piece(color));
			Car car = new Car.Builder()
					.primaryColor(players[i].getPiece().getColor())
					.build();
			GUI.addPlayer(players[i].getName(), players[i].getBalance(), car);
		}
	}

	public void playGame(){
		boolean winnerFound = false;
		Player currentPlayer;

		//first player is player 1
		currentPlayer = players[0];

		while (winnerFound == false){
			currentPlayer = playTurn(currentPlayer);

			if (players.length == 1){
				winnerFound = true;
			}
		}

		GUI.showMessage(Messages.getGMessages()[14] + currentPlayer.getName() + Messages.getGMessages()[15]);

	}

	private Player playTurn(Player currentPlayer){
		GUI.getUserButtonPressed(Messages.getGMessages()[11] + currentPlayer.getName() + Messages.getGMessages()[12], Messages.getGMessages()[7]);

		//throw dice
		dice.setAllValuesRandom();
		currentPlayer.setDiceSum(dice.getSum());
		GUI.setDice(dice.getValues()[0], dice.getValues()[1]);

		movePiece(currentPlayer);

		currentField.landOnField(currentPlayer);

		//define next player
		Player nextPlayer;
		if (currentPlayer == players[players.length-1]){
			nextPlayer = players[0];
		}
		else{
			//find currentPlayer's index in players
			int arrayIndex = 0;
			for (int i=0;i<players.length;i++){
				if (currentPlayer == players[i]){
					arrayIndex=i;
				}
			}
			nextPlayer = players[arrayIndex+1];
		}

		//remove player if balance = 0
		if (currentPlayer.getBalance() == 0){
			removePlayer(currentPlayer);
		}
		
		if (players.length == 1){
			nextPlayer = players[0];
		}

		return nextPlayer;
	}

	private void removePlayer(Player player){
		Player[] temp;
		temp = players;

		players = new Player[temp.length-1];

		int playerCount = 0;
		for (int i = 0; i<temp.length;i++){
			if (temp[i] != player){
				players[playerCount] = temp[i];
				playerCount++;
			}
		}
		GUI.removeAllCars(player.getName());
	}

	private void movePiece(Player currentPlayer) {
		if (currentPlayer.getPiece().getPosition() != 0){
			/*
			 * If there has already been placed a car, we remove it before placing a new one
			 * We avoid bugs in the first turn by having the position set to 0
			 * Every field is then a value of 1-21.
			 */
			GUI.removeCar(currentPlayer.getPiece().getPosition(),currentPlayer.getName());
		}
		/*
		 * Position is equal to the current position + the sum of the dice throw
		 * We use modulus to calculate whether the player would end up outside the board
		 */
		int position = (currentPlayer.getPiece().getPosition() + dice.getSum()) % board.getFields().length;
		//Since we use mod 21, we need to have a special case for field 21, or else we get position == 0
		if (position == 0){
			position = board.getFields().length;
		}

		//We set the car and piece position to the new values
		currentPlayer.getPiece().setPosition(position);
		GUI.setCar(position, currentPlayer.getName());
		currentField = board.getFields()[position-1];
		GUI.displayChanceCard(Messages.getFNames()[position-1] + "<br><br>" + Messages.getFMessages()[position-1]);

	}

}
