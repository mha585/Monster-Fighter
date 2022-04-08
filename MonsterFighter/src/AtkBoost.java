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
	private static String description = "Use in battle to increase your monster's attack stat.";		
	/**
	 * The price of attack boost
	 */
	private static int price = 50;
	/**
	 * The selling price of attack boost
	 */
	private static int sell = 40;
	/**
	 * The amount a monster's attack will increase by
	 */
	private static int incAttack = 10;
	/**
	 * Basic attack boost constructor
	 * @param name				The name of attack boost
	 * @param price 			The price of attack boost
	 * @param sell				The selling price of attack boost
	 * @param description 		The description of attack booost
	 */
	AtkBoost() {
		super(name, price, sell ,description);
	}

	/**
	 * Use attack boost on a chosen monster
	 * @param myMonster			The monster attack boost will be used on
	 */
	public void useAtkBoost(Monster myMonster) {
		myMonster.gainDamage(incAttack);
	}
	

}
