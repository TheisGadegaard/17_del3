/**
 * @version 1.0
 * @author Tobias
 */

package diceGame;

public class Board {
	Field[] fields = new Field[21];
	
	public Board(){
		//We can instantiate an object in the field array by using a subclass' constructor
		//The refuge will get typecasted into a field, but we can downcast it and get a refuge again
		//Remember to use the appropriate constructors
		
		/*
		fields[0] = new Refuge(5000); 		//Walled city
		fields[1] = new Tax(); 			//Goldmine
		fields[2] = new Territory(1000, 100); //Tribe Encampment
		fields[3] = new Fleet(); //Second sail
		fields[4] = new Territory(); //Crater
		fields[5] = new Territory(); //Mountain
		fields[6] = new LaborCamp();//Huts in the mountain
		fields[7] = new Territory(); //Cold Desert
		fields[8] = new Fleet(); //Sea Grover
		fields[9] = new Territory(); //Black cave
		fields[10] = new Territory(); //The WereWall
		fields[11] = new Refuge(); //Monastery
		fields[12] = new Tax(); //Caravan
		fields[13] = new Fleet(); //The Buccaneers
		fields[14] = new LaborCamp(); //The Pit
		fields[15] = new Territory(); //Mountain village
		fields[16] = new Territory(); //South Citadel
		fields[17] = new Territory(); //Palace Gates
		fields[18] = new Fleet(); //Private Armada
		fields[19] = new Territory(); //Tower
		fields[20] = new Territory(); //Castle
		
		*/
	}
}
