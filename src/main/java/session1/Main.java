package session1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var s = new Scanner(System.in);

		System.out.println("Enter the amount in Rappen you want to request");
		int requestedRappen = Integer.parseInt(s.nextLine());
		System.out.println("Requesting " + requestedRappen + " Rappen");

		var paymentProcess = new CoinPaymentProcess(requestedRappen);

		while (true) {
			switch (s.nextLine()) {
			case "500":
				System.out.println("5.- inserted");
				paymentProcess.add(Coin.CHF_500);
				break;
			case "200":
				System.out.println("2.- inserted");
				paymentProcess.add(Coin.CHF_200);
				break;
			case "100":
				System.out.println("1.- inserted");
				paymentProcess.add(Coin.CHF_100);
				break;
			case "050":
			case "50":
				System.out.println("0.50 inserted");
				paymentProcess.add(Coin.CHF_050);
				break;
			case "020":
			case "20":
				System.out.println("0.20 inserted");
				paymentProcess.add(Coin.CHF_020);
				break;
			case "010":
			case "10":
				System.out.println("0.10 inserted");
				paymentProcess.add(Coin.CHF_010);
				break;
			default:
				System.out.println("Command not understood");
				break;
			}
			if (paymentProcess.isPaymentComplete()) {
				System.out.println("Ideal change would be "
										   + new UnlimitedChangeCalculator().calculateChange(-paymentProcess.getDebit()));
				System.out.println(
						"Associal change would be " + new LimitedChangeCalculator(new HashMap<>(Map.of(Coin.CHF_010,
																									   Integer.MAX_VALUE,
																									   Coin.CHF_050,
																									   4))).calculateChange(
								-paymentProcess.getDebit()));
				return;
			}
		}
	}
}
