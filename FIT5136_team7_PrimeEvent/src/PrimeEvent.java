import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * This class is the controller of the application. It is responsible to manage User, Booking, Hall, discount and quotation data
 * @author Adrian, Hannah, Chris, 
 *
 */
public class PrimeEvent {
	
	Hall hallarr[] = new Hall[100];
	private ArrayList<Booking> listOfBooking = new ArrayList<Booking>();
	private ArrayList<Hall> listOfHall = new ArrayList<Hall>();
	private ArrayList<User> listOfUsers = new ArrayList<User>();
	int bookIDCount = 20000;
	Scanner input = new Scanner(System.in);;
	Scanner sc = new Scanner(System.in);
	User currentUser;
	
	/**
	 * Constructor of the PrimeEvent Class
	 */
	public PrimeEvent() {
		User newOwner = new Owner("James", "Clayton", "12345678", "thisEmail", "james", "james");
		listOfUsers.add(newOwner);
		User newCustomer = new Customer("Jack", "Clayton", "12345678", "thisEmail", "jack", "jack", true);
		listOfUsers.add(newCustomer);
		Quotation newQuote = new Quotation("12345", 0, "Birthday");
		Hall newHall = new Hall(newOwner,"Testing", "Clayton",  "Testing", "5", "999");

		listOfHall.add(newHall);

	}

		
	/**
	 * This method validate the username and password input by the user to see if the user exist and if the password is correct.
	 * @param userName Inputed username
	 * @param password Inputed password
	 * @return An enum for the type of the user if a user is found. Otherwise, return null
	 */
	public userType login(String userName, String password) {		
		//Verify details
		boolean found = false;	
		
		for(User thisUser : listOfUsers) {
			if(thisUser.getUsername().equals(userName)) {
				if(thisUser.getPassword().equals(password)) {
					//Display page based on user's privilege
					System.out.println("\nLogin successful." + "\nWelcome " + userName);
					System.out.println("\nRedirecting to home page\n");
					System.out.println();
					currentUser = thisUser;
					return currentUser.getType();
				}
			}
		}
		return null;
	}
	
	/**
	 * This method clear the user from current login status
	 */
	public void logout() {
		System.out.println();
		for(int i = 0; i < 30; i ++) {
			System.out.print("=");
		}
		System.out.println("\n\nLogout successful.");
		System.out.println("\nRedirecting to home page");
		System.out.println();
		
		currentUser = null;
	}
	
	/**
	 * This method register new user into the system
	 * @param userData A String array that store the userData inputed by the user. The order should be Name, Address, Phone number, Email, Username, Password, for customer also include y/n for concession
	 * @return An enum for the type of the user that was registered
	 */
	public userType register(String[] userData) {			
		//create the corresponding user object
		User newUser;
		if(userData[0].equals("1")) {
			newUser = new Customer(userData[1], userData[2], userData[3], userData[4], userData[5], userData[6], Boolean.parseBoolean(userData[7]));
			currentUser = newUser;
		}else {
			newUser = new Owner(userData[1], userData[2], userData[3], userData[4], userData[5], userData[6]);
			currentUser = newUser;
		}
		
		listOfUsers.add(newUser);
		
		//return to home
		System.out.println("\nRegister successful.");
		System.out.println("\nRedirecting to home page\n");
		System.out.println();
		
		//display based on user
		return currentUser.getType();
		
	}
	
	

    /**
     * This method create a new hall as request
     * @param hallData a String array of hall data in an order of Hall name, Hall address, description, initial price, capacity of the hall
     */
    public void createHall(String[] hallData) {
    	
    	Hall h = new Hall(currentUser, hallData[0], hallData[1], hallData[2], hallData[3], hallData[4]); 	
		
		listOfHall.add(h);
		System.out.println("Hall " + hallData[0] + " created.");
		System.out.println("Press [Enter] to redirecting to home page.\n");
		sc.nextLine();
    }
     
