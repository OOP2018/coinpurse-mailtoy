package coinpurse;

import java.util.Collections;
import java.util.List;
/**
 * 
 * @author Kanchanok Kannee
 *
 */
public class MoneyUtil {
	
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