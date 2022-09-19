package ticketbooking;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {

	static Scanner userInput = new Scanner(System.in);
	static ArrayList<Customer> customerList = new ArrayList<>(5);
	

	public static void main(String[] args) {
		System.out.println();
		System.out.println("🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏  WELCOME TO ZOHO MULTIPLEX  🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏    ");
	
		int choice;
		task: while (true) {
			welcomeStatements();
			while (true) {
				try {
					choice = userInput.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Enter Only Integer value!");
					userInput.reset();
					userInput.next();
				} catch (Exception e) {
					System.out.println("Enter Valid Input!");
					userInput.reset();
					userInput.next();
				}
			}

			switch (choice) {
			case 1:
				System.out.print("Enter Your Name      :");
				String name = userInput.next();
				String mailId = EmailCheckerUtil.getMailId(customerList, true);
				String number = NumberCheckerUtil.getContactNumber(customerList, true);

				MultiplexEnum.SCREEN1.screenDetails();
				MultiplexEnum.SCREEN2.screenDetails();
				MultiplexEnum.SCREEN3.screenDetails();
				TicketBooking ticketBooker = TicketBooking.getTicketBookingInstance();
				ticketBooker.ticketBooking(customerList, name, mailId, number);

				break;

			case 2:

				ShowMyBooking.showMyBookings(customerList);
				break;

			case 3:
				EditBookingDetail.editDetails(customerList);
				break;
			case 4:
				Cancellation.ticketCancelling(customerList);
				break;
			case 5:
				AdminLogin admin = new AdminLogin();
				admin.adminCheckingProccess(customerList);
				break;

			case -1:
				System.out.println(
						"🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏  THANKS FOR VISITING US!  🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏🙏");
				break task;

			default:
				System.out.println("Enter Valid Input !");

			}
		}
	}

	public static void welcomeStatements() {
		System.out.println();

		System.out.println();
		System.out.println("                         * * * * * * * * * * * * * * * * * *");
		System.out.println("                         *                                 *");
		System.out.println("                         *       1 to New Booking          *");
		System.out.println("                         *       2 to Show My Bookings     *");
		System.out.println("                         *       3 to Edit Booking Details *");
		System.out.println("                         *       4 to Cancel  Booking      *");
		System.out.println("                         *       5 to Admin Login          *");
		System.out.println("                         *      -1 to Exit                 *");
		System.out.println("                         *                                 *");
		System.out.println("                         * * * * * * * * * * * * * * * * * *");

	}
}
