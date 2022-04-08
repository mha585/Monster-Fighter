/**
 * This class describes the PartyMonsters class
 * this is all the monsters in the players party
 * these PartyMonsters are the same as Monsters
 * however they have the ability to level up and get stronger
 * 
 * @author Matthew Harper
 * @version 1.0
 */
public class PartyMonster extends Monster {
	/**
	 * The amount of experience of the PartyMonster
	 */
	private double myExperience;
	
	/**
	 * The basic constructor for the PartyMonsters class
	 * also initialises myExperience to be 0
	 * @param name			The name of the Monster
	 * @param maxHealth		The maxHealth of the Monster
	 * @param healAmount	The healAmount of the Monster
	 * @param damage		The amount of damage the Monster does
	 * @param speed			The speed of the Monster
	 * @param Tier			The level of the Monster
	 */
	public PartyMonster(String name, double maxHealth, double healAmount, double damage, double speed, int Tier) {
		super(name, maxHealth, healAmount, damage, speed, Tier);
		myExperience = 0;
	}
	/**
	 * The constructor for the Monster class
	 * this gets called when no params are entered.
	 */
	public PartyMonster() {
		super();
		myExperience = 0;
	}
	/**
	 * Gets the current amount of experience of the PartyMonsters
	 */
	public double getMyExperience() {
		return myExperience;
	}
	
	/**
	 * Sets the experience of the PartyMonster
	 * checks if the experience is above 100 and if it is the monster levels up
	 * @param healthChange	The amount the health of the monster changes by
	 */
	public void gainExperience(double experience) {
		myExperience += experience;
		while (myExperience >= 100) {
			levelUp();
			myExperience -= 100;
		}
	}
	
	/**
	 * Levels up the PartyMonster
	 * increases the Tier by one and increases the maxHealth and damage by the new Tier
	 */
	public void levelUp() {
		super.gainTier(1);
		double amountToAdd = (super.getTier() * 2);
		super.gainMaxHealth(amountToAdd);
		super.gainDamage(amountToAdd / 5);
		super.gainSpeed(amountToAdd / 8);
	}
	/**
	 * Generates a string representation of the PartyMonsters
	 * Same as the Monster toString but also lists experience
	 */
	public String toString() {
		return super.toString() + "\nexp: " +
				(int) getMyExperience() + " / 100";
	}
}
