package ticketbooking;

import java.util.ArrayList;
import java.util.Scanner;

public enum MultiplexEnum implements GetObjects{

	SCREEN1("rohini", 29 , 200 , "Available" , "KGF-2"), SCREEN2("rahini", 35 , 175 , "Availabe","KRK"), SCREEN3("ratchini", 49 , 150 , "Not Available" , "BEAST");

	private String name;
	private int noOfSeats;
	private String currentlyPlayingMovie ;
	private int ticketCost ;
	private String AC ;
	private Seat[][] seats ;
	private int adminAccessCode;
	ArrayList<TicketDetails> bookedTickets ;
	Scanner userInput = new Scanner(System.in);

	private MultiplexEnum(String name, int noOfSeats , int cost , String AC , String movie) {
		this.name = name;
		this.noOfSeats = noOfSeats;
		this.ticketCost =cost ;
		this.AC = AC ;
		this.currentlyPlayingMovie = movie ;
		seatingAssigner();
	}
	
	public int getAdminAccessCode(String loginId , String password) {
		if(loginId.equals("zoho") && password.equals("abcd@1234"))
			return adminAccessCode ;
		return 0 ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSeatingCapacity() {
		return noOfSeats;
	}

	public void setSeatingCapacity(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public void seatingAssigner() {//purpose to admin
		this.seats = SeatingAssigner.seatingArrangement(seats, noOfSeats);
	}
	
	public void screenDetails() {
		System.out.println();
		System.out.println("*****************************************************");
		System.out.printf("Sreen Name  : %s%nTotal Seats : %s%nTicket Cost : %s%nA/C         : %s%nCurrently Playing Movie : %S" , this.name , this.noOfSeats , this.ticketCost , this.AC , this.currentlyPlayingMovie);
		System.out.println();
		System.out.println();
	}

	public void showSeatsAvailability() {
		System.out.println("⬛ ------> Booked");
		System.out.println("⬜ ------> Not Booked");
		System.out.println("☒ ------> Under Service");
		System.out.println();
		System.out.println("------------------------SEATS AVAILABILITY-----------------------------");

		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats.length; j++) {
				if(seats[i][j].isAvailability()==true) {
					if(seats[i][j].getIsBooked().equals("NO")) { System.out.print("⬜  "); }
					else{System.out.print("⬛  ");}
					}
				else {System.out.print("☒  ");
				}
			}
			System.out.println();
		}
		System.out.println();

	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {

		if(accessChecker()) {  this.noOfSeats = noOfSeats;  }
		else {
			System.out.println();
			System.out.println(" Access Code Get Mismtached!");
			}
		
	}

	public String getAC() {
		return AC;
	}

	public void setAC(String ac) {
		AC = ac;
	}

	public Seat[][] getSeats() {
		return seats;
	}

	public void setSeats(Seat[][] seats) {
		this.seats = seats;
	}

	public int getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(int ticketCost ) {
		
		if(accessChecker()) {  this.ticketCost = ticketCost;  }
		else {
			System.out.println();
			System.out.println(" Access Code Get Mismatched!");
			}
	}

	public String getCurrentlyPlayingMovie() {
		return currentlyPlayingMovie;
	}

	public void setCurrentlyPlayingMovie(String currentlyPlayingMovie) {
		if(accessChecker()) {  this.currentlyPlayingMovie = currentlyPlayingMovie;  }
		else {
			System.out.println();
			System.out.println(" Access Code Get Mismatched!");
			}
	}

	@Override
	public MultiplexEnum getObject() {
		return this;
	}
	public void generateAccessCode() {
		this.adminAccessCode = (int)(Math.random()*(10000-1000+1)+1000);
	}
	
	public boolean accessChecker() {
		System.out.print("Enter Access Code To Manipulate : ");
		int accessCode = userInput.nextInt();
		if(adminAccessCode==accessCode) {return true ;}
		return false;
		
	}
}
