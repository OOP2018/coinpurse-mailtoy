package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
	 * @param coin is a List of Valuable objects. This list is not modified.
	 * @param currency is the currency we want. Must not be null.
	 * @return a new List containing only the elements from coin that have
	 *         the requested currency.
	 */
	public static List<Valuable> filterByCurrency(List<Valuable> vals, String currency){
		List<Valuable> sameCurrencyValue =  new ArrayList<>();;
		for(Valuable val : vals){
			if(currency.equals(val.getCurrency())){
				sameCurrencyValue.add(val);
			}
		}
		return sameCurrencyValue;
	}
	
	/**
	 * Method to sort a list of value.(minimun value come first)
	 * 
	 * @param value is a List of Valuable we want to sort.
	 * 
	 */
	public static void sortCoins(List<Valuable> coins) {
		Collections.sort(coins, new Comparator<Valuable>() {

			@Override
			public int compare(Valuable o1, Valuable o2) {
				if(o1.getValue() < o2.getValue())
					return -1;
				else if(o1.getValue() > o2.getValue())
					return 1;
				return 0;
			}
		});
	}
	
	/**
	 * Print value in purse
	 * 
	 * @param value of Valuable
	 */
	public static void printList(List<Valuable> values) {
		for(Valuable v: values) {
			System.out.print(v.toString() + " ");
		}
	}
	
	/**
     * To test filterByCurrency and sortCoins method.
     * @param args not used
     */
	public static void main(String[] args) {
		List<Valuable> coins = new ArrayList<>();

        coins.add(new Coin(0.5, "Baht"));
        coins.add(new Coin(1.0, "Baht"));
        coins.add(new Coin(0.25, "Baht"));
        coins.add(new Coin(5.0, "Baht"));

        sortCoins(coins);
        List<Valuable> filteredList = filterByCurrency(coins, "Baht");
        printList(filteredList);
	}

}