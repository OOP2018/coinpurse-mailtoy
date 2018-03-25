package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import coinpurse.Valuable;
import coinpurse.ValueComparator;

/**
 * Withdraw money using greedy algorithm.
 * 
 * @author Kanchanok Kannee
 *
 */
public class GreedyWithdraw implements WithdrawStrategy {

	/**
	 * Withdraw the requested amount of money. Return an array of Valuable
	 * withdrawn
	 */
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
		double amountValue = amount.getValue();
		Comparator<Valuable> comp = new ValueComparator();
		Collections.sort(money, comp);
		Collections.reverse(money);
		List<Valuable> withdraw = new ArrayList<>();
		for (int i = 0; i < money.size(); i++) {
			if (money.get(i).getValue() <= amountValue
					&& money.get(i).getCurrency().equalsIgnoreCase(amount.getCurrency())) {
				withdraw.add(money.get(i));
				amountValue -= money.get(i).getValue();
			}
		}
		if (amountValue != 0)
			return null;

		return withdraw;

	}

}