     /**
     * This method edit the detail of the hall
     */
    public void editHall() {
    	 int ed = 0;    	 
    	 for (Hall thisHall : listOfHall) {
    		 System.out.println(listOfHall.indexOf(thisHall)+1 +"."+ thisHall.getName());
    	 }
    	 System.out.println("Please choose a Hall: ");
    	 ed = Integer.parseInt(input.nextLine());
    	 
//    	 edit hall name
    	 System.out.println("Name: " + listOfHall.get(ed-1).getName());
    	 System.out.println("Change: (Maximum 15 alphabets)");
    	 String edname = input.nextLine();
//       validation hall name
    	 if (edname.trim().length()!= 0) {
    		 listOfHall.get(ed-1).setName(edname);
    		 while(edname.length() >15) {
 				System.out.println("Change: (Maximum 15 alphabets)");
 				edname = input.nextLine();
 				listOfHall.get(ed-1).setName(edname);
 				
 			}
 		 }

//       edit hall address
    	 System.out.println("Address: "+ listOfHall.get(ed-1).getAddress());
 		 System.out.println("change: (Maximum 150 alphabets)");
 		 String edaddress = input.nextLine();
// 		 validation hall address
 		 if (edaddress.trim().length()!= 0) {
 			listOfHall.get(ed-1).setAddress(edaddress);
 			while(edaddress.length() >150) {
 				System.out.println("Change: (Maximum 150 alphabets)");
 				edaddress = input.nextLine();
 				listOfHall.get(ed-1).setAddress(edaddress);
 				
 			}
 		 }
 		 
// 		 edit description
 		 System.out.println("Description: "+ listOfHall.get(ed-1).getDescription());
		 System.out.println("change: ");
		 String eddescription = input.nextLine();
//       validation description		 
		 if (eddescription.trim().length()!= 0) {
			listOfHall.get(ed-1).setDescription(eddescription);
			while(eddescription.length() >500) {
 				System.out.println("Change: (Maximum 500 alphabets)");
 				eddescription = input.nextLine();
 				listOfHall.get(ed-1).setDescription(eddescription);
 			}
		 }
		 
//		 edit price
		 System.out.println("Price: "+ listOfHall.get(ed-1).getPrice());
		 System.out.println("change: (Numbers only)");
		 String edprice = input.nextLine();
//		 validation Hall price
		 if (edprice.trim().length()!= 0) {
			 
			 while(edprice.length() >10 || isNumeric(edprice) == false) {
	 				System.out.println("Change: (Numbers only)");
	 				edprice = input.nextLine();
	 				if(isNumeric(edprice)) {
	 					double dprice = Double.parseDouble(edprice);
		 				listOfHall.get(ed-1).setPrice(dprice);
	 				}
	 			}
			 double dprice = Double.parseDouble(edprice);
			 listOfHall.get(ed-1).setPrice(dprice);
		 }
		 
//		 edit capacity
		 System.out.println("Capacity: "+ listOfHall.get(ed-1).getCapacity());
		 System.out.println("change: (Numbers only)");
		 String edcapacity = input.nextLine();
//		 validation hall capacity
		 if (edcapacity.trim().length()!= 0) {
			 while(edprice.length() >10 || isNumeric(edcapacity) == false) {
	 				System.out.println("Change: (Numbers only)");
	 				edcapacity = input.nextLine();
	 				if(isNumeric(edcapacity)) {
	 					int icapa = Integer.parseInt(edcapacity);
		 				listOfHall.get(ed-1).setCapacity(icapa);
	 				}
	 			}
			 int icapa = Integer.parseInt(edcapacity);
			 listOfHall.get(ed-1).setCapacity(icapa);
		 }
		 
		 System.out.println("Change saved.\n");
		 System.out.println("Press [Enter] to redirect to home page.\n");
		 sc.nextLine();
		 
     }
     
