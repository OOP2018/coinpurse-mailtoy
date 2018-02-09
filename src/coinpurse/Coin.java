package coinpurse;

import java.util.ArrayList;
import java.util.List;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * @author Kanchanok Kannee
 *
 */
public class Coin extends Money implements Comparable<Coin> {
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
	 * Order values by values 
	 * @return < 0 when this value is less than other value,
	 *         = 0 when this value equals other value and
	 *         > 0 when this value is more than other value.
	 */
	public int compareTo(Coin coin){
		return (int)Math.signum(this.getValue() - coin.getValue());
		
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
