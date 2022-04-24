
import java.util.Arrays;
import java.util.List;

public class RandomMonster extends Monster{
	/**
	 * List containing all possible types of monsters
	 */
	private List<Monster> possibleTypes = Arrays.asList(new WaterMonster(), new FireMonster(), new GrassMonster(), 
			new GlassMonster(), new MedicalMonster(), new HolyMonster());
	/**
	 * generates a random number in a given range
	 */
	private randomGen number = new randomGen();
	/**
	 * generates a random Monster from the list
	 */
	private Monster random = generateMonster();

	
	/**
	 * Gets a random monster from the list of all possible monster types.
	 * This is used to initialise the randomMonster with the given values
	 */	
	public Monster generateMonster() {
		return possibleTypes.get(number.randNumInRange(0, possibleTypes.size()));
	}
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
	 * @param sell			Selling price of the RandomMonster
	 * @param cost			Price of the RandomMonster
	 * @param description	Description of the RandomMonster
	 */
	public RandomMonster(String name, double maxHealth, double healAmount, double damage, double speed, int Tier, 
			int sell, int cost, String description) {
		super(name, maxHealth, healAmount, damage, speed, Tier, sell, cost, description);
		super.setType(random.getType());
	}
	/**
	 * The constructor for the RandomMonster class
	 * this gets called when no params are entered.
	 * uses values from  a random Monster in possibleTypes to construct.
	 * 
	 * As there is no set methods (only gain methods in Monster) we need to set each stat to 0 then
	 * add the randomly generated Monsters stat in order to ensure that the stats
	 * are appropriate to each monster type.
	 */
	public RandomMonster(Player player) {
		super();
		if (player.getDayCompleted() <= 1) {
			super.gainMaxHealth(((-1 * (super.getMaxHealth()))) + random.getMaxHealth());
			super.gainHealth(((-1 * (super.getHealth()))) + random.getHealth());
			super.gainDamage(((-1 * (super.getDamage()))) + random.getDamage());
			super.gainSpeed(((-1 * (super.getSpeed()))) + random.getSpeed());
			super.gainHealAmount(((-1 * (super.getHealAmount()))) + random.getHealAmount());
			super.setType(random.getType());
			super.setDescription(random.getDescription());
			super.setPrice(random.getPrice());
			super.setSellPrice(random.sellPrice());
			if (super.getMaxHealth() > 30) {
				double toSet = -1 * (super.getMaxHealth() - 30);
				super.gainMaxHealth((toSet));
			}
			if (super.getDamage() > 10) {
				double toSet = -1 * (super.getDamage() - 10);
				super.gainDamage((toSet));
			}
			if (super.getSpeed() > 25) {
				double toSet = -1 * (super.getSpeed() - 30);
				super.gainSpeed((toSet));
			}
		}
		
		else {
			super.gainMaxHealth(((-1 * (super.getMaxHealth()))) + random.getMaxHealth());
			super.gainHealth(((-1 * (super.getHealth()))) + random.getHealth());
			super.gainDamage(((-1 * (super.getDamage()))) + random.getDamage());
			super.gainSpeed(((-1 * (super.getSpeed()))) + random.getSpeed());
			super.gainHealAmount(((-1 * (super.getHealAmount()))) + random.getHealAmount());
			super.setType(random.getType());
			super.setDescription(random.getDescription());
			super.setPrice(random.getPrice());
			super.setSellPrice(random.sellPrice());
		}
	}
	/**
	 * Generates a string representation of the RandomMonster
	 */
	public String toString() {
		return super.toString() + "\nType: " + super.getType();
	}
}
