
/**
 * This class implements a Battle
 *
 * @author Matthew Harper
 * @version 1.1, Apr 2022.
 */
public class Battles {
	/**
	 * Battles your team of Monsters with an enemy Monster
	 * the battle continues until either the player is out of Monsters or the enemy is dead
	 * @param friends		The current team of Monsters the Player has
	 * @param badGuy		The enemy the player is fighting
	 */
	public Team fight(Team friends, Monster badGuy) {
		while ((badGuy.getHealth() > 0) && friends.getSize() > 0) {
			badGuy.gainHealth(-10);
		}
		System.out.println("Congrats you killed " + badGuy.getName() +
				"\n-------------------------------------\n");
		friends.getFriend(0).gainHealth(-5);
		friends.getFriend(0).gainExperience(badGuy.getReward());
		System.out.println("Team stats after the battle:\n");
		System.out.println(friends);
		return friends;
	}
}
