import java.text.SimpleDateFormat;
import java.util.Date;

public class booking {
	private String bookingID;
	private boolean payDeposit;
	private Hall hall;
	private Date stratTime;
	private Date endTime;
	private double balance;
	public booking()
    {
        // initialise instance variables
    }

	public void setBookingID(String bookingID) {
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
	public String getBookingID() {
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
