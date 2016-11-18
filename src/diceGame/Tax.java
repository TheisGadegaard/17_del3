/**
 * @version 1.0
 * @author freya
 */
package diceGame;

public class Tax extends Field {
	private int taxAmount;
	private int taxRate; //taxRate = -1 means no taxRate.

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
		if (taxRate >= 0){
			//GUI choice between amount or rate
			//player.setBalance(player.getBalance() - taxAmount);
			//player.setBalance(player.getBalance() - (taxRate * getAllAssets(player)));
		}
		else{
			player.setBalance(player.getBalance() - taxAmount);
		}
	}

	private int getAllAssets(Player player){
		Ownable[] fields = player.getOwnedFields();
		int ownedAssets = player.getBalance();

		for (int i = 0; i < fields.length; i++){
			ownedAssets += fields[i].getPrice();
		}

		return ownedAssets;
	}

}
