<<<<<<< HEAD:MonsterFighter/src/Item.java
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
	
	String itemUse;
	
	int itemEffect;
	
	String itemStat;
	
	/**
	 * Basic Item constructor
	 * @param name				Name of the item
	 * @param sell				Selling price of the item
	 * @param cost				Price of the item
	 * @param description		Description of the item
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
	public String whenToUse() {
		return itemUse;
	}
	
	public int getFrequency() {
		return totalFrequency;
	}
	
	public void addFreq(Object item, int freq) {
		((Item)item).totalFrequency += freq;
	}
	
	public String toString() {
		return getFrequency() + "x " + getName();
		
	}
	
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
		else if(itemStat == "t") {
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
=======

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
	
	String itemUse;
	
	int itemEffect;
	
	String itemStat;
	
	/**
	 * Basic Item constructor
	 * @param name				Name of the item
	 * @param sell				Selling price of the item
	 * @param cost				Price of the item
	 * @param description		Description of the item
	 */
	Item(String name, int sell, int cost, String description, String use, int effect, String stat) {
		itemName = name;
		itemCost = cost;
		itemSell = sell;
		itemDescription = description;
		itemUse = use;
		itemEffect = effect;
		itemStat = stat;
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
	public String whenToUse() {
		return itemUse;
	}
	
	
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
	
	public String toString() {
		return getFrequency() + "x " + getName();
		
	}
	
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
		else if(itemStat == "t") {
			int currentTier = monster.getTier();
			monster.levelUp();
			System.out.println("Tier Increased: \n"+currentTier+" -----> "+monster.getTier());
			System.out.println(monster.getName() +" looks a lot tougher!");
		}
		
	}

	
}
>>>>>>> Matthew:MonsterFighter/Main/Item.java
