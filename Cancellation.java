package ticketbooking;

import java.util.ArrayList;
import java.util.Scanner;

public class Cancellation {
	
	public static void ticketCancelling(ArrayList<Customer> customerList) {
		
		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter Your Number: ");
		String userContactNum = userInput.next();
		System.out.print("Enter Ticket No  : ");
		String userTicketNo = userInput.next();
		boolean presence = false;
		
		customerLoop:

		for (Customer i : customerList) {
			if (i.getTicketInfo().getTicketNo().equals(userTicketNo) && i.getNumber().equals(userContactNum)) {
				presence = true;
				System.out.println();
				System.out.println("✔Press 1 To Comfirm Cancelling  ");
				int comfirmation;
				while (true) {
					try {
						comfirmation = userInput.nextInt();
						break;
					} catch (Exception e) {
						System.out.println("Enter Valid Input !");
						userInput.reset();
						userInput.next();
					}
				}
				switch (comfirmation) {
				case 1:
					WaitingList cancelledTicketAlloter = WaitingList.getWaitingListInstance();
					for (MultiplexEnum element : MultiplexEnum.values()) {
						if (element.getName().equals(i.getTicketInfo().getScreenName())) {
							int ticketCost = element.getTicketCost();
							System.out.println("You Will Get Payment Of Rs" + (ticketCost - 0.2 * ticketCost)
									+ "(Fine Amount Deducted 20% Of The Cost)");
							if (!(cancelledTicketAlloter.waitingCustomerAssigner(i.getTicketInfo(), customerList))) {

								element.getSeats()[Integer.parseInt(Character.toString(i.getTicketInfo().getTicketNo()
										.charAt(i.getTicketInfo().getTicketNo().length() - 2)))][Integer
												.parseInt(Character.toString(i.getTicketInfo().getTicketNo()
														.charAt(i.getTicketInfo().getTicketNo().length() - 1)))]
										.setIsBooked("NO");
							}

						}
					}
					customerList.remove(i);
					break customerLoop;
				default:
					System.out.println("Please Enter Valid Option !");
				}
			}
		}
		if (!presence) {
			System.out.println("");
			System.out.println("The Ticket No Is Not Present In The List !");
		}
	}
}
