
public class Quotation {
	private String quoteID;
	private double cost;
	private String eventType;
	public Quotation()
    {
        // initialise instance variables
    }
	public String getQuoteID() {
		return quoteID;
	}
	public double getCost() {
		return cost;
	}
	public String getEventType() {
		return eventType;
	}
	public void setQuoteID(String quoteID) {
		this.quoteID = 	quoteID;	
	}
	public void setCost(double cost) {
		this.cost = 	cost;	
	}
	public void setEvenType(String eventType) {
		this.eventType = 	eventType;	
	}

}