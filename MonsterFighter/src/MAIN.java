import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class MAIN {

	/**
	 * Asks for players name, sets playerName to input
	 * @param inputName			Scanner to check input
	 */
	public static void setPlayerName(Scanner scanner, Player player) {
		boolean isProper = false;
		while(isProper == false) {
			System.out.println("Please enter a name: \nMust be between 3 and 15 characters. \nMust not contain numbers or special characters. ");
			String givenName = scanner.nextLine();
			if (givenName.trim().length() >= 3 && givenName.trim().length() <= 15 && givenName.trim().matches("[a-zA-Z]+")){
				player.setName(givenName);
				isProper = true;
				System.out.println("\n");
			}
			else {
				System.out.println("Invalid input");
			}
		}
	}
	/**
	 * Asks for how many days the player wants
	 * @param inputDay			Scanner to check input
	 */
	public static void setDays(Scanner scanner, Player player) {
		boolean isDay = false;
		while(isDay == false) {
			System.out.println("How many days will your adventure last for? \nEnter a number between 5 and 15.");
			String input = scanner.nextLine();
			int givenDay = Integer.parseInt(input);
			if(givenDay >=5 && givenDay <= 15) {
				player.setDay(givenDay);
				isDay = true;
				System.out.println("\n");
			}
			else {
				System.out.println("Invalid input");
			}
		}
	}
	/**
	 * Prompts player to set their difficulty
	 * @param inputDiff			Scanner to check input
	 */
	public static void setDifficulty(Scanner scanner, Player player) {
		boolean isDiff = false;
		while(isDiff == false) {
			System.out.println("Please select a difficulty level. \nEnter the number of the difficulty you want. (1) for Easy, (2) for Normal or (3) for Hard.");
			String input = scanner.nextLine();
			int givenDiff = Integer.parseInt(input);
			if(givenDiff == 1|| givenDiff == 2|| givenDiff == 3){
				player.setDifficulty(givenDiff);
				isDiff = true;
				System.out.println("\n");
			}
			else {
				System.out.println("Invalid input");
			}
		}
	}
	
	/**
	 * Prompts player to pick a monster, choice between 3 monsters
	 * @param inputMonster			Scanner to check input
	 * @param forParty				Player to put monster into player's party
	 */
	public static void selectMonster(Scanner scanner, Player player) {
		final Monster one = new FireMonster("Fireguy", 50.0, 5.0, 20.0, 20.0, 1, 150, 250, "A strong fire type Monster capable of burning down buildings.");
		final Monster two = new GrassMonster("Grassdude", 70, 5.0, 10.0, 20.0, 1, 150, 250, "A strong grass type Monster. It is said that they dwell in the deapest parts of the jungle.");
		final Monster three = new WaterMonster("Waterman", 60, 5.0, 15.0, 20.0, 1, 150, 250, "A strong water type Monster. These streamline monsters are known to have existed before humans.");
		
		boolean isMonster = false;
		while(isMonster == false) {
			System.out.println("Select your first monster \nType '1' for " + one.getName() + "\nType '2' for " + two.getName() + "\nType '3' for " + three.getName());
			String input = scanner.nextLine();
			int givenMonster = Integer.parseInt(input);
			if(givenMonster == 1){
				player.playerTeam.addFriend(one);
				isMonster = true;
			}
			else if(givenMonster == 2) {
				player.playerTeam.addFriend(two);
				isMonster = true;
			}
			else if(givenMonster == 3) {
				player.playerTeam.addFriend(three);
				isMonster = true;
			}
			else {
				System.out.println(givenMonster + " is not a valid input.");
			}
		}
	}
	
	public static void dayPrep(Scanner scanner, Player player) {
		boolean isDone = false;
		while(isDone == false) {
			Inventory bag = player.getInventory();
			Team team = player.getTeam();
			System.out.println("What would you like to do? (1)Look at Inventory\n                           (2)Look at Team\n                           (3)Move on");            
			String input = scanner.nextLine();
			int givenChoice = Integer.parseInt(input);
			if (givenChoice == 1) {
				System.out.println(bag);
				if (bag.getSize()>0) {
					System.out.println("Would you like to use an item? Enter the number of the item you would like to use. Enter 'Q' if you would like to exit.");
					String useItem = scanner.nextLine();
					int indexItem = Integer.parseInt(useItem);
					if (useItem.trim().matches("[0-9]+") == true) {
						Item item = (Item) bag.getItem(indexItem - 1);
						System.out.println(item.whenToUse());
						System.out.println(item.whenToUse().getClass());
						if (item.whenToUse().trim()=="out"|| item.whenToUse().trim()=="both") {
							System.out.println(team);
							System.out.println("Which monster do you want to use it on?");
							String choose = scanner.nextLine();
							int chosenMonster = Integer.parseInt(choose);
							Monster monster = team.getFriend(chosenMonster-1);
							item.useItem(monster);	
							bag.removeBag(indexItem - 1, 1);
						}
						else {
							System.out.println(item + " can only be used in battle.")
;						}
					}
					else {
						System.out.println("Invalid input");
					}
				}
				else {
					System.out.println("Your bag is empty");
				}
			}
			else if(givenChoice == 2) {
				System.out.println(team);
				System.out.println("Do you want to switch your monster's positions or leave?\n(1)Switch monster positions\n(2)Leave");
				String askPositions = scanner.nextLine();
				int switchPosition = Integer.parseInt(askPositions);
				if (switchPosition == 1) {
					if(team.getSize() > 1) {
						System.out.println("Select the first monster you want to switch");
						String positionOne = scanner.nextLine();
						int first = Integer.parseInt(positionOne);
						System.out.println("Select the second monster you want to switch");
						String positionTwo = scanner.nextLine();
						int second = Integer.parseInt(positionTwo);
						team.swap(first - 1, second - 1);
						System.out.println(team);
					} else {
						System.out.println("You must have atleast 2 monsters");
					}
					
				}
			}
			else if(givenChoice == 3) {
				isDone = true;
			}
			else {
				System.out.println("Invalid input");
			}
		}
	}
	
	public static void displayBattles(Scanner scanner, Player player) {
		
	}
	
	public static void shoppingTime(Scanner scanner, Shop shop, Player player) {
		System.out.println("Welcome to the Shop!");
		shop.generateNewMonsters();
		boolean isDone = false;
		while(isDone == false) {
			Inventory bag = player.getInventory();
			int funds = player.getMoney();
			System.out.println("Money: $"+funds);
			System.out.println("Would you like to (1)Buy Items \n                  (2)Buy Monsters\n                  (3)Sell Items\n                  (4)Sell Monsters\n                  (5)Quit Shopping\nPlease enter a number (1-4) that corresponds to one of the options above");
			String givenOption = scanner.nextLine();
			
			if(givenOption.trim().equals("1")){
				System.out.println(shop.displayItems());
				System.out.println("Enter the number of an item you would like to buy. Enter 10 if you would like to exit.");
				String givenItem = scanner.nextLine();
				int number = Integer.parseInt(givenItem);
				List<Item> listItem = shop.getItems();
				Object toBuy = listItem.get(number - 1);
				System.out.println("How many would you like to buy?");
				String givenFreq = scanner.nextLine();
				int freq = Integer.parseInt(givenFreq);
				if(number > 0 && number < 10) {
					bag.buyItem(freq, toBuy, player);
				}
				else if (number == 10){
					System.out.println("\n");
				}
				else {
					System.out.println("Invalid input");
				}
			}
			
			else if(givenOption.trim().equals("2")){
				Team team = player.getTeam();
				shop.displayMonsters(player);
				System.out.println("Enter the number of the monster that you want to buy.\nEnter 5 if you want to exit.\n");
				String monsterToBuy = scanner.nextLine();
				int monsterNumber = Integer.parseInt(monsterToBuy);
				if (monsterNumber > 0 && monsterNumber < 5) {
					team.buyMonster(monsterNumber, shop, player);
				}
				else if(monsterNumber == 5) {
					System.out.println("\n");
				}
				else {
					System.out.println("Invalid input");
				}
			}
			
			else if(givenOption.trim().equals("3")){
				Inventory currentInven = player.getInventory();
				if(currentInven.getSize() == 0) {
					System.out.println("You have no items to sell.");
				}
				else {
					System.out.println(currentInven);
					System.out.println("Enter the number of the item you would like to sell.");
					String toSell = scanner.nextLine();
					int indexItem = Integer.parseInt(toSell) - 1;
					System.out.println("How many do you want to sell?\nEnter a number between 1 and "+((Item) currentInven.getItem(indexItem)).getFrequency()+" (Inclusive).");
					String itemFreq = scanner.nextLine();
					int sellFreq = Integer.parseInt(itemFreq);
					currentInven.sellItem(sellFreq, indexItem, player, currentInven);
				}
			}
			else if(givenOption.trim().equals("4")){
				Team currentTeam = player.getTeam();
				if(player.playerTeam.getSize() == 1) {
					System.out.println(player.playerTeam.getFriend(0).getName()+" is worried about you, you cannot sell your last monster.");
				}
				else {
					System.out.println(currentTeam);
					System.out.println("Enter the Team slot for the monster you want to sell (1-"+player.playerTeam.getSize()+".\nEnter 5 if you want to quit.");
					String indexTeam = scanner.nextLine();
					if(indexTeam.equalsIgnoreCase("5")) {
						System.out.println("\n");
					}
					else {
						int indexMonster = Integer.parseInt(indexTeam) - 1;
						int moneyIndex = currentTeam.getFriend(indexMonster).getTier();
						System.out.println("Are you sure?\nEnter 'Y' for yes, 'N' for no.");
						String confirmChoice = scanner.nextLine();
						if(confirmChoice.trim().equalsIgnoreCase("Y")) {
							currentTeam.sellMonster(indexMonster, moneyIndex, shop, player);
						}
						else if(confirmChoice.trim().equalsIgnoreCase("N")){
							System.out.println("");
						}
						else {
							System.out.println("Invalid input");
						}
					}
				}
			}
			else if(givenOption.trim().equals("5")){
				System.out.println("Thank you, Please come again!");
				isDone = true;
			}
			else {
				System.out.println("Invalid input");
			}
		}
	}
	
	public static void nightPhase(Scanner scanner, Player player) {
		System.out.println("Time to go to sleep. Goodnight!");
		RandomEvent event = new RandomEvent();
		Team notUpdatedTeam = player.getTeam();
		Team updatedTeam = player.getTeam();
		RandomMonster newMonster = null;
		Monster lostMonster = null;
		boolean newFriend = false;
		boolean lostFriend = false;
		int numMonsters = 0;
		for (int i = 0; i < updatedTeam.getSize(); i++) {
			Monster monster = updatedTeam.getFriend(i);
			monster.gainHealth(monster.getMaxHealth() - monster.getHealth());
		}
		for (int j = 0; j <= updatedTeam.getSize()-1; j ++) {
			Monster monster = updatedTeam.getFriend(j);
			if (event.shouldLevelUp(monster) == true) {
				monster.gainTier(1);
				numMonsters += 1;
			}
		}
		RandomMonster couldAdd = new RandomMonster();
		if (event.shouldJoin(updatedTeam) == true) {
			newMonster = couldAdd;
			couldAdd.setPrice(0);
			updatedTeam.addFriend(couldAdd);
			newFriend = true;
		}
		for (int l = 0; l <= updatedTeam.getSize()-1; l ++) {
			Monster monster = updatedTeam.getFriend(l);
			if (event.shouldLeave(updatedTeam, monster.getDeaths()) == true) {
				lostMonster = monster;
				monster.setPrice(0);
				updatedTeam.removeFriend(monster);
				lostFriend = true;
			}
		}
		if (lostFriend == true) {
			System.out.println("Oh no! "+ lostMonster +" monster has left");
		}
		if (newFriend == true) {
			System.out.println("A new monster has joined!");
			System.out.println(newMonster);
		}
		if (numMonsters > 0) {
			for (int n = 0; n < notUpdatedTeam.getSize(); n++) {
				if (notUpdatedTeam.getFriend(n).getTier() < updatedTeam.getFriend(n).getTier()) {
					Monster friend = notUpdatedTeam.getFriend(n);
					Monster nFriend = notUpdatedTeam.getFriend(n);
					System.out.println(friend.getName() + " Tier: " + friend.getTier() + " - - - > " + nFriend.getTier());
				}
			}
		}
	}

	public static boolean checkAbruptEnd(Player player) {
		if(player.getTeam().getSize() == 0 && player.getMoney() < 150) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void endGame(Player player, int originalDays) {
		if(player.getDayCompleted() < originalDays){
			System.out.println("Y O U    L O S E");
			System.out.println("   GAME OVER   ");
			System.out.println("Game Stats: \nName: " + player.getPlayerName() + "\nDays Completed: " + player.getDayCompleted()+ " / " + originalDays + "\nMoney Earned: +player.getMoneyEarned() + \nPoints Gained: +player.getPoints()");
		}
		else {
			System.out.println("Y O U    W I N");
			System.out.println("   GOOD JOB   ");
			System.out.println("Game Stats: \nName: " + player.getPlayerName() + "\nDays Completed: " + player.getDayCompleted()+ " / " + originalDays + "\nMoney Earned: +player.getMoneyEarned() + \nPoints Gained: +player.getPoints()");
		}
	}
	
	public static void timer(int ms) {
	    try
	    {
	        Thread.sleep(ms);
	    }
	    catch(InterruptedException ex)
	    {
	        Thread.currentThread().interrupt();
	    }
	}
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		Player newPlayer = new Player();
		Shop newShop = new Shop();
		setPlayerName(scanner, newPlayer);
		setDays(scanner, newPlayer);
		setDifficulty(scanner, newPlayer);
		selectMonster(scanner, newPlayer);
		System.out.println("~||~||~||~||~||~||~||~||~||~||~||~||~\n~||~ Let's Begin The Adventure!! ~||~ \n~||~||~||~||~||~||~||~||~||~||~||~||~");
		timer(3000);
		int inputDays = newPlayer.daysLeft();
		while(newPlayer.daysLeft() >= 0) {
			newPlayer.toString();
			dayPrep(scanner, newPlayer);
			timer(1000);
			shoppingTime(scanner, newShop, newPlayer);
			nightPhase(scanner, newPlayer);
			boolean gameOver = checkAbruptEnd(newPlayer);
			if(gameOver == false) {
				newPlayer.addDay();
			}
			else {
				newPlayer.abruptEnd();
				
			}
		}
		endGame(newPlayer, inputDays);
	}
}

