package diceGame;

public class Refuge extends Field {
	private int bonus;
	
	public Refuge (int bonus){
		this.bonus = bonus;
	}
	
//	public int getBonus(){
//		return bonus;
//	}
	
	public void landOnField(Player player){
		player.setBalance(player.getBalance() + bonus);
	}
}
