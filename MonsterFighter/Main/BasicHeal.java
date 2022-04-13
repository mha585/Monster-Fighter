
/**
 * 
 * @author Angelo  Gasmin
 * @version 1.0
 */
public class BasicHeal extends Item {
	/**
	 * Name of Basic Heal
	 */
	private static String name = "Basic Heal";
	/**
	 * Description of Basic Heal
	 */
	private static String description = "Use on a monster to heal your monster's HP by 20.";
	/**
	 * Price of Basic Heal
	 */
	private static int price = 50;
	/**
	 * Selling price of Basic Heal
	 */
	private static int sell = 40;
	/**
	 * How much HP Basic Heal increases
	 */
	private static int itemEffect = 20;
	
	private static String statEffect = "hp";
	
	private static String whenToUse = "both";
	/**
	 * Basic Heal constructor
	 * @param name			The name of BasicHeal
	 * @param price			The price of Basic Heal
	 * @param sell 			The selling price of Basic Heal
	 * @param description	The description of Basic Heal
	 */
	BasicHeal() {
		super(name, price, sell ,description, whenToUse, itemEffect, statEffect);
	}

	/**
	 * Uses Basic Heal on a chosen monster
	 * @param myMonster		The monster Basic Heal is used on
	 */
}
