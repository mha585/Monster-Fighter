import java.util.Scanner;
/**
 * 
 * @author Angelo  Gasmin
 * @version 1.0
 */
public class Initialize {
	/**
	 * Stores the player's chosen name, will be used to construct Player
	 */
	private static String playerName;
	/**
	 * Stores the player's chosen amount days, will be used to construct Player
	 */
	private static int playerDays;
	/**
	 * Stores the player's chosen difficulty, will be used to construct Player
	 */
	private static String playerDiff;
	
	/**
	 * Players difficulty = easy
	 */
	private static String easy = "easy";
	/**
	 * Players difficulty = medium
	 */
	private static String normal = "normal";
	/**
	 * Players difficulty = hard
	 */
	private static String hard = "hard";

	/**
	 * Asks for players name, sets playerName to input
	 * @param inputName			Scanner to check input
	 */
	public static void setPlayerName(Scanner inputName) {
		boolean isProper = false;
		while(isProper == false) {
			System.out.println("Please enter a name: \nMust be between 3 and 15 characters. \nMust not contain numbers or special characters. ");
			String givenName = inputName.nextLine();
			if(givenName.trim().length() < 3 || givenName.trim().length() > 15) {
				System.out.println("Name must be between 3 and 15 characters.");
			}
			else if(givenName.trim().matches("[a-zA-Z]+") == false) {
				System.out.println("Invalid characters detected.");
			}
			else {
				playerName = givenName;
				isProper = true;
			}
		}
	}
	/**
	 * Asks for how many days the player wants
	 * @param inputDay			Scanner to check input
	 */
	public static void setDays(Scanner inputDay) {
		boolean isDay = false;
		while(isDay == false) {
			System.out.println("How many days will your adventure last for? \nEnter a number between 5 and 15.");
			String givenDay = inputDay.nextLine();
			if(givenDay.trim().matches("[a-zA-Z]+") == true) {
				System.out.println("Non-integer characters present. \n");
			}
			else if(Integer.parseInt(givenDay.trim()) < 5 || Integer.parseInt(givenDay.trim()) > 15) {
				System.out.println("Number not in bounds. \n");
			}
			else {
				playerDays = Integer.parseInt(givenDay);
				isDay = true;
			}
		}
	}
	/**
	 * Prompts player to set their difficulty
	 * @param inputDiff			Scanner to check input
	 */
	public static void setDifficulty(Scanner inputDiff) {
		boolean isDiff = false;
		while(isDiff == false) {
			System.out.println("Please select a difficulty. \nType either Easy, Normal or Hard.");
			String givenDiff = inputDiff.nextLine();
			if(givenDiff.toLowerCase().trim().equals(easy)|| givenDiff.toLowerCase().trim().equals(normal)|| givenDiff.toLowerCase().trim().equals(hard)) {
				playerDiff = givenDiff.toLowerCase();
				isDiff = true;
			}
			else {
				System.out.println("" + givenDiff + " is not a valid difficulty level.");
			}
			
		}
	}
	
	/**
	 * Prompts player to pick a monster, choice between 3 monsters
	 * @param inputMonster			Scanner to check input
	 * @param forParty				Player to put monster into player's party
	 */
	public static void selectMonster(Scanner inputMonster, Player forParty) {
		final Monster one = new Monster("firemonster", 50, 5, 20, 1);
		final Monster two = new Monster("grassmonster", 70, 5, 10, 1);
		final Monster three = new Monster("watermonster", 60, 5, 15, 1);
		
		boolean isMonster = false;
		while(isMonster == false) {
			System.out.println("Select your first monster \nType 'one' for " + one.getName() + "\nType 'two' for " + two.getName() + "\nType 'three' for " + three.getName());
			String givenMonster = inputMonster.nextLine();
			if(givenMonster.toLowerCase().trim().equals("one")){
				forParty.playerParty.add(one);
				isMonster = true;
			}
			else if(givenMonster.toLowerCase().trim().equals("two")) {
				forParty.playerParty.add(two);
				isMonster = true;
			}
			else if(givenMonster.toLowerCase().trim().equals("three")) {
				forParty.playerParty.add(three);
				isMonster = true;
			}
		}
	}
	public static void main(String args[]) {
		Scanner scannerName = new Scanner(System.in);
		Scanner scannerDays = new Scanner(System.in);
		Scanner scannerDiff = new Scanner(System.in);
		Scanner scannerMonster = new Scanner(System.in);
		setPlayerName(scannerName);
		System.out.println("");
		setDays(scannerDays);
		System.out.println("");
		setDifficulty(scannerDiff);
		System.out.println("");
		Player newPlayer = new Player(playerName, playerDays, playerDiff);
		selectMonster(scannerMonster, newPlayer);
		System.out.println(newPlayer.toString());
	
		System.out.println("~||~||~||~||~||~||~||~||~||~||~||~||~\n~||~ Let's Begin The Adventure!! ~||~ \n~||~||~||~||~||~||~||~||~||~||~||~||~");

	}
}
