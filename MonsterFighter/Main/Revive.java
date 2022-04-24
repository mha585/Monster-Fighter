/**
 * This class creates the item "Revive".
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
	 * The amount a monsters attack will increase by.
	 */
	private static int itemEffect = 1000000;
	/**
	 * The status that Revive effects.
	 */
	private static String statEffect = "fainted";
	/**
	 * The situations where you can use Revive.
	 */
	private static String whenToUse = "both";
	/**
	 * Basic attack plus constructor
	 * @param name				The name of attack plus
	 * @param price				The price of attack plus
	 * @param sell				The selling price of attack plus
	 * @param description		The description of attack plus
	 * @param whenToUse			The situations where you can use Revive
	 * @param itemEffect		The amount a monsters attack will increase by
	 * @param statEffect		The status that Revive effects
	 */
	Revive() {
		super(name, price, sell ,description, whenToUse, itemEffect, statEffect);
	}
}
