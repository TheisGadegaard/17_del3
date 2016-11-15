/**
 * @version 1.0
 * @author Tobias
 */

package diceGame;

public class Field {
	
	public void landOnField(Player player){
		
		// We use instanceof operator to check if field has a subclass 
		if (this instanceof Ownable){
			
			//If field has the ownable subclass, check which ownable field type it is
			if(this instanceof Territory){
				//Reference use case "land on territory"
				Territory territory = (Territory)this;
				
			}
			else if(this instanceof LaborCamp){
				//Reference use case "land on labor camp"
				LaborCamp laborCamp = (LaborCamp)this;
			}
			else if(this instanceof Fleet){
				//Reference use case "land on fleet" 
				Fleet fleet = (Fleet)this;
			}
		}
		else if (this instanceof Tax){
			 //Reference use case "land on tax"
			Tax tax = (Tax)this;
			
		}
		else if (this instanceof Refuge){
			//Reference use case "land on refuge"
			Refuge refuge = (Refuge)this;
		}
	}


}
