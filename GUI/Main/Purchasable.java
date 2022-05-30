/**
 * This interface describes purchasable classes.
 * Each class with the "Purchasable" attribute has 3 Attributes.
 * They are: getDescription(), getPrice, sellPrice, getName.
 * @version 1.0
 */
public interface Purchasable {
	/**
	 * Returns description of an item/ monster
	 * @return String containing the description of an item/ monster
	 */
	public String getDescription();
	/**
	 * Returns the price of an item/ monster
	 * @return int indicative of the price of the item/ monster	
	 */
	public int getPrice();
	/**
	 * Returns the selling price of an item/ monster
	 * @return int indicative of the selling price of the item/ monster
	 */
	public int sellPrice();
	/**
	 * Returns the name of an item/ monster
	 * @return String containing the name of the item/ monster
	 */
	public String getName();
}