import java.util.ArrayList;

/**
 * This class is a subclass of User class. This is responsible to handle the owner data
 * This include the list of booking related to the owner 
 * @author Adrian Yip
 * @version 1
 *
 */
public class Owner extends User{
	
	private ArrayList<Booking> listOfBooking = new ArrayList<Booking>();

	/**
	 * Constructor of the Owner class
	 * @param name Actual name of the owner
	 * @param adress Address of the owner
	 * @param phone Phone number of the owner
	 * @param email Email of the owner
	 * @param username Username of the owner account
	 * @param password Password of the owner account
	 */
	public Owner(String name, String adress, String phone, String email, String username, String password) {
		// TODO Auto-generated constructor stub
		super(userType.owner, name, adress, phone, email, username, password);
	}
	
	/**
	 * Add a booking to the list of booking for this owner
	 * @param newBooking The Booking object related to this owner
	 */
	public void addBooking(Booking newBooking) {
		listOfBooking.add(newBooking);
	}
	
	/**
	 * Return the booking list related to this owner
	 * @return an ArrayList of booking
	 */
	public ArrayList<Booking> getBookingList(){
		return listOfBooking;
	}

}
