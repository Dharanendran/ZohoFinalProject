package ticketbooking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class WaitingList {

	private static WaitingList customerAssigner = new WaitingList();
	HashMap<String, Queue> waitingDetails = new HashMap<>();
	Scanner comfirmation = new Scanner(System.in);
	
	private WaitingList() {}
	public static WaitingList getWaitingListInstance () {return customerAssigner ;}

	public void waitingProcess(Customer customer, String ticketNo) {
		System.out.println(" _____________________________________________");
		System.out.printf("| There Are %s People Already In WaitingList   |\n", waitingDetails.containsKey(ticketNo) ? waitingDetails.get(ticketNo).size():0);
		System.out.println("|_____________________________________________|");
		System.out.println();
		System.out.println("✔ Press 1 To Add Your request In Waiting List ! ");
		int choice;
		while (true) {
			try {
				choice = comfirmation.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("Enter Valid Input !");
				comfirmation.reset();
				comfirmation.next();
			}
		}
		if (choice == 1) {
			System.out.println();
			System.out.println("✔ SuccesFully Added Your Details in WaitingList!");
			System.out.println();
			System.out.println("Please Check your Booking Status After Sometimes (By Using Show My Bookings Option)");
			Queue waitingQueue = new Queue();
			if (waitingDetails.containsKey(ticketNo)) {
				waitingDetails.get(ticketNo).add(customer);
				
			} else {
				waitingQueue.add(customer);
				waitingDetails.put(ticketNo, waitingQueue);
				

			}
		}

	}

	public boolean waitingCustomerAssigner(TicketDetails cancelledTicketInfo, ArrayList<Customer> customerList) {
	
		if (waitingDetails.containsKey(cancelledTicketInfo.getTicketNo())) {
			if(waitingDetails.get(cancelledTicketInfo.getTicketNo()).size()>=1) {
				Customer waitingCustomer = (Customer) waitingDetails.get(cancelledTicketInfo.getTicketNo()).getFirst();
				waitingCustomer.setTicketInfo(cancelledTicketInfo);
				customerList.add(waitingCustomer);
				waitingDetails.get(cancelledTicketInfo.getTicketNo()).deleteFirst();
				return true;
				}
		}
		return false;

	}
}
