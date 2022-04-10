import java.util.Scanner;

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
	 * gets user input to allow the user to switch which monster is fighting,
	 * heal itself, use items or fight.
	 * @param friends		The current team of Monsters the Player has
	 * @param badGuy		The enemy the player is fighting
	 */
	
	public boolean fight(Team friends, Monster badGuy) {
		int fighterIndex = 0;
		while ((badGuy.getHealth() > 0) && friends.getSize() > 0) {
			Scanner action = new Scanner(System.in);
			System.out.println("The enemies current stats:\n");
			System.out.println(badGuy + "\n\n-------------------------------------\n");
			System.out.println("Your teams current stats:\n");
			System.out.println(friends);
			System.out.println("Please select a action. \nType either Fight, Switch, Heal or Items.");
			String givenAction = action.nextLine();
			if(givenAction.toLowerCase().trim().equals("fight")) {
				attack(friends.getFriend(fighterIndex), badGuy, friends);
			}
//			if (givenAction.toLowerCase().trim().equals("switch")) {
//				
//			}
//			if (givenAction.toLowerCase().trim().equals("item")) {
//				
//			}
			if (friends.getFriend(fighterIndex).getHealth() <= 0) {
				System.out.println("\nYour friend " + friends.getFriend(fighterIndex).getName() +
						" just died r.i.p\n");
				friends.removeFriend(friends.getFriend(fighterIndex));
			}
		}
		if ((badGuy.getHealth() <= 0) && friends.getSize() > 0) {
			return true;
		} 
		return false;
	}
	
	public boolean attack(Monster friend, Monster badGuy, Team friends) {
		if (friend.getSpeed() > badGuy.getSpeed()) {
			badGuy.gainHealth(-1 * friend.getDamage());
			if (badGuy.getHealth() <= 0) {
				friend.gainExperience(badGuy.getReward());
				System.out.println("Congrats you killed " + badGuy.getName() +
						"\n\n-------------------------------------\n");
				System.out.println("Team stats after the battle:\n");
				System.out.println(friends);
				return true;
			}
			friend.gainHealth(-1 * badGuy.getDamage());
		} else {
			friend.gainHealth(-1 * badGuy.getDamage());
			if (friend.getHealth() <= 0) {
				System.out.println("\nYour friend " + friend.getName() +
						" just died r.i.p\n");
				friends.removeFriend(friend);
			}
			badGuy.gainHealth(-1 * friend.getDamage());
		}
		return false;
	}
}
