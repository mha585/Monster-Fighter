public class HolyMonster extends Monster{
	/**
	 * The description of HolyMonster
	 */
	private static String description = "Embodiment of Light and purity, effective against Demon Monsters and resists all but Demon Monsters";
	/**
	 * The price of HolyMonster
	 */
	private static int price = 300;
	/**
	 * The selling price of HolyMonster
	 */
	private static int sell = 150;
	/**
	 * The basic constructor for the HolyMonster class
	 * used when all values but type are given
	 * manually updates the type to Holy"
	 * @param name			The name of the HolyMonster
	 * @param maxHealth		The maxHealth of the HolyMonster
	 * @param healAmount	The healAmount of the HolyMonster
	 * @param damage		The amount of damage the HolyMonster does
	 * @param speed			The speed of the HolyMonster
	 * @param tier			The level of the HolyMonster
	 * @param sell			Selling price of the HolyMonster
	 * @param cost			Price of the HolyMonster
	 * @param description	Description of the HolyMonster
	 */
	public HolyMonster(String name, double maxHealth, double healAmount, double damage, double speed, int Tier, 
			int sell, int cost, String description) {
		super(name, maxHealth, healAmount, damage, speed, Tier, sell, cost, description);
		super.setType("Holy");
	}
	/**
	 * The empty constructor for the HolyMonster class
	 * this gets called when no params are entered.
	 */
	public HolyMonster() {
		super(price, sell, description);
		super.setType("Holy");
	}
	/**
	 * Generates a string representation of the HolyMonster
	 */
	public String toString() {
		return super.toString() + "\nType: " + super.getType();
	}
}