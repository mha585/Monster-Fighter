
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class MAIN {
	/**
	 * Stores the player's chosen name, will be used to construct Player
	 */
	private static String playerName;
	/**
	 * Stores the player's chosen amount days, will be used to construct Player
	 */
	private static int playerDays;
	/**
	 * Stores the player's chosen difficulty, will be used to construct Player
	 */
	private static int playerDiff;
	private static RandomMonster shopMonster1;
	private static RandomMonster shopMonster2;
	private static RandomMonster shopMonster3;
	private static RandomMonster shopMonster4;
	private static List<Integer> buyMonsters =  Arrays.asList(0, 100, 200, 300);
	private static List<Integer> sellMonsters = Arrays.asList(0, 50, 100, 150);


	/**
	 * Asks for players name, sets playerName to input
	 * @param inputName			Scanner to check input
	 */

	
	public static void setPlayerName(Scanner scanner) {
		boolean isProper = false;
		while(isProper == false) {
			try {
				System.out.println("Please enter a name: \nMust be between 3 and 15 characters. \nMust not contain numbers or special characters. ");
				String givenName = scanner.nextLine();
				if (givenName.trim().length() >= 3 && givenName.trim().length() <= 15){
					playerName = givenName;
					isProper = true;
				}
			}
			catch (Exception e) {
				System.out.println("Invalid name input");
			}
		}
	}
	/**
	 * Asks for how many days the player wants
	 * @param inputDay			Scanner to check input
	 */
	public static void setDays(Scanner scanner) {
		boolean isDay = false;
		while(isDay == false) {
			try {
			System.out.println("How many days will your adventure last for? \nEnter a number between 5 and 15.");
			int givenDay = scanner.nextInt();
				if(givenDay >=5 && givenDay <= 15) {
					playerDays = givenDay;
					isDay = true;
				}
			}
			catch (Exception e) {
				System.out.println("Invalid Input");
			}
		}
	}
	/**
	 * Prompts player to set their difficulty
	 * @param inputDiff			Scanner to check input
	 */
	public static void setDifficulty(Scanner scanner) {
		boolean isDiff = false;
		while(isDiff == false) {
			try {
				System.out.println("Please select a difficulty level. \nEnter the number of the difficulty you want. (1) for Easy, (2) for Normal or (3) for Hard.");
				int givenDiff = scanner.nextInt();
				if(givenDiff == 1|| givenDiff == 2|| givenDiff == 3){
					givenDiff = playerDiff;
					isDiff = true;
				}
			}
			catch (Exception e) {
				System.out.println("Invalid Input");
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
			int givenMonster = scanner.nextInt();
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
			try {
			System.out.println("What would you like to do? (1)Look at Inventory\n                           (2)Look at Team\n                           (3)Move on");            
				int givenChoice = scanner.nextInt();
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
								int chosenMonster = scanner.nextInt();
								Monster monster = team.getFriend(chosenMonster-1);
								item.useItem(monster);	
								bag.removeBag(indexItem - 1, 1);
							}
						}
					}
				}
				else if(givenChoice == 2) {
					System.out.println(team);
					System.out.println("Do you want to switch your monster's positions or leave?\n(1)Switch monster positions\n(2)Leave");
					int switchPosition = scanner.nextInt();
					if (switchPosition == 1) {
						System.out.println("Select the first monster you want to switch");
						int first = scanner.nextInt();
						System.out.println("Select the second monster you want to switch");
						int second = scanner.nextInt();
						team.swap(first - 1, second - 1);
						System.out.println(team);
						
					}
				}
				else if(givenChoice == 3) {
					isDone = true;
				}
			}
			catch (Exception e) {
				System.out.println("Invalid input");
			}
		}
	}
	
	public static void displayBattles(Scanner scanner, Player player) {
		
	}
	
	public static void shoppingTime(Scanner scanner, Shop shop, Player player) {
		AtkBoost AB = new AtkBoost();
		AtkPlus AP = new AtkPlus();
		BasicHeal BH = new BasicHeal();
		HPrestore HR = new HPrestore();
		MegaHeal MH = new MegaHeal();
		SpeedBoost SB = new SpeedBoost();
		SpeedPlus SP = new SpeedPlus();
		TierPlus TP = new TierPlus();
		System.out.println("Welcome to the Shop!");
		boolean isDone = false;
		while(isDone == false) {
			try {
				int funds = player.getMoney();
				System.out.println("Money: $"+funds);
				System.out.println("Would you like to (1)Buy Items \n                  (2)Buy Monsters\n                  (3)Sell Items\n                  (4)Sell Monsters\n                  (5)Quit Shopping\nPlease enter a number (1-4) that corresponds to one of the options above");
				String givenOption = scanner.nextLine();
				if(givenOption.trim().equals("1")){
					System.out.println(shop.toString());
					System.out.println("Enter the number of an item you would like to buy. Enter 9 if you would like to exit.");
					String givenItem = scanner.nextLine();
					int number = Integer.parseInt(givenItem);
					switch(number) {
						case 1:
							System.out.println("How many Attack Boost's would you like?");
							int givenFreq1 = scanner.nextInt();
							int totalCost1 = AB.itemCost * givenFreq1;
							if(totalCost1 <= funds) {
								player.playerBag.addtoBag(AB, givenFreq1);
								player.deductMoney(totalCost1);
								System.out.println("Purchase Successful.");
							}
							else {
								System.out.println("Insufficient funds");
							}
							break;
							
						case 2:
							System.out.println("How many Attack Plus's would you like?");
							int givenFreq2 = scanner.nextInt();
							int totalCost2 = AP.itemCost * givenFreq2;
							if(totalCost2 <= funds) {
								player.playerBag.addtoBag(AP, givenFreq2);
								player.deductMoney(totalCost2);
								System.out.println("Purchase Successful.");
							}
							else {
								System.out.println("Insufficient funds.");
							}
							break;
	
							
						case 3:
							System.out.println("How many Attack Boost's would you like.?");
							int givenFreq3 = scanner.nextInt();
							int totalCost3 = BH.itemCost * givenFreq3;
							if(totalCost3 <= funds) {
								player.playerBag.addtoBag(BH, givenFreq3);
								player.deductMoney(totalCost3);
								System.out.println("Purchase Successful.");
							}
							else {
								System.out.println("Insufficient funds.");
							}
							break;
							
						case 4:
							System.out.println("How many Attack Boost's would you like?");
							int givenFreq4 = scanner.nextInt();
							int totalCost4 = HR.itemCost * givenFreq4;
							if(totalCost4 <= funds) {
								player.playerBag.addtoBag(HR, givenFreq4);
								player.deductMoney(totalCost4);
								System.out.println("Purchase Successful.");
							}
							else {
								System.out.println("Insufficient funds.");
							}
							break;
							
						case 5: 
							System.out.println("How many Attack Boost's would you like?");
							int givenFreq5 = scanner.nextInt();
							int totalCost5 = MH.itemCost * givenFreq5;
							if(totalCost5 <= funds) {
								player.playerBag.addtoBag(MH, givenFreq5);
								player.deductMoney(totalCost5);
								System.out.println("Purchase Successful.");
							}
							else {
								System.out.println("Insufficient funds.");
							}
							break;
							
						case 6:
							System.out.println("How many Attack Boost's would you like?");
							int givenFreq6 = scanner.nextInt();
							int totalCost6 = SB.itemCost * givenFreq6;
							if(totalCost6 <= funds) {
								player.playerBag.addtoBag(SB, givenFreq6);
								player.deductMoney(totalCost6);
								System.out.println("Purchase Successful.");
							}
							else {
								System.out.println("Insufficient funds.");
							}
							break;
							
						case 7:
							System.out.println("How many Attack Boost's would you like?");
							int givenFreq7 = scanner.nextInt();
							int totalCost7 = SP.itemCost * givenFreq7;
							if(totalCost7 <= funds) {
								player.playerBag.addtoBag(SP, givenFreq7);
								player.deductMoney(totalCost7);
								System.out.println("Purchase Successful.");
							}
							else {
								System.out.println("Insufficient funds.");
							}
							break;
							
						case 8:
							System.out.println("How many Attack Boost's would you like?");
							int givenFreq8 = scanner.nextInt();
							int totalCost8 = TP.itemCost * givenFreq8;
							if(totalCost8 <= funds) {
								player.playerBag.addtoBag(TP, givenFreq8);
								player.deductMoney(totalCost8);
								System.out.println("Purchase Successful.");
							}
							else {
								System.out.println("Insufficient funds.");
							}
							break;
							
						case 9:
							break;
						}
					
					}
				
				else if(givenOption.trim().equals("2")){
					System.out.println("Enter the number of the monster that you want to buy.\nEnter 5 if you want to exit.\n");
					if(player.getTeamNames().contains(shopMonster1.getName())==false){
						System.out.println("(1)\n"+shopMonster1+"\n");
					}
					if(player.getTeamNames().contains(shopMonster2.getName())==false){
						System.out.println("(2)\n"+shopMonster2+"\n");
					}
					if(player.getTeamNames().contains(shopMonster3.getName())==false){
						System.out.println("(3)\n"+shopMonster3+"\n");
					}
					if(player.getTeamNames().contains(shopMonster4.getName())==false){
						System.out.println("(4)\n"+shopMonster4+"\n");
					}
					String monsterToBuy = scanner.nextLine();
					int monsterNumber = Integer.parseInt(monsterToBuy);
					switch(monsterNumber) {
						case 1:
							int m1Tier = shopMonster1.getTier();
							int m1Price = buyMonsters.get(m1Tier);
							if (m1Price > funds){
								System.out.println("Insufficient funds");
							}
							else {
								player.playerTeam.addFriend(shopMonster1);
								player.deductMoney(m1Price);
								System.out.println("Purchase Successful");
							}
							break;
						case 2:
							int m2Tier = shopMonster2.getTier();
							int m2Price = buyMonsters.get(m2Tier);
							if (m2Price > funds){
								System.out.println("Insufficient funds");
							}
							else {
								player.playerTeam.addFriend(shopMonster2);
								player.deductMoney(m2Price);
								System.out.println("Purchase Successful");
							}
							break;
						case 3:
							int m3Tier = shopMonster3.getTier();
							int m3Price = buyMonsters.get(m3Tier);
							if (m3Price > funds){
								System.out.println("Insufficient funds");
							}
							else {
								player.playerTeam.addFriend(shopMonster3);
								player.deductMoney(m3Price);
								System.out.println("Purchase Successful");
							}
							break;
						case 4:
							int m4Tier = shopMonster4.getTier();
							int m4Price = buyMonsters.get(m4Tier);
							if (m4Price > funds){
								System.out.println("Insufficient funds");
							}
							else {
								player.playerTeam.addFriend(shopMonster4);
								player.deductMoney(m4Price);
								System.out.println("Purchase Successful");
							}
							break;
						case 5:
							break;
						default:
							System.out.println("Input not valid.");
							break;
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
							Object item = currentInven.getItem(indexItem);
							System.out.println("How many do you want to sell?\nEnter a number between 1 and "+((Item) item).getFrequency()+" (Inclusive).");
							String itemFreq = scanner.nextLine();
							int sellFreq = Integer.parseInt(itemFreq);
							int addMoney = ((Item)item).sellPrice() * sellFreq;
							currentInven.removeBag(indexItem, sellFreq);
							player.addMoney(addMoney);
							System.out.println("New balange: " + player.getMoney());
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
							Object monster = currentTeam.getFriend(indexMonster);
							int moneyIndex = ((Monster) monster).getTier();
							System.out.println("Are you sure?\nEnter 'Y' for yes, 'N' for no.");
							String confirmChoice = scanner.nextLine();
							if(confirmChoice.trim().equalsIgnoreCase("Y")) {
								currentTeam.removeFriend(currentTeam.getFriend(indexMonster));
								player.addMoney(sellMonsters.get(moneyIndex));
								System.out.println("Bye-bye "+((Monster)monster).getName());
							}
							else if(confirmChoice.trim().equalsIgnoreCase("N")){
								System.out.println("");
							}
						}
					}
				}
				else if(givenOption.trim().equals("5")){
					System.out.println("Thank you, Please come again!");
					isDone = true;
				}
			}
			catch (Exception e) {
				System.out.println("Invalid Input");
			}
		}
	}
	
	public static void nightPhase(Scanner scanner, Player player) {
		RandomEvent event = new RandomEvent();
		Team team = player.getTeam();
		Team updateTeam = player.getTeam();
		RandomMonster newMonster = null;
		Monster lostMonster = null;
		boolean newFriend = false;
		boolean lostFriend = false;
		int numMonsters = 0;
		try {
			for (int i = 0; i < updateTeam.getSize(); i++) {
				Monster monster = updateTeam.getFriend(i);
				monster.gainHealth(monster.getMaxHealth() - monster.getHealth());
			}
			for (int j = 0; j <= updateTeam.getSize(); j ++) {
				Monster monster = updateTeam.getFriend(j);
				if (event.shouldLevelUp(monster) == true) {
					monster.gainTier(1);
					numMonsters += 1;
				}
			}
			RandomMonster couldAdd = new RandomMonster();
			if (event.shouldJoin(updateTeam) == true) {
				newMonster = couldAdd;
				couldAdd.setPrice(0);
				updateTeam.addFriend(couldAdd);
				newFriend = true;
			}
			for (int l = 0; l <= updateTeam.getSize(); l ++) {
				Monster monster = updateTeam.getFriend(l);
				if (event.shouldLeave(updateTeam) == true) {
					lostMonster = monster;
					monster.setPrice(0);
					updateTeam.removeFriend(monster);
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
				for (int n = 0; n < team.getSize(); n++) {
					if (team.getFriend(n).getTier() < updateTeam.getFriend(n).getTier()) {
						Monster friend = team.getFriend(n);
						Monster nFriend = team.getFriend(n);
						System.out.println(friend.getName() + " Tier: " + friend.getTier() + " - - - > " + nFriend.getTier());
					}
				}
			}
		}
		catch (Exception e) {
			System.out.println("Invalid Input");
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
		setPlayerName(scanner);
		System.out.println("");
		setDays(scanner);
		System.out.println("");
		setDifficulty(scanner);
		System.out.println("");
		Player newPlayer = new Player(playerName, playerDays, playerDiff);
		Shop newShop = new Shop();
		selectMonster(scanner, newPlayer);
		System.out.println("~||~||~||~||~||~||~||~||~||~||~||~||~\n~||~ Let's Begin The Adventure!! ~||~ \n~||~||~||~||~||~||~||~||~||~||~||~||~");
		timer(3000);
		while(newPlayer.daysLeft() > 0) {
			newPlayer.toString();
			dayPrep(scanner, newPlayer);
			timer(1000);
			shopMonster1 = new RandomMonster();
			shopMonster2 = new RandomMonster();
			shopMonster3 = new RandomMonster();
			shopMonster4 = new RandomMonster();
			shoppingTime(scanner, newShop, newPlayer);
			nightPhase(scanner, newPlayer);
			newPlayer.addDay();
			
		}
	}
}

