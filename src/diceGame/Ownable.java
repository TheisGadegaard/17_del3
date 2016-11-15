/**
 * @version 1.0
 * @author freya
 */

package diceGame; 

public abstract class Ownable extends Field {
	protected int price;
	protected Player owner;

	public Ownable(int price, Player owner){
		this.price = price;
		this.owner = owner;
	}

	public int getRent(){
		return 0;
	}

}
