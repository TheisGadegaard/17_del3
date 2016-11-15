/**
 * @version 1.0
 * @author freya
 */

package diceGame;

public class LaborCamp extends Ownable {
	private int baseRent;

	public LaborCamp(int price, Player owner, int baseRent) {
		super(price, owner);
		this.baseRent = baseRent;
	}
	
}
