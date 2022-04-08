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
	private int currentDay = 0;
	/**
	 * Stores the player's name
	 */
	private String playerName;
	/**
	 * Stores the chosen difficulty
	 */
	private String playerDifficulty;
	/**
	 * Stores the player's monsters
	 */
	public ArrayList<Monster> playerParty;
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
		ArrayList<Monster> party = new ArrayList<Monster>();
		playerParty = party;
	}
	/**
	 * @return the days remaining before the game finishes	
	 */
	public int daysLeft() {
		return playerDays - currentDay;
	}
	/** 
	 * @return each monster in the ArrayList "playerParty" in String form
	 */
	public String listToString() {
		for (int i = 0; i < playerParty.size();i++) {
			Monster monster = playerParty.get(i);
			System.out.println("\n Name: " + monster.getName() + "\n Current health: " + monster.getHealth() +" / " + monster.getMaxHealth() + "\n Damage: " + monster.getDamage() +"\n Can heal: " + monster.getHealAmount() + "\n Tier: " + monster.getTier() +"\n");
		}
		return"";
	}
	/**
	 * @return Player in String form
	 */
	public String toString() {
		System.out.println( "\nName: " + playerName + "\nDays: " + daysLeft() + "\nDifficulty: " + playerDifficulty + "\nParty");
		return listToString();
	}
}
