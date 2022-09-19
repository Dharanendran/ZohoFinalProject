package ticketbooking;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminLogin {

	final String loginId = "zoho";
	final String passWord = "abcd@1234";
	static AdminLogin adminLoginInstance = new AdminLogin();
	Scanner userInput = new Scanner(System.in);

	public void adminCheckingProccess(ArrayList<Customer> customerList) {
		System.out.print("Login Id :");
		String loginId = userInput.next();
		System.out.print("Password :");
		String password = userInput.next();
		System.out.println("please wait a second for authentication........");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (this.loginId.equals(loginId) && this.passWord.equals(password)) {
			MultiplexEnum.SCREEN1.generateAccessCode();
			System.out.println();
			System.out.println(
					"----------------------------AUTHENTICATION PASSED SUCCESSFULLY ! WELCOME ADMIN------------------------");
			System.out.println();
			System.out.println(String.format("Your Access Code Is  \"%s\"(Keep It Confidentially)",
					MultiplexEnum.SCREEN1.getAdminAccessCode(loginId, password)));
			System.out.println();
			this.adminAccess(customerList);
		} else {
			System.out.println();
			System.out.println("                            AUTHENTICATION FAILED");
			System.out.println();
			System.out.println("                  \"Please Enter Valid Username Or Password\"");
			adminCheckingProccess(customerList);
		}
	}

	private void adminAccess(ArrayList<Customer> customerList) {
		System.out.println("✔1 To Do Modifications In Screen");
		System.out.println("✔2 To Do Advance Search In Customer List");
		int adminChoice = userInput.nextInt();
		switch(adminChoice) {
		case 1:
			screenModifications();
			break;
		case 2:
			AdvanceSearch.advanceSearch(customerList);
			break;
		default:
			System.out.println("Enter Valid Input!");
		}
	}
	
	private void screenModifications() {
		System.out.println();
		System.out.println("✔1 To Set No Of Seats ");
		System.out.println("✔2 To Set Playing Movie");
		System.out.println("✔3 To Modifying Ticket Cost");
		int selection = 0;
		while (true) {
			try {
				selection = userInput.nextInt();

			} catch (Exception e2) {
				System.out.println("Enter Valid Input !");
				userInput.reset();
				userInput.next();
			}
			if (0 < selection && selection < 4) {break;}
			else {System.out.println("Enter Valid Input!");}
		}
		System.out.println("✔ 1 to Screen1");
		System.out.println("✔ 2 to Screen2");
		System.out.println("✔ 3 to Screen3");
		int choice=0;
		while (true) {
			try {
				choice = userInput.nextInt();
				
			} catch (Exception e2) {
				System.out.println("Enter Valid Input !");
				userInput.reset();
				userInput.next();
			}
			if(0<choice && choice<4) {break;}
			else {System.out.println("Enter Valid Input!");}
			}
		switch (selection) {
		case 1:
			int noOfSeats;
			while (true) {
				System.out.print("Enter No Of Seats :");
				while (true) {
					try {
						noOfSeats = userInput.nextInt();
						break;
					} catch (Exception e1) {
						System.out.println("Enter Valid Input !");
						userInput.reset();
						userInput.next();
					}
				}
				if (!(noOfSeats >= 10)) {
					System.out.println("Please Enter Seats Count =>10 ");
					System.out.println();
				} else {
					break;
				}
			}
			switch (choice) {
			case 1:
				MultiplexEnum.SCREEN1.setNoOfSeats(noOfSeats);
				System.out.println("✔SuccesFully Updated!");
				break;
			case 2:
				MultiplexEnum.SCREEN2.setNoOfSeats(noOfSeats);
				System.out.println("✔SuccesFully Updated!");

				break;
			case 3:
				MultiplexEnum.SCREEN1.setNoOfSeats(noOfSeats);
				System.out.println("✔SuccesFully Updated!");
				break;
			default:
				System.out.println("Admin , Please Enter Valid Option !");
			}
			break;
		case 2:
			System.out.print("Enter Movie To Play :");
			String movieName = userInput.next();
			switch (choice) {

			case 1:
				MultiplexEnum.SCREEN1.setCurrentlyPlayingMovie(movieName);
				System.out.println("✔SuccesFully Updated!");
				break;
			case 2:
				MultiplexEnum.SCREEN2.setCurrentlyPlayingMovie(movieName);
				System.out.println("✔SuccesFully Updated!");
				break;
			case 3:
				MultiplexEnum.SCREEN1.setCurrentlyPlayingMovie(movieName);
				System.out.println("✔SuccesFully Updated!");
				break;
			default:
				System.out.println("Admin , Please Enter Valid Option !");
			}
			break;

		case 3:

			System.out.print("Enter Movie Ticket Cost  :");
			int newCost;
			while (true) {
				try {
					newCost = userInput.nextInt();
					break;
				} catch (Exception e) {
					System.out.println("Enter Valid Input !");
					userInput.reset();
					userInput.next();
				}
			}
			switch (choice) {

			case 1:

				MultiplexEnum.SCREEN1.setTicketCost(newCost);
				System.out.println("✔SuccesFully Updated!");
				break;
			case 2:
				MultiplexEnum.SCREEN2.setTicketCost(newCost);
				System.out.println("✔SuccesFully Updated!");
				break;
			case 3:
				MultiplexEnum.SCREEN1.setTicketCost(newCost);
				System.out.println("✔SuccesFully Updated!");
				break;
			default:
				System.out.println("Admin , Please Enter Valid  Option !");
			}
			break;

		}
	}
	
}
