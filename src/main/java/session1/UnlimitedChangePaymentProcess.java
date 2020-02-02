package session1;

public class UnlimitedChangePaymentProcess implements PaymentProcess {

	private final int requiredRappen;
	private int insertedRappen;

	public UnlimitedChangePaymentProcess(int requiredRappen) {
		this.requiredRappen = requiredRappen;
	}

	@Override
	public boolean isPaymentComplete() {
		return getDebit() <= 0;
	}

	@Override
	public int getDebit() {
		return requiredRappen - insertedRappen;
	}

	@Override
	public boolean add(Coin coin) {
		insertedRappen += coin.getValueRappen();
		return true;
	}
}
