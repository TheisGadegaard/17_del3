/**
 * @version 1.1
 * @author freya
 */

package diceGame;

public class LaborCamp extends Ownable {
	private int baseRent;
 
	public LaborCamp(int price, int baseRent) {
		super(price);
		this.baseRent = baseRent;
	}

	@Override
	public int getRent() {
		int ownedLaborCamps = 0;

		for (int i = 0; i<owner.getOwnedFields().length;i++){
			if (owner.getOwnedFields()[i] instanceof LaborCamp){
				ownedLaborCamps++;
			}
			else if (owner.getOwnedFields()[i] == null){
				break;
			}
		}

		return baseRent*ownedLaborCamps;
	}
}
