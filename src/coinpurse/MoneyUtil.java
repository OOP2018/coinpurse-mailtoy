package coinpurse;

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
	static List<Coin> filterByCurrency(List<Coin> coins, String currency){
		List<Coin> sameCurrencyCoin = null;
		for(Coin coin : coins){
			if(coin.getCurrency().contains(currency)){
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
	static void sortCoins(List<Coin> coins) {
		Collections.sort(coins);
	}

}