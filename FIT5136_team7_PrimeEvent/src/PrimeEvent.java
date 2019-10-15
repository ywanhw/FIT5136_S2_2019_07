import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class PrimeEvent {
	
	Hall hallarr[] = new Hall[100];
	private ArrayList<Booking> listOfBooking = new ArrayList<Booking>();
	private ArrayList<Hall> listOfHall = new ArrayList<Hall>();
	private ArrayList<User> listOfUsers = new ArrayList<User>();
	int bookIDCount = 20000;
	Scanner input = new Scanner(System.in);;
	User currentUser;
	
	public PrimeEvent() {

	}

		
	//Login
	public User login(String userName, String password) {		
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
					return currentUser;
				}
			}
		}
		return null;
	}
	
	//Logout
	public void logout() {
		System.out.println();
		for(int i = 0; i < 30; i ++)
			System.out.print("=");
		System.out.println("\n\nLogout successful.");
		System.out.println("\nRedirecting to home page");
		System.out.println();
		
		currentUser = null;
	}
	
	//Register
	public User register(String[] userData) {			
		//create the corresponding user object
		User newUser;
		if(userData[0] == "1") {
			newUser = new Customer(userData[1], userData[2], userData[3], userData[4], userData[5], userData[6], Boolean.parseBoolean(userData[7]));
			currentUser = newUser;
		}else {
			newUser = new Owner(userData[1], userData[2], userData[3], userData[4], userData[5], userData[6]);
			currentUser = newUser;
		}
		
		//return to home
		System.out.println("\nRegister successful.");
		System.out.println("\nRedirecting to home page\n");
		System.out.println();
		
		//display based on user
		return currentUser;
		
	}
	
	//Search

     public void createHall(String[] hallData) {
    	
    	Hall h = new Hall(currentUser, hallData[0], hallData[1], hallData[2], hallData[3], hallData[4]); 	
		
		listOfHall.add(h);
		System.out.println("Hall " + hallData[0] + " created.");
		System.out.println("Redirecting to home page.\n");
    }
     
     public void editHall() {
    	 int ed = 0;
    	 
    	 for(int i = 0; i<=listOfHall.size();i++) {
    		 System.out.println(i+1 +"."+ listOfHall.get(i).getName());
    	 }
    	 ed = input.nextInt();
    	 System.out.println("name: " + listOfHall.get(ed-1).getName());
    	 System.out.println("change: ");
    	 String edname = input.nextLine();
    	 if (edname != null) {
    		 listOfHall.get(ed-1).setName(edname);
 		 }
    	 System.out.println("Address: "+ listOfHall.get(ed-1).getAddress());
 		 System.out.println("change: ");
 		 String edaddress = input.nextLine();
 		 if (edaddress != null) {
 			listOfHall.get(ed-1).setAddress(edaddress);
 		 }
 		 System.out.println("Description: "+ listOfHall.get(ed-1).getDescription());
		 System.out.println("change: ");
		 String eddescription = input.nextLine();
		 if (eddescription != null) {
			listOfHall.get(ed-1).setDescription(eddescription);
		 }
		 	 
     }
