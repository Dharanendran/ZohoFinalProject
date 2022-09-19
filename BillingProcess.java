package ticketbooking;

import java.util.Scanner;

public class BillingProcess {
	static Scanner userInput = new Scanner(System.in);
	static double snacksCost;

	public static void produceBilling(MultiplexEnum object) {
		snacksOrdering();
		double movieCost = object.getTicketCost();
		double GST = (0.2) * (movieCost);
		double discount = (0.1) * (movieCost);
		double totalCost = movieCost + GST + snacksCost - discount;
		System.out.println("           ____________________________________________");
		System.out.println("          |          ZOHO MULTIPLEX BILLING            |");
		System.out.println("          |____________________________________________|");
		System.out.println(String.format("          |     MOVIE COST    |    %-6s              |", movieCost));
		System.out.println(String.format("          |     GST           |    %-6s              |", GST));
		System.out.println(String.format("          |     DISCOUNT      |    %-6s              |", discount));
		System.out.println(String.format("          |     Snacks Cost   |    %-6s              |", snacksCost));
		System.out.println("          |___________________|________________________|");
		System.out.println(String.format("          |     TOTAL COST    |    %-6s              |", totalCost));
		System.out.println("          |___________________|________________________|");
		System.out.println();

	}

	public static void snacksOrdering() {

		SnacksInterval.POPCORN.showSnackBoard();
		SnacksInterval.BUTTERPOPCORN.showSnackBoard();
		SnacksInterval.ICECREAM.showSnackBoard();
		SnacksInterval.COCOCOLA.showSnackBoard();

		System.out.println();
		System.out.println("✔ 1 To Order Popcorn");
		System.out.println("✔ 2 To Order Butter Popcorn");
		System.out.println("✔ 3 To Order Ice Cream");
		System.out.println("✔ 4 To Order Cococola");
		System.out.println("✔ -1 To Exit");
		int choice = 0;
		while (true) {
			try {
				choice = userInput.nextInt();
			} catch (Exception e) {
				System.out.println("Enter Valid Input !");
				userInput.reset();
				userInput.next();
			}

			if ((0 < choice && choice < 5) || (choice == -1)) {
				break;
			} else {
				System.out.println("Enter Valid Input");
			}
		}

		switch (choice) {
		case 1 -> {
			snacksCost = BillingProcess.getQuantity() * SnacksInterval.POPCORN.getCost();
		}
		case 2 -> {
			snacksCost = BillingProcess.getQuantity() * SnacksInterval.BUTTERPOPCORN.getCost();
		}
		case 3 -> {
			snacksCost = BillingProcess.getQuantity() * SnacksInterval.ICECREAM.getCost();
		}
		case 4 -> {
			snacksCost = BillingProcess.getQuantity() * SnacksInterval.COCOCOLA.getCost();
		}
		case -1 -> {
			snacksCost = 0.0;
			break;
		}
		default -> {System.out.println("Please Enter The Correct Option !");}

		}

	}

	public static int getQuantity() {
		int quantity = 0;
		System.out.println("Enter The Quantity You Want :");
		while (true) {
			try {
				quantity = userInput.nextInt();
			} catch (Exception e) {
				System.out.println("Enter Valid Input !");
				userInput.reset();
				userInput.next();
			}
			if (quantity < 0) {System.out.println("Enter Valid Input!");} 
			else {return quantity;}
		}
	}
}
