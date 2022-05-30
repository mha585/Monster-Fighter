
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class implements a Battle between a team of monsters and an enemy.
 *
 * @author Matthew Harper
 * @version 1.4, Apr 2022.
 */
public class Battles {
	
	/**
	 * Generates all the possible battles the player can fight in a day
	 * @param numBattles			The number of battles the player wants to fight in a day
	 * @param player				The current stats of the player
	 * @return ArrayList			An array list containing all the possible battles
	 */
	public ArrayList<Trainers> getBattles (int numBattles, Player player) {
		ArrayList<Trainers> trainerToBattle = new ArrayList<Trainers>();
		int num = 1;
		while (num <= numBattles) {
			Trainers newTrainer = new Trainers(player);
			trainerToBattle.add(newTrainer);
			num++;
		}
		return trainerToBattle;
	}
	/**
	 * Prints the possible battles the player can fight in a day
	 * @param possibleBattles		An array containing all the possible battles.
	 */
	public void printBattles(ArrayList<Trainers> possibleBattles) {
		int num = 1;
		while (num <= possibleBattles.size()) {
			System.out.println("Battle" + " "+num);
			Trainers trainer = possibleBattles.get(num-1);
			System.out.println("Trainer: " + trainer.getFullName());
			System.out.println(trainer.printEnemyTeam());
			System.out.println("--------------------------------------");
			num++;
		}
	}
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
	public boolean fight(Team friends, Monster badGuy, Inventory playerInventory, Scanner action) {
		int fighterIndex = 0;
//		Scanner action = new Scanner(System.in);
		printEnemyAndTeamStats(badGuy, friends);
		while ((badGuy.getHealth() > 0) && friends.sumTeamHealth() > 0) {
			String givenAction = action.nextLine();
			if (givenAction.toLowerCase().trim().equals("fight")) {
				attack(friends.getFriend(fighterIndex), badGuy, friends, true);
			} else if (givenAction.toLowerCase().trim().equals("switch")) {
				swap(badGuy, friends, action);
			} else if (givenAction.toLowerCase().trim().equals("heal")) {
				heal(friends.getFriend(fighterIndex), badGuy, friends, action);
			} else if (givenAction.toLowerCase().trim().equals("items")) {
				useItem(friends, badGuy, playerInventory, action);
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
		double friendAttackMultiplier = howEffective(friend, badGuy);
		double enemyAttackMultiplier = howEffective(badGuy, friend);
		if (evenFight == true) {
			speedAttacks(friend, badGuy, friends, friendAttackMultiplier, enemyAttackMultiplier);
		} else {
			oneSidedAttack(friend, badGuy, friends, enemyAttackMultiplier);
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
	public void swap(Monster badGuy, Team friends, Scanner scanner) {
		System.out.println("Which two monsters would you like to swap positions?");
		System.out.println("Look at the team memeber number to figure out who to swap with");
		System.out.println("Be careful this will take your turn!\n");
		
		boolean isSwapped = false;
		while (isSwapped == false) {
			try {
				System.out.println("Please type the position of the monster you would like to move");
				String input1 = scanner.nextLine();
				int indexOfFirstMonster = Integer.parseInt(input1);
				if ((indexOfFirstMonster >= 1 && indexOfFirstMonster <= friends.getSize()) && 
						friends.getFriend(indexOfFirstMonster - 1).getHealth() != 0) {
					System.out.println("Now please type the postition of the monster you want to swap with");
					String input2 = scanner.nextLine();
					int indexOfSecondMonster = Integer.parseInt(input2);
					if (indexOfSecondMonster >= 1 && indexOfSecondMonster <= friends.getSize() && 
							friends.getFriend(indexOfSecondMonster - 1).getHealth() != 0) {
						friends.swap(indexOfFirstMonster - 1, indexOfSecondMonster - 1);
						attack(friends.getFriend(0), badGuy, friends, false);
						printEnemyAndTeamStats(badGuy, friends);
						isSwapped = true;
					} else {
						throw new InvalidInputException();
					}
				} else {
					throw new InvalidInputException();
				}
			}
			catch(Exception e) {
//				saves the current input (for test inputs)
				InputStream savedStandardInputStream = System.in;
				PrintStream savedStandardOut = System.out;
				
//				Sets output to something other than system so the player cant see this
			    System.setOut(new PrintStream(new ByteArrayOutputStream()));
//			    Sets the automatic input to "continue" (this can be any string)
			    String input = "continue";
				System.setIn(new ByteArrayInputStream(input.getBytes()));
//				Scans the automatic input to avoid getting the user to press any key to continue then closes it
				Scanner skipGettingUserToContinue = new Scanner(System.in);
				skipGettingUserToContinue.nextLine();
				skipGettingUserToContinue.close();
				
//				Sets user input back to normal and gets the user to try again
			    System.setIn(savedStandardInputStream);
			    System.setOut(savedStandardOut);
				System.out.println("Input must be a number from 1 to " + friends.getSize());
				System.out.println("Press any key to try switching again");
			}
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
	 * @param healNumber	The scanner used to get input
	 */
	public void heal(Monster friend, Monster badGuy, Team friends, Scanner healNumber) {
		System.out.println("Which monster would you like to heal?");
		boolean isHealed = false;
		while (isHealed == false) {
			try {
				System.out.println("Please type the position of the monster you would like to heal");
				String friendToHealIndex = healNumber.nextLine();
				if ((Character.isDigit(friendToHealIndex.charAt(0)) == true) && (Integer.parseInt(friendToHealIndex) <= friends.getSize()) && (Integer.parseInt(friendToHealIndex) > 0)) {
					friends.getFriend(Integer.parseInt(friendToHealIndex) - 1).gainHealth(friend.getHealAmount());
					attack(friend, badGuy, friends, false);
					printEnemyAndTeamStats(badGuy, friends);
					isHealed = true;
				} else {
					throw new InvalidInputException();
				}
			} catch(Exception e) {
//				saves the current input (for test inputs)
				InputStream savedStandardInputStream = System.in;
				PrintStream savedStandardOut = System.out;
				
//				Sets output to something other than system so the player cant see this
			    System.setOut(new PrintStream(new ByteArrayOutputStream()));
//			    Sets the automatic input to "continue" (this can be any string)
			    String input = "continue";
				System.setIn(new ByteArrayInputStream(input.getBytes()));
//				Scans the automatic input to avoid getting the user to press any key to continue then closes it
				Scanner skipGettingUserToContinue = new Scanner(System.in);
				skipGettingUserToContinue.nextLine();
				skipGettingUserToContinue.close();
				
//				Sets user input back to normal and gets the user to try again
			    System.setIn(savedStandardInputStream);
			    System.setOut(savedStandardOut);
				System.out.println("Sorry that number wasnt recognised");
				System.out.println("Please enter a number between 1 and " + friends.getSize());
			}
		}
	}
	/**
	 * Gets called when the user inputs "items".
	 * Allows the use of any items currently in the players bag
	 * This will use the players turn and cause a one sided attack by the enemy monster against the friend
	 * Checks that both the item index and the Monster index is in a valid range else asks for a different input
	 * @param friends			The current team of monsters the player has
	 * @param badGuy			The enemy that attacks while the item is being used
	 * @param playerInventory	The current inventory of the player
	 * @param itemNumber		The scanner used to get input
	 */
	public void useItem(Team friends, Monster badGuy, Inventory playerInventory, Scanner itemNumber) {
		if (playerInventory.getSize() <= 0) {
			printEnemyAndTeamStats(badGuy, friends);
			System.out.println("You have no items left to use");
		} else {
			
			System.out.println(playerInventory);
			
			boolean isUsed = false;
			while (isUsed == false) {
				try {
					System.out.println("Please type the position of the item you want to use");
					String input1 = itemNumber.nextLine();
					int itemToUseIndex = Integer.parseInt(input1);
					if ((itemToUseIndex <= playerInventory.getSize()) && (itemToUseIndex > 0) && playerInventory.getSize() > 0) {
						System.out.println("Now please type the postition of the monster you want to use it on");
						String input2 = itemNumber.nextLine();
						int monsterToUseItemOnIndex = Integer.parseInt(input2);
						if ((monsterToUseItemOnIndex <= friends.getSize()) && (monsterToUseItemOnIndex > 0)) {
							playerInventory.getItem(itemToUseIndex - 1).useItem(friends.getFriend(monsterToUseItemOnIndex - 1));
							playerInventory.removeBag(itemToUseIndex - 1, 1);
							attack(friends.getFriend(0), badGuy, friends, false);
							printEnemyAndTeamStats(badGuy, friends);
							isUsed = true;
						} else {
							System.out.println("Input must be a number from 1 to " + friends.getSize());
							throw new InvalidInputException();
						}
					} else {
						System.out.println("Input must be a number from 1 to " + playerInventory.getSize());
						throw new InvalidInputException();
					}
				}
				catch(Exception e) {
//					saves the current input (for test inputs)
					InputStream savedStandardInputStream = System.in;
					PrintStream savedStandardOut = System.out;
					
//					Sets output to something other than system so the player cant see this
				    System.setOut(new PrintStream(new ByteArrayOutputStream()));
//				    Sets the automatic input to "continue" (this can be any string)
				    String input = "continue";
					System.setIn(new ByteArrayInputStream(input.getBytes()));
//					Scans the automatic input to avoid getting the user to press any key to continue then closes it
					Scanner skipGettingUserToContinue = new Scanner(System.in);
					skipGettingUserToContinue.nextLine();
					skipGettingUserToContinue.close();
					
//					Sets user input back to normal and gets the user to try again
				    System.setIn(savedStandardInputStream);
				    System.setOut(savedStandardOut);
					System.out.println("Sorry that number wasnt recognised, please try again");
				}
			}
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
	public void speedAttacks(Monster friend, Monster badGuy, Team friends, double friendAttackMultiplier, 
			double enemyAttackMultiplier) {
		if (friend.getSpeed() > badGuy.getSpeed()) {
			badGuy.gainHealth((-1 * friend.getDamage()) * friendAttackMultiplier);
			if (checkEnemysHealth(badGuy, friend, friends) == true) {
				friend.gainHealth((-1 * badGuy.getDamage()) * enemyAttackMultiplier);
				checkFriendsHealth(friend, friends);
			}
		} else {
			friend.gainHealth((-1 * badGuy.getDamage()) * enemyAttackMultiplier);
			if (checkFriendsHealth(friend, friends) == true) {
				badGuy.gainHealth((-1 * friend.getDamage()) * friendAttackMultiplier);
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
	public void oneSidedAttack(Monster friend, Monster badGuy, Team friends, double enemyAttackMultiplier) {
		friend.gainHealth((-1 * badGuy.getDamage()) * enemyAttackMultiplier);
		checkFriendsHealth(friend, friends);
	}
	/**
	 * Returns the respective index of the type of monster from the howEffective
	 * array in class Monster.
	 * Returns 0 for type Fire, 1 for type Water, 2 for type Grass,
	 * 3 for type glass and 4 for type Medical
	 * @param type		The type of the Monster.
	 * @return int		an integer representation of the type of monster
	 */
	public int monsterTypeToIndex(String type) {
		if (type == "Fire") {
			return 0;
		} else if (type == "Water") {
			return 1;
		} else if (type == "Grass") {
			return 2;
		} else if (type == "Glass") {
			return 3;
		} else if (type == "Medical") {
			return 4;
		} else if (type == "Holy") {
			return 5;
		} else {
			return 6;
		}
	}
	/**
	 * Checks how effective a type of attack is using the matrix howEffective in class Monster.
	 * e.g if a fire monster attacks a grass monster then the attack will be super effective so * 2.
	 * @param attacker		The Monster that is doing the attack.
	 * @param attacked		The Monster that is being attacked.
	 * @return double		returns how effective an attack is on a monster
	 */
	public double howEffective(Monster attacker, Monster attacked) {
		int attackerTypeIndex = monsterTypeToIndex(attacker.getType());
		int attackedTypeIndex = monsterTypeToIndex(attacked.getType());
		return attacker.getEffectiveness(attackerTypeIndex, attackedTypeIndex);
	}
}