/**
 * This class creates the Item "Speed Boost".
 * 
 * @author Angelo  Gasmin
 * @version 1.0
 */
public class SpeedBoost extends Item {
	/**
	 * The name of speed boost.
	 */
	private static String name = "Speed Boost";
	/**
	 * The description of speed boost.
	 */
	private static String description = "Use on a monster to increase your monster's speed stat by alot.";		
	/**
	 * The price of speed boost.
	 */
	private static int price = 100;
	/**
	 * The cost of speed boost.
	 */
	private static int sell = 75;
	/**
	 * The amount a monster's speed will increase by.
	 */
	private static int itemEffect = 10;
	/**
	 * The stat that Speed Boost effects.
	 */
	private static String statEffect = "spd";
	/**
	 * Basic speed boost constructor.
	 * @param name				The name of speed boost
	 * @param price				The price of speed boost
	 * @param sell				The selling price of speed boost
	 * @param description		The description of speed boost
	 * @param itemEffect		The amount a monster's speed will increase by
	 * @param statEffect		The stat that Speed Boost effects
	 */
	SpeedBoost() {
		super(name, price, sell ,description, itemEffect, statEffect);
	}
}
