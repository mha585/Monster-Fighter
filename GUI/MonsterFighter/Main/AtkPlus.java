/**
 * This class creates the Item "Attack Plus".
 * 
 * @author Angelo  Gasmin
 * @version 1.0
 */
public class AtkPlus extends Item{
	/**
	 * The name of attack plus
	 */
	private static String name = "Attack Plus";
	/**
	 * The description of attack plus
	 */
	private static String description = "Use on a monster to increase your monster's attack stat permanently.";
	/**
	 * The price of attack plus
	 */
	private static int price = 75;
	/**
	 * The selling price of attack plus
	 */
	private static int sell = 40;
	/**
	 * The amount a monsters attack will increase by.
	 */
	private static int itemEffect = 10;
	/**
	 * The stat that Attack Plus effects.
	 */
	private static String statEffect = "atk";
	/**
	 * Basic attack plus constructor
	 * @param name				The name of attack plus
	 * @param price				The price of attack plus
	 * @param sell				The selling price of attack plus
	 * @param description		The description of attack plus
	 * @param itemEffect		The stat that Attack Plus effects
	 * @param statEffect		The amount a monsters attack will increase by
	 */
	AtkPlus() {
		super(name, price, sell ,description, itemEffect, statEffect);
	}
}