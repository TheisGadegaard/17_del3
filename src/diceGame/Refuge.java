package diceGame;

import desktop_resources.GUI;

public class Refuge extends Field {
	private int bonus;
	
	public Refuge (int bonus){
		this.bonus = bonus;
	}
	
	public int getBonus(){
		return bonus;
	}
	
	public void landOnField(Player player){
		GUI.showMessage(player.getName() + ": " + Messages.getGMessages()[19] + bonus + ".");
		player.setBalance(player.getBalance() + bonus);
	}
}
