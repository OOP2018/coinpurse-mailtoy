package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Methods that check the value that have same currency, sort a list of money
 * and a generic max method using a type parameter.
 * 
 * @author Kanchanok Kannee
 *
 */
public class MoneyUtil {
	/**
	 * Method that examines all value in a List and returns only the value that
	 * have a currency that matches the parameter value.
	 * 
	 * @param vals
	 *            is a List of E that extends Valuable objects. This list is not
	 *            modified.
	 * @param currency
	 *            is the currency we want. Must not be null.
	 * @return a new List containing only the elements from coin that have the
	 *         requested currency.
	 */
	public static <E extends Valuable> List<E> filterByCurrency(List<? extends E> vals, String currency) {
		List<E> sameCurrencyValue = new ArrayList<E>();
		for (E val : vals) {
			if (currency.equals(val.getCurrency())) {
				sameCurrencyValue.add(val);
			}
		}
		return sameCurrencyValue;
	}

	/**
	 * Method to sort a list of money.(minimum value come first)
	 * 
	 * @param money
	 *            is a list of Valuable we want to sort.
	 * 
	 */
	public static void sortMoney(List<? extends Valuable> money) {
		Collections.sort(money, new Comparator<Valuable>() {

			@Override
			public int compare(Valuable o1, Valuable o2) {
				if (o1.getValue() < o2.getValue())
					return -1;
				else if (o1.getValue() > o2.getValue())
					return 1;
				return 0;
			}
		});
	}

	/**
	 * Print values in purse
	 * 
	 * @param values of Valuable
	 */
	public static void printList(List<Valuable> values) {
		for (Valuable v : values) {
			System.out.print(v.toString() + " ");
		}
	}

	/**
	 * Return the larger argument, based on sort order, using the objects' own
	 * compareTo method for comparing.
	 * 
	 * @param args one or more Comparable objects to compare.
	 * @return the argument that would be last if sorted the elements.
	 * @throws IllegalArgumentException if no arguments given.
	 */
	public static <E extends Comparable<? super E>> E max(E... args) {
		E max;
		try {
			max = args[0];
			for (E arg : args) {
				if (arg.compareTo(max) > 0)
					max = arg;
			}
		} catch (NullPointerException e) {
			throw new IllegalArgumentException();
		}

		return max;
	}

	/**
	 * To test filterByCurrency, sortMoney and max method.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		Money m1 = new BankNote(100, "Baht");
		Money m2 = new BankNote(500, "Baht");
		Money m3 = new Coin(20, "Baht");
		Money max = MoneyUtil.max(m1, m2, m3); // should be max=m2
		System.out.println(max);

		List<BankNote> list = new ArrayList<BankNote>();
		list.add(new BankNote(10.0, "USD"));
		list.add(new BankNote(500.0, "Baht"));
		MoneyUtil.sortMoney(list);
		System.out.println(list);

		List<Coin> coins = Arrays.asList(new Coin(5, "Baht"), new Coin(0.1, "Ringgit"), new Coin(5, "Cent"));
		List<Coin> result = MoneyUtil.filterByCurrency(coins, "Baht");
		System.out.println(result);

	}

}