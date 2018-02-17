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

	@Test
	public void testSetAndGetThaiInstance() {
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		assertEquals(MoneyFactory.getInstance().getClass().getSimpleName(), "ThaiMoneyFactory");
	}

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

}
