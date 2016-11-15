package diceGame;

public class Player {
	
	private int id;
	private int balance;
	//Piece piece = new Piece(); ?? dont get it 
	
	public Player(int id, int balance){
		
		this.id = id;
		this.balance = balance;
		return;
		
	}
	
	
	public int getBalance(){
		
		int balance = this.balance;
		
		return balance;
		
	}
	
	
	public void setBalance(int amount){
		
		this.balance = this.balance + amount;
		return;
		
	}
	
	
	public int getID(){
		
		int ID = this.id;
		return ID;		
		
	}
	

}
