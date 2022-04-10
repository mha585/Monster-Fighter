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
		printEnemyAndTeamStats(badGuy, friends);
		while ((badGuy.getHealth() > 0) && friends.getSize() > 0) {
			Scanner action = new Scanner(System.in);
			String givenAction = action.nextLine();
			if(givenAction.toLowerCase().trim().equals("fight")) {
				attack(friends.getFriend(fighterIndex), badGuy, friends);
			} else if (givenAction.toLowerCase().trim().equals("switch")) {
				System.out.println("Which two monsters would you like to swap positions?");
				System.out.println("Look at the team memeber number to figure out who to swap with");
				System.out.println("Be careful this will take your turn!\n");
				System.out.println("Please type the position of the monster you would like to move");
				int friendToSwapIndex = action.nextInt();
				if ((friendToSwapIndex == (int) friendToSwapIndex) && (friendToSwapIndex <= friends.getSize()) && (friendToSwapIndex > 0)) {
					System.out.println("Now please type the postition of the monster you want to swap with");
					int friendToSwapWithIndex = action.nextInt();
					if ((friendToSwapWithIndex == (int) friendToSwapWithIndex) && (friendToSwapWithIndex <= friends.getSize()) && (friendToSwapWithIndex > 0)) {
						friends.swap(friendToSwapIndex - 1, friendToSwapWithIndex - 1);
						friends.getFriend(fighterIndex).gainHealth(-1 * badGuy.getDamage());
						checkFriendsHealth(friends.getFriend(fighterIndex), friends);
						printEnemyAndTeamStats(badGuy, friends);
					} else {
						printEnemyAndTeamStats(badGuy, friends);
						System.out.println("Sorry that number wasnt recognised");
					}
				} else {
					printEnemyAndTeamStats(badGuy, friends);
					System.out.println("Sorry that number wasnt recognised");
				}
			} else if (givenAction.toLowerCase().trim().equals("item")) {
				System.out.println("not yet implemented");
			} else {
				System.out.println("\n-------------------------------------\n");
				System.out.println("Sorry your command wasn't understood\n");
				System.out.println("Please select a action. \nType either Fight, Switch, Heal or Items.");
			}
		}
		if ((badGuy.getHealth() <= 0) && friends.getSize() > 0) {
			return true;
		} 
		return false;
	}
	
	public void attack(Monster friend, Monster badGuy, Team friends) {
		if (friend.getSpeed() > badGuy.getSpeed()) {
			badGuy.gainHealth(-1 * friend.getDamage());
			if (checkEnemysHealth(badGuy, friend, friends) == true) {
				friend.gainHealth(-1 * badGuy.getDamage());
				checkFriendsHealth(friend, friends);
			}
		} else {
			friend.gainHealth(-1 * badGuy.getDamage());
			if (checkFriendsHealth(friend, friends) == true) {
				badGuy.gainHealth(-1 * friend.getDamage());
				checkEnemysHealth(badGuy, friend, friends);
			}
		}
		if ((badGuy.getHealth() > 0) && friends.getSize() > 0) {
			printEnemyAndTeamStats(badGuy, friends);
		}
	}
	
	public boolean checkFriendsHealth(Monster friend, Team friends) {
		if (friend.getHealth() <= 0) {
			System.out.println("\nYour friend " + friend.getName() +
					" just died r.i.p\n");
			friends.removeFriend(friend);
			return false;
		} 
		return true;
	}
	
	public boolean checkEnemysHealth(Monster badGuy, Monster friend, Team friends) {
		if (badGuy.getHealth() <= 0) {
			friend.gainExperience(badGuy.getReward());
			System.out.println("Congrats you killed " + badGuy.getName() +
					"\n\n-------------------------------------\n");
			System.out.println("Team stats after the battle:\n");
			System.out.println(friends);
			return false;
		}
		return true;
	}
	
	public void printEnemyAndTeamStats(Monster badGuy, Team friends) {
		System.out.println("The enemies current stats:\n");
		System.out.println(badGuy + "\n\n-------------------------------------\n");
		System.out.println("Your teams current stats:\n");
		System.out.println(friends);
		System.out.println("Please select a action. \nType either Fight, Switch, Heal or Items.");
	}
	
//	public void swap(int friend1Index, int friend2Index, Team friends) {
//		
//	}
}
