

public class WaterMonster extends Monster{
	/**
	 * The description of WaterMonster
	 */
	private static String description = "A watery monster, try to use against fire monsters";
	/**
	 * The price of WaterMonster
	 */
	private static int price = 200;
	/**
	 * The selling price of WaterMonster
	 */
	private static int sell = 150;
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
	 * @param sell			Selling price of the WaterMonster
	 * @param cost			Price of the WaterMonster
	 * @param description	Description of the WaterMonster
	 */
	public WaterMonster(String name, double maxHealth, double healAmount, double damage, double speed, int Tier, 
			int sell, int cost, String description) {
		super(name, maxHealth, healAmount, damage, speed, Tier, sell, cost, description);
		super.setType("Water");
	}
	/**
	 * The empty constructor for the WaterMonster class
	 * this gets called when no params are entered.
	 */
	public WaterMonster(RandomGen num) {
		super(price, sell, description, num);
		super.setType("Water");
	}
	/**
	 * Generates a string representation of the WaterMonster
	 */
	public String toString() {
		return super.toString() + "\nType: " + super.getType();
	}
}
