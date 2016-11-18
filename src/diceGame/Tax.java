/**
 * @version 1.0
 * @author freya
 */
package diceGame;

public class Tax extends Field {
	private int taxAmount;
	private int taxRate; //taxRate = 0 means no taxRate.
	
	public Tax(int taxAmount, int taxRate){
		this.taxAmount = taxAmount;
		this.taxRate = taxRate;
	}
	
	public int getTaxAmount(){
		return taxAmount;
	}

	public int getTaxRate(){
		return taxRate;
	}
	
	public void landOnField(Player player){
		
	}
}
