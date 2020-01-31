package session1;

import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class LimitedChangeCalculator implements ChangeCalculator {

	private final Map<Coin, Integer> availableCoins;

	@Override
	public Optional<List<Coin>> calculateChange(int requiredChangeRappen) {
		var changeList = new ArrayList<Coin>();

		while (requiredChangeRappen > 0) {
			final var remainingValueCopy = requiredChangeRappen;
			var coinValue = availableCoins.entrySet()
										  .stream()
										  .filter(entry -> entry.getValue() > 0)
										  .map(Map.Entry::getKey)
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
			availableCoins.replace(coin.get(), availableCoins.get(coin.get()) - 1);
		}

		return Optional.of(changeList);
	}
}