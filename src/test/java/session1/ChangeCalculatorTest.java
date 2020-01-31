package session1;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.empty;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static session1.Coin.*;

class ChangeCalculatorTest {

	@Test
	public void noChange() {
		assertThat(ChangeCalculator.calculateChange(0), is(Optional.of(Collections.emptyList())));
	}

	@Test
	public void tooManyCoins() {
		assertThat(ChangeCalculator.calculateChange(120), is(Optional.of(List.of(CHF_100, CHF_020))));
	}

	@Test
	public void roughInsertion() {
		assertThat(ChangeCalculator.calculateChange(130), is(Optional.of(List.of(CHF_100, CHF_020, CHF_010))));
	}

	@Test
	public void inexistentCoin() {
		assertThat(ChangeCalculator.calculateChange(1), is(empty()));
	}
}