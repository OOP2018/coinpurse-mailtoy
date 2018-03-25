package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;

import coinpurse.strategy.GreedyWithdraw;
import coinpurse.strategy.RecursiveWithdraw;
import coinpurse.strategy.WithdrawStrategy;

/**
 * A coin purse contains value. You can insert value, withdraw money, check the
 * balance, and check if the purse is full.
 * 
 * @author Kanchanok Kannee
 */
public class Purse {
	/** Collection of objects in the purse. */
	List<Valuable> money;
	Valuable[] array = new Valuable[20];
	WithdrawStrategy strategy;
	
	/**
	 * Capacity is maximum number of items the purse can hold. Capacity is set
	 * when the purse is created and cannot be changed.
	 */
	private final int capacity;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of values you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		money = new ArrayList<Valuable>();
		strategy = new RecursiveWithdraw(); 
	}

	/**
	 * Count and return the number of values in the purse. This is the number of
	 * values, not their value.
	 * 
	 * @return the number of values in the purse
	 */
	public int count() {
		return money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		double balance = 0;
		for (Valuable value : this.money) {
			balance += value.getValue();
		}
		return balance;
	}

	/**
	 * Return the capacity of the coin purse.
	 * 
	 * @return the capacity
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in
	 * purse equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		if (this.getCapacity() == this.count()) {
			return true;
		}
		return false;
	}

	/**
	 * Insert a value into the purse. The value is only inserted if the purse has
	 * space for it and the value has positive value. No worthless values!
	 * 
	 * @param value is a Valuable object to insert into purse
	 * @return true if value inserted, false if can't insert
	 */
	public boolean insert(Valuable value) {
		if (this.isFull() || value == null)
			return false;
		if (value.getValue() > 0) {
			money.add(value);
			return true;
		}
		return false;
	}
	
	/**
	 * Withdraw the requested amount of money. Return an array of Valuable
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount is the amount to withdraw
	 * @return array of Valuable objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(Valuable amount){
		if(this.getBalance() < 0.0)
			return null;
		if (amount.getValue() < 0)
			return null;
		if (amount.getValue() > this.getBalance())
			return null;
		List<Valuable> list = strategy.withdraw(amount, money);
		
		if(list == null){
			return null;
		}
		for (Valuable coinNeedToWithdraw : list) {
				money.remove(coinNeedToWithdraw);
			}
	
		Valuable[] arrayWithdraw = new Valuable[list.size()];
		list.toArray(arrayWithdraw);
		return arrayWithdraw;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Valuable
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested. Withdraw the amount using the default currency ("Baht").
	 * 
	 * @param amount is the amount to withdraw
	 * @return array of Valuable objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(double amount) {
		Valuable valuable = new Money(amount, "Bath");
		return withdraw(valuable);
	}

	public void setWithdrawStrategy(WithdrawStrategy strategy){
		this.strategy = strategy;
	}


	/**
	 * toString returns a string description of the purse contents. 
	 */
	public String toString() {
		return String.format("%d items with value %.2f", money.size(), getBalance());
	}

}
