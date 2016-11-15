/**
 * @version 1.1
 * @author freya
 */

package diceGame; 

public abstract class Ownable extends Field {
	protected int price;
	protected Player owner;

	public Ownable(int price){
		this.price = price;
	}

	public int getRent(){
		return 0;
	}
	
	public Player getOwner(){
		return owner;
	}

	public void setOwner(Player owner){
		this.owner = owner;
	}
}
