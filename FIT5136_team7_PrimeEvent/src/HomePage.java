package search;
import java.util.Scanner;

public class HomePage {
	
	Hall hallarr[] = new Hall[100];
	
	Scanner input;
	
	public HomePage() {
		input = new Scanner(System.in);
	}

	//Home page
	public void allHome(int pageNumber) {
		String choice = "";
		boolean end = false;
		String [] printChoice = new String [] {"[1/2/3]", "[1/2/3/4]", "[1/2/3/4]", "[1/2/3]" };
		
		//Welcome and choose next action
		header();
		
		while(!end) {
			System.out.println("\nHome\n");
			System.out.println("Choose to proceed");
			
			//0 = universial page
			//1 = Customer page
			//2 = Hall owner page
			//3 = Admin page
			switch(pageNumber) {
			
			case 0: 
				System.out.println("1. Login");
				System.out.println("2. Register");
				System.out.println("3. Exit");
				//Ask for choice
				System.out.print("Your choice " + printChoice[pageNumber] + ": ");
				choice = input.next();
				if(choice.equals("1")) {
					login();
					end = true;
				}else if(choice.equals("2")) {
					register();
					end = true;
				}else if(choice.equals("3")) {
					System.out.print("You sure you want to exit [y/n]? ");
					choice = input.next();
					if(choice.toLowerCase().equals("y")) {
						System.out.println("\n\nGood bye");
						end = true;
					}else {
						System.out.println();
					}
				}else {
					System.out.println("Invalid input. Please input the corresponding number of your choice [1/2/3].\n");
				}
				break;
			
			case 1:
				end = customerHome(printChoice[pageNumber]);
				break;
				
			case 2:
				end = hallOwnerHome(printChoice[pageNumber]);
				break;
			
			case 3:
				end = adminHome(printChoice[pageNumber]);
				break;				
			}//end switch
			
		}//end while
	}//end allHome
	
	public boolean customerHome(String printChoice) {
		String choice = "";
		boolean end = false;
		
		while(!end) {
			System.out.println("1. Manage Booking");
			System.out.println("2. Search Hall");
			System.out.println("3. Request Quotation");
			System.out.println("4. Logout");
			
			System.out.print("Your choice " + printChoice + ": ");
			choice = input.next();
			
			if(choice.equals("1")) {
				
				manageBook();
				end = true;
			}else if(choice.equals("2")) {
				
				searchHall();
				end = true;
			}else if(choice.equals("3")) {
				requestQuotation();
				end = true;
			}else if(choice.equals("4")) {
				System.out.print("You sure you want to logout [y/n]? ");
				choice = input.next();
				if(choice.toLowerCase().equals("y")) {
					logout();
					end = true;
				}else {
					System.out.println();
				}
			}else {
				System.out.println("Invalid input. Please input the corresponding number of your choice [1/2/3/4].\n");
			}
			
		}//end While
		return true;
	}//end CustomerHome
	
	public boolean hallOwnerHome(String printChoice) {
		String choice = "";
		boolean end = false;
		
		while(!end) {
			System.out.println("1. Manage Booking");
			System.out.println("2. Manage Hall");
			System.out.println("3. Manage Discount");
			System.out.println("4. Logout");
			
			System.out.print("Your choice " + printChoice + ": ");
			choice = input.next();
			
			if(choice.equals("1")) {
				
				tick();
				break;
			}else if(choice.equals("2")) {
				manageHall();
				end = true;
			}else if(choice.equals("3")) {
				//Manage discount
				break;
			}else if(choice.equals("4")) {
				System.out.print("You sure you want to logout [y/n]? ");
				choice = input.next();
				if(choice.toLowerCase().equals("y")) {
					logout();
					break;
				}else {
					System.out.println();
				}
			}else {
				System.out.println("Invalid input. Please input the corresponding number of your choice [1/2/3/4].\n");
			} //end choice
	
		}//end While
		return true;
	}//end hallOwnerHome
	
