/**
 * @version 1.2
 * @author freya, tobias
 */

package diceGame; 

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
			//GUI choice to buy field if it is not owned
			//owner = player;
		}
		else if (owner == player){
			//nothing should happen if field is owned by player
		}
		else{//pay rent to owner if owned
			if (this instanceof LaborCamp){
				//when LaborCamp we should multiply dice sum with 100 and number of owned labor camps
				
				//int rent = getRent()*player.getDiceSum();
		
//				owner.setBalance(player.getBalance() + rent;
//				player.setBalance(player.getBalance() - rent;
			}
			else{
				owner.setBalance(player.getBalance() + getRent());
				player.setBalance(player.getBalance() - getRent());
			}
		}

	}
}
