/**
 * 
 * @author Angelo  Gasmin
 * @version 1.0
 */
public class SpeedBoost extends Item {
	/**
	 * The name of speed boost
	 */
	private static String name = "Speed Boost";
	/**
	 * The description of speed boost
	 */
	private static String description = "Use in battle to increase your monster's speed stat.";		
	/**
	 * The price of speed boost
	 */
	private static int price = 50;
	/**
	 * The cost of speed boost
	 */
	private static int sell = 40;
	/**
	 * The amount a monster's speed will increase by
	 */
	private static int incSpeed = 10;
	/**
	 * Basic speed boost constructor
	 * @param name				The name of speed boost
	 * @param price				The price of speed boost
	 * @param sell				The selling price of speed boost
	 * @param description		The description of speed boost
	 */
	SpeedBoost() {
		super(name, price, sell ,description);
	}

	/**
	 * Use speed boost on a chosen monster
	 * @param myMonster			The monster speed boost is used on 
	 */
	public void useSpeedBoost(Monster myMonster) {
		myMonster.gainSpeed(incSpeed);
	}
	

}
