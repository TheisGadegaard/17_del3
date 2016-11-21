package diceGame;

public class Messages {
	private static String[] fieldMessages = {
			"Walled city" 			//Field 1
			,"Goldmine"				//Field 2
			,"Tribe Encampment"		//Field 3
			,"Second Sail"			//Field 4
			,"Crater"				//Field 5
			,"Mountain"				//Field 6
			,"Huts in the mountain" //Field 7
			,"Cold Desert"			//Field 8
			,"Sea Grover"			//Field 9
			,"Black cave"			//Field 10
			,"The Werewall"			//Field 11
			,"Monastery"			//Field 12
			,"Caravan"				//Field 13
			,"The Buccaneers"		//Field 14
			,"The pit"				//Field 15
			,"Mountain village"		//Field 16
			,"South Citadel"		//Field 17
			,"Palace gates"			//Field 18
			,"Privateer armada"		//Field 19
			,"Tower"				//Field 20
			,"Castle"				//Field 21
	};
	private static String[] fieldNames = {
			"Walled city" 			//Field 1
			,"Goldmine"				//Field 2
			,"Tribe Encampment"		//Field 3
			,"Second Sail"			//Field 4
			,"Crater"				//Field 5
			,"Mountain"				//Field 6
			,"Huts in the mountain" //Field 7
			,"Cold Desert"			//Field 8
			,"Sea Grover"			//Field 9
			,"Black cave"			//Field 10
			,"The Werewall"			//Field 11
			,"Monastery"			//Field 12
			,"Caravan"				//Field 13
			,"The Buccaneers"		//Field 14
			,"The pit"				//Field 15
			,"Mountain village"		//Field 16
			,"South Citadel"		//Field 17
			,"Palace gates"			//Field 18
			,"Privateer armada"		//Field 19
			,"Tower"				//Field 20
			,"Castle"				//Field 21
	};
	private static String[] boardMessages = {
			"Pris:",				//0	
			"Leje:", 				//1
			"Modtag:",				//2
			"Betal:",				//3
			"eller",				//4
			"af alle ejendele",		//5
	};
	
	private static String[] generalMessages = {
			"Dette felt er ikke ejet af nogen spiller. Vil du købe det for ", 	//0
			"Ja",					//1
			"Nej",					//2
			"Du har nu to muligheder",	//3
			"Betal ",				//4
			"% af alle ejendele "	//5
	};

	public static String[] getFMessages(){
		return fieldMessages;
	}

	public static String[] getFNames(){
		return fieldNames;
	}
	
	public static String[] getBMessages(){
		return boardMessages;
	}

	public static String[] getGMessages(){
		return generalMessages;
	}

}
