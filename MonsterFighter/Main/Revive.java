/**
 * 
 * @author Angelo  Gasmin
 * @version 1.0
 */
public class Revive extends Item{
	/**
	 * The name of attack plus
	 */
	private static String name = "Revive";
	/**
	 * The description of attack plus
	 */
	private static String description = "Use on a fainted monster to revive them.";
	/**
	 * The price of attack plus
	 */
	private static int price = 250;
	/**
	 * The selling price of attack plus
	 */
	private static int sell = 150;
	/**
	 * The amount a monsters attack will increase by
	 */
	private static int itemEffect = 1000000;
	
	private static String statEffect = "fainted";
	
	private static String whenToUse = "both";
	/**
	 * Basic attack plus constructor
	 * @param name				The name of attack plus
	 * @param price				The price of attack plus
	 * @param sell				The selling price of attack plus
	 * @param description		The description of attack plus
	 * @param whenToUse
	 * @param itemEffect
	 * @param statEffect
	 */
	Revive() {
		super(name, price, sell ,description, whenToUse, itemEffect, statEffect);
	}

	/**
	 * Use attack plus on a chosen monster
	 * @param myMonster			The monster attack plus will be used on
	 */

}
