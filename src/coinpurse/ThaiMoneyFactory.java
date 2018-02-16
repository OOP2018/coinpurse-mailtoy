package coinpurse;

public class ThaiMoneyFactory extends MoneyFactory {

	private static final String CURRENCY = "Baht";
	private double[] thaiMoney = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };

	@Override
	Valuable createMoney(double value) {

		Valuable valuable = null;
		boolean checkContain = false;

		for (double checkMoneyContain : thaiMoney) {
			if (value == checkMoneyContain)
				checkContain = true;
		}

		for (double checkMoney : thaiMoney) {
			if (checkContain) {

				if (checkMoney <= 10) {
					valuable = new Coin(value, CURRENCY);
				} else if (checkMoney > 10) {
					valuable = new BankNote(value, CURRENCY, nextSerialNumber++);
				}

			} else {
				throw new IllegalArgumentException("Thailand doesn't have "+ value + " note");
			}
		}
		return valuable;
	}

	public static void main(String[] args) {
		MoneyFactory factory = MoneyFactory.getInstance();
		Valuable m = factory.createMoney(5);
		System.out.println(m.toString());
		Valuable m2 = factory.createMoney("1000.0");
		System.out.println(m2.toString());
	}

}
