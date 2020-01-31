package session1;

import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.Optional.empty;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static session1.Coin.*;

class LimitedChangeCalculatorTest {

	@Test
	public void noChange() {
		assertThat(new LimitedChangeCalculator(Collections.emptyMap()).calculateChange(0),
				   is(Optional.of(Collections.emptyList())));
	}

	@Test
	public void changePossible() {
		assertThat(new LimitedChangeCalculator(new HashMap<>(Map.of(CHF_010,
																	10,
																	CHF_100,
																	1,
																	CHF_050,
																	4))).calculateChange(220),
				   is(Optional.of(List.of(CHF_100, CHF_050, CHF_050, CHF_010, CHF_010))));
	}

	@Test
	public void changeImpossible() {
		assertThat(new LimitedChangeCalculator(Collections.emptyMap()).calculateChange(130), is(empty()));
	}

}