	public boolean adminHome(String printChoice) {
		String choice = "";
		boolean end = false;
		
		while(!end) {
			System.out.println("1. Manage Users");
			System.out.println("2. Manage Discounts");
			System.out.println("3. Logout");
			
			System.out.print("Your choice " + printChoice + ": ");
			choice = input.next();
			
			if(choice.equals("1")) {
				//Manage user page
				end = true;
			}else if(choice.equals("2")) {
				//Manage discount page
				end = true;
			}else if(choice.equals("3")) {
				System.out.print("You sure you want to logout [y/n]? ");
				choice = input.next();
				if(choice.toLowerCase().equals("y")) {
					logout();
					end = true;
				}else {
					System.out.println();
				}
			}else {
				System.out.println("Invalid input. Please input the corresponding number of your choice [1/2/3].\n");
			}
			
		}//end while
		return true;
	}//end adminHome
	
	
	//Login
	public void login() {
		String userName = "";
		String password = "";
		
		System.out.println();
		for(int i = 0; i < 30; i ++)
			System.out.print("=");
		
		System.out.println("\nLogin\n");
		System.out.println("Username: ");
		input.nextLine();
		userName = input.nextLine();
		System.out.println("Password: ");
		password = input.nextLine();
		
		//Verify details
		
		//Display page based on user's privilege
		System.out.println("\nLogin successful." + "\nWelcome " + userName);
		System.out.println("\nRedirecting to home page\n");
		System.out.println();
		allHome(1);
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
		allHome(0);
	}
	
	//Register
	public void register() {
		int type = 0;
		System.out.println();
		for(int i = 0; i < 30; i ++)
			System.out.print("=");
		System.out.println("\nRegister\n");
		
		do {
			try {
				System.out.println("Choose to continue");
				System.out.println("1. Customer");
				System.out.println("2. Hall Owner");
				System.out.print("Your choice [1/2]? ");
				type = input.nextInt();
				System.out.println(type);
			} catch (Exception e) {
				System.out.print("Invalid input. Please choose again.");
			}
		}while(type != 1 && type != 2);
			
		System.out.println("First Name: ");
		input.nextLine();
		input.nextLine();
		System.out.println("Last Name: ");
		input.nextLine();
		System.out.println("Email: ");
		input.nextLine();
		System.out.println("Phone Number:");
		input.nextLine();
		System.out.println("Address");
		input.nextLine();
		System.out.println("Username: ");
		input.nextLine();
		System.out.println("Password: ");
		input.nextLine();
		
		if(type == 1) {
			System.out.println("Do you have concession [y/n]?");
			input.nextLine();
		}
		//create the corresponding user object
		
		//return to home
		System.out.println("\nRegister successful.");
		System.out.println("\nRedirecting to home page\n");
		System.out.println();
		
		//display based on user
		allHome(type);
		
	}
	
	//Search
	
