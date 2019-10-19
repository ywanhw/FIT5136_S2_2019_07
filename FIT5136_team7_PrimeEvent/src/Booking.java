import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class handle and store individual booking data
 * @author Chris 
 *
 */
public class Booking {
	private double balance;
	private int bookingID;
	private Date endTime;
	private Hall hall;
	private boolean payDeposit;
	private Date stratTime;
	
	/**
	 * Default constructor of the Booking class
	 */
	public Booking()
    {
        // initialise instance variables
    }

	/** Return the outstanding balancing of the booking
	 * @return A double of the outstanding balancing of the booking
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * Return the booking ID
	 * @return An integer of the booking ID
	 */
	public int getBookingID() {
		return bookingID;
	}
	
	/** Return the End time of the booking
	 * @return A Date object for the end time
	 */
	public Date getEndTime() {
		return endTime;
	}
	
	/**
	 * Return the Hall for the booking
	 * @return An Hall object for the booking
	 */
	public Hall getHall() {
		return hall;
	}
	
	/** Return if the deposit is paid
	 * @return A boolean True, if the deposit is paid; False if the deposit is not paid
	 */
	public boolean getPayDeposit() {
		return payDeposit;
	}
	
	/**
	 * Return the Starting Time of the booking
	 * @return A Date object for the starting time
	 */
	public Date getStratTime() {
		return stratTime;
	}
	
	/**
	 * Set the balance of payment
	 * @param balance The outstanding balancing for the current booking
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	/**
	 * Set the Booking ID
	 * @param bookingID The booking ID of the booking
	 */
	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}
	
	/** Set the end time of the booking
	 * @param endTime The end time of the booking
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	/**
	 * Set the hall for the booking
	 * @param hall The hall object that is related to the booking
	 */
	public void setHall(Hall hall) {
		this.hall = hall;
	}
	
	/** 
	 * Set if the deposit is paid
	 * @param payDeposit A boolean True, if the deposit is paid; False if the deposit is not paid
	 */
	public void setPayDeposit(boolean payDeposit) {
		this.payDeposit = payDeposit;
	}
	
	/** Set the starting time for the booking
	 * @param stratTime The start time of the booking
	 */
	public void setStratTime(Date stratTime) {
		this.stratTime = stratTime;
	}
	

}
