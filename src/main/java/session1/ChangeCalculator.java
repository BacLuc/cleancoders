package session1;

import java.util.List;
import java.util.Optional;

public interface ChangeCalculator {
	Optional<List<Coin>> calculateChange(int requiredChangeRappen);

	default Optional<List<Coin>> calculateChange(int requiredRappen, List<Coin> paidCoins) {
		return calculateChange(paidCoins.stream().mapToInt(Coin::getValueRappen).sum());
	}
}
