
/**
 * This class implements a Battle
 *
 * @author Matthew Harper
 * @version 1.1, Apr 2022.
 */
public class Battles {
	
//	private Team myParty;
//	private Enemy enemy;
//	should I do propper oop stuff here?
	
	public Team fight(Team friends, Enemy badGuy) {
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