	//Manage Hall
	public void manageHall() {
		int ch = 0;
		System.out.println();
		for(int i = 0; i < 30; i ++)
			System.out.print("=");
		System.out.println("\nManage Hall\n");
		
		do {
			try {
				System.out.println("Choose to continue");
				System.out.println("1. Create Hall");
				System.out.println("2. Edit Hall");
				System.out.print("Your choice [1/2]? ");
				ch = input.nextInt();
				System.out.println(ch);
			} catch (Exception e) {
				System.out.print("Invalid input. Please choose again.");
			}
		}while(ch != 1 && ch != 2);
		
		Hall p0 = new Hall();
		Hall p1 = new Hall();
		Hall p2 = new Hall();
		
		if(hallarr[0] == null) {
			System.out.println("Hall Name: ");
			input.nextLine();
			p0.setName(input.nextLine());
			System.out.println("Address: ");
			p0.setAddress(input.nextLine());
			System.out.println("Email: ");
			p0.setEmail(input.nextLine());
			System.out.println("Phone Number:");
			p0.setNumber(input.nextLine());
			System.out.println("Description");
			p0.setDescription(input.nextLine());
			System.out.println("Event: ");
			p0.setEvent(input.nextLine());
			System.out.println("Size: ");
			p0.setSize(input.nextLine());
			System.out.println("Price: ");
			p0.setPrice(input.nextLine());
			
		};
		
		if(hallarr[0] != null && hallarr[1] == null) {
			System.out.println("Hall Name: ");
			input.nextLine();
			p1.setName(input.nextLine());
			System.out.println("Address: ");
			p1.setAddress(input.nextLine());
			System.out.println("Email: ");
			p1.setEmail(input.nextLine());
			System.out.println("Phone Number:");
			p1.setNumber(input.nextLine());
			System.out.println("Description");
			p1.setDescription(input.nextLine());
			System.out.println("Event: ");
			p1.setEvent(input.nextLine());
			System.out.println("Size: ");
			p1.setSize(input.nextLine());
			System.out.println("Price: ");
			p1.setPrice(input.nextLine());
		};
		
		if(hallarr[1] != null && hallarr[2] == null) {
			System.out.println("Hall Name: ");
			input.nextLine();
			p2.setName(input.nextLine());
			System.out.println("Address: ");
			p2.setAddress(input.nextLine());
			System.out.println("Email: ");
			p2.setEmail(input.nextLine());
			System.out.println("Phone Number:");
			p2.setNumber(input.nextLine());
			System.out.println("Description");
			p2.setDescription(input.nextLine());
			System.out.println("Event: ");
			p2.setEvent(input.nextLine());
			System.out.println("Size: ");
			p2.setSize(input.nextLine());
			System.out.println("Price: ");
			p2.setPrice(input.nextLine());
		};
		
		hallarr[0] = p0;
		if(p1.getName() != null) {
			hallarr[1] = p1;
		}
		if(p2.getName() != null) {
			hallarr[2] = p2;
		}
		
//		if(p1.getName() != null) {
//			System.out.println("name: "+ hallarr[1].getName());
//		}
		
		
		System.out.println("\nChange saved.");
		System.out.println("\nRedirecting to home page\n");
		System.out.println();
		
		//display based on user
		allHome(2);
	}
	
