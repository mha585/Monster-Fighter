/**
 * 
 * @author Angelo  Gasmin
 * @version 1.0
 */
public class SpeedPlus extends Item{
	/**
	 * The name of Speed Plus
	 */
	private static String name = "Speed Plus";
	/**
	 * The description of Speed Plus
	 */
	private static String description = "Use out of battle to increase your monster's speed stat permanently.";	
	/** 
	 * The price of Speed Plus
	 */
	private static int price = 50;
	/**
	 * The selling price of Speed Plus
	 */
	private static int sell = 40;
	/**
	 * The amount of speed to be increased
	 */
	private static int incSpeed = 10;
	/**
	 * Basic SpeedPlus Constructor
	 * @param name				The name of speed plus
	 * @param price				The price of speed plus
	 * @param sell				The selling price of speed plus
	 * @param description		The description of speed plus
	 */
	SpeedPlus() {
		super(name, price, sell ,description);
	}
	/**
	 * Use speed plus on a chosen monster
	 * @param myMonster				The monster speed plus will be used on
	 */
	public void useSpeedPlus(Monster myMonster) {
		myMonster.gainSpeed(incSpeed);
	}
	

}
