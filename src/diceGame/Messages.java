package diceGame;

public class Messages {
	private static String[] fieldMessages = {
/*Field 1*/			"Du ankommer til en fæstning med meget høje mure. Indbyggerne kan ikke komme ud. De betaler dig 5000 som tak, da du foreslår dem at lave en port i muren."
/*Field 2*/			,"Du ankommer til en Guldmine! En masse sure dværge kommer ud og stjæler 2000 fra dig."																		
/*Field 3*/			,"Du ankommer til en Lejr hvor alle beboerne stammer."																										
/*Field 4*/			,"Du ankommer til en havn hvor det berømte skib 'Sejl nr. 2' ligger til kaj."																				
/*Field 5*/			,"Du ankommer til et krater."																																
/*Field 6*/			,"Du ankommer til et bjerg."																																
/*Field 7*/			,"Du ankommer til nogle bjerghytter der er beboet af venlige nisser." 																						
/*Field 8*/			,"Du ankommer til en gold og forfrossen ørken."																												
/*Field 9*/			,"Du ankommer til en havn hvor det gigantiske lyserøde skib 'Hav Crover' ligger til kaj."			
/*Field 10*/		,"Du ankommer til en meget uhyggelig mørk grotte der er til salg."			
/*Field 11*/		,"Du ankommer til den berygtede varulvemur."			
/*Field 12*/		,"Du ankommer til et kloster. Her tilbeder munkene pengeguden Yll'an. De giver dig 500."			
/*Field 13*/		,"Du ankommer til en campingvogn. Ud kommer der en hillbilly med et haglgevær. Betal ham 4000 eller 10% af alt hvad du ejer."				
/*Field 14*/		,"Du møder en venlig pirat, der giver dig en enestående mulighed for at købe hans sørøverskib."		
/*Field 15*/		,"Du ankommer til et stort hul i jorden."				
/*Field 16*/		,"Du ankommer til en bjergby."		
/*Field 17*/		,"Du ankommer til Den sydlige hovedstad. Borgmesteren er virkelig fuld, og han tilbyder dig at købe hele byen."		
/*Field 18*/		,"Du ankommer til et meget stort og flot palads."			
/*Field 19*/		,"Du møder kaptajnen for en flåde af lejesoldater."		
/*Field 20*/		,"Du møder en gal troldmand i et højt tårn. Han tryller sine egne bukser om til guld, og tilbyder dig at købe tårnet."				
/*Field 21*/		,"Du ankommer til kongerigets slot."				
	};
	private static String[] fieldNames = {
			"Fæstning" 					//Field 1
			,"Guldmine"					//Field 2
			,"Stamme Lejr"				//Field 3
			,"Sejl nr. 2"				//Field 4
			,"Krater"					//Field 5
			,"Bjerg"					//Field 6
			,"Bjerghytter"			    //Field 7
			,"Kold Ørken"				//Field 8
			,"Hav Grover"				//Field 9
			,"Grotte"					//Field 10
			,"Varulvemuren"				//Field 11
			,"Kloster"					//Field 12
			,"Campingvogn"				//Field 13
			,"Sørøverskibet"			//Field 14
			,"Hullet"					//Field 15
			,"Bjergby"					//Field 16
			,"Den sydlige hovedstad"	//Field 17
			,"Palads"					//Field 18
			,"Lejesoldater"				//Field 19
			,"Tårn"						//Field 20
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
	/*0*/	"Denne ejendom er ikke ejet af nogen spiller. Vil du købe den for ", 	
	/*1*/	"Ja",					
	/*2*/	"Nej",					
	/*3*/	"Du har nu to muligheder",	
	/*4*/	"Betal ",				
	/*5*/	"% af alle ejendele ",	
	/*6*/	"Vil du starte et nyt spil?",
	/*7*/	"Slå med terningerne",
	/*8*/	"Hvor mange spillere skal deltage i spillet?",
	/*9*/	"Du er landet på en anden spillers ejendom. Du skal betale ",
	/*10*/	"Spiller ",
	/*11*/	"Det er ",
	/*12*/	"'s tur.",
	/*13*/	"Du er landet på en arbejdslejr og skal slå med terningerne, for at bestemme hvor meget du skal betale i leje.",
	/*14*/	"Tillykke ",
	/*15*/	", du har vundet spillet!",
	/*16*/	" i leje.",
	/*17*/	"Du skal betale ",
	/*18*/	" til skattefar.",
	/*19*/	"Du modtager ",
	/*20*/	"Du er landet på din egen ejendom og nyder de dejlige omgivelser.",
	/*21*/	"Ejeren af denne ejendom er gået bankerot, og du slipper derfor for at betale leje.",
	/*22*/	"Leje: ",
	/*23*/	"Leje: 500, 1000, 2000, 5000",
	/*24*/	"Leje: 100*øjne*labor camps ejet",
	/*25*/  "Du har ikke nok penge til at købe dette felt.",
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
