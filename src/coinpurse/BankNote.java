package coinpurse;

/**
 * Banknote represents money with a value, currency and  has a different serial number.
 * @author Kanchanok Kannee
 *
 */
public class BankNote extends Money {
	
	private static long nextSerialNumber = 1000000;
	private long serialNumber;
	/**
	 * A banknote with given value using the default currency.
	 * 
	 * @param value is the value of banknote.
	 * @param currency is the currency of banknote.
	 */
	public BankNote(double value, String currency) {
		super(value,currency);
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
	 * Return a string representation of this BankNote
	 * 
	 * @return string that describes the banknote
	 * 
	 */
	public String toString() {
		return String.format("%.0f-%s note [%d]",getValue(),getCurrency(),this.serialNumber);
	}

}
