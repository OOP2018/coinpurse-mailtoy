package coinpurse;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * MoneyFactoryTest class containing JUnit tests of MoneyFactory methods.
 * 
 * @author Kanchanok Kannee
 *
 */
public class MoneyFactoryTest {

	/**
	 * Easy test set and get an instance of MoneyFactory in ThaiMoneyFactory
	 * complete.
	 */
	@Test
	public void testSetAndGetThaiInstance() {
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		assertEquals(MoneyFactory.getInstance().getClass().getSimpleName(), "ThaiMoneyFactory");
	}

	/**
	 * Easy test set and get an instance of MoneyFactory in MalayMoneyFactory
	 * complete.
	 */
	@Test
	public void testSetAndGetMalayInstance() {
		MoneyFactory.setFactory(new MalayMoneyFactory());
		assertEquals(MoneyFactory.getInstance().getClass().getSimpleName(), "MalayMoneyFactory");
	}

	/** Insert some coins. Easy test. */
	@Test
	public void testInsert() {
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory moneyFactory = MoneyFactory.getInstance();
		Purse purse = new Purse(3);
		Valuable val1 = moneyFactory.createMoney(1);
		Valuable val2 = moneyFactory.createMoney(20);
		Valuable val3 = moneyFactory.createMoney(100);
		assertTrue(purse.insert(val1));
		assertTrue(purse.insert(val2));
		assertTrue(purse.insert(val3));
		assertEquals(3, purse.count());
		// purse is full so insert should fail
		assertFalse(purse.insert(moneyFactory.createMoney(1)));
	}

	/** Not Insert some coins. Easy test. */
	@Test(expected = IllegalArgumentException.class)
	public void someTest() throws Exception {
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory moneyFactory = MoneyFactory.getInstance();
		Purse purse = new Purse(3);
		Valuable val1 = moneyFactory.createMoney(9);
		Valuable val2 = moneyFactory.createMoney("21");
		Valuable val3 = moneyFactory.createMoney(33);
		assertFalse(purse.insert(val1));
		assertFalse(purse.insert(val2));
		assertFalse(purse.insert(val3));
		// purse is not full so insert should work!
		assertTrue(purse.insert(moneyFactory.createMoney(10)));
		assertEquals(1, purse.count());
	}

	/**
	 * Test Country-Specific Formatting to Money (Optional) for Malaysia. For
	 * Malaysian coins a 0.05 Ringgit coin has value = 0.05, currency="Ringgit".
	 * But the Coin's toString() method should return "5-Sen coin", not
	 * "0.05-Ringgit coin".
	 * 
	 */
	@Test
	public void testCurrencyMalay() {
		MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory moneyFactory = MoneyFactory.getInstance();
		Valuable malayMoney1 = moneyFactory.createMoney(0.05);
		Valuable malayMoney2 = moneyFactory.createMoney(1);
		Valuable malayMoney3 = moneyFactory.createMoney(5);
		assertEquals(malayMoney1.getCurrency(), "Ringgit");
		assertEquals(malayMoney2.getCurrency(), "Ringgit");
		assertEquals(malayMoney1.toString(), "5-Sen coin");
		assertEquals(malayMoney3.toString(), "5-Ringgit note [1000001]");
	}

	/**
	 * Test that a serial number running or not and start at 1000000 to 100000x
	 */
	@Test
	public void testBankNoteSerialNumber() {
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory moneyFactory = MoneyFactory.getInstance();
		Valuable bankNote1 = moneyFactory.createMoney(20);
		Valuable bankNote2 = moneyFactory.createMoney(100);
		Valuable bankNote3 = moneyFactory.createMoney(500);
		assertEquals(((BankNote) bankNote1).getSerial(), 1000000);
		assertEquals(((BankNote) bankNote2).getSerial(), 1000001);
		assertEquals(((BankNote) bankNote3).getSerial(), 1000002);

		MoneyFactory.setFactory(new MalayMoneyFactory());
		moneyFactory = MoneyFactory.getInstance();
		Valuable bankNote4 = moneyFactory.createMoney(1);
		Valuable bankNote5 = moneyFactory.createMoney(2);
		Valuable bankNote6 = moneyFactory.createMoney(5);
		assertEquals(((BankNote) bankNote4).getSerial(), 1000000);
		assertEquals(((BankNote) bankNote5).getSerial(), 1000001);
		assertEquals(((BankNote) bankNote6).getSerial(), 1000002);
	}

	@Test
	public void testImpossibleWithdraw() {
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory moneyFactory = MoneyFactory.getInstance();
		Purse purse = new Purse(100);
		assertNull(purse.withdraw(1));
		Valuable val1 = moneyFactory.createMoney(10);
		Valuable val2 = moneyFactory.createMoney(20);
		assertTrue(purse.insert(val1));
		assertTrue(purse.insert(val2));
		assertNull(purse.withdraw(2));
		assertNull(purse.withdraw(18));
		assertNull(purse.withdraw(21));
		Valuable val3 = moneyFactory.createMoney(20);
		assertTrue(purse.insert(val3)); // now it has 30 + 20
		assertNull(purse.withdraw(45));
	}

}
