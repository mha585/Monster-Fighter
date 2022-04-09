
public class FireMonster extends Monster{
	/**
	 * The basic constructor for the FireMonster class
	 * used when all values but type are given
	 * manually updates the type to "Fire"
	 * @param name			The name of the FireMonster
	 * @param maxHealth		The maxHealth of the FireMonster
	 * @param healAmount	The healAmount of the FireMonster
	 * @param damage		The amount of damage the FireMonster does
	 * @param speed			The speed of the FireMonster
	 * @param tier			The level of the FireMonster
	 */
	public FireMonster(String name, double maxHealth, double healAmount, double damage, double speed, int Tier) {
		super(name, maxHealth, healAmount, damage, speed, Tier);
	}
	/**
	 * The empty constructor for the FireMonster class
	 * this gets called when no params are entered.
	 */
	public FireMonster() {
		super();
		super.setType("Fire");
	}
	/**
	 * Generates a string representation of the FireMonster
	 */
	public String toString() {
		return super.toString() + "\nType: " + super.getType();
	}
}
