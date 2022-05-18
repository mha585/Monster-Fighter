/**
 * This class is the super class for all classes of type "Item" that are purchasable.
 * 
 * @author Angelo  Gasmin
 * @version 1.0
 */
public class Item implements Purchasable{
	/**
	 * The name of the item.
	 */
	private String itemName;
	/**
	 * The cost of the item.
	 */
	private int itemCost;
	/** 
	 * The selling price of the item.
	 */
	private int itemSell;
	/**
	 * The description of the item.
	 */
	private String itemDescription;
	/***
	 * The total amount of an item in the player's bag.
	 */
	private int totalFrequency;
	/**
	 * The situation where an item can be used.
	 */
	private String itemUse;
	/**
	 * The amount an item effects a stat by.
	 */
	private int itemEffect;
	/**
	 * The stat that an item effects.
	 */
	private String itemStat;
	/**
	 * Basic Item constructor.
	 * @param name				Name of the item
	 * @param sell				Selling price of the item
	 * @param cost				Price of the item
	 * @param description		Description of the item
	 * @param use				Situation where you can use an item
	 * @param effect			Amount an item increases a stat by
	 * @param stat				The stat an item effects
	 */
	Item(String name, int cost, int sell, String description, int effect, String stat) {
		itemName = name;
		itemCost = cost;
		itemSell = sell;
		itemDescription = description;
		itemEffect = effect;
		itemStat = stat;
	}
	/**
	 * Returns the description of an item.
	 * 
	 * @return the description of an item
	 */
	public String getDescription() {
		return itemDescription;
	}
	/**
	 * Returns the name of an item.
	 * 
	 * @return the name of an item
	 */
	public String getName() {
		return itemName;
	}
	/**
	 * Returns the price of an item.
	 * 
	 * @return the name of an item
	 */
	public int getPrice() {
		return itemCost;
	}
	/**
	 * Returns the selling price of an item.
	 * 
	 * @return the selling price of an item
	 */
	public int sellPrice() {
		return itemSell;
	}
	/**
	 * Returns the situations where an item can be used.
	 * 
	 * @return the situations where an item can be used
	 */
	public String whenToUse() {
		return itemUse;
	}
	/**
	 * Returns the amount that the item will effect a given stat by.
	 * 
	 * @return Int indicative of the amount the item will effect a given stat by.
	 */
	public int getEffect() {
		return itemEffect;
	}
	/**
	 * Returns the stat that the item affects.
	 * 
	 * @return String that describes the stat
	 */
	public String getStat() {
		return itemStat;
	}
	/**
	 * Returns the total amount of an item in the players inventory.
	 * 
	 * @return the total amount of an item in the players inventory
	 */
	public int getFrequency() {
		return totalFrequency;
	}
	/**
	 * Sets an item's frequency to amount.
	 * 
	 * @param amount the frequency the item's frequency will be set to
	 */
	public void setFrequency(int amount) {
		totalFrequency = amount;
	}
	/**
	 * Adds x amount of an item into the players inventory.
	 * 
	 * @param item		The item to be added to into the players inventory
	 * @param freq		The amount of the item to be added to the players inventory
	 */
	public void addFreq(int freq) {
		totalFrequency += freq;
	}
	/**
	 * Returns the item as its frequency and name.
	 * 
	 * @return string of an item's frequency and name
	 */
	public String toString() {
		return getFrequency() + "x " + getName();
	}
	/**
	 * Uses an item in the player's inventory.
	 * 
	 * @param monster	The monster the chosen item will be used on
	 */
	public void useItem(Monster monster) {
		if(itemStat == "atk") {
			monster.gainDamage(itemEffect);
		}
		else if(itemStat == "hp") {
			monster.gainHealth(itemEffect);
		}
		else if(itemStat == "spd") {
			monster.gainSpeed(itemEffect);
		}
		else if(itemStat == "tier") {
			monster.levelUp();
		}
		else if(itemStat == "fainted") {
			monster.revive();
		}
	}
}