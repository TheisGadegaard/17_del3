/**
 * @version 1.1
 * @author freya, tobias
 */

package diceGame; 

public abstract class Ownable extends Field {
	protected int price;
	protected Player owner;

	public Ownable(int price){
		this.price = price;
	}

	public abstract int getRent();
	
	public Player getOwner(){
		return owner;
	}

	public void setOwner(Player owner){
		this.owner = owner;
	}
	
	public void landOnField(Player player){
		
	}
}
