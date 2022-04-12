/**
 * 
 * @author Angelo  Gasmin
 * @version 1.0
 */
public class AtkBoost extends Item{
	/**
	 * The name of attack boost
	 */
	private static String name = "Attack Boost";
	/**
	 * The description of attack boost
	 */
	private static String description = "Use on a monster in battle to increase your monster's attack stat.";		
	/**
	 * The price of attack boost
	 */
	private static int price = 50;
	/**
	 * The selling price of attack boost
	 */
	private static int sell = 30;
	/**
	 * The amount a monster's attack will increase by
	 */
	private static int itemEffect = 10;
	
	private static String statEffect = "atk";
	
	private static String whenToUse = "in";
	/**
	 * Basic attack boost constructor
	 * @param name				The name of attack boost
	 * @param price 			The price of attack boost
	 * @param sell				The selling price of attack boost
	 * @param description 		The description of attack boost
	 */
	AtkBoost() {
		super(name, price, sell ,description, whenToUse, itemEffect, statEffect);
	}

	
	/**
	 * Use attack boost on a chosen monster
	 * @param myMonster			The monster attack boost will be used on
	 */

	


}
