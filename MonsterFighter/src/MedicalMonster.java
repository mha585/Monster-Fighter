
public class MedicalMonster extends Monster{
	/**
	 * The description of MedicalMonster
	 */
	private static String description = "A educated Monster, good at healing and great at being beaten up";
	/**
	 * The price of MedicalMonster
	 */
	private static int price = 250;
	/**
	 * The selling price of MedicalMonster
	 */
	private static int sell = 200;
	/**
	 * generates a random number in a given range
	 */
	private randomGen number = new randomGen();
	/**
	 * The basic constructor for the MedicalMonster class
	 * used when all values but type are given
	 * manually updates the type to "Medical"
	 * @param name			The name of the MedicalMonster
	 * @param maxHealth		The maxHealth of the MedicalMonster
	 * @param healAmount	The healAmount of the MedicalMonster
	 * @param damage		The amount of damage the MedicalMonster does
	 * @param speed			The speed of the MedicalMonster
	 * @param tier			The level of the MedicalMonster
	 * @param sell			Selling price of the MedicalMonster
	 * @param cost			Price of the MedicalMonster
	 * @param description	Description of the MedicalMonster
	 */
	public MedicalMonster(String name, double maxHealth, double healAmount, double damage, double speed, int Tier, 
			int sell, int cost, String description) {
		super(name, maxHealth, healAmount, damage, speed, Tier, sell, cost, description);
		super.setType("Medical");
	}
	/**
	 * The empty constructor for the MedicalMonster class
	 * this gets called when no params are entered.
	 */
	public MedicalMonster() {
		super(price, sell, description);
		super.setType("Medical");
		super.gainDamage((-1 * (super.getDamage())) + (super.getDamage() / 4));
		super.gainMaxHealth((-1 * (super.getMaxHealth())) + number.randNumInRange(100, 200));
		super.gainHealth((-1 * (super.getHealth())) + super.getMaxHealth());
		super.gainDamage((int)((-1 * (super.getDamage())) + (super.getDamage() / 4)));
		super.gainHealAmount((-1 * (super.getHealAmount())) + number.randNumInRange(10, 50));
	}
	/**
	 * Generates a string representation of the MedicalMonster
	 */
	public String toString() {
		return super.toString() + "\nType: " + super.getType();
	}
}
