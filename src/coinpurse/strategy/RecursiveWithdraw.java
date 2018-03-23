package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.MoneyUtil;
import coinpurse.Valuable;

/**
 * 
 * @author Kanchanok Kannee
 *
 */
public class RecursiveWithdraw implements WithdrawStrategy {

	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
		MoneyUtil.filterByCurrency(money, amount.getCurrency());
		return withdrawHelper(amount.getValue(), money);
	}

	/**
	 * Help find the money in the purse that can withdraw all the amount by
	 * going through all the money in the purse.
	 * 
	 * @param amount
	 * @param money
	 * @return
	 */
	public List<Valuable> withdrawHelper(double amount, List<Valuable> money) {
		if (amount < 0)
			return null;
		if (money.isEmpty() && amount != 0)
			return null;
		if (amount == 0)
			return new ArrayList<Valuable>();

		List<Valuable> left = withdrawHelper(amount - money.get(0).getValue(), money.subList(1, money.size()));
		List<Valuable> right = withdrawHelper(amount, money.subList(1, money.size()));
		if (left != null) {
			left.add(money.get(0));
			return left;
		}
		return right;
	}

}
