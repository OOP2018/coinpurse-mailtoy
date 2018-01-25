package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Methods that check the value that have same currency and sort a list of value. 
 * @author Kanchanok Kannee
 *
 */
public class MoneyUtil {
	/**
	 * Method that examines all coin in a List and returns only the value
	 * that have a currency that matches the parameter value.
	 * 
	 * @param coin is a List of Coin objects. This list is not modified.
	 * @param currency is the currency we want. Must not be null.
	 * @return a new List containing only the elements from coin that have
	 *         the requested currency.
	 */
	public static List<Coin> filterByCurrency(List<Coin> coins, String currency){
		List<Coin> sameCurrencyCoin =  new ArrayList<>();;
		for(Coin coin : coins){
			if(currency.equals(coin.getCurrency())){
				sameCurrencyCoin.add(coin);
			}
		}
		return sameCurrencyCoin;
	}
	
	/**
	 * Method to sort a list of value.
	 * 
	 * @param value is a List of Coin we want to sort.
	 * 
	 */
	public static void sortCoins(List<Coin> coins) {
		Collections.sort(coins);
	}

}