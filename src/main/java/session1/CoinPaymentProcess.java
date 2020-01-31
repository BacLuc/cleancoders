package session1;

public class CoinPaymentProcess {

	private final int requiredRappen;
	private int insertedRappen;

	public CoinPaymentProcess(int requiredRappen) {
		this.requiredRappen = requiredRappen;
	}

	public boolean isPaymentComplete() {
		return getDebit() <= 0;
	}

	public int getDebit() {
		return requiredRappen - insertedRappen;
	}

	public void add(Coin coin) {
		insertedRappen += coin.getValueRappen();
	}
}
