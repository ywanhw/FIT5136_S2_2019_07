import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking {
	private int bookingID;
	private boolean payDeposit;
	private Hall hall;
	private Date stratTime;
	private Date endTime;
	private double balance;
	
	public Booking()
    {
        // initialise instance variables
    }

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}
	public void setPayDeposit(boolean payDeposit) {
		this.payDeposit = payDeposit;
	}
	public void setHall(Hall hall) {
		this.hall = hall;
	}
	public void setStratTime(Date stratTime) {
		this.stratTime = stratTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getBookingID() {
		return bookingID;
	}
	public boolean getPayDeposit() {
		return payDeposit;
	}
	public Hall getHall() {
		return hall;
	}
	public Date getStratTime() {
		return stratTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public double getBalance() {
		return balance;
	}
	

}
