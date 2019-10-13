import java.util.ArrayList;

public class Owner extends User{
	
	private static String type = "Owner";
	private ArrayList<Booking> listOfBooking = new ArrayList<Booking>();

	public Owner(String name, String adress, String phone, String email, String username, String password) {
		// TODO Auto-generated constructor stub
		super(type, name, adress, phone, email, username, password);
	}
	
	public void addBooking(Booking newBooking) {
		listOfBooking.add(newBooking);
	}
	
	public ArrayList<Booking> getBookingList(){
		return listOfBooking;
	}

}
