package session1;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class CoinPaymentProcessTest {

	@Test
	public void zeroAmount() {
		assertThat(new CoinPaymentProcess(0).isPaymentComplete(), is(true));
	}

	@Test
	public void paidInOneStep() {
		CoinPaymentProcess coinPaymentProcess = new CoinPaymentProcess(1);

		assertThat(coinPaymentProcess.isPaymentComplete(), is(false));
		coinPaymentProcess.add(1);
		assertThat(coinPaymentProcess.isPaymentComplete(), is(true));
	}

	@Test
	public void paidInTwoSteps() {
		CoinPaymentProcess coinPaymentProcess = new CoinPaymentProcess(2);

		coinPaymentProcess.add(1);
		assertThat(coinPaymentProcess.isPaymentComplete(), is(false));
		coinPaymentProcess.add(1);
		assertThat(coinPaymentProcess.isPaymentComplete(), is(true));
	}
}