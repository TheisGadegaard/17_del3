
package diceGameTest;

import static org.junit.Assert.*;

import org.junit.Test;

import diceGame.DiceCup;

public class DiceCupTest {

	@Test
	public void test() {

		int[] Runs = new int[30000];
		int[] Throw = new int[6];

		Boolean FailOnce = false;
		Boolean FailRandom = false;
		Boolean Fail = false;
		
		int DiceSides = 6;

		DiceCup Cup = new DiceCup(DiceSides,1);

		for (int i = 0; i < 30000; i++){

			Cup.setAllValuesRandom();
			Runs[i] = Cup.getSum();
			switch(Cup.getSum()){
			
			case 1:
				Throw[0] = Throw[0] + 1;
				break;
				
			case 2:
				Throw[1] = Throw[1] + 1;
				break;
				
			case 3:
				Throw[2] = Throw[2] + 1;
				break;
				
			case 4:
				Throw[3] = Throw[3] + 1;
				break;
				
			case 5:
				Throw[4] = Throw[4] + 1;
				break;
				
			case 6:
				Throw[5] = Throw[5] + 1;
				break;
			}
			
			if (Runs[i] <= 0 || Runs[i] > DiceSides ){
				
				FailOnce = true;
			
			}
		}
		
		for (int n = 0; n < 6; n++){
			
			if (Throw[n] < 4500){
				
				FailRandom = true;
				
			}
			
		}

		if (FailOnce == true || FailRandom == true){
			
			Fail = true;
			
		}
		assertEquals(Fail, false);
  
	}
  
}
