/**
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
	private static String description = "Use on a monster out of battle to increase your monster's attack stat permanently.";
	/**
	 * The price of attack plus
	 */
	private static int price = 50;
	/**
	 * The selling price of attack plus
	 */
	private static int sell = 40;
	/**
	 * The amount a monsters attack will increase by
	 */
	private static int itemEffect = 10;
	
	private static String statEffect = "atk";
	
	private static String whenToUse = "out";
	/**
	 * Basic attack plus constructor
	 * @param name				The name of attack plus
	 * @param price				The price of attack plus
	 * @param sell				The selling price of attack plus
	 * @param description		The description of attack plus
	 */
	AtkPlus() {
		super(name, price, sell ,description, whenToUse, itemEffect, statEffect);
	}

	/**
	 * Use attack plus on a chosen monster
	 * @param myMonster			The monster attack plus will be used on
	 */

}
