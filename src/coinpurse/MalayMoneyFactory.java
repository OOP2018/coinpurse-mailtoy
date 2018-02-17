package coinpurse;

/**
 * MalayMoneyFactory is a class that creates money of Malaysia.
 * @author Kanchanok Kannee
 *
 */
public class MalayMoneyFactory extends MoneyFactory {

	protected long nextSerialNumber = 1000000;
	private static final String CURRENCY = "Ringgit";
	private static final String currencyCoin = "Sen";
	private double[] malayMoney = { 0.05, 0.10, 0.20, 0.50, 1, 2, 5, 10, 20, 50, 100 };

	/**
	 * Create money of Malaysia.
	 * 
	 * @param value is a value that you want to create.
	 * @return the Valuable object.
	 * @throws IllegalArgumentException if value is not valid.
	 */
	@Override
	public Valuable createMoney(double value) {
		Valuable valuable = null;
		boolean valid = false;

		for (double checkMoney : malayMoney) {
			if (checkMoney == value) {
				valid = true;
				if (value < 1) {
					valuable = new Coin(value, CURRENCY, currencyCoin);
				} else if (value >= 1) {
					valuable = new BankNote(value, CURRENCY, nextSerialNumber++);
				}
			}
		}
		if (!valid)
			throw new IllegalArgumentException("Malaysia doesn't have " + value + " note");
		return valuable;
	}

	/**
	 * Test MalayMoneyFactory.
	 * @param args not used.
	 */
	public static void main(String[] args) {
		MoneyFactory factory = MoneyFactory.getInstance();
		Valuable m = factory.createMoney(5);
		System.out.println(m.toString());

		Valuable m3 = factory.createMoney(0.05);
		System.out.println(m3.toString());

		System.out.println(m3.getCurrency());
		// Valuable m2 = factory.createMoney("1000.0");
		// System.out.println(m2.toString());
	}

}
