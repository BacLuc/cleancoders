package session1;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class UnlimitedChangePaymentProcessTest {

	@Test
	public void zeroAmount() {
		UnlimitedChangePaymentProcess unlimitedChangePaymentProcess = new UnlimitedChangePaymentProcess(0);
		assertThat(unlimitedChangePaymentProcess.isPaymentComplete(), is(true));
		assertThat(unlimitedChangePaymentProcess.getDebit(), is(0));
	}

	@Test
	public void paidInOneStep() {
		UnlimitedChangePaymentProcess unlimitedChangePaymentProcess = new UnlimitedChangePaymentProcess(10);
		assertThat(unlimitedChangePaymentProcess.getDebit(), is(10));
		assertThat(unlimitedChangePaymentProcess.isPaymentComplete(), is(false));
		unlimitedChangePaymentProcess.add(Coin.CHF_010);
		assertThat(unlimitedChangePaymentProcess.isPaymentComplete(), is(true));
	}

	@Test
	public void paidInTwoSteps() {
		UnlimitedChangePaymentProcess unlimitedChangePaymentProcess = new UnlimitedChangePaymentProcess(20);

		unlimitedChangePaymentProcess.add(Coin.CHF_010);
		assertThat(unlimitedChangePaymentProcess.getDebit(), is(10));
		assertThat(unlimitedChangePaymentProcess.isPaymentComplete(), is(false));
		unlimitedChangePaymentProcess.add(Coin.CHF_020);
		assertThat(unlimitedChangePaymentProcess.getDebit(), is(-10));
		assertThat(unlimitedChangePaymentProcess.isPaymentComplete(), is(true));
	}
}