package coinpurse;

/**
 * Superclass for Coin and BankNote eliminate duplicate code that implements Valuable
 * @author Kanchanok Kannee
 *
 */
public class Money implements Valuable{

	protected double value;
	protected String currency;

	public Money() {
		super();
	}
	
	public Money(double value,String currency){
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
	 * Compare two Coin by value and currency. They are equal if the value and
	 * currency matches.
	 * 
	 * @param arg is another Object to compare to this one.
	 * @return true if the value is same and the currency is same, false
	 *         otherwise.
	 */
	public boolean equals(Object arg) {
		if (arg == null) return false;
		if ( arg.getClass() != this.getClass() )
		return false;
		Money other = (Money) arg;
		if (this.value == other.getValue() && this.currency == other.getCurrency())
			return true;
		return false;
		
	}
	
	public static void main (String[]arg){
		Money coin = new BankNote(100.00, "Bat");
		Money coin2 = new BankNote(100, "Bat");
		System.out.println(coin.equals(coin2));
		
	}

}