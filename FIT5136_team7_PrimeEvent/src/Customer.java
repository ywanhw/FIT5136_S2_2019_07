import java.util.ArrayList;

/**
 * This class is responsible to handle the customer data. This class extend the User class.
 * @author Adrian
 *
 */
public class Customer extends User{
	
	private boolean concession = false;
	private ArrayList<Booking> listOfBooking = new ArrayList<Booking>();

	/**
	 * The constructor of the Customer class
	 * @param name The name of the customer
	 * @param adress The address of the customer
	 * @param phone The phone number of the customer
	 * @param email The email address of the customer
	 * @param username The username of the customer
	 * @param password The password of the customer
	 * @param concession Does the customer has concession(y/n)
	 */
	public Customer(String name, String adress, String phone, String email, String username, String password, boolean concession) {
		// TODO Auto-generated constructor stub
		super(userType.customer, name, adress, phone, email, username, password);
		this.concession = concession;
	}
	
	/**
	 * Set the concession of the customer
	 * @param concession The boolean if the customer has concession or not
	 */
	public void setConcession(boolean concession) {
		this.concession = concession;
	}
	
	/**
	 * Return a boolean if the customer has concession
	 * @return boolean of True for having concession and False for not having concession
	 */
	public boolean getConcession() {
		return concession;
	}
	
	/**
	 * Add booking object related to the customer
	 * @param newBooking A booking object for the customer 
	 */
	public void addBooking(Booking newBooking) {
		listOfBooking.add(newBooking);
	}
	
	/**
	 * Return the list of booking related to the customer
	 * @return An ArrayList of booking for the customer
	 */
	public ArrayList<Booking> getBookingList(){
		return listOfBooking;
	}

}
