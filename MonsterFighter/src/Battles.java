import java.util.Scanner;

/**
 * This class implements a Battle between a team of monsters and an enemy.
 *
 * @author Matthew Harper
 * @version 1.2, Apr 2022.
 */
public class Battles {
	/**
	 * Battles your team of Monsters with an enemy Monster
	 * the battle continues until either the player is out of Monsters or the enemy is dead
	 * gets user input to allow the user to switch which monster is fighting,
	 * heal itself, use items, fight or switch the team positions around.
	 * Returns true if the player still has a living team at the end of the battle.
	 * Returns false if all the players monsters are dead by the end of the battle.
	 * @param friends		The current team of Monsters the Player has
	 * @param badGuy		The enemy the player is fighting
	 */
	public boolean fight(Team friends, Monster badGuy) {
		int fighterIndex = 0;
		Scanner action = new Scanner(System.in);
		printEnemyAndTeamStats(badGuy, friends);
		while ((badGuy.getHealth() > 0) && friends.sumTeamHealth() > 0) {
			String givenAction = action.nextLine();
			if(givenAction.toLowerCase().trim().equals("fight")) {
				attack(friends.getFriend(fighterIndex), badGuy, friends, true);
			} else if (givenAction.toLowerCase().trim().equals("switch")) {
				swap(badGuy, friends);
			} else if (givenAction.toLowerCase().trim().equals("heal")) {
				heal(friends.getFriend(fighterIndex), badGuy, friends);
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
	/**
	 * Gets called when the user inputs "attack".
	 * Checks the effectiveness of the current attack then multiplies the damage by that
	 * If the attack is one sided (aka the friend is either healing, switching or using an item)
	 * then only the enemy attack as the player has already used their turn.
	 * @param friend		The friend that does the attack
	 * @param badGuy		The enemy that responds to the attack
	 * @param friends		The current team of monsters the player has
	 * @param evenFight		Used to check if the fight is one sided or not
	 */
	public void attack(Monster friend, Monster badGuy, Team friends, boolean evenFight) {
		if (howEffective(friend, badGuy) == "super effective") {
			if (evenFight == true) {
				speedAttacks(friend, badGuy, friends, 2.0);
			} else {
				oneSidedAttack(friend, badGuy, friends, 2.0);
			}
		} else if (howEffective(friend, badGuy) == "not very effective") {
			if (evenFight == true) {
				speedAttacks(friend, badGuy, friends, 0.5);
			} else {
				oneSidedAttack(friend, badGuy, friends, 0.5);
			}
		} else {
			if (evenFight == true) {
				speedAttacks(friend, badGuy, friends, 1.0);
			} else {
				oneSidedAttack(friend, badGuy, friends, 1.0);
			}
		}
	}
	/**
	 * Gets called when the user inputs "switch".
	 * Gets the user to input the position of the first and second monster they want to switch then switches their positions
	 * Checks that the numbers are in a valid range else will ask the user to input another valid command
	 * Also checks that the monster you are trying to swap is not currently dead
	 * After the switch happens the Monster that is now at the front of the team will get attacked.
	 * @param badGuy		The enemy that attacks while the switch is happening
	 * @param friends		The current team of monsters the player has
	 */
	public void swap(Monster badGuy, Team friends) {
		System.out.println("Which two monsters would you like to swap positions?");
		System.out.println("Look at the team memeber number to figure out who to swap with");
		System.out.println("Be careful this will take your turn!\n");
		System.out.println("Please type the position of the monster you would like to move");
		Scanner number = new Scanner(System.in);
		int friendToSwapIndex = number.nextInt();
		if ((friendToSwapIndex == (int) friendToSwapIndex) && (friendToSwapIndex <= friends.getSize()) && 
				(friendToSwapIndex > 0) && (friends.getFriend(friendToSwapIndex - 1).getHealth() > 0)) {
			System.out.println("Now please type the postition of the monster you want to swap with");
			int friendToSwapWithIndex = number.nextInt();
			if ((friendToSwapWithIndex == (int) friendToSwapWithIndex) && (friendToSwapWithIndex <= friends.getSize()) && 
					(friendToSwapWithIndex > 0) && (friends.getFriend(friendToSwapWithIndex - 1).getHealth() > 0)) {
				friends.swap(friendToSwapIndex - 1, friendToSwapWithIndex - 1);
				attack(friends.getFriend(0), badGuy, friends, false);
				printEnemyAndTeamStats(badGuy, friends);
			} else {
				printEnemyAndTeamStats(badGuy, friends);
				System.out.println("\nSorry that monster cant be swapped");
			}
		} else {
			printEnemyAndTeamStats(badGuy, friends);
			System.out.println("\nSorry that monster cant be swapped");
		}
	}
	/**
	 * Gets called when the user inputs "heal".
	 * Allows the monster in position 1 to heal any monster (including itself) in the team
	 * This will use the players turn and cause a one sided attack by the enemy monster against the friend
	 * Checks that the index of the monster to heal is in a valid range else will ask the user to input another valid command
	 * @param friend		The friend that does the healing
	 * @param badGuy		The enemy that attacks while the healing is happening
	 * @param friends		The current team of monsters the player has
	 */
	public void heal(Monster friend, Monster badGuy, Team friends) {
		System.out.println("Which monster would you like to heal?");
		System.out.println("Please type the position of the monster you would like to heal");
		Scanner healNumber = new Scanner(System.in);
		int friendToHealIndex = healNumber.nextInt();
		if ((friendToHealIndex == (int) friendToHealIndex) && (friendToHealIndex <= friends.getSize()) && (friendToHealIndex > 0)) {
			friends.getFriend(friendToHealIndex - 1).gainHealth(friend.getHealAmount());
			attack(friend, badGuy, friends, false);
			printEnemyAndTeamStats(badGuy, friends);
		} else {
			System.out.println("Sorry that number wasnt recognised");
		}
	}
	/**
	 * Checks the health of the friend.
	 * If the health of the friend is less than or equal to 0 it removes the friend from the team.
	 * Returns false if the friend is dead or returns true if it's still alive.
	 * @param friend		The friend that is being checked
	 * @param friends		The current team of monsters the player has
	 */
	public boolean checkFriendsHealth(Monster friend, Team friends) {
		if (friend.getHealth() <= 0) {
			System.out.println("\nYour friend " + friend.getName() +
					" just died r.i.p\n");
			friend.gainDeaths();
			friends.pushFrontToBack();
			return false;
		} 
		return true;
	}
	/**
	 * Checks the health of an enemy.
	 * If the health of the enemy is less than or equal to 0 it returns false else returns true.
	 * @param badGuy		The enemy that is being checked
	 * @param friend		The friend that will gain the experience at the end of the battle
	 * @param friends		The current team of monsters the player has
	 */
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
	/**
	 * Prints the stats of both the enemy and the players team.
	 * If the health of the enemy is less than or equal to 0 it returns false else returns true.
	 * @param badGuy		The enemy that stats get printed
	 * @param friends		The current team of monsters the player has
	 */
	public void printEnemyAndTeamStats(Monster badGuy, Team friends) {
		System.out.println("The enemies current stats:\n");
		System.out.println(badGuy + "\n\n-------------------------------------\n");
		System.out.println("Your teams current stats:\n");
		System.out.println(friends);
		System.out.println("Please select a action. \nType either Fight, Switch, Heal or Items.");
	}
	/**
	 * Considers the speed of the enemy and friend before performing an attack.
	 * The monster with the fastest speed will attack first.
	 * If the Monster that gets attacked first dies then the other monster does not get attacked.
	 * @param friend			The friend that will attack first if its speed is faster than the enemy
	 * @param badGuy			The enemy that will attack first if its speed is faster than the friend
	 * @param friends			The current team of monsters the player has
	 * @param attackMultiplier	The amount that the attack will be multiplied by.
	 */
	public void speedAttacks(Monster friend, Monster badGuy, Team friends, double attackMultiplier) {
		if (friend.getSpeed() > badGuy.getSpeed()) {
			badGuy.gainHealth((-1 * friend.getDamage()) * attackMultiplier);
			if (checkEnemysHealth(badGuy, friend, friends) == true) {
				friend.gainHealth((-1 * badGuy.getDamage()) * (1 / attackMultiplier));
				checkFriendsHealth(friend, friends);
			}
		} else {
			friend.gainHealth((-1 * badGuy.getDamage()) * (1 / attackMultiplier));
			if (checkFriendsHealth(friend, friends) == true) {
				badGuy.gainHealth((-1 * friend.getDamage()) * (attackMultiplier));
				checkEnemysHealth(badGuy, friend, friends);
			}
		}
		if ((badGuy.getHealth() > 0) && friends.sumTeamHealth() > 0) {
			printEnemyAndTeamStats(badGuy, friends);
		}
	}
	/**
	 * Performs a one sided attack so that only the badGuy gets to attack the friend.
	 * This only gets called when the user wastes their turn healing, using an item or switching.
	 * Considers the type of attack (e.g. super effective) to scale the damage appropriately. 
	 * @param friend			The friend that will be attacked by the enemy
	 * @param badGuy			The enemy that will attack the friend
	 * @param friends			The current team of monsters the player has
	 * @param attackMultiplier	The amount that the attack will be multiplied by.
	 */
	public void oneSidedAttack(Monster friend, Monster badGuy, Team friends, double attackMultiplier) {
		friend.gainHealth((-1 * badGuy.getDamage()) * (1 / attackMultiplier));
		checkFriendsHealth(friend, friends);
	}
	/**
	 * Checks how effective a type of attack is.
	 * e.g if a fire monster attacks a grass monster then the attack will be super effective.
	 * @param attacker		The Monster that is doing the attack.
	 * @param attacked		The Monster that is being attacked.
	 */
	public String howEffective(Monster attacker, Monster attacked) {
		if ((attacker.getType() == "Fire") && (attacked.getType() == "Grass")) {
			return "super effective";
		} else if ((attacker.getType() == "Grass") && (attacked.getType() == "Water")) {
			return "super effective";
		} else if ((attacker.getType() == "Water") && (attacked.getType() == "Fire")) {
			return "super effective";
		} else if ((attacker.getType() == "Fire") && (attacked.getType() == "Water")) {
			return "not very effective";
		} else if ((attacker.getType() == "Grass") && (attacked.getType() == "Fire")) {
			return "not very effective";
		} else if ((attacker.getType() == "Water") && (attacked.getType() == "Grass")) {
			return "not very effective";
		} else {
			return "no change";
		}
	}
}