	//search hall
	public void searchHall() {
		String search = "";

		System.out.println();
		for(int i = 0; i < 30; i ++)
			System.out.print("=");
		System.out.println("\nSearch Hall\n");
		
		System.out.println("Size (metre^2): ");
		input.nextLine();
		String size = input.nextLine();
		System.out.println("Name: ");
		String name = input.nextLine();
		System.out.println("Price: ");
		String price = input.nextLine();
		if(hallarr[0] == null) {
			System.out.println("There is no availible Halls, please try again");
			allHome(1);
		}
		for(int i=0;i<100;i++) {
			
			if(hallarr[i].getName().equals(name) && hallarr[i].getSize().equals(size) && hallarr[i].getPrice().equals(price)) {
				System.out.println("Display hall infomation");
				System.out.println("Name:"+hallarr[i].getName());
				System.out.println("Owner:"+hallarr[i].getOwner());
				System.out.println("Address:"+hallarr[i].getAddress());
				System.out.println("Number:"+hallarr[i].getNumber());
				System.out.println("Description:"+hallarr[i].getDescription());
				System.out.println("Email:"+hallarr[i].getEmail());
				System.out.println("Event:"+hallarr[i].getEvent());
				System.out.println("Price:"+hallarr[i].getPrice());
				
				System.out.println("Do you want create a booking?([y/n])");
				String choice = input.next();
				if(choice.toLowerCase().equals("y")) {
					createBook();
					
				}else {
					System.out.println("There is no availible Halls, please try again");
					allHome(1);
				}
			}else {
				allHome(1);
			}
			
			if(hallarr[i].getName()== null && hallarr[i].getSize().equals(size) && hallarr[i].getPrice().equals(price)) {
				System.out.println("Display hall infomation");
				System.out.println("Name:"+hallarr[i].getName());
				System.out.println("Owner:"+hallarr[i].getOwner());
				System.out.println("Address:"+hallarr[i].getAddress());
				System.out.println("Number:"+hallarr[i].getNumber());
				System.out.println("Description:"+hallarr[i].getDescription());
				System.out.println("Email:"+hallarr[i].getEmail());
				System.out.println("Event:"+hallarr[i].getEvent());
				System.out.println("Price:"+hallarr[i].getPrice());
				
				System.out.println("Do you want create a booking?([y/n])");
				String choice = input.next();
				if(choice.toLowerCase().equals("y")) {
					createBook();
					
				}else {
					System.out.println("There is no availible Halls, please try again");
					allHome(1);
				}
			}else {
				allHome(1);
			}
			
			if(hallarr[i].getName().equals(name) && hallarr[i].getSize()== null && hallarr[i].getPrice().equals(price)) {
				System.out.println("Display hall infomation");
				System.out.println("Name:"+hallarr[i].getName());
				System.out.println("Owner:"+hallarr[i].getOwner());
				System.out.println("Address:"+hallarr[i].getAddress());
				System.out.println("Number:"+hallarr[i].getNumber());
				System.out.println("Description:"+hallarr[i].getDescription());
				System.out.println("Email:"+hallarr[i].getEmail());
				System.out.println("Event:"+hallarr[i].getEvent());
				System.out.println("Price:"+hallarr[i].getPrice());
				
				System.out.println("Do you want create a booking?([y/n])");
				String choice = input.next();
				if(choice.toLowerCase().equals("y")) {
					createBook();
					
				}else {
					System.out.println("There is no availible Halls, please try again");
					allHome(1);
				}
			}else {
				allHome(1);
			}
			
			if(hallarr[i].getName().equals(name) && hallarr[i].getSize().equals(size) && hallarr[i].getPrice()== null) {
				System.out.println("Display hall infomation");
				System.out.println("Name:"+hallarr[i].getName());
				System.out.println("Owner:"+hallarr[i].getOwner());
				System.out.println("Address:"+hallarr[i].getAddress());
				System.out.println("Number:"+hallarr[i].getNumber());
				System.out.println("Description:"+hallarr[i].getDescription());
				System.out.println("Email:"+hallarr[i].getEmail());
				System.out.println("Event:"+hallarr[i].getEvent());
				System.out.println("Price:"+hallarr[i].getPrice());
				
				System.out.println("Do you want create a booking?([y/n])");
				String choice = input.next();
				if(choice.toLowerCase().equals("y")) {
					createBook();
					
				}else {
					System.out.println("There is no availible Halls, please try again");
					allHome(1);
				}
			}else {
				allHome(1);
			}
			
			if(hallarr[i].getName()== null && hallarr[i].getSize()== null && hallarr[i].getPrice().equals(price)) {
				System.out.println("Display hall infomation");
				System.out.println("Name:"+hallarr[i].getName());
				System.out.println("Owner:"+hallarr[i].getOwner());
				System.out.println("Address:"+hallarr[i].getAddress());
				System.out.println("Number:"+hallarr[i].getNumber());
				System.out.println("Description:"+hallarr[i].getDescription());
				System.out.println("Email:"+hallarr[i].getEmail());
				System.out.println("Event:"+hallarr[i].getEvent());
				System.out.println("Price:"+hallarr[i].getPrice());
				
				System.out.println("Do you want create a booking?([y/n])");
				String choice = input.next();
				if(choice.toLowerCase().equals("y")) {
					createBook();
					
				}else {
					System.out.println("There is no availible Halls, please try again");
					allHome(1);
				}
			}else {
				allHome(1);
			}
			
			if(hallarr[i].getName()== null && hallarr[i].getSize().equals(size) && hallarr[i].getPrice()== null) {
				System.out.println("Display hall infomation");
				System.out.println("Name:"+hallarr[i].getName());
				System.out.println("Owner:"+hallarr[i].getOwner());
				System.out.println("Address:"+hallarr[i].getAddress());
				System.out.println("Number:"+hallarr[i].getNumber());
				System.out.println("Description:"+hallarr[i].getDescription());
				System.out.println("Email:"+hallarr[i].getEmail());
				System.out.println("Event:"+hallarr[i].getEvent());
				System.out.println("Price:"+hallarr[i].getPrice());
				
				System.out.println("Do you want create a booking?([y/n])");
				String choice = input.next();
				if(choice.toLowerCase().equals("y")) {
					createBook();
					
				}else {
					System.out.println("There is no availible Halls, please try again");
					allHome(1);
				}
			}else {
				allHome(1);
			}
			
			if(hallarr[i].getName().equals(name) && hallarr[i].getSize()== null && hallarr[i].getPrice()== null) {
				System.out.println("Display hall infomation");
				System.out.println("Name:"+hallarr[i].getName());
				System.out.println("Owner:"+hallarr[i].getOwner());
				System.out.println("Address:"+hallarr[i].getAddress());
				System.out.println("Number:"+hallarr[i].getNumber());
				System.out.println("Description:"+hallarr[i].getDescription());
				System.out.println("Email:"+hallarr[i].getEmail());
				System.out.println("Event:"+hallarr[i].getEvent());
				System.out.println("Price:"+hallarr[i].getPrice());
				
				System.out.println("Do you want create a booking?([y/n])");
				String choice = input.next();
				if(choice.toLowerCase().equals("y")) {
					createBook();
					
				}else {
					System.out.println("There is no availible Halls, please try again");
					allHome(1);
				}
			}else {
				allHome(1);
			}
			
			if(hallarr[i].getName()== null && hallarr[i].getSize()== null && hallarr[i].getPrice()== null) {
				System.out.println("Display hall infomation");
				System.out.println("Name:"+hallarr[i].getName());
				System.out.println("Owner:"+hallarr[i].getOwner());
				System.out.println("Address:"+hallarr[i].getAddress());
				System.out.println("Number:"+hallarr[i].getNumber());
				System.out.println("Description:"+hallarr[i].getDescription());
				System.out.println("Email:"+hallarr[i].getEmail());
				System.out.println("Event:"+hallarr[i].getEvent());
				System.out.println("Price:"+hallarr[i].getPrice());
				
				System.out.println("Do you want create a booking?([y/n])");
				String choice = input.next();
				if(choice.toLowerCase().equals("y")) {
					createBook();
					
				}else {
					System.out.println("There is no availible Halls, please try again");
					allHome(1);
				}
			}else {
				allHome(1);
			}
			
			
		}
		
	}
	
	public void manageBook() {
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
		
		allHome(1);
	}
	public void createBook() {
		String create = "";
		System.out.println("Please select one of the given results to book:");
		System.out.println("[1. Fake1, 2. Fake2, 3. Fake3, 4. Fake4, 5. Fake5]");
		System.out.println("Your choice?");
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
		
		System.out.println("\nHall Booking successful.");
		System.out.println("\nRedirecting to home page");
		System.out.println();
		
		allHome(1);
	}
	
	public void tick() {
		System.out.println();
		for(int i = 0; i < 30; i ++)
			System.out.print("=");
		System.out.println("\nManage Booking\n");
		System.out.println("There is no booking ");
		System.out.println("\nRedirecting to home page");
		allHome(2);
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
		allHome(1);
		
	}
	
	
	
	public void header() {
		for(int i = 0; i < 30; i ++)
			System.out.print("=");
		System.out.println("\nPrime Event Booking System");
		for(int i = 0; i < 30; i ++)
			System.out.print("=");
	}
	public static void main(String[] args) {
		
		HomePage homePage = new HomePage();
		homePage.allHome(0);
	

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