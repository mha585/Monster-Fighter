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
	 * The current level / teir of the Monster
	 */
	private int myTeir;
	/**
	 * The basic constructor for the Monster class
	 * @param name			The name of the Monster
	 * @param maxHealth		The maxHealth of the Monster
	 * @param healAmount	The healAmount of the Monster
	 * @param damage		The amount of damage the Monster does
	 * @param teir			The level of the Monster
	 */
	public Monster(String name, double maxHealth, double healAmount, double damage, int teir) {
		myName = name;
		myMaxHealth = maxHealth;
		myCurrentHealth = myMaxHealth;
		myHealAmount = healAmount;
		myDamage = damage;
		myTeir = teir;
	}
	/**
	 * Gets the name of the Monster
	 */
	public String getName() {
		return myName;
	}
	/**
	 * Gets the teir / level of the Monster
	 */
	public int getTeir() {
		return myTeir;
	}
	/**
	 * increments the teir / level of the Monster
	 * @param teirGained		The amount the teir increases by
	 */
	public void gainTeir(int teirGained) {
		myTeir += teirGained;
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
				" / " + getMaxHealth() + "\nDamage: " + getDamage() +
				"\nCan heal: " + getHealAmount() + "\nTeir: " + getTeir();
	}
}
