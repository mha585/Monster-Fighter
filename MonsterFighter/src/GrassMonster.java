
public class GrassMonster extends Monster{
	/**
	 * The basic constructor for the GrassMonster class
	 * used when all values but type are given
	 * manually updates the type to "Grass"
	 * @param name			The name of the GrassMonster
	 * @param maxHealth		The maxHealth of the GrassMonster
	 * @param healAmount	The healAmount of the GrassMonster
	 * @param damage		The amount of damage the GrassMonster does
	 * @param speed			The speed of the GrassMonster
	 * @param tier			The level of the GrassMonster
	 */
	public GrassMonster(String name, double maxHealth, double healAmount, double damage, double speed, int Tier) {
		super(name, maxHealth, healAmount, damage, speed, Tier);
	}
	/**
	 * The empty constructor for the GrassMonster class
	 * this gets called when no params are entered.
	 */
	public GrassMonster() {
		super();
		super.setType("Grass");
	}
	/**
	 * Generates a string representation of the GrassMonster
	 */
	public String toString() {
		return super.toString() + "\nType: " + super.getType();
	}
}
