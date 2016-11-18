package diceGame;

public class Player {

	private int id;
	private int balance;
	private Piece piece;
	private Ownable[] ownedFields;

	public Player(int id, int balance, Piece piece){

		this.id = id;
		this.balance = balance;
		this.piece = piece;
		ownedFields = new Ownable[17];

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

	public void setBalance(int amount){

		this.balance = this.balance + amount;

	}
	
	public void setOwnedField(Ownable field){

		for (int i = 0; i<ownedFields.length;i++){
			if (ownedFields[i] == null){
				ownedFields[i] = field;
				break;
			}
		}

	}

}