//	public void editHall() {
//		int ed =0;
//		System.out.println("Please choose Hall number:");
//		int x = 0;
//		index: for(int j=0; j<hallarr.length;j++) {
//			if(hallarr[j] != null) {
//				x = j;
//			}
//			else {
//				break index;
//			}
//		}
//		for(int i=0; i<=x;i++) {
//			System.out.println(i+1 + "."+ hallarr[i].getName());
//		}
//		ed = input.nextInt();
//		// modify name
//		System.out.println("Name: "+ hallarr[ed-1].getName());
//		System.out.println("change: ");
//		String edname = input.nextLine();
//		edname = input.nextLine();
//		if (edname != null) {
//			hallarr[ed-1].setName(edname);
//		}
//		sc.nextLine();
//		
//		// modify address;
//		System.out.println("Address: "+ hallarr[ed-1].getAddress());
//		System.out.println("change: ");
//		String edaddress = input.nextLine();
//		if (edaddress != null) {
//			hallarr[ed-1].setAddress(edaddress);
//		}
//
//		// modify phoneNumber
//		System.out.println("Phone Number: "+ hallarr[ed-1].getNumber());
//		System.out.println("change: ");
//		String ednumber = input.nextLine();
//		if (ednumber != null) {
//			hallarr[ed-1].setNumber(ednumber);
//		}
//
//		// modify Email
//		System.out.println("Email: "+ hallarr[ed-1].getEmail());
//		System.out.println("change: ");
//		String edemail = input.nextLine();
//		if (edemail != null) {
//			hallarr[ed-1].setEmail(edemail);
//		}
//
//		// modify description
//		System.out.println("Description: "+ hallarr[ed-1].getDescription());
//		System.out.println("change: ");
//		String eddes = input.nextLine();
//		if (eddes != null) {
//			hallarr[ed-1].setDescription(eddes);
//		}
//
//		// modify Event
//		System.out.println("Event: "+ hallarr[ed-1].getEvent());
//		System.out.println("change: ");
//		String edevent = input.nextLine();
//		if (edevent != null) {
//			hallarr[ed-1].setEvent(edevent);
//		};
//
//		// modify Size
//		System.out.println("Size: "+ hallarr[ed-1].getSize());
//		System.out.println("change: ");
//		String edsize = input.nextLine();
//		if (edsize != null) {
//			hallarr[ed-1].setSize(edsize);
//		};
//		
//		// modify price
//		System.out.println("Price: "+ hallarr[ed-1].getPrice());
//		System.out.println("change: ");
//		String edprice = input.nextLine();
//		if (edprice != null) {
//			hallarr[ed-1].setPrice(edprice);
//		};
//		
//		
//
//		
//		System.out.println("\nChange saved.");
//		System.out.println("\nRedirecting to home page\n");
//		System.out.println();
//		
//		sc.nextLine();
//		
//		//display based on user
//		ui.displayHomePage("owner");
//		
//		
//	}
     
     //search booking
	
     public ArrayList<Hall> searchHall(){
    	 ArrayList<Hall> equalHall = new ArrayList<Hall>();
    		if(currentUser.getType() == userType.owner) {
    			boolean next = false;
    			String name = "";
    			
    			while(!next) {
    				System.out.println("What is the name of the hall? Leave blank to find all hall.");
    				try {
    					name = input.nextLine();
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
    					}
    				}catch(Exception e) {
    					System.out.println("Number only. Please try again.");
    				}
    			}
    			
    			System.out.println("Highest:");
    			try {
    				budget_high = input.nextFloat();
    				if(budget_high >= budget_low) {
    					next = true;
    				}else {
    					System.out.println("Invalid number. Please try again");
    				}
    			}catch(Exception e) {
    				System.out.println("Number only. Please try again.");
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
    					}
    				}catch(Exception e) {
    					System.out.println("Number only. Please try again.");
    				}
    				
    				System.out.println("Highest:");
    				try {
    					size_high = input.nextInt();
    					if(size_high >= size_low) {
    						next = true;
    					}else {
    						System.out.println("Invalid number. Please try again");
    					}
    				}catch(Exception e) {
    					System.out.println("Number only. Please try again.");
    				}
    				
    			}
    			
    			//Address
    			next = false;
    			while(!next) {
    				System.out.println("Where do you want to hold the event?");
    				try {
    					address = input.nextLine();
    					if(address.trim().length() != 0) {
    						next = true;
    					}else {
    						System.out.println("Can not be blank. Please try again");
    					}
    				}catch(Exception e) {
    					System.out.println("Invalid input. Please try again.");
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
    			System.out.print("Hall " + thisHall.getName() + " is at " + thisHall.getAddress() 
    			+ ". Can hold " + thisHall.getCapacity() + " people.");
    		}
    		return equalHall;
    		
    	}
	
	public void createBooking() throws ParseException {		
		Hall hall = null;
		boolean found = false;
		String likeThis = "";
		int times = 0;
		ArrayList<Hall> result = new ArrayList<Hall>();
		System.out.println("Please look for the hall you would like to book.");
		result = searchHall();
		while(!found) {
			System.out.println("Please enter the name of the hall that you like.");
			likeThis = input.next();
			for(Hall thisHall : result){
				if(likeThis.toLowerCase().trim().equals(thisHall.getName().toLowerCase().trim())) {
					hall = thisHall;
					found = true;
				}
			}
			if(!found && times <= 3) {
				System.out.println("Please check your typing.");
				times += 1;
			}
		}
		
		if(!found) {
			System.out.println("Failed too many times. Redirecting to home....");
		} else {
			int j = 0;
			while(j == 0) {
				Booking newBook = new Booking();
				SimpleDateFormat DateFormat=new SimpleDateFormat("dd-mm-yyyy");
				String dateString = "01-01-2000";
				Date stratTime = DateFormat.parse(dateString);
				Date endTime = DateFormat.parse(dateString);
		
		
				System.out.println("Please Enter the Booking Detail.");
				//Enter the start time
				System.out.println("Please Enter:");		
				System.out.println("Start Date: ");
				System.out.println("In format:dd-mm-yyyy");
				String STime=input.nextLine();
				int i = 0;
				while (i == 0 && !(STime.trim().equals("")))
				{
				try {					
						stratTime = DateFormat.parse(STime);	
						i = 1;
					} catch (Exception e) {
						System.out.println("Please Enter the Right Date Type");
						STime = input.nextLine();
					}
				}
				//Enter the end date
				System.out.println("Please Enter:");		
				System.out.println("End Date: ");
				System.out.println("In format:dd-mm-yyyy");
				String ETime=input.nextLine();
				while (i == 0 && !(ETime.trim().equals("")));
				{
				try {
						endTime = DateFormat.parse(ETime);
						newBook.setStratTime(endTime);
						i = 1;
					} catch (Exception e) {
						System.out.println("Please Enter the Right Date Type");
						ETime=input.nextLine();
					}
				}
				System.out.println("Press Enter to Continue");
				input.nextLine();
				//check the time availability
				for(Hall thisHall : listOfHall) {
					if(thisHall.getName().equals(hall.getName())){
						for(String time:thisHall.getDateArray()) {
							String[] buffer = time.split("," , 2);
							if ((stratTime.after(DateFormat.parse(buffer[0])) && stratTime.before(DateFormat.parse(buffer[1])))
									|| (endTime.after(DateFormat.parse(buffer[0])) && endTime.before(DateFormat.parse(buffer[1])))) {
								System.out.println("The hall is unavailable between" +  buffer[0] + "and" + buffer[1]);							
								System.out.println("Press enter to re-enter the time.");
								input.nextLine();
							}
							else {
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
								String YorN=input.nextLine();
								int b = 0;
								while(b == 0) {
									try {									
										if (YorN.toString().toLowerCase().equals("y")) {
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
											}
										else if(YorN.toString().toLowerCase().equals("n")) {
											b = 1;
											j = 1;
											System.out.println("\nHall Booking canceled.");
											System.out.println("Press enter to back to homepage.");
											input.nextLine();										
										}
									}catch(Exception e) {
										System.out.println("Please press Y or N.");
									}
								}
							}
						}
					
				
				
					}
				}
			}
		}
	}//end create booking

	
	

	//Quotation page
	public void requestQuotation() {
		String name = "";
		String dateTime = "";
		String event = "";
		
		System.out.println();
		for(int i = 0; i < 30; i ++)
			System.out.print("=");
		
		System.out.println("\nRequest Quotation\n");
		
		System.out.println("Hall Name: ");
		input.nextLine();
		name = input.nextLine();
		
		System.out.println("Date and Time: ");
		dateTime = input.nextLine();
		
		System.out.println("Event: ");
		event = input.nextLine();
		
		System.out.println("A request has been sent.");
		System.out.println("\nRedirecting to home page\n");
		System.out.println();		
	}
	
	public void header() {
		for(int i = 0; i < 30; i ++)
			System.out.print("=");
		System.out.println("\nPrime Event Booking System");
		for(int i = 0; i < 30; i ++)
			System.out.print("=");
	}
	
//	public void start() {
//		ui.displayHomePage("home");
//	}
//	
//	public static void main(String[] args) {
//		
//		PrimeEvent primeEvent = new PrimeEvent();
//		primeEvent.start();
		
					

	}
	
	
	
	







//String arr[] = {"p0","p1","p2","p3","p4","p5","p6","p7","p8","p9","p10"};
//
//check: for (int i=0; i<hallarr.length;i++) {
//	if(hallarr[i] != null) {
//		i = i+1;
//	}
//	else {
//		Hall arr[i] = new Hall();
//		break check;
//	}
//}