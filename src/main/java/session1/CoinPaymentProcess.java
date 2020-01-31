package session1;

public class CoinPaymentProcess {

	private final int requiredRappen;
	private int insertedRappen;

	public CoinPaymentProcess(int requiredRappen) {
		this.requiredRappen = requiredRappen;
	}

	public boolean isPaymentComplete() {
		return insertedRappen >= requiredRappen;
	}

	public void add(Coin coin) {
		insertedRappen += coin.getValueRappen();
	}
}
