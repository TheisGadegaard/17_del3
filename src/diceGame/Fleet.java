/**
 * @version 1.0
 * @author freya
 */

package diceGame; 

public class Fleet extends Ownable {
	private final int RENT_1 = 500;
	private final int RENT_2 = 1000;
	private final int RENT_3 = 2000;
	private final int RENT_4 = 4000;

	public Fleet(int price) {
		super(price);
	}

	@Override
	public int getRent() {
		int ownedFleets = 0;

		for (int i = 0; i<owner.getOwnedFields().length; i++){
			if (owner.getOwnedFields()[i] instanceof Fleet){
				ownedFleets++;
			}
			else if (owner.getOwnedFields()[i] == null){
				break;
			}
		} 

		int rent = 0;

		switch (ownedFleets){
		case 1: rent = RENT_1; break;
		case 2: rent = RENT_2; break;
		case 3: rent = RENT_3; break;
		case 4: rent = RENT_4; break;
		default: rent = 0; break;
		}

		return rent;
	}
}
