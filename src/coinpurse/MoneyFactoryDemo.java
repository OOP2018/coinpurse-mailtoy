package coinpurse;

/**
 * MoneyFactoryDemo class to create a MoneyFactory and call its methods. Print
 * results on the console. 
 * 
 * @author Kanchanok Kannee
 *
 */
public class MoneyFactoryDemo {
	/**
	 * Test that MoneyFactory is a singleton, all the methods work as specified. 
	 */
	public static void testMoneyFactory() {
		MoneyFactory f1 = MoneyFactory.getInstance();
		System.out.println("f1 is a " + f1.getClass().getName());
		MoneyFactory f2 = MoneyFactory.getInstance();
		System.out.println("f2 is a " + f2.getClass().getName());
		System.out.println("f1 == f2 (same object)?");
		System.out.println(f1 == f2);

		// create some money
		String[] values = { "0.25", "0.5", "1.0", "2.0", "5", "20", "100", "1000" };
		for (String arg : values) {
			System.out.printf("createMoney(%s) is ", arg);
			try {
				Valuable v = f1.createMoney(arg);
				System.out.println(v.toString());
			} catch (IllegalArgumentException ex) {
				System.out.println(ex.getMessage());
				ex.printStackTrace();
			}
		}
	}

	/**
	 * Print results. 
	 * @param args not used.
	 */
	public static void main(String[] args) {
		MoneyFactory.getInstance().setFactory(new ThaiMoneyFactory());
		testMoneyFactory();
		System.out.println("\nThailand is too hot. Moving to Malasia!");
		MoneyFactory.getInstance().setFactory(new MalayMoneyFactory());
		testMoneyFactory();
	}

}
