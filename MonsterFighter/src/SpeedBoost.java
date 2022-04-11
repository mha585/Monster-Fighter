/**
 * 
 * @author Angelo  Gasmin
 * @version 1.0
 */
public class SpeedBoost extends Item {
	/**
	 * The name of speed boost
	 */
	private static String name = "Speed Boost";
	/**
	 * The description of speed boost
	 */
	private static String description = "Use on a monster in battle to increase your monster's speed stat.";		
	/**
	 * The price of speed boost
	 */
	private static int price = 50;
	/**
	 * The cost of speed boost
	 */
	private static int sell = 40;
	/**
	 * The amount a monster's speed will increase by
	 */
	private static int itemEffect = 10;
	
	private static String statEffect = "spd";
	
	private static String whenToUse = "in";
	/**
	 * Basic speed boost constructor
	 * @param name				The name of speed boost
	 * @param price				The price of speed boost
	 * @param sell				The selling price of speed boost
	 * @param description		The description of speed boost
	 */
	SpeedBoost() {
		super(name, price, sell ,description, whenToUse, itemEffect, statEffect);
	}

	/**
	 * Use speed boost on a chosen monster
	 * @param myMonster			The monster speed boost is used on 
	 */
}
