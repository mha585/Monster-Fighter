import java.util.ArrayList;

public class Inventory {
	
	private ArrayList<Object> bag = new ArrayList <>();
	
	public ArrayList<Object> getBag() {
		return bag;
	}
	
	public int getSize() {
		return bag.size();
	}
	
	public Object getGet(int i) {
		return bag.get(i);
	}
	
	public void addtoBag(Object item, int freq) {
		if (bag.contains(item) == true) {
			((Item)item).addFreq(item, freq);
		}
		else {
			bag.add(item);
			((Item)item).addFreq(item, freq);
		}
	}
	public void removeBag(int index, int freq) {
		Item item = (Item)bag.get(index);
		if (item.getFrequency() > freq) {
			item.totalFrequency -= freq;
		}else if(item.getFrequency() == freq) {
			item.totalFrequency = 0;
			bag.remove(index);
			
		}
	}
	
	public String toString() {
		if (bag.size() == 0) {
			return "Your bag is empty";
		} else {
			System.out.println("Inventory: ");
			for (int i = 0; i < bag.size();i++) {
				Item item = (Item) bag.get(i);
				System.out.println("("+i+")"+item.totalFrequency + "x " + item.getName());
			}
		}	
		return "";
	}
	public static void main(String args[]) {
		Inventory bag = new Inventory();
		AtkBoost attack = new AtkBoost();
		MegaHeal Mheal = new MegaHeal();
		bag.addtoBag(attack, 2);
		bag.addtoBag(Mheal, 1);
		bag.addtoBag(attack,  2);
		System.out.println(bag);
		bag.removeBag(0, 2);
		System.out.println(bag);
	}
}
