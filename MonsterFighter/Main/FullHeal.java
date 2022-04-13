/**
 * 
 * @author Angelo  Gasmin
 * @version 1.0
 */
public class FullHeal extends Item{
	/**
	 * Name of item
	 */
	private static String name = "Full Heal";
	/**
	 * Description of item
	 */
	private static String description = "Use on a monster to heal a monster to full health.";
	/**
	 * Price of item
	 */
	private static int price = 100;
	/**
	 * Selling price of item
	 */
	private static int sell = 60;
	
	private static int itemEffect = 10000000;
	
	private static String statEffect = "hp";
	
	private static String whenToUse = "both";
	/**
	 * Basic HP Restore constructor
	 * @param name            The name of the HP Restore
	 * @param price           The price of the HP Restore
	 * @param sell            The selling price of HP Restore
	 * @param description	  The description of HP Restore
	 */
	FullHeal() {
		super(name, price, sell ,description, whenToUse, itemEffect, statEffect);
	}

	/**
	 * Uses HP Restore on a monster
	 * @param myMonster		  The monster HP Restore will be used on
	 */
}
