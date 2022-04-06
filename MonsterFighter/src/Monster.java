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
	
	public String getName() {
		return myName;
	}
	
	public int getTeir() {
		return myTeir;
	}
	
	public void gainTeir(int teirGained) {
		myTeir += teirGained;
	}
	
	public double getMaxHealth() {
		return myMaxHealth;
	}
	
	public void gainMaxHealth(double healthGained) {
		myMaxHealth += healthGained;
	}
	
	/**
	 * Sets the health of the Monster
	 * if statement to ensure that the current health does not exceed the max health
	 * @param healthChange	The amount the health of the monster changes by
	 */
	public void gainHealth(double healthChange) {
		if ((myCurrentHealth + healthChange) <= myMaxHealth) {
			myCurrentHealth += healthChange;
			if (myCurrentHealth <= 0) {
				System.out.println("This is dead so do something");
			}
		} else {
			myCurrentHealth = myMaxHealth;
		}
	}
	
	public String toString() {
		return "name: " + getName() + "\ncurrent health: " + myCurrentHealth +
				" / " + myMaxHealth + "\nteir: " + myTeir;
	}
	
	public static void main(String[] args) {
		Monster test = new Monster("Test", 100, 5, 5, 2);
		System.out.println(test);
		test.gainHealth(-42);
		System.out.println(test);
	}
}
