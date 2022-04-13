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
			System.out.println("(1)\n"+shopMonster1+"\n");
		}
		else {
			System.out.println("(1)\nOut of stock\n");
		}
		if(player.getTeamNames().contains(shopMonster2.getName())==false){
			System.out.println("(2)\n"+shopMonster2+"\n");
		}
		else {
			System.out.println("(2)\nOut of stock\n");
		}
		if(player.getTeamNames().contains(shopMonster3.getName())==false){
			System.out.println("(3)\n"+shopMonster3+"\n");
		}
		else {
			System.out.println("(3)\nOut of stock\n");
		}
		if(player.getTeamNames().contains(shopMonster4.getName())==false){
			System.out.println("(4)\n"+shopMonster4+"\n");
		}
		else {
			System.out.println("(4)\nOut of stock\n");
		}
	}
	
	public void generateNewMonsters() {
		shopMonster1 = new RandomMonster();
		shopMonster2 = new RandomMonster();
		shopMonster3 = new RandomMonster();
		shopMonster4 = new RandomMonster();
		listMonsters.add(shopMonster1);
		listMonsters.add(shopMonster2);
		listMonsters.add(shopMonster3);
		listMonsters.add(shopMonster4);
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
