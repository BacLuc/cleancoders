package session1;

public interface PaymentProcess {
	boolean isPaymentComplete();

	int getDebit();

	boolean add(Coin coin);
}
