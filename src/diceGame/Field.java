/**
 * @version 1.0
 * @author Tobias
 */

package diceGame;

public abstract class Field {
	//private String name;
	
	/*
	 * Field is an abstract class. 
	 * Having an abstract method means that every class that 
	 * extends it will also have that method.
	 * We can then do different implementations of this method
	 * for each of our specific classes.
	 */
	public abstract void landOnField(Player player);

	/*
	public void setName(String text){
		name = text;
	}
	
	public String getName(){
		return name;
	}
	*/
}
