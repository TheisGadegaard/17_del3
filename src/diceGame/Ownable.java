/**
 * @version 1.2
 * @author freya, tobias
 */

package diceGame;

import desktop_resources.GUI;

public abstract class Ownable extends Field {
	protected int price;
	protected Player owner;
 
	public Ownable(int price){
		this.price = price;
		this.owner = null;
	}

	public abstract int getRent();

	public Player getOwner(){
		return owner;
	}

	public int getPrice(){
		return price;
	}

	public void setOwner(Player owner){
		this.owner = owner;
	}

	public void landOnField(Player player){
		if (owner == null){
			if (GUI.getUserButtonPressed(
					player.getName() + ": " + Messages.getGMessages()[0] + price + "?" //Do you want to buy field?
					,Messages.getGMessages()[1] //Yes
					,Messages.getGMessages()[2] //No
					) == Messages.getGMessages()[1])
			{//user chooses yes
				owner = player;
				player.setOwnedField(this);
				player.setBalance(player.getBalance()-price);
				GUI.setOwner(player.getPiece().getPosition(), player.getName());
			}
		}
		else if (owner == player){
			GUI.showMessage(player.getName() + ": " + Messages.getGMessages()[20]);
		}
		else if (owner.getBalance() > 0){//pay rent to owner if he is not bankrupt
			int rent = 0;
			if (this instanceof LaborCamp){
				//when LaborCamp we should multiply dice sum with 100 and number of owned labor camps
				rent = getRent()*player.getDiceSum();
			}
			else{
				rent = getRent();
			}
			
			GUI.showMessage(player.getName() + ": " + Messages.getGMessages()[9] + rent + Messages.getGMessages()[16]);
			
			owner.setBalance(owner.getBalance() + rent);
			player.setBalance(player.getBalance() - rent);		
		}
		else{
			GUI.showMessage(player.getName() + ": " + Messages.getGMessages()[21]);
		}
		
	}
}
