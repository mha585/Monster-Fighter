import java.util.*;
/**
 * This class determines whether the random events (that happen every night) are to be executed or not.
 * 
 * @author Angelo  Gasmin
 * @version 1.0
 */
public class RandomEvent {
	/**
	 * Creates an instance of the object randomGen to be used to generate random numbers.
	 */
	private randomGen randNum = new randomGen();
	/**
	 * Creates an instance of RandomEvent.
	 */
	public RandomEvent() {}
	/**
	 * Determines whether or not each monster in the player's party should level up or not.
	 * This is dependent on the monster's current tier.
	 * 
	 * @param monster		The monster that might level up
	 * @return				Boolean for if the chosen monster should level up or not
	 */
	public boolean shouldLevelUp(Monster monster) {
		Set<Integer> num = new HashSet<Integer>();
		if (monster.getTier() == 1) {
			while (num.size() < 20 ) {
				int number = randNum.randNumInRange(0, 100);
				num.add(number);	
			}
		}
		else if (monster.getTier() == 2) {
			while (num.size() < 10 ) {
				int number = randNum.randNumInRange(0, 100);
				num.add(number);
			}
		}
		else if (monster.getTier() == 3) {
			num.add(101);
			}
		int getNumber = randNum.randNumInRange(0, 100);
		if (num.contains(getNumber)) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Determines whether or not each monster in they player's party should leave.
	 * This is dependent on the number of times each monster has fainted.
	 * 
	 * @param team			The Player's party of monsters
	 * @param faints		The number of times a monster has fainted
	 * @return				Boolean for if the chosen monster should leave.
	 */
	public boolean shouldLeave(Team team, double faints) {
		Set<Integer> num = new HashSet<Integer>();
		if (team.getSize() > 1) {
			if(faints == 0) {
				while (num.size() < 5) {
					int number = randNum.randNumInRange(0, 100);
					num.add(number);
				}
			}
			else if (faints == 1) {
				while(num.size() < 24) {
					int number = randNum.randNumInRange(0, 100);
					num.add(number);
				}
			}
			else if (faints == 2) {
				while(num.size() < 47) {
					int number = randNum.randNumInRange(0, 100);
					num.add(number);
				}
			}
		}
		else {
			num.add(101);
		}
		int getNumber = randNum.randNumInRange(0, 100);
		if (num.contains(getNumber)) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Determines whether or not a random monster can join the player's team.
	 * This is dependent on the number of monster's that are already in the player's team.
	 * 
	 * @param team			The player's team
	 * @return				Boolean for if a randomMonster should join
	 */
	public boolean shouldJoin(Team team) {
		Set<Integer> num = new HashSet<Integer>();
		if (team.getSize() == 3) {
			while (num.size() < 5) {
				int number = randNum.randNumInRange(0, 100);
				num.add(number);
			}
		}
		else if (team.getSize() == 2) {
			while (num.size() < 10) {
				int number = randNum.randNumInRange(0, 100);
				num.add(number);
			}
		}
		else if (team.getSize() == 1) {
			while (num.size() < 15) {
				int number = randNum.randNumInRange(0, 100);
				num.add(number);
			}
		}
		else {
			num.add(101);
		}
		int getNumber = randNum.randNumInRange(0, 100);
		if (num.contains(getNumber)) {
			return true;
		}
		else {
			return false;
		}
	}
}