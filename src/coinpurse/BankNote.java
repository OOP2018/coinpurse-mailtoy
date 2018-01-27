package coinpurse;

/**
 * 
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
	public long getSerialNumber() {
		return this.serialNumber;
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
