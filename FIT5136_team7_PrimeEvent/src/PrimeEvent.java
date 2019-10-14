import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import search.Hall;

public class PrimeEvent {
	
	Hall hallarr[] = new Hall[100];
	private ArrayList<Booking> listOfBooking = new ArrayList<Booking>();
	private ArrayList<Hall> listOfHall = new ArrayList<Hall>();
	private ArrayList<User> listOfUsers = new ArrayList<User>();
	int bookIDCount = 20000;
	Scanner input;
	Scanner sc = new Scanner(System.in);
	UserInterface ui = new UserInterface();
	User currentUser = new User();
	
	public PrimeEvent() {
		input = new Scanner(System.in);
	}

		
	//Login
	public void login(String userName, String password) {		
		//Verify details
		boolean found = false;
		for(User thisUser : listOfUsers) {
			if(thisUser.getUsername().equals(userName)) {
				if(thisUser.getPassword().equals(password)) {
					//Display page based on user's privilege
					System.out.println("\nLogin successful." + "\nWelcome " + userName);
					System.out.println("\nRedirecting to home page\n");
					System.out.println();
					ui.displayHomePage(thisUser.getType());
					currentUser = thisUser;
				}
			}
		}
	}
	
	//Logout
	public void logout() {
		System.out.println();
		for(int i = 0; i < 30; i ++)
			System.out.print("=");
		System.out.println("\n\nLogout successful.");
		System.out.println("\nRedirecting to home page");
		System.out.println();
		
		//return to home
		ui.displayHomePage("home");;
	}
	
	//Register
	public void register(String[] userData) {			
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
		ui.displayHomePage(newUser.getType());
		
	}
	
	//Search

     public void createHall(String[] hallData) {
    	
    	Hall h = new Hall(currentUser, hallData[0], hallData[1], hallData[3], hallData[5], hallData[4]); 	
		
		listOfHall.add(h);
		System.out.println("Hall " + hallData[0] + " created.");
		System.out.println("Redirecting to home page.\n");
		ui.displayHomePage(currentUser.getType());
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
	
 	public Hall searchHall_Owner(ArrayList<Hall> listOfHall, String name) {
		for(Hall thisHall : listOfHall) {
			if(thisHall.getName().toLowerCase().trim().equals(name.toLowerCase().trim())) {
				return thisHall;
			}
		}
		
	}
	
	public ArrayList<Hall> searchHall_Cust(ArrayList<Hall> listOfHall, String name, int capacity, double price, String address) {
		ArrayList<Hall> equalHall = new ArrayList<Hall>();
		if(listOfHall == null ) {
			return null;
		}else {
			for(Hall thisHall : listOfHall) {
				if(thisHall.getName().toLowerCase().trim().equals(name.toLowerCase().trim()) && thisHall.getCapacity() == capacity && thisHall.getPrice() == price && thisHall.getAddress().toLowerCase().trim().equals(address.toLowerCase().trim())) {
					equalHall.add(thisHall);
				}
			}
			
		}
		return equalHall;
	}
	
	
	public void manageBooking() {
		System.out.println();
		for(int i = 0; i < 30; i ++)
			System.out.print("=");
		System.out.println("\nEdit Booking\n");
		
		System.out.println("Booking number: ");
		input.nextLine();
		input.nextLine();
		System.out.println("Start Date: ");
		input.nextLine();
		System.out.println("Duration: ");
		input.nextLine();
		System.out.println("Propose: ");
		input.nextLine();
		System.out.println("Name:");
		input.nextLine();
		System.out.println("Email:");
		input.nextLine();
		System.out.println("Phone Number: ");
		input.nextLine();
		
		System.out.println("\nBooking changed.");
		System.out.println("\nRedirecting to home page");
		System.out.println();
		
		ui.displayHomePage(currentUser.getType());
	}
	
	public void createBooking(Hall hall, User currentUser) {
		Booking newBook = new Booking();
		Date stratTime;
		Date endTime;
		//String create = "";
		System.out.println("Please Enter the Booking Detail.");
		System.out.println("Please Enter:");		
		System.out.println("Start Date: ");
		System.out.println("In format:dd-mm-yyyy");
		String STime=input.nextLine();
		SimpleDateFormat format=new SimpleDateFormat("dd-mm-yyyy");
		int i = 0;
		while (i == 0 && STime.trim() != "")
			{
			try {
					STime=input.nextLine();
					stratTime = format.parse(STime);
					newBook.setStratTime(stratTime);
					i = 1;
				} catch (Exception e) {
					System.out.println("Please Enter the Right Date Type");
				}
			}
		String ETime=input.nextLine();
		while (i == 0 && ETime.trim() != "")
		{
		try {
				ETime=input.nextLine();
				endTime = format.parse(ETime);
				newBook.setStratTime(endTime);
				i = 1;
			} catch (Exception e) {
				System.out.println("Please Enter the Right Date Type");
			}
		}

		newBook.setHall(hall);
		newBook.setBookingID(bookIDCount);
		System.out.println("Press Enter to see the Deatil of Booking");
		input.nextLine();
		System.out.println("Do you want create the booking?(Y/N)");
		int a = 0;
		while ( a == 0) {
			try {
				String YorN=input.nextLine();
				if (YorN.toString().toLowerCase() == "y") {
					listOfBooking.add(newBook);
					System.out.println("\nHall Booking successful.");
					System.out.println("\nRedirecting to home page");
					a = 1;
					ui.displayHomePage(currentUser.getType());
				}
				else if(YorN.toString().toLowerCase() == "n") {
					System.out.println("\nHall Booking canceled.");
					System.out.println("Press enter to back to homepage.");
					input.nextLine();
					ui.displayHomePage(currentUser.getType());
					a = 1;
				}
			}catch(Exception e) {
				System.out.println("Please press Y or N.");
			}
		}
		

		
		
	}
	

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
		ui.displayHomePage("customer");
		
	}
	
	public void header() {
		for(int i = 0; i < 30; i ++)
			System.out.print("=");
		System.out.println("\nPrime Event Booking System");
		for(int i = 0; i < 30; i ++)
			System.out.print("=");
	}
	
	public void start() {
		ui.displayHomePage("home");
	}
	
	public static void main(String[] args) {
		
		PrimeEvent primeEvent = new PrimeEvent();
					

	}
	
	
	
	

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