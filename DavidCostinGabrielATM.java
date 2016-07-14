import java.util.Scanner;
public class DavidCostinGabrielATM {

	static String userCont1 = "Aurelian Istodor";
	static String passCont1 = "parola";
	static String sumaCont1 = "1250";
	
	static String userCont2 = "Chirbit Amariei";
	static String passCont2 = "superz";
	static String sumaCont2 = "2250";
	
	static String userCont3 = "Eufrosin Eusebiu";
	static String passCont3 = "valre98";
	static String sumaCont3 = "3250";
	
	static String[][] dataBase = new String[3][3];
	
	static Scanner tst = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		dataBase[0][0] = userCont1; dataBase[0][1] = passCont1; dataBase[0][2] = sumaCont1;
		dataBase[1][0] = userCont2; dataBase[1][1] = passCont2; dataBase[1][2] = sumaCont2;
		dataBase[2][0] = userCont3; dataBase[2][1] = passCont3; dataBase[2][2] = sumaCont3;
		
		System.out.println("Welcome to our bank! Type exit at any moment to terminate the program");

				login();
				
	}
	//Method used for all keyboard input instances.
	
	static String cereString(String a){
		
		System.out.println(a);
		String retur = tst.nextLine();
		if(retur.equals("exit")){
			System.out.println("exiting ATM");
			System.exit(0);
			
		}
		return retur;
	}
	
	static int cereInt(String a){
		
		System.out.println(a);
		int retur = tst.nextInt();
		
		return retur;
	}
		
	// Actual functionality starts here
	static void login(){
					
		String user = cereString("Enter username");
		String parola = cereString("Enter password");
		
		verifyLogin(user,parola);	
		 				
	}
		
	//This was before the use of any proper persistence, so we emulate a database using a 2-dimensional array
	// We check the database and if login successful, we prompt the user to choose either the main menu or to change his/her password.
	
	static void verifyLogin(String userDeVerif, String parolaDeVerif){
				
		boolean logat = false;
		int i=-1;
		for (int j = 0; j < dataBase.length; j++) {
			
			if(userDeVerif.equals(dataBase[j][0]) && parolaDeVerif.equals(dataBase[j][1])){
				System.out.println("Greetings, " + dataBase[j][0]);
				i=j;
				logat = true;
				break;
			}	
		}
		
		if (logat == true){	
				String alegere = cereString("Choose an option:\n1.Change password\n2.Main menu");
				if(alegere.equals("1")||alegere.equalsIgnoreCase("schimbare")){
					
					dataBase[i][1]=schimbareParola(dataBase[i][1]);
					verifyLogin(userDeVerif, dataBase[i][1]);
				} else if(alegere.equals("2")||alegere.equalsIgnoreCase("meniu")){
					
					dataBase[i][2]=operatiiBancare(Integer.parseInt(dataBase[i][2]));	
				} else { 
					
					System.out.println("Invalid selection");
					verifyLogin(userDeVerif, parolaDeVerif);
				}			
			
		}else {
			System.out.println("User does not exist or incorrect password");
			login();
		}
		
		
	
	}

	// password changing with length and confirmation checks
	static String schimbareParola(String passCont) {
		
		String vecheaParola = cereString("Enter current password");
		while(!vecheaParola.equals(passCont)){
			vecheaParola = cereString("Wrong. Try again");
		}
		String nouaParola = "";
			nouaParola = cereString("Enter new password");
			while(nouaParola.length()<4){
				
				nouaParola = cereString("Password must be at least 4 character long");
			}
			String confirmareParola = cereString("Re-type password for confirmation");
			while(!nouaParola.equals(confirmareParola)){
				confirmareParola = cereString("Entries do not match. Try again");
								
			} 
			
		return nouaParola;
	}

	
	//Main menu
	
	private static String operatiiBancare(Integer sumaCont)
	{
		System.out.println("Select an option:\n1.Check account balance\n2.Withdraw\n3.Deposit\n4.Exit");
		String alegere = cereString("");
		
		if(alegere.equals("1")||alegere.equalsIgnoreCase("check")){
			System.out.println("Aveti "+sumaCont+"RON");
			operatiiBancare(sumaCont);
		} else if(alegere.equals("2")||alegere.equalsIgnoreCase("withdraw")) {
			
			sumaCont=extragereSuma(sumaCont);
			operatiiBancare(sumaCont);
		} else if(alegere.equals("3")||alegere.equalsIgnoreCase("deposit")) {
			
			sumaCont=depunereSuma(sumaCont);
			operatiiBancare(sumaCont);
		} else if(alegere.equals("4")||alegere.equalsIgnoreCase("exit")){
			System.out.println("Thank you and come again.");
			userCont1 = dataBase[0][0]; passCont1 = dataBase[0][1]; sumaCont1 = dataBase[0][2];
			userCont2 = dataBase[1][0]; passCont2 = dataBase[1][1]; sumaCont2 = dataBase[1][2];
			userCont3 = dataBase[2][0]; passCont3 = dataBase[2][1]; sumaCont3 = dataBase[2][2];
			login();
											
			} else {
			System.out.println("Unrecognized. Try again.");
			operatiiBancare(sumaCont);
		}
				
		
		return sumaCont.toString();
		
	}

	//Below you will find the deposit and withdrawal methods,
	//we use the Maths methods for absolute values to avoid negative numbers.
	
	private static int depunereSuma(int sumaCont) {

		int sumaDeDepus = cereInt("Enter deposit sum");
		sumaCont += Math.abs(sumaDeDepus);
		System.out.println("Success. You deposited "+Math.abs(sumaDeDepus));
		return sumaCont;
	}

	static int extragereSuma(int sumaCont) {
		int sumaDeExtras = cereInt("Enter withdrawal sum");
		if(Math.abs(sumaDeExtras) <= sumaCont){
			sumaCont -= Math.abs(sumaDeExtras);
			System.out.println("You withdrew "+Math.abs(sumaDeExtras)+" RON.");
		} else {
			System.out.println("Insufficient funds.");
		}
		return sumaCont;
	}
		
}