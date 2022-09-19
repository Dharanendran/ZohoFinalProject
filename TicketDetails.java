
package ticketbooking;
import java.time.LocalDate;
 
public class TicketDetails {

	private String ticketNo;
	private String screenName;
	private String movie ;
	private String movieTime = "Matinee show on 2022/05/22 ";
	private LocalDate bookedDate ;
	


	TicketDetails(String ticketNo , String screenName , String movie, LocalDate bookedDate ){// date class have to implement
		this.ticketNo = screenName+ticketNo;
		this.screenName = screenName ;
		this.movie = movie ;
		this.bookedDate = bookedDate ;
	}
	
	
	public String getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
	public LocalDate getBookedDate() {
		return bookedDate;
	}
	
	public void setBookedDate(LocalDate bookedDate) {
		this.bookedDate = bookedDate;
	}
	public String getMovieTime() {
		return movieTime;
	}
	public void setMovieTime(String movieTime) {
		this.movieTime = movieTime;
	}
	public void showTicketDetails() {
		
		System.out.println(String.format("TICKET NO   : %s%nSCREEN NAME : %s%nMOVIE       : %s%nMOVIE TIME  : %s%nBOOKED DATE : %s", ticketNo , screenName , movie , movieTime , bookedDate));
	}

}
