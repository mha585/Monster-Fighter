

public class GrassMonster extends Monster{
	/**
	 * The description of GrassMonster
	 */
	private static String description = "A grassy monster, try to use against water monsters";
	/**
	 * The price of GrassMonster
	 */
	private static int price = 200;
	/**
	 * The selling price of GrassMonster
	 */
	private static int sell = 150;
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
	 * @param sell			Selling price of the GrassMonster
	 * @param cost			Price of the GrassMonster
	 * @param description	Description of the GrassMonster
	 */
	public GrassMonster(String name, double maxHealth, double healAmount, double damage, double speed, int Tier, 
			int sell, int cost, String description) {
		super(name, maxHealth, healAmount, damage, speed, Tier, sell, cost, description);
		super.setType("Grass");
	}
	/**
	 * The empty constructor for the GrassMonster class
	 * this gets called when no params are entered.
	 */
	public GrassMonster() {
		super(price, sell, description);
		super.setType("Grass");
	}
	/**
	 * Generates a string representation of the GrassMonster
	 */
	public String toString() {
		return super.toString() + "\nType: " + super.getType();
	}
}
