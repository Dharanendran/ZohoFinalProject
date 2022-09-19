package ticketbooking;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class AdvanceSearch {

	public static void advanceSearch(ArrayList<Customer> customerList) {
		System.out.println();
		System.out.println("✔1 To Search In Booking List");
		Scanner userInput = new Scanner(System.in);
		int choice;
		while (true) {
			try {
				choice = userInput.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("Enter Valid Input !");
				userInput.close();
				userInput.next();
			}
		}

		switch (choice) {
			case 1:
				System.out.println();
				System.out.println("✔1 to Search by Name");
				System.out.println("✔2 to Search by Number");
				System.out.println("✔3 to Search by Email Id");
				System.out.println("✔4 to Search by Booking Date");
				System.out.println("✔5 to Search by Screen Name");
				System.out.println("✔6 to Search by Ticket No");
				int adminChoice = userInput.nextInt();
				switch(adminChoice) {
					case 1:
						searching(customerList , 1 );
						break;
					case 2:
						searching(customerList , 2 );
						break;
					case 3:
						searching(customerList , 3 );
						break;
					case 4:
						searching(customerList , 4 );
						break;
					case 5:
						searching(customerList , 5 );
						break;
					case 6:
						searching(customerList , 6 );
						break;
					default:
						System.out.println("Enter Valid Input");
					
				}
				break;
			default:
				System.out.println("Enter Valid Input!");
				
		}
	}
	
	public static void searching(ArrayList<Customer> customerList , int referenceNo ) {
		System.out.println();
		System.out.println("✔Press 1 for contains ");
		System.out.println("✔Press 2 for !=");
		System.out.println("✔Press 3 for ==");
		Scanner userChoice = new Scanner(System.in);
		int choice ;
		while(true) {
			try {
				choice = userChoice.nextInt();
				break;} 
			catch (Exception e) {
				System.out.println("Enter Valid Input!");
				userChoice.close();
				userChoice.next();
				}
		}
		String searchElement ;
		if(referenceNo==1) {System.out.println("Enter Name : "); searchElement = userChoice.next();}
		else if(referenceNo==2) {System.out.println("Enter Number : "); searchElement = userChoice.next();}
		else if(referenceNo==3) {System.out.println("Enter emailId : "); searchElement = userChoice.next();}
		else if(referenceNo==4) {System.out.println("Enter Booking Date (yyyy-MM-dd) : "); searchElement= userChoice.next();}
		else if(referenceNo==5) {System.out.println("Enter Screen Name : "); searchElement = userChoice.next();}
		else {System.out.println("Enter ticketNo: "); searchElement = userChoice.next();}

		switch(choice) {
		case 1:
			boolean containsPresence = false;
			for(Customer i: customerList) {
				if(getCustomerDetail(i,referenceNo).contains(searchElement)) {
					containsPresence = true;
					System.out.println();
					i.showCustomerInfo();
					System.out.println("--------------------------------------------------");
					}
			}
			if(containsPresence == false) {System.out.println("Sorry Admin! No Details get matched In Customer List");}
			break;
		case 2:
			boolean equalsPresence = false ;
			for(Customer i: customerList) {
				if(getCustomerDetail(i,referenceNo).equals(searchElement)) {
					equalsPresence=true ;
					System.out.println();
					i.showCustomerInfo();
					System.out.println("--------------------------------------------------");
					}
			}
			if(equalsPresence == false) {System.out.println("Sorry Admin! No Details get matched In Customer List");}
			break;
			
		case 3:
			boolean notEqualsPresence = false ;
			for(Customer i: customerList) {
				if(!getCustomerDetail(i,referenceNo).equals(searchElement)) {
					notEqualsPresence = true;
					System.out.println();
					i.showCustomerInfo();
					System.out.println("--------------------------------------------------");
					}
			}
			if(notEqualsPresence == false) {System.out.println("Sorry Admin! No Details get matched In Customer List");}
			break;
			
		default:
			System.out.println("Enter Valid Input!");
		}
		
	}
	public static String getCustomerDetail(Customer i , int referenceNo) {
		if(referenceNo==1) {return i.getName();}
		else if(referenceNo==2) {return i.getNumber();}
		else if(referenceNo==3) {return i.getMailId();}
		else if(referenceNo==4) {return (i.getTicketInfo().getBookedDate()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));}
		else if(referenceNo==5) {return i.getTicketInfo().getScreenName();}
		else {return i.getTicketInfo().getTicketNo();}
	}
}																											
