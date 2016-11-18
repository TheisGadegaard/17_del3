/**
 * @version 1.0
 * @author Tobias
 */

package diceGame;

import desktop_fields.*;
import desktop_resources.*;
import java.awt.Color;

public class Board {
	Field[] fields = new Field[21];
	Street[] graphicfields;
	
	public Board(){
		//We can instantiate an object in the field array by using a subclass' constructor
		//Remember to use the appropriate constructors
		
		fields[0] = new Refuge(5000); 					//Walled city
		fields[1] = new Tax(2000, -1); 					//Goldmine (has -1 as tax rate so we know it does not actually have a tax rate)
		fields[2] = new Territory(1000, 100); 			//Tribe Encampment
		fields[3] = new Fleet(4000); 					//Second sail
		fields[4] = new Territory(1500, 200); 			//Crater
		fields[5] = new Territory(2000, 500); 			//Mountain
		fields[6] = new LaborCamp(2500, 100);			//Huts in the mountain
		fields[7] = new Territory(3000, 700); 			//Cold Desert
		fields[8] = new Fleet(4000); 					//Sea Grover
		fields[9] = new Territory(4000, 1000); 			//Black cave
		fields[10] = new Territory(4300, 1000); 		//The WereWall
		fields[11] = new Refuge(500); 					//Monastery
		fields[12] = new Tax(4000, 10); 				//Caravan
		fields[13] = new Fleet(4000); 					//The Buccaneers
		fields[14] = new LaborCamp(2500, 100); 			//The Pit
		fields[15] = new Territory(4750, 1600); 		//Mountain village
		fields[16] = new Territory(5000, 2000); 		//South Citadel
		fields[17] = new Territory(5500, 2600); 		//Palace Gates
		fields[18] = new Fleet(4000); 					//Private Armada
		fields[19] = new Territory(6000, 3200); 		//Tower
		fields[20] = new Territory(8000, 4000); 		//Castle
		
		//Use messages class to set the names of the field class
		String[] names = Messages.getFNames(); 		//We get the names
		for(int i = 0; i < fields.length; i++){
			fields[i].setName(names[i]); 			//We set the names
		}
		
	}
	
	//TODO Add to design diagrams
	public void showFieldsOnGUI(){
		//Show fields on GUI is a public method that can be used to make
		//the graphical representation of the fields with the GUI.
		//Board now creates the GUI board as well
		
		for(int i = 0; i < fields.length; i++){
			graphicfields[i] = new Street.Builder()
					.setBgColor(determineFieldColor(fields[i]))
					.setTitle(Messages.getFNames()[i])
					.setDescription("")
					.setSubText(Messages.getFMessages()[i])
					.build();	
		}
		
		GUI.create(graphicfields);
		
	}
	
	private Color determineFieldColor(Field field){
		Color color;
		int red = 200;
		int green = 200;
		int blue = 200;
		
		int temp;
		int percentage;
		
		//We use instanceof to determine type of field
		if(field instanceof Territory){
			//Territory should be green and varying in darkness after how expensive it is
			temp = ((Territory) field).getRent();
			percentage = 100*(temp/4000);
			
			red -= 2*percentage;
			green -= percentage;
			blue -= 2*percentage;
			
		}
		else if(field instanceof Fleet){
			//Fleet is blue
			red -= 100;
			green -= 100;
		}
		else if(field instanceof LaborCamp){
			//LaborCamp is grey
		}
		else if(field instanceof Tax){
			//Tax is yellow
			blue -= 150;
			
		}
		else if(field instanceof Refuge){
			//Refuge is white
			red += 50;
			green += 50;
			blue += 50;
		}
		//color is assigned values of RGB
		color = new Color(red, green, blue);
		return color;
	}
}
