public class DemonMonster extends Monster{
	/**
	 * The description of DemonMonster
	 */
	private static String description = "A demonic monster, effective against Holy Monsters and resists all but Holy Monsters";
	/**
	 * The price of DemonMonster
	 */
	private static int price = 250;
	/**
	 * The selling price of DemonMonster
	 */
	private static int sell = 200;

	/**
	 * The basic constructor for the DemonMonster class
	 * used when all values but type are given
	 * manually updates the type to "Demon"
	 * @param name			The name of the DemonMonster
	 * @param maxHealth		The maxHealth of the DemonMonster
	 * @param healAmount	The healAmount of the DemonMonster
	 * @param damage		The amount of damage the DemonMonster does
	 * @param speed			The speed of the DemonMonster
	 * @param tier			The level of the DemonMonster
	 * @param sell			Selling price of the DemonMonster
	 * @param cost			Price of the DemonMonster
	 * @param description	Description of the DemonMonster
	 */
	public DemonMonster(String name, double maxHealth, double healAmount, double damage, double speed, int Tier, 
			int sell, int cost, String description) {
		super(name, maxHealth, healAmount, damage, speed, Tier, sell, cost, description);
		super.setType("Demon");
	}
	/**
	 * The empty constructor for the DemonMonster class
	 * this gets called when only the RandomGen is entered
	 * @param num used by RandomMonster to generate stats
	 */
	public DemonMonster(RandomGen num) {
		super(price, sell, description, num);
		super.setType("Demon");
	}
	/**
	 * Generates a string representation of the DemonMonster
	 * @return String	 a string representation of the DemonMonster
	 */
	public String toString() {
		return super.toString() + "\nType: " + super.getType();
	}
}