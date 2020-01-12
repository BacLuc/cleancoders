package session1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var s = new Scanner(System.in);

		System.out.println("Enter the amount in Rappen you want to request");
		int requestedRappen = Integer.parseInt(s.nextLine());
		System.out.println("Requesting " + requestedRappen + " Rappen");

		//TODO add some initialization logic

		while (true) {
			switch (s.nextLine()) {
			case "500":
				System.out.println("5.- inserted");
				//TODO add some insertion logic
				break;
			case "200":
				System.out.println("2.- inserted");
				//TODO add some insertion logic
				break;
			case "100":
				System.out.println("1.- inserted");
				//TODO add some insertion logic
				break;
			case "050":
			case "50":
				System.out.println("0.50 inserted");
				//TODO add some insertion logic
				break;
			case "020":
			case "20":
				System.out.println("0.20 inserted");
				//TODO add some insertion logic
				break;
			case "010":
			case "10":
				System.out.println("0.10 inserted");
				//TODO add some insertion logic
				break;
			default:
				System.out.println("Command not understood");
				break;
			}
		}
	}
}
