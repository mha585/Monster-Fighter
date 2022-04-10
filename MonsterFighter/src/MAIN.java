import java.util.Scanner;
import java.util.Arrays;
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
	private static String playerDiff;
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

	
	public static void setPlayerName(Scanner inputName) {
		boolean isProper = false;
		while(isProper == false) {
			System.out.println("Please enter a name: \nMust be between 3 and 15 characters. \nMust not contain numbers or special characters. ");
			String givenName = inputName.nextLine();
			if(givenName.trim().length() < 3 || givenName.trim().length() > 15) {
				System.out.println("Name length out of bounds.");
			}
			else if(givenName.trim().matches("[a-zA-Z]+") == false) {
				System.out.println("Invalid characters detected.");
			}
			else {
				playerName = givenName;
				isProper = true;
			}
		}
	}
	/**
	 * Asks for how many days the player wants
	 * @param inputDay			Scanner to check input
	 */
	public static void setDays(Scanner inputDay) {
		boolean isDay = false;
		while(isDay == false) {
			System.out.println("How many days will your adventure last for? \nEnter a number between 5 and 15.");
			String givenDay = inputDay.nextLine();
			if (givenDay.trim().matches("[0-9]+") == true) {
				if(Integer.parseInt(givenDay.trim()) >=5 && Integer.parseInt(givenDay.trim())<= 15) {
					playerDays = Integer.parseInt(givenDay);
					isDay = true;
				}
				else{
					System.out.println("Number not in bounds. \n");
				}
			}
			else if(givenDay.trim().matches("[a-zA-Z]+") == true) {
				System.out.println("Non-integer characters present. \n");
			}
			else {
				System.out.println("Unknown input, try again.");
			}

		}
	}
	/**
	 * Prompts player to set their difficulty
	 * @param inputDiff			Scanner to check input
	 */
	public static void setDifficulty(Scanner inputDiff) {
		boolean isDiff = false;
		while(isDiff == false) {
			System.out.println("Please select a difficulty. \nType either Easy, Normal or Hard.");
			String givenDiff = inputDiff.nextLine();
			if(givenDiff.equalsIgnoreCase("easy")|| givenDiff.equalsIgnoreCase("normal")|| givenDiff.equalsIgnoreCase("hard")){
				playerDiff = givenDiff.toLowerCase();
				isDiff = true;
			}
			else {
				System.out.println("" + givenDiff + " is not a valid difficulty level.");
			}
			
		}
	}
	
	/**
	 * Prompts player to pick a monster, choice between 3 monsters
	 * @param inputMonster			Scanner to check input
	 * @param forParty				Player to put monster into player's party
	 */
	public static void selectMonster(Scanner inputMonster, Player forParty) {
		final Monster one = new FireMonster("Fireguy", 50.0, 5.0, 20.0, 20.0, 1);
		final Monster two = new GrassMonster("Grassdude", 70, 5.0, 10.0, 20.0, 1);
		final Monster three = new WaterMonster("Waterman", 60, 5.0, 15.0, 20.0, 1);
		
		boolean isMonster = false;
		while(isMonster == false) {
			System.out.println("Select your first monster \nType 'one' for " + one.getName() + "\nType 'two' for " + two.getName() + "\nType 'three' for " + three.getName());
			String givenMonster = inputMonster.nextLine();
			if(givenMonster.toLowerCase().trim().equals("one")){
				forParty.playerTeam.addFriend(one);
				isMonster = true;
			}
			else if(givenMonster.toLowerCase().trim().equals("two")) {
				forParty.playerTeam.addFriend(two);
				isMonster = true;
			}
			else if(givenMonster.toLowerCase().trim().equals("three")) {
				forParty.playerTeam.addFriend(three);
				isMonster = true;
			}
			else {
				System.out.println(givenMonster + " is not a valid monster.");
			}
		}
	}
	
	public static void shoppingTime(Scanner inputShop, Shop newShop, Player newPlayer) {
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
			int funds = newPlayer.getMoney();
			System.out.println("Money: $"+funds);
			System.out.println("Would you like to (1)Buy Items \n                  (2)Buy Monsters\n                  (3)Sell Items\n                  (4)Sell Monsters\n                  (5)Quit Shopping\nPlease enter a number (1-4) that corresponds to one of the options above");
			String givenOption = inputShop.nextLine();
			if(givenOption.trim().equals("1")){
				try {
				System.out.println(newShop.toString());
				System.out.println("Enter the number of an item you would like to buy. Enter 9 if you would like to exit.");
				String givenItem = inputShop.nextLine();
				int number = Integer.parseInt(givenItem);
				switch(number) {
					case 1:
						System.out.println("How many Attack Boost's would you like?");
						String givenFreq1 = inputShop.nextLine();
						try {
							int x = Integer.parseInt(givenFreq1); 
							int totalCost = AB.itemCost * x;
							if(totalCost <= funds) {
								newPlayer.playerBag.addtoBag(AB, x);
								newPlayer.deductMoney(totalCost);
								System.out.println("Purchase Successful.");
							}
							else {
								System.out.println("Insufficient funds");
							}
						}
						catch(NumberFormatException e) {
							System.out.println("input is not an int value"); 
						} 
						break;
						
					case 2:
						System.out.println("How many Attack Boost's would you like?");
						String givenFreq2 = inputShop.nextLine();
						try {
							int x = Integer.parseInt(givenFreq2); 
							int totalCost = AP.itemCost * x;
							if(totalCost <= funds) {
								newPlayer.playerBag.addtoBag(AP, x);
								newPlayer.deductMoney(totalCost);
								System.out.println("Purchase Successful.");
							}
							else {
								System.out.println("Insufficient funds.");
							}
						}
						catch(NumberFormatException e) {
							System.out.println("Input is not an int value."); 
						} 
						break;

						
					case 3:
						System.out.println("How many Attack Boost's would you like.?");
						String givenFreq3 = inputShop.nextLine();
						try {
							int x = Integer.parseInt(givenFreq3); 
							int totalCost = BH.itemCost * x;
							if(totalCost <= funds) {
								newPlayer.playerBag.addtoBag(BH, x);
								newPlayer.deductMoney(totalCost);
								System.out.println("Purchase Successful.");
							}
							else {
								System.out.println("Insufficient funds.");
							}
						}
						catch(NumberFormatException e) {
							System.out.println("input is not an int value."); 
						} 
						break;
						
					case 4:
						System.out.println("How many Attack Boost's would you like?");
						String givenFreq4 = inputShop.nextLine();
						try {
							int x = Integer.parseInt(givenFreq4); 
							int totalCost = HR.itemCost * x;
							if(totalCost <= funds) {
								newPlayer.playerBag.addtoBag(HR, x);
								newPlayer.deductMoney(totalCost);
								System.out.println("Purchase Successful.");
							}
							else {
								System.out.println("Insufficient funds.");
							}
						}
						catch(NumberFormatException e) {
							System.out.println("input is not an int value."); 
						} 
						break;
						
					case 5: 
						System.out.println("How many Attack Boost's would you like?");
						String givenFreq5 = inputShop.nextLine();
						try {
							int x = Integer.parseInt(givenFreq5); 
							int totalCost = MH.itemCost * x;
							if(totalCost <= funds) {
								newPlayer.playerBag.addtoBag(MH, x);
								newPlayer.deductMoney(totalCost);
								System.out.println("Purchase Successful.");
							}
							else {
								System.out.println("Insufficient funds.");
							}
						}
						catch(NumberFormatException e) {
							System.out.println("input is not an int value."); 
						} 
						break;
						
					case 6:
						System.out.println("How many Attack Boost's would you like?");
						String givenFreq6 = inputShop.nextLine();
						try {
							int x = Integer.parseInt(givenFreq6); 
							int totalCost = SB.itemCost * x;
							if(totalCost <= funds) {
								newPlayer.playerBag.addtoBag(SB, x);
								newPlayer.deductMoney(totalCost);
								System.out.println("Purchase Successful.");
							}
							else {
								System.out.println("Insufficient funds.");
							}
						}
						catch(NumberFormatException e) {
							System.out.println("input is not an int value."); 
						} 
						break;
						
					case 7:
						System.out.println("How many Attack Boost's would you like?");
						String givenFreq7 = inputShop.nextLine();
						try {
							int x = Integer.parseInt(givenFreq7); 
							int totalCost = SP.itemCost * x;
							if(totalCost <= funds) {
								newPlayer.playerBag.addtoBag(SP, x);
								newPlayer.deductMoney(totalCost);
								System.out.println("Purchase Successful.");
							}
							else {
								System.out.println("Insufficient funds.");
							}
						}
						catch(NumberFormatException e) {
							System.out.println("input is not an int value."); 
						} 
						break;
						
					case 8:
						System.out.println("How many Attack Boost's would you like?");
						String givenFreq8 = inputShop.nextLine();
						try {
							int x = Integer.parseInt(givenFreq8); 
							int totalCost = TP.itemCost * x;
							if(totalCost <= funds) {
								newPlayer.playerBag.addtoBag(TP, x);
								newPlayer.deductMoney(totalCost);
								System.out.println("Purchase Successful.");
							}
							else {
								System.out.println("Insufficient funds.");
							}
						}
						catch(NumberFormatException e) {
							System.out.println("input is not an int value."); 
						} 
						break;
					case 9:
						break;
					}
				
				}
				catch(Exception e) {
					System.out.println("Input not valid.");
				}
			}
			else if(givenOption.trim().equals("2")){
				try {
					System.out.println("Enter the number of the monster that you want to buy.\nEnter 5 if you want to exit.\n");
					if(newPlayer.getTeamNames().contains(shopMonster1.getName())==false){
						System.out.println("(1)\n"+shopMonster1+"\n");
					}
					if(newPlayer.getTeamNames().contains(shopMonster2.getName())==false){
						System.out.println("(2)\n"+shopMonster2+"\n");
					}
					if(newPlayer.getTeamNames().contains(shopMonster3.getName())==false){
						System.out.println("(3)\n"+shopMonster3+"\n");
					}
					if(newPlayer.getTeamNames().contains(shopMonster4.getName())==false){
						System.out.println("(4)\n"+shopMonster4+"\n");
					}
					String monsterToBuy = inputShop.nextLine();
					int monsterNumber = Integer.parseInt(monsterToBuy);
					switch(monsterNumber) {
						case 1:
							int m1Tier = shopMonster1.getTier();
							int m1Price = buyMonsters.get(m1Tier);
							if (m1Price > funds){
								System.out.println("Insufficient funds");
							}
							else {
								newPlayer.playerTeam.addFriend(shopMonster1);
								newPlayer.deductMoney(m1Price);
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
								newPlayer.playerTeam.addFriend(shopMonster2);
								newPlayer.deductMoney(m2Price);
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
								newPlayer.playerTeam.addFriend(shopMonster3);
								newPlayer.deductMoney(m3Price);
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
								newPlayer.playerTeam.addFriend(shopMonster4);
								newPlayer.deductMoney(m4Price);
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
				catch(Exception e) {
					System.out.println("Input not valid.");
				}
			}
			else if(givenOption.trim().equals("3")){
				Inventory currentInven = newPlayer.getInventory();
				if(currentInven.getSize() == 0) {
					System.out.println("You have no items to sell.");
				}
				else {
					try {
						System.out.println(currentInven);
						System.out.println("Enter the number of the item you would like to sell.");
						String toSell = inputShop.nextLine();
						int indexItem = Integer.parseInt(toSell);
						Object item = currentInven.getItem(indexItem);
						System.out.println("How many do you want to sell?\nEnter a number between 1 and "+((Item) item).getFrequency()+" (Inclusive).");
						String itemFreq = inputShop.nextLine();
						int sellFreq = Integer.parseInt(itemFreq);
						int addMoney = ((Item)item).sellPrice() * sellFreq;
						currentInven.removeBag(indexItem, sellFreq);
						newPlayer.addMoney(addMoney);
						System.out.println("New balange: " + newPlayer.getMoney());
					}
					catch(IndexOutOfBoundsException e) {
						System.out.println("Index out of bounds.");
					}
					catch(NumberFormatException e) {
						System.out.println("Input not recognised.");
					}
				}
			}
			else if(givenOption.trim().equals("4")){
				Team currentTeam = newPlayer.getTeam();
				if(newPlayer.playerTeam.getSize() == 1) {
					System.out.println(newPlayer.playerTeam.getFriend(0).getName()+" is worried about you, you cannot sell your last monster.");
				}
				else {
					try {
						System.out.println(currentTeam);
						System.out.println("Enter the Team slot for the monster you want to sell (1-"+newPlayer.playerTeam.getSize()+".\nEnter 5 if you want to quit.");
						String indexTeam = inputShop.nextLine();
						if(indexTeam.equalsIgnoreCase("5")) {
							System.out.println("\n");
						}
						else {
							int indexMonster = Integer.parseInt(indexTeam) - 1;
							Object monster = currentTeam.getFriend(indexMonster);
							int moneyIndex = ((Monster) monster).getTier();
							System.out.println("Are you sure?\nEnter 'Y' for yes, 'N' for no.");
							String confirmChoice = inputShop.nextLine();
							if(confirmChoice.trim().equalsIgnoreCase("Y")) {
								currentTeam.removeFriend(currentTeam.getFriend(indexMonster));
								newPlayer.addMoney(sellMonsters.get(moneyIndex));
								System.out.println("Bye-bye "+((Monster)monster).getName());
							}
							else if(confirmChoice.trim().equalsIgnoreCase("N")){
								System.out.println("");
							}
						}
					}
					catch(IndexOutOfBoundsException e) {
						System.out.println("Index out of bounds.");
					}
					catch(NumberFormatException e) {
						System.out.println("Input not recognised.");
					}
				}
			}
			else if(givenOption.trim().equals("5")){
				System.out.println("Thank you, Please come again!");
				isDone = true;
				
			}
			else{
				System.out.println("Input not valid.");
			}
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
			timer(1000);
			shopMonster1 = new RandomMonster();
			shopMonster2 = new RandomMonster();
			shopMonster3 = new RandomMonster();
			shopMonster4 = new RandomMonster();
			shoppingTime(scanner, newShop, newPlayer);
			newPlayer.addDay();
			
		}
	}
}

