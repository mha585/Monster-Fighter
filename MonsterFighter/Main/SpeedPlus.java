/**
 * This class creates the Item "Speed Plus".
 * 
 * @author Angelo  Gasmin
 * @version 1.0
 */
public class SpeedPlus extends Item{
	/**
	 * The name of Speed Plus.
	 */
	private static String name = "Speed Plus";
	/**
	 * The description of Speed Plus.
	 */
	private static String description = "Use on a monster out of battle to increase your monster's speed stat permanently.";	
	/** 
	 * The price of Speed Plus.
	 */
	private static int price = 75;
	/**
	 * The selling price of Speed Plus.
	 */
	private static int sell = 40;
	/**
	 * The amount speed is increased by.
	 */
	private static int itemEffect = 10;
	/**
	 * The stat that Speed Plus effects.
	 */
	private static String statEffect = "spd";
	/**
	 * The situation where Speed Plus can be used.
	 */
	private static String whenToUse = "out";
	/**
	 * Basic SpeedPlus Constructor.
	 * @param name				The name of speed plus
	 * @param price				The price of speed plus
	 * @param sell				The selling price of speed plus
	 * @param description		The description of speed plus
	 * @param whenToUse			The situation where Speed Plus can be used
	 * @param itemEffect  		The amount speed is increased by
	 * @param statEffect		The stat that Speed Plus effects
	 */
	SpeedPlus() {
		super(name, price, sell ,description, whenToUse, itemEffect, statEffect);
	}
}
