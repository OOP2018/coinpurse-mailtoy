package coinpurse;

import java.util.ResourceBundle;

/**
 * FileReader that can read a properties file and create from the file.
 * 
 * @author Kanchanok Kannee
 *
 */
public class FileReader {

	/**
	 * Read a properties file and create MoneyFactory.
	 * 
	 * @return MoneyFactory instance.
	 */
	public static MoneyFactory init() {
		ResourceBundle bundle = ResourceBundle.getBundle("purse");
		String factoryclass = bundle.getString("moneyfactory");
		MoneyFactory factory = null;
		try {
			factory = (MoneyFactory) Class.forName(factoryclass).newInstance();
		} catch (ClassCastException cce) {
			System.out.println(factoryclass + " is not type MoneyFactor");
		} catch (Exception ex) {
			System.out.println("Error creating MoneyFactory " + ex.getMessage());
		}
		if (factory == null)
			System.exit(1);
		else
			MoneyFactory.setFactory(factory);
		return factory;
	}

}
