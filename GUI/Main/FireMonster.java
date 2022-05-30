public class FireMonster extends Monster{
	/**
	 * The description of FireMonster
	 */
	private static String description = "A firey monster, try to use against grass monsters";
	/**
	 * The price of FireMonster
	 */
	private static int price = 200;
	/**
	 * The selling price of FireMonster
	 */
	private static int sell = 150;
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
	 * @param sell			Selling price of the FireMonster
	 * @param cost			Price of the FireMonster
	 * @param description	Description of the FireMonster
	 */
	public FireMonster(String name, double maxHealth, double healAmount, double damage, double speed, int Tier, 
			int sell, int cost, String description) {
		super(name, maxHealth, healAmount, damage, speed, Tier, sell, cost, description);
		super.setType("Fire");
	}
	/**
	 * The empty constructor for the FireMonster class
	 * this gets called when only the RandomGen is entered
	 * @param num used by RandomMonster to generate stats
	 */
	public FireMonster(RandomGen num) {
		super(price, sell, description, num);
		super.setType("Fire");
	}
}