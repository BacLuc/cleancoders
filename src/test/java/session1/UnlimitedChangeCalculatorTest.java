package session1;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.empty;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static session1.Coin.*;

class UnlimitedChangeCalculatorTest {

	@Test
	public void noChange() {
		assertThat(new UnlimitedChangeCalculator().calculateChange(0), is(Optional.of(Collections.emptyList())));
	}

	@Test
	public void tooManyCoins() {
		assertThat(new UnlimitedChangeCalculator().calculateChange(120), is(Optional.of(List.of(CHF_100, CHF_020))));
	}

	@Test
	public void roughInsertion() {
		assertThat(new UnlimitedChangeCalculator().calculateChange(130), is(Optional.of(List.of(CHF_100, CHF_020, CHF_010))));
	}

	@Test
	public void inexistentCoin() {
		assertThat(new UnlimitedChangeCalculator().calculateChange(1), is(empty()));
	}
}