     /**
     * This method remove the hall from record
     */
    public void deleteHall() {
    	 int delete = 0;
    	 for (Hall thisHall : listOfHall) {
    		 System.out.println(listOfHall.indexOf(thisHall)+1 +"."+ thisHall.getName());
    	 }
    	 System.out.println("Please delete a Hall: ");
    	 delete = input.nextInt();
    	 listOfHall.remove(delete-1);
    	 
    	 System.out.println("Delete successfully.\n");
    	 System.out.println("Press [Enter] to redirecting to home page.\n");
		 
		 sc.nextLine();
    	 
     }
     
	
     /**
      * This method search for hall(s) that matches the criteria
     * @return An ArrayList of hall matches the search criteria
     */
    public ArrayList<Hall> searchHall(){
    	 ArrayList<Hall> equalHall = new ArrayList<Hall>();
    		if(currentUser.getType() == userType.owner) {
    			boolean next = false;
    			String name = "";
    			
    			while(!next) {
    				System.out.println("What is the name of the hall? Leave blank to find all hall.\n");
    				try {

    					name = input.nextLine();
    					next = true;
    				}catch(Exception e) {
    					System.out.println("Invalid input. Please try again.");
    				}
    			}
    		
    			if(name.trim().length() == 0 ) {
    				for(Hall thisHall : listOfHall) {
    					if(thisHall.getOwner().getName().toLowerCase().trim().equals(currentUser.getName().toLowerCase().trim())){
    						equalHall.add(thisHall);
    					}
    				}
    			}else {
    				for(Hall thisHall : listOfHall) {
    					if(thisHall.getName().toLowerCase().equals(name.trim().toLowerCase())) {
    						equalHall.add(thisHall);
    					}
    				}
    				
    			}
    			
    			
    			
    		} else {
    			boolean next = false;
    			float budget_low = 0;
    			float budget_high = 0;
    			int size_low = 0;
    			int size_high = 0;
    			String address = "";
    			String name = "";
    			
    			//budget
    			while(!next) {
    				System.out.println("What is your budget range?");
    				System.out.println("Lowest:");
    				try {
    					budget_low = input.nextFloat();
    					if(budget_low > 0) {
    						next = true;
    					}else {
    						System.out.println("Invalid number. Please try again");
    						next = false;
    					}
    				}catch(Exception e) {

    					System.out.println("Number only. ");
    					input.nextLine();
    					next = false;

    				}
    			}
    			next = false;
    			while(!next) {
    			
    			System.out.println("Highest:");
    			try {
    				budget_high = input.nextFloat();
    				if(budget_high >= budget_low) {
    					next = true;
    				}else {
    					System.out.println("Invalid number. Please try again");
    					next = false;
    				}
    			}catch(Exception e) {
    				System.out.println("Number only. ");
    				input.nextLine();
    				next = false;
    			}
    		
    			}		
    			//size
    			next = false;
    			while(!next) {
    				System.out.println("How many people do you have?");
    				System.out.println("Lowest:");
    				try {
    					size_low = input.nextInt();
    					if(size_low > 0) {
    						next = true;
    					}else {
    						System.out.println("Invalid number. Please try again");
    						next = false;
    					}
    				}catch(Exception e) {
    					System.out.println("Number only. ");
    					input.nextLine();
    					next = false;
    				}
    				
    			}
    			next = false;
    			while(!next) {
    				System.out.println("Highest:");
    				try {
    					size_high = input.nextInt();
    					if(size_high >= size_low) {
    						next = true;
    					}else {
    						System.out.println("Invalid number. Please try again");
    						next = false;
    					}
    				}catch(Exception e) {
    					System.out.println("Number only. ");
    					input.nextLine();
    					next = false;
    				}
    				
    			}
    			
    			//Address
    			next = false;
    			while(!next) {
    				System.out.println("Where do you want to hold the event?\n");
    				try {
    					input.nextLine();
    					address = input.nextLine();

    					if(address.trim().length() != 0) {
    						next = true;
    					}else {
    						System.out.println("Can not be blank. Please try again");
    						next = false;
    					}
    				}catch(Exception e) {
    					System.out.println("Invalid input. Please try again.");
    					input.nextLine();
    					next = false;
    				}
    				
    			}
    			
    			//Name
    			next = false;
    			while(!next) {
    				System.out.println("Have you got a keyword for name?");
    				try {
    					name = input.nextLine();
    					if(address.trim().length() != 0) {
    						next = true;
    						System.out.println("With keyword:"+name);
    					}else {
    						next = true;
    						System.out.println("No keyword:");
    					}
    				}catch(Exception e) {
    					System.out.println("Invalid input. Please try again.");
    					input.nextLine();
    					next = false;
    				}
    				
    			}
    			
    			
    			if(listOfHall == null ) {
    				return null;
    			}else {
    				for(Hall thisHall : listOfHall) {
    					if(address.trim().length() != 0) {
    						if(thisHall.getCapacity() >= size_low && thisHall.getCapacity() <= size_high && thisHall.getPrice() <= budget_high && thisHall.getPrice() >= budget_low && thisHall.getAddress().toLowerCase().trim().contains(address.toLowerCase().trim()) && thisHall.getName().toLowerCase().trim().contains(name.toLowerCase().trim())) {
    							equalHall.add(thisHall);
    						}
    					}else {
    						if(thisHall.getCapacity() >= size_low && thisHall.getCapacity() <= size_high && thisHall.getPrice() <= budget_high && thisHall.getPrice() >= budget_low && thisHall.getAddress().toLowerCase().trim().contains(address.toLowerCase().trim())) {
    							equalHall.add(thisHall);
    						}
    					}
    				}
    				
    			}
    				
    		}// end else if

    		
    		for(Hall thisHall : equalHall) {
    			System.out.println(equalHall.indexOf(thisHall) + ". " + "Hall " + thisHall.getName() + " is at " + thisHall.getAddress() 
    			+ ". Can hold " + thisHall.getCapacity() + " people.");

    		}

    		
    		
    		return equalHall;
    		
    	}
    
