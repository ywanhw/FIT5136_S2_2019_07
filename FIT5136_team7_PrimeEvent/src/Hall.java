import java.util.ArrayList;
import java.util.Date;

/**
 * This class handle the hall data
 * @author 
 *
 */
public class Hall {
	
	private String name;
	private String address;
	private User owner;
	private String description;
	private double price;
	//Availability time, save as: (string type) start time, end time
	private ArrayList<String> availability; 
	private int capacity;
	private ArrayList<String> function;
	private Quotation quotation;
	
	
	/**
	 * The constructor of the Hall class.
	 * @param owner The owner of the hall
	 * @param name The name of the hall
	 * @param address The address of the hall
	 * @param description The description of the hall
	 * @param price The initial price for the hall
	 * @param capacity The number of people the hall can hold
	 */
	public Hall(User owner, String name, String address, String description, String price, String capacity) {
		
		this.owner = owner;
		this.name = name;
		this.address = address;
		this.description = description;
		this.price = Double.parseDouble(price);
		this.capacity = Integer.parseInt(capacity);
		availability = new ArrayList<String>();
		function = new ArrayList<String>();
		quotation = new Quotation();
	}
	
	/**
	 * Set the name of the hall
	 * @param name The name of the hall
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Set the address of the hall
	 * @param address The address of the hall
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Set the owner of the hall
	 * @param owner The owner of the hall
	 */
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	/**
	 * Set the capacity of the hall
	 * @param capacity The number of people the hall can hold
	 */
	public void setCapacity(int capacity){
	    this.capacity = capacity;
	}
	
	/**
	 * Set the description of the hall
	 * @param description The description of the hall
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/** 
	 * Set the event the hall can hold
	 * @param function The event the hall can hold
	 */
	public void setEvent(String function) {
		this.function.add(function);
	}
	
	/**
	 * Set the initial price of the hall
	 * @param price The initial price of the hall
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Set the date the hall that is booked
	 * @param date The date the hall is booked
	 */
	public void setDate(String date) {
		availability.add(date);
	}
	
	/**
	 * Set the quotation for the hall
	 */
	public void setQuotationCost() {
		quotation.setCost(1000);
	}
	
	/**
	 * Return the ArrayList date the hall that is booked
	 * @return An ArrayList of booked date
	 */
	public ArrayList<String> getDateArray(){
		return availability;
	}
	
	/**
	 * Return the name of the hall
	 * @return A String of the hall name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Return the owner of the hall
	 * @return The Owner object of the hall 
	 */
	public User getOwner() {
		return owner;
	}
	
	/**
	 * Return the address of the hall
	 * @return A String of the hall address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Return the description of the hall
	 * @return A String of the hall description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Return the list of function the hall can hold
	 * @return The ArrayList of String for the event the hall can hold
	 */
	public ArrayList<String> getFunction() {
		return function;
	}
	
	/**
	 * Return the number of people the hall can hold as the capacity
	 * @return An integer of the number of people the hall can hold
	 */
	public int getCapacity() {
		return capacity;
	}
	
	/**
	 * Return the initial price of the hall
	 * @return A double of the price of the hall
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Return the quotation of the hall
	 * @return A Quotation object for the hall
	 */
	public Quotation getQuotation() {
		return quotation;
	}

}
