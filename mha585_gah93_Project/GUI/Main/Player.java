import java.util.ArrayList;
/**
 * This class is used to create an instance of Player who the user controls.
 * 
 * @author Angelo  Gasmin
 * @version 1.0
 */
public class Player {
	/**
	 * Stores the number of days the game will last for.
	 */
	private int playerDays = 1;
	/**
	 * Stores the current day.
	 */
	private int currentDay = 1;
	/**
	 * Stores the player's name.
	 */
	private String playerName;
	/**
	 * Stores the chosen difficulty.
	 */
	private String playerDifficulty;
	/**
	 * Stores the player's current money.
	 */
	private int currentMoney = 250;
	/**
	 * The total money earned throughout the game.
	 */
	private int totalEarned = 250;
	/**
	 * The total points earned throughout the game.
	 */
	private int playerPoints = 0;
	/**
	 * The player's team.
	 */
	public Team playerTeam;
	/**
	 * The player's inventory.
	 */
	public Inventory playerBag;
	/**
	 * The names of the monster's in your team.
	 */
	private ArrayList<String> myTeamNames = new ArrayList<>();
	/**
	 * Basic constructor for player 
	 * @param name				The name of the player
	 * @param day				The days the player has chosen
	 * @param difficulty		The difficulty the player has chosen
	 */
	Player() {
		BasicHeal BH = new BasicHeal();
		AtkPlus AP = new AtkPlus();
		Team newTeam = new Team();
		playerTeam = newTeam;
		Inventory bag = new Inventory();
		playerBag = bag;
		playerBag.addtoBag(BH, 3);
		playerBag.addtoBag(AP, 3);
	}
	/**
	 * Sets the name of the player.
	 * 
	 * @param name		The name of the player
	 */
	public void setName(String name) {
		playerName = name;
	}
	/**
	 * Checks if the name of the player is a proper name
	 * 
	 * @param name      Inputed name
	 * @return          boolean for if name is proper
	 */
	public boolean checkName(String name) {
		if (name.trim().length() >= 3 && name.trim().length() <= 15 && name.trim().matches("[a-zA-Z]+")){
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Sets the number of days the player's adventure will last for.
	 * 
	 * @param days		The number of days the game will last for.
	 */
	public void setDay(int days) {
		playerDays = days;
	}	

	/**
	 * Sets the players difficulty.
	 * 
	 * @param diff		The difficulty the game is set to
	 */
	public void setDifficulty(int diff) {
		if (diff == 1) {
			playerDifficulty = "easy";
		}
		else if (diff == 2) {
			playerDifficulty = "normal";
		}
		else {
			playerDifficulty = "hard";
		}
	}
	/**
	 * Returns the name of the player.
	 * 
	 * @return the name of the player
	 */
	public String getPlayerName() {
		return playerName;
	}
	/**
	 * Returns the difficulty of the game.
	 * 
	 * @return the difficulty of the game
	 */
	public String getDifficulty() {
		return playerDifficulty;
	}
	/**
	 * Return the current day
	 * 
	 * @returns the current day
	 */
	public int getCurrentDay() {
		return currentDay;
	}
	/**
	 * Return the amount of money earned.
	 * 
	 * @return the money earned.
	 */
	public int getMoneyEarned() {
		return totalEarned;
	}
	/**
	 * Return the amount of points the player has.
	 * 
	 * @return the total points a player currently has
	 */
	public int getPoints() {
		return playerPoints;
	}
	/**
	 * Return the days remaining.
	 * 
	 * @return the days remaining before the game finishes	
	 */
	public int daysLeft() {
		return playerDays - currentDay;
	}
	/**
	 * Adds to the current day.
	 */
	public void addDay() {
		currentDay++;
	}
	/**
	 * Return the player's bag.
	 * 
	 * @return the player's bag
	 */
	public Inventory getInventory() {
		return playerBag;
	}
	/**
	 * Return the player's team.
	 * 
	 * @return the player's team
	 */
	public Team getTeam() {
		return playerTeam;
	}
	/**
	 * Return the amount of money the player has left.
	 * 
	 * @return the current amount of money the player has
	 */
	public int getMoney() {
		return currentMoney;
	}
	/**
	 * Adds x amount of money to the player's total money.
	 * 
	 * @param moneyEarned		Money to be added to the player's current money
	 */
	public void addMoney(int moneyEarned) {
		currentMoney += moneyEarned;
		totalEarned += moneyEarned; 
	}
	/**
	 * Adds x amount of points to the player's total points.
	 * 
	 * @param pointsEarned		Points to be added to the player's current points
	 */
	public void addPoints(int pointsEarned) {
		playerPoints += pointsEarned;
	}
	/**
	 * Subtracts x amount of money from the player's total money.
	 * 
	 * @param moneyLost			Money to be deducted to the player's current money
	 */
	public void deductMoney(int moneyLost) {
		currentMoney -= moneyLost;
	}
	/**
	 * return the current amount of days the player has completed
	 * @return the days the player has completed
	 */
	public int getPlayerDay() {
		return playerDays;
	}
}