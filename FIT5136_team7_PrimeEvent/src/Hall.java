import java.util.ArrayList;
import java.util.Date;

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
	
	public void setDate(String date) {
		availability.add(date);
	}

	public ArrayList<String> getDateArray(){
		return availability;
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
	public Quotation getQuotation() {
		return quotation;
	}

}
