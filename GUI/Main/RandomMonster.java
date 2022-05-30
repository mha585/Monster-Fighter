
import java.util.Arrays;
import java.util.List;

public class RandomMonster extends Monster{
	/**
	 * generates a random number in a given range
	 */
	private RandomGen number;

	/**
	 * generates a random Monster from the list
	 */
	private Monster random;

	public List<Monster> getPossibleTypes() {
		return  Arrays.asList(new WaterMonster(number), new FireMonster(number), new GrassMonster(number), 
				new GlassMonster(number), new MedicalMonster(number), new HolyMonster(number));
	}
	
	/**
	 * Gets a random monster from the list of all possible monster types.
	 * This is used to initialise the randomMonster with the given values
	 */	
	public Monster generateMonster() {
		return getPossibleTypes().get(number.randNumInRange(0, getPossibleTypes().size()));
	}
	
	/**
	 * The constructor for the RandomMonster class
	 * this gets called when the player in entered as a paramater
	 * Generates different types of random monsters based on what day it is.
	 * Generates these monsters stats with help from the generateMonsterStats function
	 * 
	 * As there is no set methods (only gain methods in Monster) we need to set each stat to 0 then
	 * add the randomly generated Monsters stat in order to ensure that the stats
	 * are appropriate to each monster type.
	 * @param player	the current player, used to scale the monster stats
	 */
	public RandomMonster(Player player, RandomGen num) {
		super(num);
		number = num;
		random = generateMonster();
		int dayGlassAndMedicalCome = 3;
		int dayHolyComes = 5;
		if (player.getCurrentDay() < dayGlassAndMedicalCome) {
			while (random.getType() != "Fire" && random.getType() != "Grass" && random.getType() != "Water") {
				random = generateMonster();
			}
			generateMonsterStats(player);
		} else if ((player.getCurrentDay() >= dayGlassAndMedicalCome) && (player.getCurrentDay() < dayHolyComes)) {
			while (random.getType() == "Holy") {
				random = generateMonster();
			}
			generateMonsterStats(player);
		} else {
			generateMonsterStats(player);
		}
	}
	/**
	 * Generates the stats for a randomMonster.
	 * scales the stats based on the current day the player is on
	 * @param player	the current player, used to scale the monster stats
	 */
	public void generateMonsterStats(Player player) {

		int amountToScaleStatsBy = (int)(1+(player.getCurrentDay() / 2));
		super.gainMaxHealth(((-1 * (super.getMaxHealth()))) + random.getMaxHealth());
		super.gainHealth(((-1 * (super.getHealth()))) + random.getHealth());
		super.gainDamage(((-1 * (super.getDamage()))) + random.getDamage());
		super.gainSpeed(((-1 * (super.getSpeed()))) + random.getSpeed());
		super.gainHealAmount(((-1 * (super.getHealAmount()))) + random.getHealAmount());
		super.setType(random.getType());
		super.setDescription(random.getDescription());
		super.setPrice((int)(random.getPrice() * (1 + (random.getTier() / 5))));
		super.setSellPrice((int)(random.getPrice() * (1 + (random.getTier() / 5))));
		if (super.getMaxHealth() > (30 * amountToScaleStatsBy)) {
			double toSet = -1 * (super.getMaxHealth() - (30 * amountToScaleStatsBy));
			super.gainMaxHealth((toSet));
			super.gainHealth((toSet));
		}
		if (super.getDamage() > (10 * amountToScaleStatsBy)) {
			double toSet = -1 * (super.getDamage() - (10 * amountToScaleStatsBy));
			super.gainDamage((toSet));
		}
		if (super.getSpeed() > (10 * amountToScaleStatsBy)) {
			double toSet = -1 * (super.getSpeed() - (25 * amountToScaleStatsBy));
			super.gainSpeed((toSet));
		}
	}
}
