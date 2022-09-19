package ticketbooking;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TicketBooking {
	
	private static TicketBooking singletonObject = new TicketBooking();
	
	TicketDetails ticketInfo;
	ArrayList<Customer> customerList;
	String name, mailId, number;
	Scanner userInput = new Scanner(System.in);

	
	private TicketBooking() {}
	public static TicketBooking getTicketBookingInstance() { return singletonObject ; }

	public void ticketBooking(ArrayList<Customer> customerlist, String customerName, String customerMailId,
			String customerNumber) {
		customerList = customerlist;// should create object
		name = customerName;
		mailId = customerMailId;
		number = customerNumber;
		int choice;

		System.out.println();
		System.out.println("   Please Chooce The Screen Which You Want !");
    	while (true) {
			System.out.println();
			System.out.println("        * * * * * * * * * * * * * *");
			System.out.println("        *                         *");
			System.out.println("        *     1 to Rohini         *");
			System.out.println("        *     2 to Rahini         *");
			System.out.println("        *     3 to Ratchini       *");
			System.out.println("        *    -1 to exit           *");
			System.out.println("        *                         *");
			System.out.println("        * * * * * * * * * * * * * *");
			while (true) {
				try {
					choice = userInput.nextInt();
					break;
				} catch (Exception e) {
					System.out.println("Invalid Input");
					userInput.reset();
					userInput.next();
				}
			}
			switch (choice) {
			case 1:
				seatBooking(MultiplexEnum.SCREEN1);
				break;
			case 2:
				seatBooking(MultiplexEnum.SCREEN2);
				break;
			case 3:
				seatBooking(MultiplexEnum.SCREEN3);
				break;
			case -1:
				return ;
			default:
				System.out.println("Enter Valid Option !");
			}
		}

	}

	public void seatBooking(GetObjects object) { 

		int row1, column1, comfirmation;
		
		((MultiplexEnum) object).showSeatsAvailability();
		int columnLimit = ((MultiplexEnum) object).getSeats()[0].length - 1;
		int rowLimit = ((MultiplexEnum) object).getSeats().length - 1;
		int row;
		int column;
		while (true) {
			System.out.printf("Enter row (0-%s) :", rowLimit);

			while (true) {
				try {
					row1 = userInput.nextInt();
					break;
				} catch (Exception e) {
					System.out.println("Enter Valid Input !");
					userInput.reset();
					userInput.next();
				}
			}
			if (row1 >= 0 && row1 <= rowLimit) {
				row = row1;
				break;
			} else {
				System.out.println("The row  you entered is out of the range ");
			}
		}

		while (true) {
			System.out.printf("Enter column (0-%s) :", columnLimit);

			while (true) {
				try {
					column1 = userInput.nextInt();
					break;
				} catch (Exception e) {
					System.out.println("Enter Valid Input !");
					userInput.reset();
					userInput.next();
				}
			}

			if (column1 >= 0 && column1 <= columnLimit) {
				column = column1;
				System.out.println(column);
				break;
			} else {
				System.out.println("The row  you entered is out of the range ");
			}
		}

		if (((MultiplexEnum) object).getSeats()[row][column].getIsBooked().equals("NO")) {
			if (((MultiplexEnum) object).getSeats()[row][column].isAvailability() == false) {
				System.out.println("The Seat You Entered Is In Under Service !");
			} else {
				BillingProcess.produceBilling((MultiplexEnum) object);
				System.out.print("PRESS 1 TO COMFIRM :");

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
					System.out.println();
					((MultiplexEnum) object).getSeats()[row][column].setIsBooked("YES");
					System.out.println("Your Ticket Is Booked Successfully ! , Happy Movie Time ");
					((MultiplexEnum) object).showSeatsAvailability();
					ticketInfo = ticketGenerator(row, column, ((MultiplexEnum) object));
					createCustomerObject();
					break;
				default:
					System.out.println("Your Booking Process Get Cancelled ! Your Payment Will Get Return Within 2 Days");

				}

			}
		} else {
			if (((MultiplexEnum) object).getSeats()[row][column].isAvailability() == false) {
				System.out.println("The Seat You Entered Is In Under Service !");
			} else {
				System.out.println("SORRY THE SEAT IS ALREADY BOOKED !");
				System.out.println();
				System.out.println("---------------------------------------Waiting List Details---------------------------");
				System.out.println();
				WaitingList waiting = WaitingList.getWaitingListInstance() ;
				String dummyTicket = ((MultiplexEnum) object).getName()+Integer.toString(row)+Integer.toString(column) ;
				waiting.waitingProcess(new Customer(name, mailId, number, ticketInfo=null) , dummyTicket);
			}
		}
	}

	public TicketDetails ticketGenerator(int row, int column, MultiplexEnum screenObject) {
		ticketReceipt(row, column, screenObject.getName());
		String ticketNo = Integer.toString(row) + Integer.toString(column);
		return new TicketDetails(ticketNo, screenObject.getName(), screenObject.getCurrentlyPlayingMovie(),
				java.time.LocalDate.now());
	}

	public void ticketReceipt(int row, int column, String screenName) {
		System.out.println("                    YOUR MOVIE TICKET (KEEP IT SAFELY)");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("                    * * * * * * * * * * * * * * * * ");
		System.out.println("                   *                               *");
		System.out.println("                  *     ZOHO MULTIPLEX CINEMAS      *");
		System.out.println(String.format("                 *           %-8s                *", screenName));
		System.out.println(String.format("                *              %s%s                     *", row, column));
		System.out.println("                 *                                   *");
		System.out.println("                  *                                 *");
		System.out.println("                   *                               *");
		System.out.println("                    * * * * * * * * * * * * * * * *");
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println();
		System.out.println();
	}

	public TicketDetails getTicketDetails() {
		return ticketInfo;
	}

	public void createCustomerObject() {
		customerList.add(new Customer(name, mailId, number, ticketInfo));
	}

}
