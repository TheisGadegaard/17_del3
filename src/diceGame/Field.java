package diceGame;

public class Field {
	
	public void LandOnField(Player player){
		
		// We use instanceof operator to check if field has a subclass 
		if (this instanceof Ownable){
			
			//If field has the ownable subclass, check which ownable field type it is
			if(this instanceof Territory){
				//Reference use case "land on territory"
				
			}
			else if(this instanceof LaborCamp){
				//Reference use case "land on labor camp"
				
			}
			else if(this instanceof Fleet){
				//Reference use case "land on fleet"
				
			}
		}
		else if (this instanceof Tax){
			 //Reference use case "land on tax"
			
		}
		else if (this instanceof Refuge){
			//Reference use case "land on refuge"
			
		}
	}

}
