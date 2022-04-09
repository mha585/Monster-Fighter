import java.util.Scanner;

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
	
	/**
	 * Players difficulty = easy
	 */
	private static String easy = "easy";
	/**
	 * Players difficulty = medium
	 */
	private static String normal = "normal";
	/**
	 * Players difficulty = hard
	 */
	private static String hard = "hard";

	/**
	 * Asks for players name, sets playerName to input
	 * @param inputName			Scanner to check input
	 */
	private static Monster shopMonster1;
	private static Monster shopMonster2;
	private static Monster shopMonster3;
	private static Monster shopMonster4;
	
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
			if(givenDiff.toLowerCase().trim().equals(easy)|| givenDiff.toLowerCase().trim().equals(normal)|| givenDiff.toLowerCase().trim().equals(hard)) {
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
				forParty.playerTeam.add(one);
				isMonster = true;
			}
			else if(givenMonster.toLowerCase().trim().equals("two")) {
				forParty.playerTeam.add(two);
				isMonster = true;
			}
			else if(givenMonster.toLowerCase().trim().equals("three")) {
				forParty.playerTeam.add(three);
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
			System.out.println(funds);
			System.out.println("Would you like to (1)Buy Items \n                  (2)Buy Monsters\n                  (3)Sell\n                  (4)Quit Shopping\nPlease enter a number (1-4) that corresponds to one of the options above");
			String givenOption = inputShop.nextLine();
			if(givenOption.trim().equals("1")){
				try {
				System.out.println(newShop.toString());
				System.out.println("Enter the number of an item you would like to buy. Enter 9 if you would like to exit.");
				String givenItem = inputShop.nextLine();
				int number = Integer.parseInt(givenItem);
				switch(number) {
					case 1:
						boolean isProper1 = false;
						while(isProper1 == false) {
							System.out.println("How many Attack Boost's would you like?");
							String givenFreq = inputShop.nextLine();
							try {
								int x = Integer.parseInt(givenFreq); 
								int totalCost = AB.itemCost * x;
								if(totalCost <= funds) {
									newPlayer.playerBag.addtoBag(AB, x);
									newPlayer.deductMoney(totalCost);
									System.out.println("Purchase Successful.");
									isProper1 = true;
								}
								else {
									System.out.println("Not enough funds");
								}
							}
							catch(NumberFormatException e) {
								System.out.println("input is not an int value"); 
							} 
						}
						break;
						
					case 2:
						boolean isProper2 = false;
						while(isProper2 == false) {
							System.out.println("How many Attack Boost's would you like?");
							String givenFreq = inputShop.nextLine();
							try {
								int x = Integer.parseInt(givenFreq); 
								int totalCost = AP.itemCost * x;
								if(totalCost <= funds) {
									newPlayer.playerBag.addtoBag(AP, x);
									newPlayer.deductMoney(totalCost);
									System.out.println("Purchase Successful.");
									isProper2 = true;
								}
								else {
									System.out.println("Not enough funds.");
								}
							}
							catch(NumberFormatException e) {
								System.out.println("Input is not an int value."); 
							} 
						}
						break;
						
					case 3:
						boolean isProper3 = false;
						while(isProper3 == false) {
							System.out.println("How many Attack Boost's would you like.?");
							String givenFreq = inputShop.nextLine();
							try {
								int x = Integer.parseInt(givenFreq); 
								int totalCost = BH.itemCost * x;
								if(totalCost <= funds) {
									newPlayer.playerBag.addtoBag(BH, x);
									newPlayer.deductMoney(totalCost);
									System.out.println("Purchase Successful.");
									isProper3 = true;
								}
								else {
									System.out.println("Not enough funds.");
								}
							}
							catch(NumberFormatException e) {
								System.out.println("input is not an int value."); 
							} 
						}
						break;
						
					case 4:
						boolean isProper4 = false;
						while(isProper4 == false) {
							System.out.println("How many Attack Boost's would you like?");
							String givenFreq = inputShop.nextLine();
							try {
								int x = Integer.parseInt(givenFreq); 
								int totalCost = HR.itemCost * x;
								if(totalCost <= funds) {
									newPlayer.playerBag.addtoBag(HR, x);
									newPlayer.deductMoney(totalCost);
									System.out.println("Purchase Successful.");
									isProper4 = true;
								}
								else {
									System.out.println("Not enough funds.");
								}
							}
							catch(NumberFormatException e) {
								System.out.println("input is not an int value."); 
							} 
						}
						break;
						
					case 5: 
						boolean isProper5 = false;
						while(isProper5 == false) {
							System.out.println("How many Attack Boost's would you like?");
							String givenFreq = inputShop.nextLine();
							try {
								int x = Integer.parseInt(givenFreq); 
								int totalCost = MH.itemCost * x;
								if(totalCost <= funds) {
									newPlayer.playerBag.addtoBag(MH, x);
									newPlayer.deductMoney(totalCost);
									System.out.println("Purchase Successful.");
									isProper5 = true;
								}
								else {
									System.out.println("Not enough funds.");
								}
							}
							catch(NumberFormatException e) {
								System.out.println("input is not an int value."); 
							} 
						}
						break;
						
					case 6:
						boolean isProper6 = false;
						while(isProper6 == false) {
							System.out.println("How many Attack Boost's would you like?");
							String givenFreq = inputShop.nextLine();
							try {
								int x = Integer.parseInt(givenFreq); 
								int totalCost = SB.itemCost * x;
								if(totalCost <= funds) {
									newPlayer.playerBag.addtoBag(SB, x);
									newPlayer.deductMoney(totalCost);
									System.out.println("Purchase Successful.");
									isProper6 = true;
								}
								else {
									System.out.println("Not enough funds.");
								}
							}
							catch(NumberFormatException e) {
								System.out.println("input is not an int value."); 
							} 
						}
						break;
						
					case 7:
						boolean isProper7 = false;
						while(isProper7 == false) {
							System.out.println("How many Attack Boost's would you like?");
							String givenFreq = inputShop.nextLine();
							try {
								int x = Integer.parseInt(givenFreq); 
								int totalCost = SP.itemCost * x;
								if(totalCost <= funds) {
									newPlayer.playerBag.addtoBag(SP, x);
									newPlayer.deductMoney(totalCost);
									System.out.println("Purchase Successful.");
									isProper7 = true;
								}
								else {
									System.out.println("Not enough funds.");
								}
							}
							catch(NumberFormatException e) {
								System.out.println("input is not an int value."); 
							} 
						}
						break;
						
					case 8:
						boolean isProper8 = false;
						while(isProper8 == false) {
							System.out.println("How many Attack Boost's would you like?");
							String givenFreq = inputShop.nextLine();
							try {
								int x = Integer.parseInt(givenFreq); 
								int totalCost = TP.itemCost * x;
								if(totalCost <= funds) {
									newPlayer.playerBag.addtoBag(TP, x);
									newPlayer.deductMoney(totalCost);
									System.out.println("Purchase Successful.");
									isProper8 = true;
								}
								else {
									System.out.println("Not enough funds.");
								}
							}
							catch(NumberFormatException e) {
								System.out.println("input is not an int value."); 
							} 
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
				
			}
			else if(givenOption.trim().equals("3")){
				Inventory currentInven = newPlayer.getInventory();
				if(currentInven.getSize() == 0) {
					System.out.println("You have no items to sell.");
				}
				else {
					try {
						System.out.println(currentInven.toString());
						System.out.println("Enter the number of the item you would like to sell.");
						String toSell = inputShop.nextLine();
						int sellNumber = Integer.parseInt(toSell);
						Object item = currentInven.getGet(sellNumber);
						System.out.println("How many do you want to sell?\nEnter a number between 1 and "+((Item) item).getFrequency()+" (Inclusive).");
						String itemFreq = inputShop.nextLine();
						int sellFreq = Integer.parseInt(itemFreq);
						int addMoney = ((Item)item).sellPrice() * sellFreq;
						currentInven.removeBag(sellNumber, sellFreq);
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
			shoppingTime(scanner, newShop, newPlayer);
			newPlayer.addDay();
			
		}
	}
}

