/**
 * This interface describes purchasable classes.
 * Each class with the "Purchasable" attribute has 3 Attributes.
 * They are: getDescription(), getPrice, sellPrice.
 * @version 1.0
 */
public interface Purchasable {
	/**
	 * Returns description of an item
	 * @return
	 */
	String getDescription();
	/**
	 * Returns the price of an item
	 * @return		
	 */
	int getPrice();
	/**
	 * Returns the selling price of an item
	 * @return
	 */
	int sellPrice();
}