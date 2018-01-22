package coinpurse;

import java.util.ArrayList;
import java.util.List;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * @author Kanchanok Kannee
 *
 */
public class Coin implements Comparable<Coin> {
	double value;
	String currency;
	
	/**
	 * A coin with given value and currency.
	 * 
	 * @param value
	 *            is the value of coin.
	 * @param currency
	 *            is the currency of coin.
	 */
	public Coin(double value, String currency){
		if(value < 0) return;
		this.value = value;
		this.currency = currency;
	}
	
	/**
	 * Return the value of the money.
	 * 
	 * @return the value.
	 */
	public double getValue(){
		return this.value;
	}
	
	/**
	 * Return the currency of the money.
	 * 
	 * @return the currency.
	 */
	public String getCurrency(){
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
	public boolean equals(Object arg){
		if (arg == null) return false;
		if ( arg.getClass() != this.getClass() )
		return false;
		Coin other = (Coin) arg;
		return this.value == other.getValue() && this.currency == other.getCurrency();
		
	}
	
	/**
	 * Order values by values 
	 * @return < 0 when this value is less than other value,
	 *         = 0 when this value equals other value and
	 *         > 0 when this value is more than other value.
	 */
	public int compareTo(Coin coin){
		return -1*(int)Math.signum(this.getValue() - coin.getValue());
		
	}
	
	/**
	 * Return a string representation of this Coin
	 * 
	 * @return string that describes the coin
	 * 
	 */
	public String toString(){
		return String.format("%.2f-%s", value, currency);
	}
	
	public static void main (String[]arg){
		// Don't just copy this code. Write your own test code.
		List<Coin> coins = new ArrayList<Coin>( );
		coins.add( new Coin(10.0, "Baht") );
		coins.add( new Coin(0.5, "Baht") );
		coins.add( new Coin(2.0, "Baht") ); // the most hated coin
		coins.add( new Coin(1.0, "Baht") );
		System.out.println(new Coin(5.0,"B").compareTo(new Coin(0.2,"B")));
	}
	
	

}
