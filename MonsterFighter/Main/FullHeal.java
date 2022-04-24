/**
 * This class creates the Item "Full Heal".
 * 
 * @author Angelo  Gasmin
 * @version 1.0
 */
public class FullHeal extends Item{
	/**
	 * Name of FullHeal
	 */
	private static String name = "Full Heal";
	/**
	 * Description of FullHeal
	 */
	private static String description = "Use on a monster to heal a monster to full health.";
	/**
	 * Price of FullHeal
	 */
	private static int price = 100;
	/**
	 * Selling price of FullHeal
	 */
	private static int sell = 60;
	/**
	 * The amount of HP Full Heal restores.
	 */
	private static int itemEffect = 10000000;
	/**
	 * The stat that Full Heal effects.
	 */
	private static String statEffect = "hp";
	/**
	 * The situation where you can use Full Heal.
	 */
	private static String whenToUse = "both";
	/**
	 * Basic Full Heal constructor.
	 * @param name            	The name of the HP Restore
	 * @param price          	The price of the HP Restore
	 * @param sell           	The selling price of HP Restore
	 * @param description	 	The description of HP Restore
	 * @param whenToUse			The situation where you can use Full Heal
	 * @param itemEffect		The amount of HP Full Heal restores
	 * @param statEffect		The stat Full Heal restores
	 */
	FullHeal() {
		super(name, price, sell ,description, whenToUse, itemEffect, statEffect);
	}
}
