package coinpurse;

import java.util.ArrayList;
import java.util.List;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * @author Kanchanok Kannee
 *
 */
public class Coin extends Money {
	/**
	 * A coin with given value and currency.
	 * 
	 * @param value
	 *            is the value of coin.
	 * @param currency
	 *            is the currency of coin.
	 */
	public Coin(double value, String currency){
		super(value,currency);
	}
	
	/**
	 * Return a string representation of this Coin
	 * 
	 * @return string that describes the coin
	 * 
	 */
	public String toString(){
		return String.format("%.2f-%s", getValue(), getCurrency());
	}
	

}
