package session1;

import java.util.List;
import java.util.Optional;

public interface ChangeCalculator {
	Optional<List<Coin>> calculateChange(int requiredChangeRappen);
}
