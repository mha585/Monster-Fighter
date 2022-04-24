/**
 * This class creates the Item "Tier Plus".
 * 
 * @author Angelo  Gasmin
 * @version 1.0
 */
public class TierPlus extends Item{
	/**
	 * The name of TierPlus.
	 */
	private static String name = "Tier Plus";
	/**
	 * The description of Tier Plus.
	 */
	private static String description = "Use on a monster out of battle to increase your monster's Tier by 1.";
	/**
	 * The price of Tier Plus.
	 */
	private static int price = 50;
	/**
	 * The selling price of Tier Plus.
	 */
	private static int sell = 40;
	/**
	 * The amount a monster's Tier increases by.
	 */
	private static int itemEffect = 1;
	/** 
	 * The stat Tier Plus effects.
	 */
	private static String statEffect = "tier";
	/**
	 * The situation where you can use Tier Plus.
	 */
	private static String whenToUse = "out";
	/**
	 * The basic constructor for TierPlus.
	 * @param name				The name of Tier Plus
	 * @param price				The price of Tier Plus
	 * @param sell				The selling price of Tier Plus
	 * @param description		The description of Tier Plus
	 * @param whenToUse			The situations where you can use Tier Plus 
	 * @param itemEffect		The amount a monster's Tier increases by when Tier Plus is used
	 * @param statEffect		The stat Tier Plus effects
	 */
	TierPlus() {
		super(name, price, sell ,description, whenToUse, itemEffect, statEffect);
	}
}