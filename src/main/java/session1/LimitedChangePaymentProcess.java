package session1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LimitedChangePaymentProcess implements PaymentProcess {

	private final UnlimitedChangePaymentProcess unlimitedChangePaymentProcess;
	private final Map<Coin, Integer> availableCoins;

	public LimitedChangePaymentProcess(int requiredRappen, Map<Coin, Integer> availableCoins) {
		this.unlimitedChangePaymentProcess = new UnlimitedChangePaymentProcess(requiredRappen);
		this.availableCoins = availableCoins;
	}

	public Set<Coin> getAcceptedCoins() {
		return Arrays.stream(Coin.values())
					 .filter(c -> new LimitedChangeCalculator(new HashMap<>(availableCoins)).calculateChange(
							 c.getValueRappen() - unlimitedChangePaymentProcess.getDebit()).isPresent())
					 .collect(Collectors.toSet());
	}

	@Override
	public boolean isPaymentComplete() {
		return unlimitedChangePaymentProcess.isPaymentComplete();
	}

	@Override
	public int getDebit() {
		return unlimitedChangePaymentProcess.getDebit();
	}

	@Override
	public boolean add(Coin coin) {
		if (getAcceptedCoins().contains(coin)) {
			availableCoins.put(coin, availableCoins.getOrDefault(coin, 0) + 1);
			return unlimitedChangePaymentProcess.add(coin);
		} else {
			return false;
		}
	}

}
