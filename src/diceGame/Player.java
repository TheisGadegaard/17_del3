package diceGame;

import desktop_resources.GUI;

public class Player {

	private int id;
	private int balance;
	private String name;
	private int diceSum;
	private Piece piece; 
	private Ownable[] ownedFields;

	public Player(String name,int id, int balance, Piece piece){
		this.name = name;
		this.id = id;
		this.balance = balance;
		this.piece = piece;
		ownedFields = new Ownable[17];
		diceSum = 0;

	}

	public String getName(){

		return name;

	}

	public int getBalance(){

		return balance;

	}

	public Piece getPiece(){

		return piece;

	}

	public int getID(){

		return id;		

	}

	public Ownable[] getOwnedFields(){

		return ownedFields;		

	}
	
	public int getDiceSum(){
		return diceSum;
	}

	public void setBalance(int balance){
		//we shall set balance to 0 if it is negative
		if (balance < 0){
			balance = 0;
		}
		this.balance = balance;

		GUI.setBalance(name, balance);
	}
	
	public void setOwnedField(Ownable field){
		//set next empty position in Ownable array to the given field
		for (int i = 0; i<ownedFields.length;i++){
			if (ownedFields[i] == null){
				ownedFields[i] = field;
				break; //exit the loop
			}
		}

	}
	
	public void setDiceSum(int diceSum){
		this.diceSum = diceSum;
	}

}
