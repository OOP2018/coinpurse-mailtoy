package coinpurse;

/**
 * ThaiMoneyFactory is a class that creates money of Thailand.
 * 
 * @author Kanchanok Kannee
 *
 */
public class ThaiMoneyFactory extends MoneyFactory {

	protected static long nextSerialNumber = 1000000;
	private static final String CURRENCY = "Baht";
	private double[] thaiMoney = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };

	/**
	 * Create money of Thai.
	 * 
	 * @param value
	 *            is a value that you want to create.
	 * @return the Valuable object.
	 * @throws IllegalArgumentException
	 *             if value is not valid.
	 */
	@Override
	public Valuable createMoney(double value) {

		Valuable valuable = null;
		boolean valid = false;

		for (double checkMoney : thaiMoney) {
			if (checkMoney == value) {
				valid = true;
				if (value <= 10) {
					valuable = new Coin(value, CURRENCY);
				} else if (value >= 20) {
					valuable = new BankNote(value, CURRENCY, nextSerialNumber++);
				}
			}
		}
		if (!valid)
			throw new IllegalArgumentException("Thailand doesn't have " + value + " note");
		return valuable;
	}

	/**
	 * Test ThaiMoneyFactory.
	 * @param args not used.
	 */
	public static void main(String[] args) {
		MoneyFactory factory = MoneyFactory.getInstance();
		Valuable m = factory.createMoney("5");
		System.out.println(m.toString());
		Valuable m2 = factory.createMoney("1000.0");
		System.out.println(m2.toString());
	}

}
