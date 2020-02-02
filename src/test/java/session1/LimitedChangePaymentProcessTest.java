package session1;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.*;

class LimitedChangePaymentProcessTest {

	@Test
	public void zeroAmount() {
		var paymentProcess = new LimitedChangePaymentProcess(0, new HashMap<>());
		assertThat(paymentProcess.isPaymentComplete(), Matchers.is(true));
		assertThat(paymentProcess.getDebit(), Matchers.is(0));
		assertThat(paymentProcess.getAcceptedCoins(), is(Collections.emptySet()));
	}

	@Test
	public void paidInOneStep() {
		var paymentProcess = new LimitedChangePaymentProcess(10, new HashMap<>(Map.of(Coin.CHF_010, 1)));
		assertThat(paymentProcess.getDebit(), Matchers.is(10));
		assertThat(paymentProcess.isPaymentComplete(), Matchers.is(false));
		assertThat(paymentProcess.getAcceptedCoins(), is(Set.of(Coin.CHF_010, Coin.CHF_020)));
		paymentProcess.add(Coin.CHF_010);
		assertThat(paymentProcess.isPaymentComplete(), Matchers.is(true));
	}

	@Test
	public void possibleByAddedCoins(){
		var paymentProcess = new LimitedChangePaymentProcess(20, new HashMap<>());
		assertThat(paymentProcess.getDebit(), Matchers.is(20));
		assertThat(paymentProcess.isPaymentComplete(), Matchers.is(false));
		assertThat(paymentProcess.getAcceptedCoins(), is(Set.of(Coin.CHF_010, Coin.CHF_020)));
		paymentProcess.add(Coin.CHF_010);
		assertThat(paymentProcess.getAcceptedCoins(), is(Set.of(Coin.CHF_010, Coin.CHF_020)));
	}
}