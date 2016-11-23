package diceGame;

public class Messages {
	private static String[] fieldMessages = {
/*Field 1*/			"Du ankommer til en fÃ¦stning med meget hÃ¸je mure. Indbyggerne kan ikke komme ud. De betaler dig 5000 som tak, da du foreslÃ¥r dem at lave en port i muren."
/*Field 2*/			,"Du ankommer til en Guldmine! En masse sure dvÃ¦rge kommer ud og stjÃ¦ler 2000 fra dig."																		
/*Field 3*/			,"Du ankommer til en Lejr hvor alle beboerne stammer."																										
/*Field 4*/			,"Du ankommer til en havn hvor det berÃ¸mte skib â€�Sejl nr. 2â€� ligger til kaj."																				
/*Field 5*/			,"Du ankommer til et krater."																																
/*Field 6*/			,"Du ankommer til er bjerg."																																
/*Field 7*/			,"Du ankommer til nogle bjerghytter der er beboet af venlige nisser." 																						
/*Field 8*/			,"Du ankommer til en gold og forfrossen Ã¸rken."																												
/*Field 9*/			,"Du ankommer til en havn hvor det gigantiske lyserÃ¸de skib â€�Hav Croverâ€� ligger til kaj."			
/*Field 10*/		,"Du ankommer til en meget uhyggelig mÃ¸rk grotte der er til salg."			
/*Field 11*/		,"Du ankommer til den berygtede varulvemur."			
/*Field 12*/		,"Du ankommer til et kloster. Her tilbeder munkene pengeguden Yllâ€™an. De giver dig 500."			
/*Field 13*/		,"Du ankommer til en campingvogn. Ud kommer der en hillbilly med et haglgevÃ¦r. Betal ham 4000 eller 10% af alt hvad du ejer."				
/*Field 14*/		,"Du mÃ¸der en venlig pirat, der giver dig en enestÃ¥ende mulighed for at kÃ¸be hans sÃ¸rÃ¸verskib."		
/*Field 15*/		,"Du ankommer til et stort hul i jorden."				
/*Field 16*/		,"Du ankommer til en bjergby."		
/*Field 17*/		,"Du ankommer til Den sydlige hovedstad. Borgmesteren er virkelig fuld, og han tilbyder dig at kÃ¸be hele byen."		
/*Field 18*/		,"Du ankommer til et meget stort og flot palads."			
/*Field 19*/		,"Du mÃ¸der kaptajnen for en flÃ¥de af lejesoldater."		
/*Field 20*/		,"Du mÃ¸der en gal troldmand i et hÃ¸jt tÃ¥rn. Han tryller sine egne bukser om til guld, og tilbyder dig at kÃ¸be tÃ¥rnet."				
/*Field 21*/		,"Du ankommer til kongerigets slot."				
	};
	private static String[] fieldNames = {
			"FÃ¦stning" 					//Field 1
			,"Guldmine"					//Field 2
			,"Stamme Lejr"				//Field 3
			,"Sejl nr. 2"				//Field 4
			,"Krater"					//Field 5
			,"Bjerg"					//Field 6
			,"Bjerghytter"			    //Field 7
			,"Kold Ã˜rken"				//Field 8
			,"Hav Grover"				//Field 9
			,"Grotte"					//Field 10
			,"Varulvemuren"				//Field 11
			,"Kloster"					//Field 12
			,"Campingvogn"				//Field 13
			,"SÃ¸rÃ¸verskibet"			//Field 14
			,"Hullet"					//Field 15
			,"Bjergby"					//Field 16
			,"Den sydlige hovedstad"	//Field 17
			,"Palads"					//Field 18
			,"Lejesoldater"				//Field 19
			,"TÃ¥rn"						//Field 20
			,"Slot"						//Field 21
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
	/*0*/	"Denne ejendom er ikke ejet af nogen spiller. Vil du kÃ¸be den for ", 	
	/*1*/	"Ja",					
	/*2*/	"Nej",					
	/*3*/	"Du har nu to muligheder",	
	/*4*/	"Betal ",				
	/*5*/	"% af alle ejendele ",	
	/*6*/	"Vil du starte et nyt spil?",
	/*7*/	"SlÃ¥ med terningerne",
	/*8*/	"Hvor mange spillere skal deltage i spillet?",
	/*9*/	"Du er landet pÃ¥ en anden spillers ejendom. Du skal betale ",
	/*10*/	"Spiller ",
	/*11*/	"Det er ",
	/*12*/	"'s tur.",
	/*13*/	"Du er landet pÃ¥ en arbejdslejr og skal slÃ¥ med terningerne, for at bestemme hvor meget du skal betale i leje.",
	/*14*/	"Tillykke ",
	/*15*/	", du har vundet spillet!",
	/*16*/	" i leje.",
	/*17*/	"Du skal betale ",
	/*18*/	" til skattefar.",
	/*19*/	"Du modtager ",
	/*20*/	"Du er landet pÃ¥ din egen ejendom og nyder de dejlige omgivelser.",
	/*21*/	"Ejeren af denne ejendom er gÃ¥et bankerot, og du slipper derfor for at betale leje.",
	/*22*/	"",
	/*23*/	"",
	/*24*/	"",
	/*25*/  "Du har ikke nok penge til at købe dette felt",
	/*26*/  "ok",
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
