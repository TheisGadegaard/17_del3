/**
 * @version 1.0
 * @author Tobias
 */

package diceGame;

public abstract class Field {
	private String name;
	
	public abstract void landOnField(Player player);

	public void setName(String text){
		name = text;
	}
}
