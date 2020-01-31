package session1;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class CoinPaymentProcessTest {

	@Test
	public void zeroAmount() {
		CoinPaymentProcess coinPaymentProcess = new CoinPaymentProcess(0);
		assertThat(coinPaymentProcess.isPaymentComplete(), is(true));
		assertThat(coinPaymentProcess.getDebit(), is(0));
	}

	@Test
	public void paidInOneStep() {
		CoinPaymentProcess coinPaymentProcess = new CoinPaymentProcess(10);
		assertThat(coinPaymentProcess.getDebit(), is(10));
		assertThat(coinPaymentProcess.isPaymentComplete(), is(false));
		coinPaymentProcess.add(Coin.CHF_010);
		assertThat(coinPaymentProcess.isPaymentComplete(), is(true));
	}

	@Test
	public void paidInTwoSteps() {
		CoinPaymentProcess coinPaymentProcess = new CoinPaymentProcess(20);

		coinPaymentProcess.add(Coin.CHF_010);
		assertThat(coinPaymentProcess.getDebit(), is(10));
		assertThat(coinPaymentProcess.isPaymentComplete(), is(false));
		coinPaymentProcess.add(Coin.CHF_020);
		assertThat(coinPaymentProcess.getDebit(), is(-10));
		assertThat(coinPaymentProcess.isPaymentComplete(), is(true));
	}
}