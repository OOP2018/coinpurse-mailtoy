package coinpurse;

/**
 * Superclass for Coin and BankNote eliminate duplicate code that implements
 * Valuable
 * 
 * @author Kanchanok Kannee
 *
 */
public class Money implements Valuable {

	protected double value;
	protected String currency;

	/**
	 * Money with given value and currency.
	 * 
	 * @param value is the value of money.
	 * @param currency is the currency of money.
	 */
	public Money(double value, String currency) {
		if(value < 0) throw new IllegalArgumentException("Money must more than 0.");
		this.currency = currency;
		this.value = value;
	}

	/**
	 * Return the value of the money.
	 * 
	 * @return the value.
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Return the currency of the money.
	 * 
	 * @return the currency.
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Compare two Valuable by value and currency. They are equal if the value
	 * and currency matches.
	 * 
	 * @param arg is another Object to compare to this one.
	 * @return true if the value is same and the currency is same, false
	 *         otherwise.
	 */
	public boolean equals(Object arg) {
		if (arg == null)
			return false;
		if (arg.getClass() != this.getClass())
			return false;
		Money other = (Money) arg;
		if (this.value == other.getValue() && this.currency.equalsIgnoreCase(other.getCurrency()))
			return true;
		return false;

	}

	/**
	 * If the currency is the same, order values by values If the currency is
	 * not the same, sort the currency.
	 * 
	 * @return < 0 when this value is less than other value, = 0 when this value
	 *         equals other value and > 0 when this value is more than other
	 *         value.
	 */
	@Override
	public int compareTo(Valuable other) {
		if (other == null) {
			return -1;
		} else if (this.getCurrency().equalsIgnoreCase(other.getCurrency())) {
			if (this.getValue() < other.getValue())
				return -1;
			if (this.getValue() > other.getValue())
				return 1;
			return 0;
		} else
			return this.getCurrency().compareTo(other.getCurrency());
	}

}