package diceGame;

public class DiceCup {
	private int[] values;
	private int sides;
	
//Constructor to set amount of dice-sides and the amount of dices
//furthermore uses the setAllValuesRandom method which simulates a roll
	public DiceCup(int diceSides, int diceAmount){
		values = new int[diceAmount];
		this.sides = diceSides;	
		this.setAllValuesRandom();
	}
	
	public int[] getValues(){
		return values;
	}
	
	public void setSingleValue(int place, int newValue){
		values[place] = newValue;
	}
	
	public void setAllValues(int[] values){
		this.values = values;
	}

	public int getSum(){
		int sum = 0;
		for (int i = 0; i<values.length;i++){
			sum += values[i];
		}
		return sum;
	}
	
	//Simulates a roll of the chosen dice(s)
	public void setAllValuesRandom(){
		for (int i = 0; i < values.length; i++){
			values[i] = ( (int) (Math.random()*sides)+1);
		}
	}
}
