import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shop {
	private static AtkBoost AB = new AtkBoost();
	private static AtkPlus AP = new AtkPlus();
	private static BasicHeal BH = new BasicHeal();
	private static FullHeal FH = new FullHeal();
	private static MegaHeal MH = new MegaHeal();
	private static Revive RV = new Revive();
	private static SpeedBoost SB = new SpeedBoost();
	private static SpeedPlus SP = new SpeedPlus();
	private static TierPlus TP = new TierPlus();
	private static RandomMonster shopMonster1;
	private static RandomMonster shopMonster2;
	private static RandomMonster shopMonster3;
	private static RandomMonster shopMonster4;
	private static List<Integer> buyMonsters =  Arrays.asList(0, 150, 200, 300);
	private static List<Integer> sellMonsters = Arrays.asList(0, 50, 100, 150);
	private static ArrayList<RandomMonster> listMonsters = new ArrayList<RandomMonster>();
	private static List<Item> listItems = Arrays.asList(AB, AP, BH, FH, MH, RV, SB ,SP, TP);
	
	public Shop() {}
	
	public String displayItems() {
		return"(1)"+ AB.getName() + " - " + AB.getDescription() + " ......................$" + AB.getPrice()+ "\n" +
				"(2)"+AP.getName() + " - " + AP.getDescription() + " .......$" + AP.getPrice()+"\n" +
				"(3)"+BH.getName() + " - " + BH.getDescription() + " .........................................$" + BH.getPrice()+"\n" +
				"(4)"+FH.getName() + " - " + FH.getDescription() + " .........................................$" + FH.getPrice()+"\n" +
				"(5)"+MH.getName() + " - " + MH.getDescription() + " ................................$" + MH.getPrice()+"\n" +
 				"(6)"+RV.getName() + " - " + RV.getDescription() + " ......................................................$" + RV.getPrice()+"\n" +
				"(7)"+SB.getName() + " - " + SB.getDescription() + " ........................$" + SB.getPrice()+"\n" +
				"(8)"+SP.getName() + " - " + SP.getDescription() + " .........$" + SP.getPrice()+"\n" +
				"(9)"+TP.getName() + " - " + TP.getDescription() + " .......................$" + TP.getPrice() +
				"\n(10)Exit";
	}
	
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
	
	public void generateNewMonsters(Player player) {
		if (player.daysLeft() <= 2) {
			shopMonster1 = new RandomMonster(player);
			shopMonster2 = new RandomMonster(player);
			shopMonster3 = new RandomMonster(player);
			shopMonster4 = new RandomMonster(player);
			listMonsters.add(shopMonster1);
			listMonsters.add(shopMonster2);
			listMonsters.add(shopMonster3);
			listMonsters.add(shopMonster4);
		}
		else {
			boolean notHoly1 = false;
			while (notHoly1 == false) {
				shopMonster1 = new RandomMonster(player);
				if (shopMonster1.getType().equalsIgnoreCase("holy") == false) {
					listMonsters.add(shopMonster1);
					notHoly1 = true;
				}
			}
			boolean notHoly2 = false;
			while (notHoly2 == false) {
				shopMonster2 = new RandomMonster(player);
				if (shopMonster2.getType().equalsIgnoreCase("holy") == false) {
					listMonsters.add(shopMonster2);
					notHoly2 = true;
				}
			}
			boolean notHoly3 = false;
			while (notHoly3 == false) {
				shopMonster3 = new RandomMonster(player);
				if (shopMonster3.getType().equalsIgnoreCase("holy") == false) {
					listMonsters.add(shopMonster3);
					notHoly3 = true;
				}
			}
			boolean notHoly4 = false;
			while (notHoly4 == false) {
				shopMonster4 = new RandomMonster(player);
				if (shopMonster4.getType().equalsIgnoreCase("holy") == false) {
					listMonsters.add(shopMonster4);
					notHoly4 = true;
				}
			}
		}
	}
	
	public List<Integer> getBuy() {
		return buyMonsters;
	}
	
	public List<Integer> getSell() {
		return sellMonsters;
	}
	
	public List<RandomMonster> getMonsters() {
		return listMonsters;
	}
	
	public List<Item> getItems() {
		return listItems;
	}
	
}
