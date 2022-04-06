/**
 * This interface describes purchasable classes
 * 
 * @author Angelo Gasmin
 * @version 1.0
 */
public interface Purchasable {
	/**
	 * Gets the description of the current item.
	 */
	void getDescription(String descr);
	/**
	 * Gets the price to purchase the current item.
	 */
	void getPrice(int cost);
	/**
	 * Gets the price to sell the current item.
	 */
	void sellPrice(int sell);

}
