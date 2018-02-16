package coinpurse;

import java.util.ResourceBundle;

public class ReadFile {
	public static MoneyFactory read(){
		ResourceBundle bundle = ResourceBundle.getBundle( "purse" );
		String factoryclass = bundle.getString( "moneyfactory" ); 
		MoneyFactory factory = null;
		try {
		 factory = (MoneyFactory)Class.forName(factoryclass).newInstance();
		}
		catch (ClassCastException cce) {
		 //the object could not be cast to type MoneyFactory
		 System.out.println(factory+" is not type MoneyFactory");
		}
		catch (Exception ex) {
		 // any other exception means we could not create an object
		 System.out.println("Error creating MoneyFactory "+ex.getMessage() );
		}
		// if no factory then quit
		if (factory == null) System.exit(1);
		return factory;
	}

}
