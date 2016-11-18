/**
 * @version 1.0
 * @author freya
 */

package diceGame;

public class Territory extends Ownable {
	private int rent;

	public Territory(int price, int rent) {
		super(price);
		this.rent = rent;
	}
	
	@Override
	public int getRent() {
		return rent;
	}
}
