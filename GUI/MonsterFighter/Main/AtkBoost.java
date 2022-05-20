/**
 * This class creates the Item "Attack Boost".
 * sayph
 * @author Angelo  Gasmin
 * @version 1.0
 */
public class AtkBoost extends Item{
	/**
	 * The name of attack boost.
	 */
	private static String name = "Attack Boost";
	/**
	 * The description of attack boost.
	 */
	private static String description = "Use on a monster to increase your monster's attack stat by alot.";
	/**
	 * The price of attack boost.
	 */
	private static int price = 100;
	/**
	 * The selling price of attack boost.
	 */
	private static int sell = 75;
	/**
	 * The amount a monster's attack will increase by.
	 */
	private static int itemEffect = 10;
	/**
	 * The stat Attack Boost effects.
	 */
	private static String statEffect = "atk";
	/**
	 * Basic attack boost constructor.
	 * @param name				The name of attack boost
	 * @param price 			The price of attack boost
	 * @param sell				The selling price of attack boost
	 * @param description 		The description of attack boost
	 * @param itemEffect		The amount a monster's attack will increase by
	 * @param statEffect		The stat Attack Boost effects
	 */
	AtkBoost() {
		super(name, price, sell ,description, itemEffect, statEffect);
	}
}