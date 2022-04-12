import java.util.Arrays;
import java.util.List;
/**
 * This class describes the Monster superclass
 * 
 * @author Matthew Harper
 * @version 1.0
 */
public class Monster implements Purchasable{
	/**
	 * The name of the Monster
	 */
	private String myName;
	/**
	 * The max health of the Monster
	 */
	private double myMaxHealth;
	/**
	 * The current health of the Monster
	 */
	private double myCurrentHealth;
	/**
	 * The heal amount of the Monster
	 */
	private double myHealAmount;
	/**
	 * The damage the Monster deals
	 */
	private double myDamage;
	/**
	 * The speed of the Monster, should determine who attacks first
	 */
	private double mySpeed;
	/**
	 * The amount of experience of the Monster
	 */
	private double myExperience;
	/**
	 * The reward for killing the Monster
	 */
	private int myReward;
	/**
	 * The current level / tier of the Monster
	 */
	private int myTier;
	/**
	 * The current type of the Monster
	 */
	private String myType;
	/**
	 * The amount of times the Monster has died
	 */
	private int myDeaths;
	/**
	 * List containing all possible names for a Monster
	 */
	private List<String> possibleNames = Arrays.asList("Chonky", "Cordoba", "Bart", "Blurple", "Blargle",
			"Chog", "Post Malone", "Ratman", "Goopy");
	/**
	 * The cost of the Monster
	 */
	int myShopCost;
	/**
	 * The selling price of the Monster
	 */
	int myShopSell;
	/**
	 * The selling price of the Monster
	 */
	String myShopDescription;
	/**
	 * The basic constructor for the Monster class
	 * @param name			The name of the Monster
	 * @param maxHealth		The maxHealth of the Monster
	 * @param healAmount	The healAmount of the Monster
	 * @param damage		The amount of damage the Monster does
	 * @param speed			The speed of the Monster
	 * @param tier			The level of the Monster
	 * @param reward		The reward for killing the Monster
	 * @param sell			Selling price of the Monster
	 * @param cost			Price of the Monster
	 * @param description	Description of the Monster
	 */
	public Monster(String name, double maxHealth, double healAmount, double damage, double speed, int tier, 
			int sell, int cost, String description) {
		randomGen number = new randomGen();
		myName = name;
		myMaxHealth = maxHealth;
		myCurrentHealth = myMaxHealth;
		myHealAmount = healAmount;
		myDamage = damage;
		mySpeed = speed;
		myExperience = 0;
		myTier = tier;
		myReward = number.randNumInRange(0, 100);
		myDeaths = 0;
		
		myShopCost = cost;
		myShopSell = sell;
		myShopDescription = description;
	}
	/**
	 * The constructor for the Monster class.
	 * This gets called when only the price in the store gets entered.
	 * @param sell			Selling price of the Monster
	 * @param cost			Price of the Monster
	 * @param description	Description of the Monster
	 */
	public Monster(int sell, int cost, String description) {
		randomGen number = new randomGen();
		myName = possibleNames.get(number.randNumInRange(0, possibleNames.size()));
		myMaxHealth = number.randNumInRange(1, 100);
		myCurrentHealth = myMaxHealth;
		myHealAmount = number.randNumInRange(0, 5);
		myDamage = number.randNumInRange(1, 70);
		mySpeed = number.randNumInRange(1, 15);
		myExperience = 0;
		myReward = number.randNumInRange(0, 100);
		myTier = number.randNumInRange(1, 3);
		myDeaths = 0;
		
		myShopCost = cost;
		myShopSell = sell;
		myShopDescription = description;
	}
	/**
	 * The constructor for the Monster class.
	 * This gets called when nothing gets entered.
	 */
	public Monster() {
		randomGen number = new randomGen();
		myName = possibleNames.get(number.randNumInRange(0, possibleNames.size()));
		myMaxHealth = number.randNumInRange(1, 100);
		myCurrentHealth = myMaxHealth;
		myHealAmount = number.randNumInRange(0, 5);
		myDamage = number.randNumInRange(1, 70);
		mySpeed = number.randNumInRange(1, 15);
		myExperience = 0;
		myDeaths = 0;
		myReward = number.randNumInRange(0, 100);
		myTier = number.randNumInRange(1, 3);
	}
	/**
	 * Gets the name of the Monster
	 */
	public String getName() {
		return myName;
	}
	/**
	 * Gets the tier / level of the Monster
	 */
	public int getTier() {
		return myTier;
	}
	/**
	 * increments the tier / level of the Monster
	 * @param tierGained		The amount the tier increases by
	 */
	public void gainTier(int tierGained) {
		myTier += tierGained;
	}
	/**
	 * Gets the maxHealth of the Monster
	 */
	public double getMaxHealth() {
		return myMaxHealth;
	}
	/**
	 * increments the amount the Monster can heal per turn
	 * @param healGained		The amount healAmount increases by
	 */
	public void gainHealAmount(double healGained) {
		myHealAmount += healGained;
	}
	/**
	 * increments the max health of the Monster
	 * @param healthGained		The amount maxHealth increases by
	 */
	public void gainMaxHealth(double healthGained) {
		myMaxHealth += healthGained;
	}
	/**
	 * Gets the damage of the Monster
	 */
	public double getDamage() {
		return myDamage;
	}
	/**
	 * increments the damage dealt by the Monster
	 * @param damageGained		The amount damage increases by
	 */
	public void gainDamage(double damageGained) {
		myDamage += damageGained;
	}
	/**
	 * Gets the amount the Monster can heal each turn
	 */
	public double getHealAmount() {
		return myHealAmount;
	}
	/**
	 * Gets the current health of the Monster
	 */
	public double getHealth() {
		return myCurrentHealth;
	}
	/**
	 * Gets the current speed of the Monster
	 */
	public double getSpeed() {
		return mySpeed;
	}
	/**
	 * increments the speed of the Monster
	 * @param speedGained		The amount speed increases by
	 */
	public void gainSpeed(double speedGained) {
		mySpeed += speedGained;
	}
	/**
	 * Adds or subtracts health from the Monster
	 * if statement to ensure that the current health does not exceed the max health
	 * if statment to ensure health does not go below 0
	 * @param healthChange	The amount the health of the monster changes by
	 */
	public void gainHealth(double healthChange) {
		if (((getHealth() + healthChange) <= getMaxHealth()) && ((getHealth() + healthChange) > 0) && (getHealth() > 0)) {
			myCurrentHealth += healthChange;
		} else if ((getHealth() + healthChange) <= 0) {
			myCurrentHealth = 0;
		} else if ((getHealth() + healthChange) >= getMaxHealth()) {
			myCurrentHealth = getMaxHealth();
		}
	}
	/**
	 * Used to revive a dead monster.
	 * Sets the health of the dead monster to its max health
	 */
	public void revive() {
		myCurrentHealth = myMaxHealth;
	}
	/**
	 * Gets the type of the Monster
	 */
	public String getType() {
		return myType;
	}
	/**
	 * Sets the type of the Monster
	 * @param type		The type of the Monster
	 */
	public void setType(String type) {
		myType = type;
	}
	/**
	 * Returns the current experience of the Monster
	 */
	public double getMyExperience() {
		return myExperience;
	}
	/**
	 * Sets the experience of the Monster
	 * checks if the experience is above 100 and if it is the monster levels up
	 * @param healthChange	The amount the health of the monster changes by
	 */
	public void gainExperience(double experience) {
		myExperience += experience;
		while (myExperience >= 100) {
			levelUp();
			myExperience -= 100;
		}
	}
	/**
	 * Gets the amount of time the Monster has died
	 */
	public double getDeaths() {
		return myDeaths;
	}
	/**
	 * increments the speed of the Monster by 1
	 */
	public void gainDeaths() {
		myDeaths += 1;
	}
	/**
	 * Levels up the Monster
	 * increases the Tier by one and increases the maxHealth and damage by the new Tier
	 */
	public void levelUp() {
		gainTier(1);
		double amountToAdd = (getTier() * 2);
		gainMaxHealth(amountToAdd);
		gainDamage(amountToAdd / 5);
		gainSpeed(amountToAdd / 8);
	}
	/**
	 * Returns the reward for killing the Enemy
	 */
	public int getReward() {
		return myReward;
	}
	/**
	 * Generates a string representation of the Monster
	 */
	public String toString() {
		return "Name: " + getName() + "\nCurrent health: " + getHealth() +
				" / " + getMaxHealth() + "\nDamage: " + (int) getDamage() +
				"\nCan heal: " + getHealAmount() + "\nSpeed: " + getSpeed() + "\nTier: " + 
				getTier() + "\nexp: " + (int) getMyExperience() + " / 100";
	}
	/**
	 * Returns the description of a Monster
	 */
	public String getDescription() {
		return myShopDescription;
	}
	/**
	 * Returns the price of a Monster
	 */
	public int getPrice() {
		return myShopCost;
	}
	/**
	 * Returns the selling price of a Monster
	 */
	public int sellPrice() {
		return myShopSell;
	}
	/**
	 * Sets the description of a Monster
	 * @param newDescription	The new cost of the monster.
	 */
	public void setDescription(String newDescription) {
		myShopDescription = newDescription;
	}
	/**
	 * Sets the price of a Monster
	 * @param newPrice		The new price of the monster.
	 */
	public void setPrice(int newPrice) {
		myShopCost = newPrice;
	}
	/**
	 * Sets the cost of a Monster
	 * @param newPrice		The new cost of the monster.
	 */
	public void setSellPrice(int newCost) {
		myShopCost = newCost;
	}
	/**
	 * Adds a Monster to the trainers bag
	 * Deducts money from the trainer based on the price of the Monster
	 */
	public void buyMonster(Monster friend, Team friends) {
		
	}
	/**
	 * Removes a Monster from the trainers team
	 * Gives money to the trainer based on the selling price of the item
	 */
	public void sellMonster(Monster friend, Team friends) {
		//remove item from bag
		//+money (does the money go in the bag? if so add Inventory bag)
	}
}
