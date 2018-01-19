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
		this.value = value;
		this.currency = currency;
	}
	
	public double getValue(){
		return this.value;
	}
	
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
	
	public int compareTo(Coin coin){
		return (int)Math.signum(this.getValue() - coin.getValue());
	}
	
	public String toString(){
		return this.value + "-" + this.currency;
	}
	
	public static void printCoins(List<Coin> coins){
		System.out.println(coins);
	}
	
	public static void main (String[] arg){
		// Don't just copy this code. Write your own test code.
		List<Coin> coins = new ArrayList<Coin>( );
		coins.add( new Coin(10.0, "Baht") );
		coins.add( new Coin(0.5, "Baht") );
		coins.add( new Coin(2.0, "Baht") ); // the most hated coin
		coins.add( new Coin(1.0, "Baht") );
		printCoins( coins ); 
		// This static method sorts any list of Comparable objects
		java.util.Collections.sort( coins );
		printCoins( coins ); // the coins should be sorted by value now
	}

}
