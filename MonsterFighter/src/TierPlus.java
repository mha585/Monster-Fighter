/**
 * 
 * @author Angelo  Gasmin
 * @version 1.0
 */
public class TierPlus extends Item{
	/**
	 * The name of TierPlus
	 */
	private static String name = "Tier Plus";
	/**
	 * The description of Tier Plus
	 */
	private static String description = "Use on a monster out of battle to increase your monster's Tier by 1.";
	/**
	 * The price of Tier Plus
	 */
	private static int price = 50;
	/**
	 * The selling price of Tier Plus
	 */
	private static int sell = 40;
	
	private static int itemEffect = 1;
	
	private static String statEffect = "t";
	
	private static String whenToUse = "out";
	/**
	 * The basic constructor for TierPLus
	 * @param name				The name of Tier Plus
	 * @param price				The price of Tier Plus
	 * @param sell				The selling price of Tier Plus
	 * @param description		The description of Tier Plus
	 * @param whenToUse
	 * @param itemEffect
	 * @param statEffect
	 */
	TierPlus() {
		super(name, price, sell ,description, whenToUse, itemEffect, statEffect);
	}

	/**
	 * Uses Tier Plus on a chosen monster
	 * @param myMonster			The monster whose tier will be increased
	 */


}
