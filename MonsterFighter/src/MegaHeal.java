/**
 * 
 * @author Angelo  Gasmin
 * @version 1.0
 */
public class MegaHeal extends Item {
	/**
	 * The name of mega heal
	 */
	private static String name = "Mega Heal";
	/**
	 * The description of mega heal
	 */
	private static String description = "Use on a monster in battle to heal your monster's HP by 50.";	
	/**
	 * The price of mega heal
	 */
	private static int price = 75;
	/**
	 * The selling price of mega heal
	 */
	private static int sell = 40;
	/**
	 * The amount a monster's HP will increase by
	 */
	private static int itemEffect = 50;
	
	private static String statEffect = "hp";
	
	private static String whenToUse = "both";
	/**
	 * The basic mega heal constructor
	 * @param				The name of mega heal
	 * @param price			The price of mega heal
	 * @param sell			The selling price of mega heal
	 * @param description	The description of mega heal
	 * @param whenToUse
	 * @param itemEffect
	 * @param statEffect
	 */
	MegaHeal() {
		super(name, price, sell ,description, whenToUse, itemEffect, statEffect);
	}

	/**
	 * Use mega heal on a chosen monster
	 * @param myMonster		The monster mega heal will be used on 
	 */
}