    /**
     * This method extract the details of the hall and let the user pick one hall
     * @param hallList An ArrayList of hall
     * @return An Hall object of user's choice
     */
    public Hall viewHall(ArrayList<Hall> hallList) {
    	Hall chooseHall = null;
    	System.out.println("Please choose the hall you want.");
    	boolean exit = false;
    	while (!exit) {
    		try {
	    		int index = input.nextInt();
	    		if (index <= (hallList.size() - 1) && index >= 0) {
	    			chooseHall = hallList.get(index);
	    			exit = true;
	    		}
	    		else {
	    			System.out.println("Choice the hall from 0 to " + (hallList.size()- 1));
	    		}
    		}catch(Exception e) {
    			System.out.println("Invalid input. Please enter number only.\\n");
    		}
    	}
    	return chooseHall;
    }
	
	/**
	 * This method create a booking record and add the record to the list Of Booking
	 * @param hall An hall object that the user wants to book
	 * @throws ParseException This exception is thrown when formating of the Simple Date Format is unacceptable
	 */
	public void createBooking(Hall hall) throws ParseException {		
			int j = 0;
			hall.setQuotationCost();
			System.out.println("Quotation:" + 1000);
			System.out.println("Do you accept the quotation? Y/N");
			boolean ifCreate = true;
			try {
				while (ifCreate) {
					String ifAccept = input.next();
					if (ifAccept.toLowerCase().equals("y"))
					{
						System.out.println("Please Enter the Booking Detail.");
						while(j == 0) {
							Booking newBook = new Booking();
							SimpleDateFormat DateFormat=new SimpleDateFormat("yyyy-MM-dd");
							String dateString = "01-01-2000";
							Date stratTime = DateFormat.parse(dateString);
							Date endTime = DateFormat.parse(dateString);
							//Enter the start time
							System.out.println("Please Enter:");		
							System.out.println("Start Date: ");
							System.out.println("In format:yyyy-MM-dd");
							String STime=input.next();
							int i = 0;
							while (i == 0 && !(STime.trim().equals("")))
							{
							try {					
									stratTime = DateFormat.parse(STime);	
									i = 1;
								} catch (Exception e) {
									System.out.println("Please Enter the Right Date Type");
									System.out.println("Start Date: ");
									System.out.println("In format:yyyy-MM-dd");
									STime = input.next();
								}
							}
							//Enter the end date
	
							System.out.println("Please Enter:");		
							System.out.println("End Date: ");
							System.out.println("In format:yyyy-MM-dd");
							String ETime=input.next();
							while (i == 0 && !(ETime.trim().equals("")));
							{
							try {
									endTime = DateFormat.parse(ETime);
									if (endTime.before(stratTime)){
										System.out.println("End date cannot be early than start date.");
										System.out.println("End Date: ");
										System.out.println("In format:yyyy-MM-dd");
										ETime=input.next();
									}
									else{
										i = 1;
									}
								} catch (Exception e) {
									System.out.println("Please Enter the Right Date Type");
									System.out.println("End Date: ");
									System.out.println("In format:yyyy-MM-dd");
									ETime=input.next();
								}
							}
							System.out.println("Press Enter to Continue");
							input.nextLine();
							input.nextLine();
							boolean ifBook = true;
							//check the time availability
							for(Hall thisHall : listOfHall) {
								if(thisHall.getName().equals(hall.getName())){
									if (thisHall.getDateArray().size() != 0) {
										for(String time:thisHall.getDateArray()) {
											String[] buffer = time.split("," , 2);
											if ((stratTime.after(DateFormat.parse(buffer[0])) && stratTime.before(DateFormat.parse(buffer[1])))
													|| (endTime.after(DateFormat.parse(buffer[0])) && endTime.before(DateFormat.parse(buffer[1])))
													|| stratTime.equals(DateFormat.parse(buffer[0])) || endTime.equals(DateFormat.parse(buffer[1]))) {
												System.out.println("The hall is unavailable between" +  buffer[0] + "and" + buffer[1]);							
												ifBook = false;
												System.out.println("Press enter to re-enter the time.");
												input.nextLine();
											}
										}
									}					
									
									if (ifBook) {
										System.out.println("Press Enter to see the Deatil of Booking");
										input.nextLine();
										System.out.println("Hall: " + hall.getName());
										System.out.println("Booking Phone: " + currentUser.getPhone());
										System.out.println("Booking Name: " + currentUser.getName());
										System.out.println("Booking Email: " + currentUser.getEmail());
										System.out.println("Booking Time: " + "from" + DateFormat.format(stratTime) + "to" + DateFormat.format(endTime));
										System.out.println("Price: " + hall.getQuotation().getCost());
										System.out.println("Owner Name: " + hall.getOwner().getName());
										System.out.println("Owner Phone: " + hall.getOwner().getPhone());
										System.out.println("Owner Email: " + hall.getOwner().getEmail());
										System.out.println("Do you want create the booking?(Y/N)");
										int b = 0;
										while(b == 0) {
											try {	
												String YorN=input.next();
												if (YorN.toLowerCase().equals("y")) {
													b = 1;
													j = 1;
													newBook.setBookingID(bookIDCount);
													bookIDCount += 1;
													newBook.setStratTime(stratTime);
													newBook.setStratTime(endTime);
													newBook.setHall(hall);
													String addDate = DateFormat.format(stratTime) + "," + DateFormat.format(endTime);
													thisHall.setDate(addDate);
													listOfBooking.add(newBook);
													System.out.println("\nHall Booking successful.");
													System.out.println("\nRedirecting to home page");	
													input.nextLine();
													}
												else if(YorN.toLowerCase().equals("n")) {
													b = 1;
													j = 1;
													System.out.println("\nHall Booking canceled.");
													input.nextLine();										
												}
												else {
													System.out.println("Please enter Y or N.");
												}
											}catch(Exception e) {
												System.out.println("Please press Y or N.");
											}
										}
									}
								}																		
							}
						}
						ifCreate = false;
						System.out.println("Press enter to back to homepage.");
						input.nextLine();
					}
					else if (ifAccept.toLowerCase().equals("n")) {
						System.out.println("Back to the Customer homepage.");
						ifCreate = false;
						System.out.println("Press enter to back to homepage.");
						input.nextLine();
					}
					else {
						System.out.println("Please enter Y or N..");
					}
				}
			}catch (Exception e) {
				System.out.println("Please press Y or N.");
				input.nextLine();
			}
	}//end create booking	


