package session1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Optional;

@ToString
@AllArgsConstructor
public enum Coin {
	CHF_010(10),
	CHF_020(20),
	CHF_050(50),
	CHF_100(100),
	CHF_200(200),
	CHF_500(500);

	@Getter
	private int valueRappen;

	public static Optional<Coin> fromValue(int valueRappen) {
		return Arrays.stream(values()).filter(c -> c.valueRappen == valueRappen).findFirst();
	}
}
