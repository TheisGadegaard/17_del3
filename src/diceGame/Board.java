package diceGame;

public class Board {
	Field[] fields = new Field[21];
	
	public Board(){
		//We can instantiate an object in the field array by using a subclass' constructor
		fields[0] = new Refuge();
		//The refuge will get typecasted into a field, but we can downcast it and get a refuge again
		//Remember to use the appropriate constructors
	}
}
