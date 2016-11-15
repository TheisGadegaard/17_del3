package diceGame;

public class Field {
	
	public void LandOnField(Field field){
		
		// We use instanceof operator to check if field has a subclass 
		if (field instanceof Ownable){
			
			//If field has the ownable subclass, check which ownable field type it is
			if(field instanceof Territory){
				//Reference use case "land on territory"
				
			}
			else if(field instanceof LaborCamp){
				//Reference use case "land on labor camp"
				
			}
			else if(field instanceof Fleet){
				//Reference use case "land on fleet"
				
			}
		}
		else if (field instanceof Tax){
			 //Reference use case "land on tax"
			
		}
		else if (field instanceof Refuge){
			//Reference use case "land on refuge"
			
		}
	}

}