	/**
	 * This method search for the quotation for the specific hall and return the result.
	 * @param hall The Hall object that the quotation is requested
	 * @return A Hall object for further action 
	 * @throws ParseException This exception is thrown when the formatting of Simple Date Format is unacceptable 
	 */
	public Hall requestQuotation(Hall hall) throws ParseException{
		try {
			System.out.println("Press enter to show the detail of the hall");
			input.nextLine();
			System.out.println("Hall: " + hall.getName());
			System.out.println("Booking Phone: " + currentUser.getPhone());
			System.out.println("Booking Name: " + currentUser.getName());
			System.out.println("Booking Email: " + currentUser.getEmail());		
			System.out.println("Owner Name: " + hall.getOwner().getName());
			System.out.println("Owner Phone: " + hall.getOwner().getPhone());
			System.out.println("Owner Email: " + hall.getOwner().getEmail());
			System.out.println("Do you want send request?(Y/N)");

			int b = 0;
			while(b == 0) {	
				String YorN=input.next();
				if (YorN.toString().toLowerCase().equals("y")) {
					b = 1;
					System.out.println("\nRequest send successfully.");
					}
				else if(YorN.toString().toLowerCase().equals("n")) {
					b = 1;
					System.out.println("\nRequest canceled.");
					input.nextLine();	
				}
				else {					
					System.out.println("Please enter Y or N");
				}
			}
		}catch(Exception e) {
			System.out.println("Please press Y or N.");
		}
		return hall;
	}//end request quotation	
	
	/**
	 * This method check if the input is numeric
	 * @param str A string that required checking
	 * @return Boolean, True of the string is numeric and false if it is not numeric 
	 */
	public static boolean isNumeric(String str){
		for (int i = str.length();--i>=0;){ 
			if (!Character.isDigit(str.charAt(i))){
				return false;
				}
			}
		return true;
	}
}
	
	
