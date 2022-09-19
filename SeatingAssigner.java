package ticketbooking;

public class SeatingAssigner {

	public static Seat[][] seatingArrangement(Seat[][] seats, int noOfSeats) {

		int perfectSeats = (int) Math.sqrt(noOfSeats);
		int roundedSeats = (int) Math.ceil(Math.sqrt(noOfSeats));
		int extraSeats = noOfSeats - (perfectSeats * perfectSeats);

		if (extraSeats == 0) {
			seats = new Seat[perfectSeats][perfectSeats];

			for (int row = 0; row < perfectSeats; row++) {
				for (int column = 0; column < perfectSeats; column++) {
					seats[row][column] = new Seat("NO", true);
				}
			}
		} else {
			seats = new Seat[roundedSeats][roundedSeats];
			int count = 0;
			for (int row = 0; row < roundedSeats; row++) {
				for (int column = 0; column < roundedSeats; column++) {
					if (count != noOfSeats) {
						count++;
						seats[row][column] = new Seat("NO", true); // "⬜";
					} else {
						seats[row][column] = new Seat("NO", false);
					}

				}
			}
		}
		return seats;
	}
}
