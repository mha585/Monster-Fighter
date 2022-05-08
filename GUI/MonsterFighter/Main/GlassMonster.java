public class GlassMonster extends Monster{
	/**
	 * The description of GlassMonster
	 */
	private static String description = "A glass cannon, effective against all (except Holy and Demon) but easily slain";
	/**
	 * The price of GlassMonster
	 */
	private static int price = 250;
	/**
	 * The selling price of GlassMonster
	 */
	private static int sell = 200;
//	/**
//	 * generates a random number in a given range
//	 */
//	private RandomGen num;
	/**
	 * The basic constructor for the GlassMonster class
	 * used when all values but type are given
	 * manually updates the type to "Glass"
	 * @param name			The name of the GlassMonster
	 * @param maxHealth		The maxHealth of the GlassMonster
	 * @param healAmount	The healAmount of the GlassMonster
	 * @param damage		The amount of damage the GlassMonster does
	 * @param speed			The speed of the GlassMonster
	 * @param tier			The level of the GlassMonster
	 * @param sell			Selling price of the GlassMonster
	 * @param cost			Price of the GlassMonster
	 * @param description	Description of the GlassMonster
	 */
	public GlassMonster(String name, double maxHealth, double healAmount, double damage, double speed, int Tier, 
			int sell, int cost, String description) {
		super(name, maxHealth, healAmount, damage, speed, Tier, sell, cost, description);
		super.setType("Glass");
	}
	/**
	 * The empty constructor for the GlassMonster class
	 * this gets called when no params are entered.
	 */
	public GlassMonster(RandomGen num) {
		super(price, sell, description, num);
		super.setType("Glass");
		super.gainMaxHealth((-1 * (super.getMaxHealth())) + (int) super.getMaxHealth() / 2);
		super.gainHealth((-1 * (super.getHealth())) + super.getMaxHealth());
		super.gainDamage(super.getDamage() + 10);
	}
	/**
	 * Generates a string representation of the GlassMonster
	 * @return String	 a string representation of the RandomMonster
	 */
	public String toString() {
		return super.toString() + "\nType: " + super.getType();
	}
}