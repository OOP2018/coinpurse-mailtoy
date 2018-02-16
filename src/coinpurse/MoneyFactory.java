package coinpurse;

/**
 * 
 * @author Kanchanok Kannee
 *
 */
public abstract class MoneyFactory {
	
	/** singleton instance of MoneyFactory. */
	private static MoneyFactory factory;
	
	public static MoneyFactory getInstance() {
		if(factory == null) 
			factory = new ThaiMoneyFactory();
		return factory;
	}
	
	public abstract Valuable createMoney(double value) throws IllegalArgumentException;
	
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
	 * @param factory is the subclass of MoneyFactory.
	 */
	public static void setFactory(MoneyFactory f) {
		MoneyFactory.factory = f;
	}

	
	

}
