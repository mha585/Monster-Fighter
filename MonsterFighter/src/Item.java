/**
 * This class is the super class for all classes of type "Item" that are purchasable
 * 
 * @author Angelo  Gasmin
 * @version 1.0
 */
public class Item implements Purchasable{
	/**
	 * The name of the item
	 */
	String itemName;
	/**
	 * The cost of the item
	 */
	int itemCost;
	/** 
	 * The selling price of the item
	 */
	int itemSell;
	/**
	 * The description of the item
	 */
	String itemDescription;
	/***
	 * The total frequency of an item in the player's bag
	 */
	int totalFrequency;
	/**
	 * Basic Item constructor
	 * @param name				Name of the item
	 * @param sell				Selling price of the item
	 * @param cost				Price of the item
	 * @param description		Description of the item
	 */
	Item(String name, int sell, int cost, String description) {
		itemName = name;
		itemCost = cost;
		itemSell = sell;
		itemDescription = description;
	}
	/**
	 * Returns the description of an item
	 */
	public String getDescription() {
		return itemDescription;
	}
	public String getName() {
		return itemName;
	}
	/**
	 * Returns the price of an item
	 */
	public int getPrice() {
		return itemCost;
	}
	/**
	 * Returns the selling price of an item
	 */
	public int sellPrice() {
		return itemSell;
	}
	/**
	 * Adds an item to the trainers bag
	 * Deducts money from the trainer based on the price of the item
	 */
	public void buyItem(int amount, Object item, Inventory bag) {
		
	}
	/**
	 * Removes an item from the trainers bag
	 * Gives money to the trainer based on the selling price of the item
	 */
	public void sellItem(int amount, Object item, Inventory bag) {
		//remove item from bag
		//+money
	}
	public int getFrequency() {
		return totalFrequency;
	}
	public void addFreq(Object item, int freq) {
		((Item)item).totalFrequency += freq;
	}

	public void useItem(Object item) {
		
	}
	public String toString() {
		return getFrequency() + "x " + getName();
		
	}
}
