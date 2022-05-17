import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * This class creates an instance of a shop.
 * The shop contains items and monsters that refresh each day.
 * 
 * @author Angelo  Gasmin
 * @version 1.0
 */
public class Shop {
	/**
	 * Creates an instance of AtkBoost that will be added to the shop
	 */
	private static AtkBoost AB = new AtkBoost();
	/**
	 * Creates an instance of AtkPlus that will be added to the shop
	 */
	private static AtkPlus AP = new AtkPlus();
	/**
	 * Creates an instance of BasicHeal that will be added to the shop
	 */
	private static BasicHeal BH = new BasicHeal();
	/**
	 * Creates an instance of  FullHeal that will be added to the shop
	 */
	private static FullHeal FH = new FullHeal();
	/**
	 * Creates an instance of MegaHeal that will be added to the shop
	 */
	private static MegaHeal MH = new MegaHeal();
	/**
	 * Creates an instance of Revive that will be added to the shop
	 */
	private static Revive RV = new Revive();
	/**
	 * Creates an instance of SpeedBoost that will be added to the shop
	 */
	private static SpeedBoost SB = new SpeedBoost();
	/**
	 * Creates an instance of SpeedPlus that will be added to the shop
	 */
	private static SpeedPlus SP = new SpeedPlus();
	/**
	 * Creates an instance of TierPlus that will be added to the shop
	 */
	private static TierPlus TP = new TierPlus();
	/**
	 * Creates an instance of RandomMonster that will be added to the shop
	 */
	private static RandomMonster shopMonster1;
	/**
	 * Creates an instance of RandomMonster that will be added to the shop
	 */
	private static RandomMonster shopMonster2;
	/**
	 * Creates an instance of RandomMonster that will be added to the shop
	 */
	private static RandomMonster shopMonster3;
	/**
	 * Creates an instance of RandomMonster that will be added to the shop
	 */
	private static RandomMonster shopMonster4;
	/**
	 * Holds the prices for the monsters dependent on their tier.
	 */
	private static List<Integer> buyMonsters =  Arrays.asList(0, 150, 200, 300);
	/**
	 * Holds the selling prices for the monsters dependent on their tier.
	 */
	private static List<Integer> sellMonsters = Arrays.asList(0, 50, 100, 150);
	/**
	 * Creates an ArrayList to hold the shopMonsters.
	 */
	private static ArrayList<RandomMonster> listMonsters = new ArrayList<RandomMonster>();
	/**
	 * Creates a list that holds each Item.
	 */
	private static List<Item> listItems = Arrays.asList(AB, AP, BH, FH, MH, RV, SB ,SP, TP);
	/**
	 * Creates an instance of the Shop
	 */
	public Shop(Player player, RandomGen num) {
		if (player.daysLeft() <= 2) {
			shopMonster1 = new RandomMonster(player, num);
			shopMonster2 = new RandomMonster(player, num);
			shopMonster3 = new RandomMonster(player, num);
			shopMonster4 = new RandomMonster(player, num);
			listMonsters.add(shopMonster1);
			listMonsters.add(shopMonster2);
			listMonsters.add(shopMonster3);
			listMonsters.add(shopMonster4);
		}
		else {
			boolean notHoly1 = false;
			while (notHoly1 == false) {
				shopMonster1 = new RandomMonster(player, num);
				if (shopMonster1.getType().equalsIgnoreCase("holy") == false) {
					listMonsters.add(shopMonster1);
					notHoly1 = true;
				}
			}
			boolean notHoly2 = false;
			while (notHoly2 == false) {
				shopMonster2 = new RandomMonster(player, num);
				if (shopMonster2.getType().equalsIgnoreCase("holy") == false) {
					listMonsters.add(shopMonster2);
					notHoly2 = true;
				}
			}
			boolean notHoly3 = false;
			while (notHoly3 == false) {
				shopMonster3 = new RandomMonster(player, num);
				if (shopMonster3.getType().equalsIgnoreCase("holy") == false) {
					listMonsters.add(shopMonster3);
					notHoly3 = true;
				}
			}
			boolean notHoly4 = false;
			while (notHoly4 == false) {
				shopMonster4 = new RandomMonster(player, num);
				if (shopMonster4.getType().equalsIgnoreCase("holy") == false) {
					listMonsters.add(shopMonster4);
					notHoly4 = true;
				}
			}
		}
	}
	/**
	 * Returns the string representation of items that can be bought.
	 * 
	 * @return String of each Item that can be bought
	 */
	public String displayItems() {
		return"(1)"+ AB.getName() + " - " + AB.getDescription() + " ......................$" + AB.getPrice()+ "\n" +
				"(2)"+AP.getName() + " - " + AP.getDescription() + " .......$" + AP.getPrice()+"\n" +
				"(3)"+BH.getName() + " - " + BH.getDescription() + " .........................................$" + BH.getPrice()+ "\n" +
				"(4)"+FH.getName() + " - " + FH.getDescription() + " .........................................$" + FH.getPrice()+ "\n" +
				"(5)"+MH.getName() + " - " + MH.getDescription() + " ................................$" + MH.getPrice()+ "\n" +
 				"(6)"+RV.getName() + " - " + RV.getDescription() + " ......................................................$" + RV.getPrice()+ "\n" +
				"(7)"+SB.getName() + " - " + SB.getDescription() + " ........................$" + SB.getPrice()+ "\n" +
				"(8)"+SP.getName() + " - " + SP.getDescription() + " .........$" + SP.getPrice()+ "\n" +
				"(9)"+TP.getName() + " - " + TP.getDescription() + " .......................$" + TP.getPrice() +
				"\n(10)Exit";
	}
	/**
	 * Shows the monsters that available to be bought.
	 * 
	 * @param player		The player
	 */
	public void displayMonsters(Player player) {
		if(player.getTeamNames().contains(shopMonster1.getName())==false){
			System.out.println("(1) Costs: $"+shopMonster1.getPrice()+"\n"+shopMonster1+"\n");
		}
		else {
			System.out.println("(1)\nOut of stock\n");
		}
		if(player.getTeamNames().contains(shopMonster2.getName())==false){
			System.out.println("(2) Costs: $"+shopMonster2.getPrice()+"\n"+shopMonster2+"\n");
		}
		else {
			System.out.println("(2)\nOut of stock\n");
		}
		if(player.getTeamNames().contains(shopMonster3.getName())==false){
			System.out.println("(3) Costs: $"+shopMonster3.getPrice()+"\n"+shopMonster3+"\n");
		}
		else {
			System.out.println("(3)\nOut of stock\n");
		}
		if(player.getTeamNames().contains(shopMonster4.getName())==false){
			System.out.println("(4) Costs: $"+shopMonster4.getPrice()+"\n"+shopMonster4+"\n");
		}
		else {
			System.out.println("(4)\nOut of stock\n");
		}
	}
	
	/**
	 * Returns the List of monster prices.
	 * 
	 * @return		List of integers that contain the prices of the shopMonsters
	 */
	public List<Integer> getBuy() {
		return buyMonsters;
	}
	/**
	 * Returns the List of monster sell prices.
	 * 
	 * @return		List of integers that contain the sell prices of the shopMonsters
	 */
	public List<Integer> getSell() {
		return sellMonsters;
	}
	/**
	 * Returns the List of monsters that can be bought.
	 * 
	 * @return		List of randomMonsters
	 */
	public List<RandomMonster> getMonsters() {
		return listMonsters;
	}
	/**
	 * REturns the List of items that can be bought.
	 * 
	 * @return		LIst of Items
	 */
	public List<Item> getItems() {
		return listItems;
	}
	/**
	 * Removes all monsters from listMonsters
	 */
	public void clearMonsters() {
		listMonsters.clear();
	}
}	