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
			"Chog", "Post Malone", "Ratman", "Goopy", "Dinky", "Donkey", "Carla", "Zingle", "Mr. Normal",
			"Mc Murder", "Charlie", "Reese", "Lil-man", "Blobagon");
	/**
	 * Matrix containing how effective each type of monster is against each other.
	 */
	private double[][] howEffective = {{1,0.5,2,2,0.5,0.5,0.5},{2,1,0.5,2,0.5,0.5,0.5},{0.5,2,1,2,0.5,0.5,0.5},{2,2,2,1,2,0.5,0.5},{0.5,0.5,0.5,0.5,1,0.5,0.5},{1,1,1,1,1,1,2},{1,1,1,1,1,2,1}};

	/**
	 * The cost of the Monster
	 */
	private int myShopCost;
	/**
	 * The selling price of the Monster
	 */
	private int myShopSell;
	/**
	 * The selling price of the Monster
	 */
	private String myShopDescription;
	
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
		RandomGen number = new RandomGen();
		myName = name;
		myMaxHealth = maxHealth;
		myCurrentHealth = myMaxHealth;
		myHealAmount = healAmount;
		myDamage = damage;
		mySpeed = speed;
		myExperience = 0;
		myTier = tier;
		myReward = number.randNumInRange(11, 99);
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
	public Monster(int sell, int cost, String description, RandomGen number) {
		myName = possibleNames.get(number.randNumInRange(0, possibleNames.size()));
		myMaxHealth = number.randNumInRange(1, 100);
		myCurrentHealth = myMaxHealth;
		myHealAmount = number.randNumInRange(0, 5);
		myDamage = number.randNumInRange(1, 70);
		mySpeed = number.randNumInRange(1, 15);
		myExperience = 0;
		myReward = number.randNumInRange(11, 99);
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
	public Monster(RandomGen number) {
		myName = possibleNames.get(number.randNumInRange(0, possibleNames.size()));
		myMaxHealth = number.randNumInRange(1, 100);
		myCurrentHealth = myMaxHealth;
		myHealAmount = number.randNumInRange(0, 5);
		myDamage = number.randNumInRange(1, 70);
		mySpeed = number.randNumInRange(1, 15);
		myExperience = 0;
		myDeaths = 0;
		myReward = number.randNumInRange(11, 99);
		myTier = number.randNumInRange(1, 3);
	}
	/**
	 * The constructor for the Monster class.
	 * This gets called when nothing gets entered.
	 */
	public Monster() {
		RandomGen number = new RandomGen();
		myName = possibleNames.get(number.randNumInRange(0, possibleNames.size()));
		myMaxHealth = number.randNumInRange(1, 100);
		myCurrentHealth = myMaxHealth;
		myHealAmount = number.randNumInRange(0, 5);
		myDamage = number.randNumInRange(1, 70);
		mySpeed = number.randNumInRange(1, 15);
		myExperience = 0;
		myDeaths = 0;
		myReward = number.randNumInRange(11, 99);
		myTier = number.randNumInRange(1, 3);
	}
	/**
	 * Gets the name of the Monster
	 * @return String	the name of the Monster
	 */
	public String getName() {
		return myName;
	}
	/**
	 * Gets the tier / level of the Monster
	 * @return int	the tier of the Monster
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
	 * @return double	the max health of the Monster
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
	 * @return double	the damage of the Monster
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
	 * @return double	the heal amount of the Monster
	 */
	public double getHealAmount() {
		return myHealAmount;
	}
	/**
	 * Gets the current health of the Monster
	 * @return double	the current health of the Monster
	 */
	public double getHealth() {
		return myCurrentHealth;
	}
	/**
	 * Gets the current speed of the Monster
	 * @return double	the speed of the Monster
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
	 * if statement to ensure health does not go below 0
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
	 * @return String	the type of the Monster
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
	 * @return double	the experience of the Monster
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
	 * @return double	the number of times the Monster has died
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
		double initialMaxHealth = getMaxHealth();
		gainMaxHealth(amountToAdd);
		gainDamage(amountToAdd / 5);
		gainSpeed(amountToAdd / 8);
		gainHealth(getMaxHealth() - initialMaxHealth);
	}
	/**
	 * Returns the reward for killing the Enemy
	 * @return int	the reward for killing the Monster
	 */
	public int getReward() {
		return myReward;
	}
	/**
	 * Checks how effective an attack is
	 * @param attackerType		The type of attack e.g fire = 0, water = 1
	 * @param victimType		The type of attack e.g grass = 2
	 * @return double	multiplier gained when a monster attacks another type
	 */
	public double getEffectiveness(int attackerType, int victimType) {
		return howEffective[attackerType][victimType];
	}
	/**
	 * Returns the description of a Monster
	 * @return String	the description of the Monster
	 */
	public String getDescription() {
		return myShopDescription;
	}
	/**
	 * Returns the price of a Monster
	 * @return String	the price of the Monster
	 */
	public int getPrice() {
		return myShopCost;
	}
	/**
	 * Returns the selling price of a Monster
	 * @return String	the selling price of the Monster
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
	 * Generates a string representation of the Monster
	 * @return String	the string representation of the monster
	 */
	public String toString() {
		return "Name: " + getName() + "\nCurrent health: " + getHealth() +
				" / " + getMaxHealth() + "\nDamage: " + getDamage() +
				"\nCan heal: " + getHealAmount() + "\nSpeed: " + getSpeed() + "\nTier: " + 
				getTier() + "\nexp: " + (int) getMyExperience() + " / 100";
	}
}
