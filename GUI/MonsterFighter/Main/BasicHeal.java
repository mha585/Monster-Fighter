/**
 * This class creates the Item "Basic Heal".
 * 
 * @author Angelo  Gasmin
 * @version 1.0
 */
public class BasicHeal extends Item {
	/**
	 * Name of Basic Heal.
	 */
	private static String name = "Basic Heal";
	/**
	 * Description of Basic Heal.
	 */
	private static String description = "Use on a monster to heal your monster's HP by 20.";
	/**
	 * Price of Basic Heal.
	 */
	private static int price = 50;
	/**
	 * Selling price of Basic Heal.
	 */
	private static int sell = 30;
	/**
	 * How much HP Basic Heal increases.
	 */
	private static int itemEffect = 20;
	/**
	 * The stat that Basic Heal effects.
	 */
	private static String statEffect = "hp";
	/**
	 * Basic Heal constructor
	 * @param name				The name of BasicHeal
	 * @param price				The price of Basic Heal
	 * @param sell 				The selling price of Basic Heal
	 * @param description		The description of Basic Heal
	 * @param whenToUse			The situation where you can use Basic Heal
	 * @param itemEffect		The amount HP increases by when Basic Heal is used
	 * @param statEffect		The stat that Basic Heal effects
	 */
	BasicHeal() {
		super(name, price, sell ,description,  itemEffect, statEffect);
	}
}