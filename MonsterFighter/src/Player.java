import java.util.ArrayList;
/**
 * 
 * @author Angelo  Gasmin
 * @version 1.0
 */
public class Player {
	/**
	 * Stores the number of player days
	 */
	private int playerDays;
	/**
	 * Stores the current day
	 */
	private int currentDay = 1;
	/**
	 * Stores the player's name
	 */
	private String playerName;
	/**
	 * Stores the chosen difficulty
	 */
	private String playerDifficulty;
	/**
	 * Stores the player's current money
	 */
	private int currentMoney = 250;

	public Team playerTeam;
	
	public Inventory playerBag;
	
	private ArrayList<String> myTeamNames = new ArrayList<>();
	
	
	/**
	 * Basic constructor for player 
	 * @param name				The name of the player
	 * @param day				The days the player has chosen
	 * @param difficulty		The difficulty the player has chosen
	 */
	Player(String name, int day, String difficulty) {
		playerName = name;
		playerDays = day;
		playerDifficulty = difficulty;
		Team newTeam = new Team();
		playerTeam = newTeam;
		Inventory bag = new Inventory();
		playerBag = bag;
		
	/**
	 * @returns the current day
	 */
	}
	public int today() {
		return currentDay;
	}
	/**
	 * @return the days remaining before the game finishes	
	 */
	public int daysLeft() {
		return playerDays - currentDay;
	}
	public void addDay() {
		currentDay++;
	}
	/**
	 * @return the current amount of money the player has
	 */
	public int getMoney() {
		return currentMoney;
	}
	/**
	 * @param moneyEarned		Money to be added to the player's current money
	 * @return					New current money
	 */
	public int addMoney(int moneyEarned) {
		return currentMoney += moneyEarned;
	}
	/**
	 * @param moneyLost			Money to be deducted to the player's current money
	 * @return					New current money
	 */
	public int deductMoney(int moneyLost) {
		return currentMoney -= moneyLost;
	}
	/** 
	 * @return each monster in the ArrayList "playerParty" in String form
	 */
	public String partyToString(Team currentTeam) {
		return currentTeam.toString();
	}
	
	public String bagToString(Inventory currentBag) {
		return currentBag.toString();
	}
	public Inventory getInventory() {
		return playerBag;
	}
	public Team getTeam() {
		return playerTeam;
	}
	public ArrayList<String> getTeamNames() {
		for(int i = 0; i < playerTeam.getSize(); i++){
			myTeamNames.add(((Team) playerTeam).getFriend(i).getName());
		}
		return myTeamNames;
	}
	/**
	 * @return Player in String form
	 */
	public String toString() {
		System.out.println("\nCurrent Day: " + today() + "\nDays Left: " + daysLeft() + "\nMoney: $" + getMoney() + "\n\nParty:");
		System.out.println(partyToString(playerTeam) + "\n\nBag:");
		System.out.println(bagToString(playerBag));
		return "";
	}
}
