
/**
 * This class handle the data of quotation
 * @author
 *
 */
public class Quotation {
	private double cost;
	private String eventType;
	private String quoteID;
	
	/**
	 * An empty default constructor of Quotation class
	 */
	public Quotation()
	{
		
	}
	
	/**
	 * A non-default constructor of Quotation class
	 * @param quoteID The ID of the quotation
	 * @param cost The price
	 * @param eventType The type of the event
	 */
	public Quotation(String quoteID, double cost, String eventType){
		// initialise instance variables
		this.quoteID = quoteID;
		this.cost = cost;
		this.eventType = eventType;
	}

	/** 
	 * Return the price for the quotation
	 * @return A double of the price
	 */
	public double getCost() {
		return cost;
	}
	
	/**
	 * Return the type of the event for the quotation
	 * @return A String of the event type
	 */
	public String getEventType() {
		return eventType;
	}
	
	/**
	 * Return the quotation ID
	 * @return A String of quotation ID
	 */
	public String getQuoteID() {
		return quoteID;
	}
	
	/**
	 * Set the price for the quotation
	 * @param cost The price value for the quotation
	 */
	public void setCost(double cost) {
		this.cost = cost;	
	}
	
	/**
	 * Set the event type for the quotation
	 * @param eventType The type of event for this quotation
	 */
	public void setEvenType(String eventType) {
		this.eventType = 	eventType;	
	}
	
	/**
	 * Set the quotation ID
	 * @param quoteID The ID of the quotation
	 */
	public void setQuoteID(String quoteID) {
		this.quoteID = 	quoteID;	
	}

}
