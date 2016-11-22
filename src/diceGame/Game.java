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

	public Game(){
		diceAmount = 2;		diceSides = 6;
		dice = new DiceCup(diceSides,diceAmount);
		board = new Board();
		board.showFieldsOnGUI();
	}

	public void resetGame(int playerAmount){
		int startBalance = 30000;
		players = new Player[playerAmount];
		for (int i = 0; i < players.length; i++){
			players[i] = new Player(i+1,startBalance, new Piece(Color.white));
			Car car = new Car.Builder()
						.primaryColor(Color.white)
						.build();
			GUI.addPlayer(Messages.getGMessages()[10] + (i + 1), startBalance, car);
		}
	}

	public void playGame(){
		boolean winnerFound = false;
		Player currentPlayer, nextPlayer;

		//first player is player 1
		currentPlayer = players[0];

		while (winnerFound == false){
			//			System.out.println(Messages.printNextPlayer(currentPlayer));
			nextPlayer = playTurn(currentPlayer);

			String scoreBoard = "Spiller\tBalance";
			for (int i = 0; i < players.length; i++){
				scoreBoard += "\n" + players[i].getID() + "\t" + players[i].getBalance();
			}

			GUI.getUserButtonPressed(scoreBoard, Messages.getGMessages()[7]);
			
			//Find out how many players are left in game
			int playersLeft = 0;
			for (Player i : players){
				if (i.getBalance() != 0){
					playersLeft++;
				}
			}
			
			if (playersLeft == 1){
				winnerFound = true;
			}

			currentPlayer = nextPlayer;
		}

		//		GUI.showMessage(Messages.getPlayers(players) + "\n\n" + Messages.printWinners(winners));
		//		System.out.println(Messages.printWinners(winners));

	}

	private Player playTurn(Player currentPlayer){
		Field currentField;
		dice.setAllValuesRandom();
		System.out.println("\nSpiller " + currentPlayer.getID() + " slog: " + dice.getSum());

		currentPlayer.setDiceSum(dice.getSum());
		GUI.setDice(dice.getValues()[0], dice.getValues()[1]);
		//Set Car/Piece
		currentField = board.getFields()[dice.getSum()-2];
		GUI.displayChanceCard(Messages.getFNames()[dice.getSum()-2] + "<br><br>" + Messages.getFMessages()[dice.getSum()-2]);

		//		System.out.println(Messages.getSquareMessages()[dice.getDiceSum()-2]);

		currentField.landOnField(currentPlayer);

		if (currentPlayer.getBalance() == 0){
			removePlayer(currentPlayer);
		}
		
		//GUI.showMessage(Messages.getSMessage(dice.getDiceSum()-2) + "\n\n" + Messages.getBalance(currentPlayer));

		Player nextPlayer;

		if (currentPlayer.getID() == players.length){
			nextPlayer = players[0];
		}
		else{
			nextPlayer = players[currentPlayer.getID()];
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
	}
	
}
