package session1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

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
}
