/**
 * @version 1.0
 * @author freya
 */

package diceGame;

public class Territory extends Ownable {
	private int rent;

	public Territory(int price, Player owner, int rent) {
		super(price, owner);
		this.rent = rent;
	}
}
