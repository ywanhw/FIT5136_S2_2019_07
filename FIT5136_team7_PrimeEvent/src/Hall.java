import java.util.ArrayList;
import java.util.Date;

public class Hall {
	
	private String name;
	private String address;
	private User owner;
	private String description;
	private double price;
	private ArrayList<Date> availability;
	private int capacity;
	private ArrayList<String> function;
	private ArrayList<Quotation> listOfQuotation;
	
	public Hall(User owner) {
		
		this.owner = owner;
		name = "";
		address = "";
		description = "";
		price = 0;
		capacity = 0;
		availability = new ArrayList<Date>();
		function = new ArrayList<String>();
		listOfQuotation = new ArrayList<Quotation>();
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	public void setCapacity(int capacity){
	    this.capacity = capacity;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setEvent(String function) {
		this.function.add(function);
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public User getOwner() {
		return owner;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getDescription() {
		return description;
	}

	public ArrayList<String> getFunction() {
		return function;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public double getPrice() {
		return price;
	}

}
