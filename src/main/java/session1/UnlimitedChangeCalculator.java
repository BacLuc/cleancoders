package session1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UnlimitedChangeCalculator implements ChangeCalculator {

	@Override
	public Optional<List<Coin>> calculateChange(int requiredChangeRappen) {
		var changeList = new ArrayList<Coin>();

		while (requiredChangeRappen > 0) {
			final var remainingValueCopy = requiredChangeRappen;
			var coinValue = Arrays.stream(Coin.values())
								  .mapToInt(Coin::getValueRappen)
								  .filter(value -> value <= remainingValueCopy)
								  .max();
			if (coinValue.isEmpty()) {
				return Optional.empty();
			}

			requiredChangeRappen -= coinValue.getAsInt();
			var coin = Coin.fromValue(coinValue.getAsInt());
			if (coin.isEmpty()) {
				return Optional.empty();
			}
			changeList.add(coin.get());
		}

		return Optional.of(changeList);
	}
}