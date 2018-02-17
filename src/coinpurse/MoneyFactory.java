package coinpurse;

/**
 * MoneyFactory is a abstract class for creating Valuable items.
 * 
 * @author Kanchanok Kannee
 *
 */
public abstract class MoneyFactory {

	/** singleton instance of MoneyFactory. */
	private static MoneyFactory factory;

	/**
	 * Get an instance of MoneyFactory.
	 * 
	 * @return MoneyFactory instance.
	 */
	public static MoneyFactory getInstance() {
		if (factory == null)
			factory = new Main().init();
		return factory;
	}

	/**
	 * Create a new money object in the local currency.
	 * 
	 * @param value
	 *            is the value that you want to create.
	 * @return the Valuable of object.
	 * @throws IllegalArgumentException
	 *             if value is not valid.
	 */
	public abstract Valuable createMoney(double value) throws IllegalArgumentException;

	/**
	 * Accepts money value as a String and create a new money object in the
	 * local currency.
	 * 
	 * @param value
	 *            is the value that you want to create.
	 * @return the Valuable of object.
	 * @throws IllegalArgument
	 *             if value is not a valid number.
	 */
	public Valuable createMoney(String value) {
		double doubleValue = 0;
		try {
			doubleValue = Double.parseDouble(value);
		} catch (IllegalArgumentException ex) {
			throw new IllegalArgumentException("Value of string is not a number");
		}
		return createMoney(doubleValue);
	}

	/**
	 * Set the local factory.
	 * 
	 * @param factory
	 *            is the subclass of MoneyFactory.
	 */
	public static void setFactory(MoneyFactory f) {
		MoneyFactory.factory = f;
	}

}
