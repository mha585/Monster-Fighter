import java.util.Arrays;
import java.util.List;

public class RandomMonster extends Monster{
	/**
	 * List containing all possible types of monsters
	 */
	private static List<Monster> possibleTypes = Arrays.asList(new WaterMonster(), new FireMonster(), new GrassMonster());
	/**
	 * generates a random number in a given range
	 */
	private static randomGen number = new randomGen();
	/**
	 * Gets a random monster from the list of all possible monster types.
	 * This is used to initialise the randomMonster with the given values
	 */
	private static Monster random = possibleTypes.get(number.randNumInRange(0, possibleTypes.size()));
	/**
	 * The basic constructor for the RandomMonster class
	 * used when all values but type are given
	 * generates a random type using the type of a randomly generated monster
	 * @param name			The name of the RandomMonster
	 * @param maxHealth		The maxHealth of the RandomMonster
	 * @param healAmount	The healAmount of the RandomMonster
	 * @param damage		The amount of damage the RandomMonster does
	 * @param speed			The speed of the RandomMonster
	 * @param tier			The level of the RandomMonster
	 */
	public RandomMonster(String name, double maxHealth, double healAmount, double damage, double speed, int Tier) {
		super(name, maxHealth, healAmount, damage, speed, Tier);
		super.setType(random.getType());
	}
	/**
	 * The constructor for the RandomMonster class
	 * this gets called when no params are entered.
	 * uses values from  a random Monster in possibleTypes to construct
	 */
	public RandomMonster() {
		super(random.getName(), random.getMaxHealth(), random.getHealAmount(), random.getDamage(), random.getSpeed(), random.getTier());
		super.setType(random.getType());
	}
	/**
	 * Generates a string representation of the RandomMonster
	 */
	public String toString() {
		return super.toString() + "\nType: " + super.getType();
	}
}
