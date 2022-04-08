/**
 * 
 * @author Angelo  Gasmin
 * @version 1.0
 */
public class TierPlus extends Item{
	/**
	 * The name of TierPlus
	 */
	private static String name = "Tier Plus";
	/**
	 * The description of Tier Plus
	 */
	private static String description = "Use out of battle to increase your monster's Tier by 1.";
	/**
	 * The price of Tier Plus
	 */
	private static int price = 50;
	/**
	 * The selling price of Tier Plus
	 */
	private static int sell = 40;

	/**
	 * The basic constructor for TierPLus
	 * @param name				The name of Tier Plus
	 * @param price				The price of Tier Plus
	 * @param sell				The selling price of Tier Plus
	 * @param description		The description of Tier Plus
	 */
	TierPlus() {
		super(name, price, sell ,description);
	}

	/**
	 * Uses Tier Plus on a chosen monster
	 * @param myMonster			The monster whose tier will be increased
	 */
	public void useTierPlus(Monster myMonster) {
		myMonster.gainTier(1);
	}
	

}
