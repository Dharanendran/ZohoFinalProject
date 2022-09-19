package ticketbooking;

import java.util.ArrayList;
import java.util.Scanner;

public class ShowMyBooking {
	static Scanner userInput = new Scanner(System.in);
	public static void showMyBookings(ArrayList<Customer> customerList) {
		System.out.print("Enter Your Number   :");
		String userNumber = userInput.next();
		System.out.print("Enter Your TicketNo :");
		String userTicketNo = userInput.next();
		System.out.println();
		boolean presence = false;
		for (Customer i : customerList) {
			if (i.getNumber().equals(userNumber) && i.getTicketInfo().getTicketNo().equals(userTicketNo)) {
				presence = true;
				i.showCustomerInfo();
				System.out.println("____________________________________________");
			}
		}
		if (presence == false) {
			System.out.println("The Detail You Entered Is Not Present In The List");
		}
		
	}
	
}
