package coinpurse;

public class MalayMoneyFactory extends MoneyFactory {
	
	protected long nextSerialNumber = 1000000;
	private static final String CURRENCY =  "Ringgit";
	private static final String currencyCoin = "Sen";
	private double[] malayMoney = {0.05, 0.10, 0.20, 0.50, 1, 2, 5, 10, 20, 50, 100};

	@Override
	public Valuable createMoney(double value){
		Valuable valuable = null;
		boolean checkContain = false;
		
		for(double checkMoneyContain : malayMoney) {
			if(value == checkMoneyContain)
				checkContain = true;
		}
		
		for(double checkMoney : malayMoney){
			if (checkContain) {
			
			if ( value < 1) {
				valuable = new Coin(value , currencyCoin);
				}
			else if ( value >= 1) {
				return valuable = new BankNote(value, CURRENCY, nextSerialNumber++);
				}
			
			}
			else {
				throw new IllegalArgumentException("Malaysia doesn't have "+ value +" note");
				}
		}
		return valuable;
	}
	
	public static void main(String[] args) {
		MoneyFactory factory = MoneyFactory.getInstance();
		Valuable m = factory.createMoney( 5 );
		System.out.println(m.toString());
		
		Valuable m3 = factory.createMoney( 0.05 );
		System.out.println(m3.toString());
		
		 System.out.println(m3.getCurrency());
//		 Valuable m2 = factory.createMoney("1000.0");
//		 System.out.println(m2.toString());
	}

}
