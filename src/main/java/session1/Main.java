package session1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	private static HashMap<Coin, Integer> availableCoins = new HashMap<>(Map.of(Coin.CHF_010, 5, Coin.CHF_050, 4));

	public static void main(String[] args) {
		var s = new Scanner(System.in);

		System.out.println("Enter the amount in Rappen you want to request");
		int requestedRappen = Integer.parseInt(s.nextLine());
		System.out.println("Requesting " + requestedRappen + " Rappen");

		var paymentProcess = new LimitedChangePaymentProcess(requestedRappen, availableCoins);

		while (true) {
			System.out.println("Accepting " + paymentProcess.getAcceptedCoins());
			switch (s.nextLine()) {
			case "500":
				System.out.println("5.- inserted");
				System.out.println(paymentProcess.add(Coin.CHF_500));
				break;
			case "200":
				System.out.println("2.- inserted");
				System.out.println(paymentProcess.add(Coin.CHF_200));
				break;
			case "100":
				System.out.println("1.- inserted");
				System.out.println(paymentProcess.add(Coin.CHF_100));
				break;
			case "050":
			case "50":
				System.out.println("0.50 inserted");
				System.out.println(paymentProcess.add(Coin.CHF_050));
				break;
			case "020":
			case "20":
				System.out.println("0.20 inserted");
				System.out.println(paymentProcess.add(Coin.CHF_020));
				break;
			case "010":
			case "10":
				System.out.println("0.10 inserted");
				System.out.println(paymentProcess.add(Coin.CHF_010));
				break;
			default:
				System.out.println("Command not understood");
				break;
			}
			if (paymentProcess.isPaymentComplete()) {
				System.out.println("Ideal change would be "
										   + new UnlimitedChangeCalculator().calculateChange(-paymentProcess.getDebit()));

				System.out.println("Asocial change would be "
										   + new LimitedChangeCalculator(availableCoins).calculateChange(-paymentProcess
						.getDebit()));
				return;
			}
		}
	}
}
