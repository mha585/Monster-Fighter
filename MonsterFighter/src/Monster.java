import java.util.Arrays;
import java.util.List;
/**
 * This class describes the Monster superclass
 * 
 * @author Matthew Harper
 * @version 1.0
 */
public class Monster {
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
	 * The current level / tier of the Monster
	 */
	private int myTier;
	/**
	 * List containing all possible names for a Monster
	 */
	private List<String> possibleNames = Arrays.asList("Chonky", "Cordoba", "Bart", "Blurple", "Blargle",
			"Chog", "Post Malone", "Ratman", "Goopy");
	/**
	 * The basic constructor for the Monster class
	 * @param name			The name of the Monster
	 * @param maxHealth		The maxHealth of the Monster
	 * @param healAmount	The healAmount of the Monster
	 * @param damage		The amount of damage the Monster does
	 * @param speed			The speed of the Monster
	 * @param tier			The level of the Monster
	 */
	public Monster(String name, double maxHealth, double healAmount, double damage, double speed, int tier) {
		myName = name;
		myMaxHealth = maxHealth;
		myCurrentHealth = myMaxHealth;
		myHealAmount = healAmount;
		myDamage = damage;
		mySpeed = speed;
		myTier = tier;
	}
	/**
	 * The constructor for the Monster class
	 * this gets called when no params are entered.
	 */
	public Monster() {
		randomGen number = new randomGen();
		myName = possibleNames.get(number.randNumInRange(0, possibleNames.size()));
		myMaxHealth = number.randNumInRange(0, 100);
		myCurrentHealth = myMaxHealth;
		myHealAmount = number.randNumInRange(0, 5);
		myDamage = number.randNumInRange(1, 20);
		mySpeed = number.randNumInRange(1, 15);
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
	 * @param healthChange	The amount the health of the monster changes by
	 */
	public void gainHealth(double healthChange) {
		if ((getHealth() + healthChange) <= getMaxHealth()) {
			myCurrentHealth += healthChange;
			if (getHealth() <= 0) {
				System.out.println("This is dead so do something");
			}
		} else {
			myCurrentHealth = getMaxHealth();
		}
	}
	/**
	 * Generates a string representation of the Monster
	 */
	public String toString() {
		return "Name: " + getName() + "\nCurrent health: " + getHealth() +
				" / " + getMaxHealth() + "\nDamage: " + (int) getDamage() +
				"\nCan heal: " + getHealAmount() + "\nSpeed: " + getSpeed() + "\nTier: " + getTier();
	}
}
