
public class WaterMonster extends Monster{
	/**
	 * The basic constructor for the WaterMonster class
	 * used when all values but type are given
	 * manually updates the type to "Water"
	 * @param name			The name of the WaterMonster
	 * @param maxHealth		The maxHealth of the WaterMonster
	 * @param healAmount	The healAmount of the WaterMonster
	 * @param damage		The amount of damage the WaterMonster does
	 * @param speed			The speed of the WaterMonster
	 * @param tier			The level of the WaterMonster
	 */
	public WaterMonster(String name, double maxHealth, double healAmount, double damage, double speed, int Tier) {
		super(name, maxHealth, healAmount, damage, speed, Tier);
		super.setType("Water");
	}
	/**
	 * The empty constructor for the WaterMonster class
	 * this gets called when no params are entered.
	 */
	public WaterMonster() {
		super();
		super.setType("Water");
		super.gainMaxHealth((-1 * (super.getMaxHealth())) + 1 );
		super.gainHealth((-1 * (super.getHealth())) + 1);
	}
	/**
	 * Generates a string representation of the WaterMonster
	 */
	public String toString() {
		return super.toString() + "\nType: " + super.getType();
	}
}
