import java.util.ArrayList;

public class Customer extends User{
	
	private boolean concession = false;
	private ArrayList<Booking> listOfBooking = new ArrayList<Booking>();

	public Customer(String name, String adress, String phone, String email, String username, String password, boolean concession) {
		// TODO Auto-generated constructor stub
		super(userType.customer, name, adress, phone, email, username, password);
		this.concession = concession;
	}
	
	public void setConcession(boolean concession) {
		this.concession = concession;
	}
	
	public boolean getConcession() {
		return concession;
	}
	
	public void addBooking(Booking newBooking) {
		listOfBooking.add(newBooking);
	}
	
	public ArrayList<Booking> getBookingList(){
		return listOfBooking;
	}

}
