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
	
	public int getTeir() {
		return myTeir;
	}
	
	public void setTeir(int teirGained) {
		myTeir += teirGained;
	}
	
	/**
	 * Sets the health of the Monster
	 * if statement to ensure that the current health does not exceed the max health
	 * @param healthChange	The amount the health of the monster changes by
	 */
	public void setHealth(double healthChange) {
		if ((myCurrentHealth + healthChange) <= myMaxHealth) {
			myCurrentHealth += healthChange;
		} else {
			myCurrentHealth = myMaxHealth;
		}
//		probably do an if statement here to see if the monseter isDead?
	}
	
	public String toString() {
		return "my name is " + myName + " and my current health is " + myCurrentHealth +
				" currently I am teir " + myTeir;
	}
	
	public static void main(String[] args) {
		Monster test = new Monster("Test", 100, 5, 5, 2);
		System.out.println(test);
		test.setHealth(-42);
		System.out.println(test);
	}

}
