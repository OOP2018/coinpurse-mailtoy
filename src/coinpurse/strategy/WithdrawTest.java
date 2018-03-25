package coinpurse.strategy;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import coinpurse.BankNote;
import coinpurse.Coin;
import coinpurse.Valuable;

/**
 * WithdrawTest class containing JUnit tests for WithdrawStrategy.
 * 
 * @author Kanchanok Kannee
 *
 */
public class WithdrawTest {
	/** tolerance for comparing two double values */
	private static final double TOL = 1.0E-6;
	private static final String CURRENCY = "BTC";
	private List<Valuable> money = new ArrayList<>();
	private List<Valuable> money2 = new ArrayList<>();
	private WithdrawStrategy strategy;

	/**
	 * Code to run before each test. Setup the "test fixture".
	 *
	 */
	@Before
	public void setUp() {
		strategy = new GreedyWithdraw();
	}

	/** Add one coin and remove more than it. */
	@Test
	public void testWithdrawImpossible() {
		Valuable valuable = new Coin(5, CURRENCY);
		Valuable valuable2 = new Coin(10, CURRENCY);
		money.add(valuable);
		assertNull(strategy.withdraw(valuable2, money));
	}

	/** Add one coin and remove it. */
	@Test
	public void testEasyWithdraw() {
		Valuable valuable = new Coin(5, CURRENCY);
		money.add(valuable);
		money2.add(valuable);
		assertEquals(strategy.withdraw(valuable, money), money2);
	}

	/**
	 * Verify that WithdrawStrategy does not change the items in the Purse.
	 */
	@Test
	public void testCompareMoney() {
		Valuable valuable = new Coin(5, CURRENCY);
		money.add(valuable);
		money2.add(valuable);
		assertEquals(strategy.withdraw(valuable, money), money2);
		money2.remove(valuable);
	}

	/**
	 * Test for checking the currency carefully.
	 */
	@Test
	public void testWithdrawCurrency() {
		Valuable valuable1 = new BankNote(20, "Ringgit");
		Valuable valuable2 = new BankNote(20, CURRENCY);
		money.add(valuable1);
		money2.add(valuable2);
		assertNotEquals(strategy.withdraw(new Coin(10, CURRENCY), money), money2);
	}

	/** Insert should reject coin with no value. */
	@Test
	public void testWithdrawNoValue() {
		Valuable valuable = new Coin(0, CURRENCY);
		Valuable valuable2 = new Coin(10, CURRENCY);
		money.add(valuable);
		assertNull(strategy.withdraw(valuable2, money));
	}

	/** Withdraw should reject coin with minus value. */
	@Test(expected = IllegalArgumentException.class)
	public void testMinusWithdraw() {
		money2 = (ArrayList<Valuable>) strategy.withdraw(new Coin(-1, "Baht"), money);
		assertNull(money2);
	}

}
