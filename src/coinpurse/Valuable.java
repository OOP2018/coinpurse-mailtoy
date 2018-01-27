package coinpurse;

/**
 * An interface for objects having a monetary value and currency.
 * 
 * @author Kanchanok Kannee
 */
public interface Valuable {
	
	/**
	* Get the monetary value of this object, in its own currency.
	* @return the value of this object
	*/
	public double getValue();

	/**
	 * Return the currency of the money.
	 * 
	 * @return the currency.
	 */
	public String getCurrency();
}
