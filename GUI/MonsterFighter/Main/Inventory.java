import java.util.ArrayList;
/**
 * Creates an instance of an Object of type Inventory. The inventory holds the player's items.
 * 
 * @author Angelo  Gasmin
 * @version 1.0
 */
public class Inventory {
	/**
	 * Creates a new Inventory.
	 */
	private ArrayList<Object> bag = new ArrayList <>();
	/**
	 * Returns the size of the bag. The size correlates to number of unique items.
	 * 
	 * @return an integer of the size of the bag.
	 */
	public int getSize() {
		return bag.size();
	}
	/**
	 * Returns the item in the i-th index in the player's inventory.
	 * 
	 * @param i			Counter to get i-th item in bag
	 * @return			Object of parent class Item
	 */
	public Item getItem(int index) {
		return (Item) bag.get(index);
	}
	/**
	 * returns index of given item in player's bag
	 * 
	 * @param name
	 * @return
	 */
	public int getIndex(String name) {
		int index = 0;
		for (int i = 0; i < bag.size(); i++) {
			Item current = (Item) bag.get(i);
			if (current.getName() == name) {
				index = i;
			}
		}
		return index;
	}
	/**
	 * Buy's an item from the shop and adds it to the player's inventory and deducts money accordingly.
	 * 
	 * @param amount	Number of items bought
	 * @param item		The type of item bought
	 * @param player	The player
	 */
	public void buyItem(int amount, Object item, Player player) {
		int totalCost1 = ((Item) item).getPrice() * amount;
		if(totalCost1 <= player.getMoney()) {
			player.playerBag.addtoBag(item, amount);
			player.deductMoney(totalCost1);
			System.out.println("Purchase Successful.");
		}
		else {
			System.out.println("Insufficient funds");
		}
	}
	/**
	 * Removes an item from the trainers inventory.
	 * Gives money to the trainer based on the selling price of the item.
	 * 
	 * @param amount	Amount of items to be sold
	 * @param index		Index of the item in the player's inventory
	 * @param player	The player
	 * @param bag		Inventory of the player
	 */
	public void sellItem(int amount, int index, Player player, Inventory bag) {
		Object item = bag.getItem(index);
		int addMoney = ((Item)item).sellPrice() * amount;
		bag.removeBag(index, amount);
		player.addMoney(addMoney);
		System.out.println("New balange: " + player.getMoney());
	}
	/**
	 * Adds x amount of items into the player's inventory.
	 * 
	 * @param item		Item to be added to the player's inventory
	 * @param freq		Amount of the item to be added
	 */
	public void addtoBag(Object item, int freq) {
		boolean inBag = false;
		int i = 0;
		while (i < bag.size()) {
			for (i = 0; i < bag.size(); i++) {
				if (((Item) bag.get(i)).getName() == ((Item) item).getName()) {
					((Item) bag.get(i)).addFreq(freq);
					inBag = true;
				}
			}
		}
		if (inBag == false) {
			bag.add(item);
			((Item)item).addFreq(freq);
		}
	}
	/**
	 * Removes x amount of items from player's inventory.
	 * 
	 * @param index		Index of the item to be removed from the player's inventory
	 * @param freq		Amount of the item to be removed
	 */
	public void removeBag(int index, int freq) {
		Item item = (Item)bag.get(index);
		if (item.getFrequency() > freq) {
			item.addFreq((-1 * freq));
		}else if(item.getFrequency() == freq) {
			item.addFreq((-1 * freq));
			bag.remove(index);
		}
	}
	/**
	 * Removes all items in bag.
	 */
	public void clear() {
		for (int i = 0; i < bag.size(); i++) {
			bag.remove(i);
		}
	}
}