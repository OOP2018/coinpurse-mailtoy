package coinpurse;

import java.util.ArrayList;
import java.util.List;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * @author Kanchanok Kannee
 *
 */
public class Coin extends Money {
	private String newCurrency;
	
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
	 * A coin with given value and currency and specific currency.
	 * @param value is the value of coin.
	 * @param currency is the currency of coin.
	 * @param newCurrency is the specific currency of coin.("Bath" and "Ringgit").
	 */
	public Coin(double value, String currency,String newCurrency){
		super(value, currency);
		this.newCurrency = newCurrency;
	}
	
	/**
	 * Return a string representation of this Coin
	 * 
	 * @return string that describes the coin
	 * 
	 */
	public String toString(){
		if(value < 1) {
			return String.format("%.0f-%s coin", getValue() * 100, newCurrency);
		}
		return String.format("%.0f-%s coin", getValue(), getCurrency());
	}
	

}
