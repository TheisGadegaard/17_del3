package diceGameTest;

import diceGame.DiceCup;

public class DiceCupTestMode extends DiceCup {
	
//Constructor to set amount of dice-sides and the amount of dices
//furthermore uses the setAllValuesRandom method which simulates a roll
	public DiceCupTestMode(int diceSides, int diceAmount){
		super(diceSides, diceAmount);
	}
	
	public void setSingleValue(int place, int newValue){
		values[place] = newValue;
	}
	
	public void setValues(int[] values){
		this.values = values;
	}

}
