/**
 * @version 1.0
 * @author freya
 */
package diceGame;

import desktop_resources.GUI;

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
			if (GUI.getUserButtonPressed(
					Messages.getGMessages()[3] //You have two options
							,Messages.getGMessages()[4] + taxAmount //Pay taxAmount
							,Messages.getGMessages()[4] + taxRate + Messages.getGMessages()[5] //Pay taxRate
					) == Messages.getGMessages()[4] + taxAmount)
			{//user chooses taxAmount
				player.setBalance(player.getBalance() - taxAmount);
			}
			else{//user chooses taxRate
				player.setBalance(player.getBalance() - (int)((taxRate/100.0) * getAllAssets(player)));
			}
		}
		else{
			player.setBalance(player.getBalance() - taxAmount);
		}
	}

	private int getAllAssets(Player player){
		Ownable[] fields = player.getOwnedFields();
		int ownedAssets = player.getBalance();

		for (int i = 0; i < fields.length; i++){
			if (fields[i] != null){
				ownedAssets += fields[i].getPrice();
			}
		}

		return ownedAssets;
	}

}
