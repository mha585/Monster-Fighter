/**
 * This class describes the PartyMonsters class
 * this is all the monsters in the players party
 * these PartyMonsters are the same as Monsters
 * however they have the ability to level up and get stronger
 * 
 * @author Matthew Harper
 * @version 1.0
 */
public class PartyMonsters extends Monster {
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
	 * @param teir			The level of the Monster
	 */
	public PartyMonsters(String name, double maxHealth, double healAmount, double damage, int teir) {
		super(name, maxHealth, healAmount, damage, teir);
		myExperience = 0;
	}
	
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
		if (myExperience >= 100) {
			super.setTeir((int) (myExperience / 100));
			myExperience = (myExperience % 100);
		}
	}
	
	public String toString() {
		return "my teir is " + super.getTeir() + " my experience is " + getMyExperience();
	}
	
	public static void main(String[] args) {
		PartyMonsters test = new PartyMonsters("Test", 100, 5, 5, 2);
		System.out.println(test);
		test.gainExperience(1020);
		System.out.println(test);
	}
}
