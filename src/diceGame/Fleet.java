/**
 * @version 1.0
 * @author freya
 */

package diceGame;

public class Fleet extends Ownable {
	private final int rent_1 = 500;
	private final int rent_2 = 1000;
	private final int rent_3 = 2000;
	private final int rent_4 = 4000;
	
	public Fleet(int price, Player owner) {
		super(price, owner);
	}
	
}
