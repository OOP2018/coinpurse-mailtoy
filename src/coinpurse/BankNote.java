package coinpurse;

/**
 * Banknote represents money with a value, currency and  has a different serial number.
 * @author Kanchanok Kannee
 *
 */
public class BankNote implements Valuable {
	
	private static long nextSerialNumber = 1000000;
	private long serialNumber;
	private double value;
	private String currency;


	/**
	 * A banknote with given value using the default currency.
	 * 
	 * @param value is the value of banknote.
	 * @param currency is the currency of banknote.
	 */
	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber++;
	
	}

	/**
	 * Return the serialnumber of the banknote.
	 * 
	 * @return the serialnumber.
	 */
	public long getSerial() {
		return this.serialNumber;
	}
	
	/**
	 * Compare two BankNote by value and currency. They are equal if the value and
	 * currency matches.
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
		BankNote other = (BankNote) arg;
		if (this.value == other.getValue() && this.currency == other.getCurrency())
			return true;
		return false;
	}
	
	/**
	 * Return value of banknote.
	 */
	@Override
	public double getValue() {
		return this.value;
	}

	/**
	 * Return currency of banknote.
	 */
	@Override
	public String getCurrency() {
		return this.currency;
	}
	
	/**
	 * Return a string representation of this BankNote
	 * 
	 * @return string that describes the banknote
	 * 
	 */
	public String toString() {
		return String.format("%.0f-%s note [%d]",this.value,this.currency,this.serialNumber);
	}

}
