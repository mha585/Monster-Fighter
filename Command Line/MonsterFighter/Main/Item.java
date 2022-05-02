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
	String itemName;
	/**
	 * The cost of the item.
	 */
	int itemCost;
	/** 
	 * The selling price of the item.
	 */
	int itemSell;
	/**
	 * The description of the item.
	 */
	String itemDescription;
	/***
	 * The total amount of an item in the player's bag.
	 */
	int totalFrequency;
	/**
	 * The situation where an item can be used.
	 */
	String itemUse;
	/**
	 * The amount an item effects a stat by.
	 */
	int itemEffect;
	/**
	 * The stat that an item effects.
	 */
	String itemStat;
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
	Item(String name, int cost, int sell, String description, String use, int effect, String stat) {
		itemName = name;
		itemCost = cost;
		itemSell = sell;
		itemDescription = description;
		itemUse = use;
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
	 * Returns the total amount of an item in the players inventory.
	 * 
	 * @return the total amount of an item in the players inventory
	 */
	public int getFrequency() {
		return totalFrequency;
	}
	/**
	 * Adds x amount of an item into the players inventory.
	 * 
	 * @param item		The item to be added to into the players inventory
	 * @param freq		The amount of the item to be added to the players inventory
	 */
	public void addFreq(Object item, int freq) {
		((Item)item).totalFrequency += freq;
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
			double currentAtk = monster.getDamage();
			monster.gainDamage(itemEffect);
			System.out.println("Damage Increased: \n"+currentAtk+" -----> "+monster.getDamage());
			System.out.println(monster.getName() +" is flexing their muscles!");
		}
		else if(itemStat == "hp") {
			double currentHp = monster.getHealth();
			monster.gainHealth(itemEffect);
			System.out.println("HP Restored: \n"+currentHp+" -----> "+monster.getHealth());
			System.out.println(monster.getName() +" is looking healthy!");
		}
		else if(itemStat == "spd") {
			double currentSpeed = monster.getSpeed();
			monster.gainSpeed(itemEffect);
			System.out.println("Speed Increased: \n"+currentSpeed+" -----> "+monster.getSpeed());
			System.out.println(monster.getName() +" is energised!");
		}
		else if(itemStat == "tier") {
			int currentTier = monster.getTier();
			monster.levelUp();
			System.out.println("Tier Increased: \n"+currentTier+" -----> "+monster.getTier());
			System.out.println(monster.getName() +" looks a lot tougher!");
		}
		else if(itemStat == "fainted") {
			double currentHealth = monster.getHealth();
			monster.revive();
			System.out.println("Tier Increased: \n"+currentHealth+" -----> "+monster.getTier());
			System.out.println(monster.getName() +" looks a lot tougher!");
		}
	}
}