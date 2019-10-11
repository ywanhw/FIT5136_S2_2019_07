import java.util.Scanner;
/**
 * @author Adrian
 *
 */
public class UserInterface {
	
	public UserInterface() {
		
	}
	
	public void displayHomePage(String page) {
		 Scanner input = new Scanner(System.in);
		 PrimeEvent controller = new PrimeEvent();
         int choice = 0;
         boolean exit = false;
		
		//header
		header("Welcome to PrimeEvent");

		//Home page before log in : 1.Login, 2.Register, 3.Exit

		if(page.toLowerCase() == "home"){
			while(!exit) {
				System.out.println("1. Login");
				System.out.println("2. Register");
				System.out.println("3. Exit");
				System.out.println(" Your choice? [1/2/3]");
				try {
					choice = input.nextInt();
					if(choice == 1) {
						header("Login");
						System.out.println("UserID:");
						String userName = input.nextLine();
						System.out.println("Password:");
						String password = input.nextLine();
						if(controller.login(userName, password)) {
							exit = true;							
						}
						
					}
					else if(choice == 2) {
						header("Register");
						String [] userData = new String[8];
						System.out.println("Are you a 1.Customer or a 2.Hall owner? [1/2]");
						userData[0] = input.nextLine();
						System.out.println("Name:");
						userData[1] = input.nextLine();
						System.out.println("Adress:");
						userData[2] = input.nextLine();
						System.out.println("Phone Number:");
						userData[3] = input.nextLine();
						System.out.println("Email:");
						userData[4] = input.nextLine();
						System.out.println("User Name:");
						userData[5] = input.nextLine();
						System.out.println("Password:");
						userData[6] = input.nextLine();
						if (userData[0] == "1"){
							System.out.println("Do you have concession? [y/n]");
							userData[7] = input.nextLine();
						}
						if(controller.register(userData)) {
							exit = true;
						}
					}
					else if(choice == 3) {
						System.out.println("You sure you want to exit? [y/n]");
						if(input.nextLine().toLowerCase().trim().equals("y")) {
							System.out.println("Thank you for using Prime Event Booking System. Good bye!");
							exit = true;
						}
						
					}
					else {
						System.out.println("Invalid input. Please enter number between 1-3.\n");
					}
						
					
				}catch(Exception e) {
					System.out.println("Invalid input. Please enter number only.\n");					
				}
			}//End while
		}//End if
				
		//Customer home page : 1. Manage Booking, 2.Search Hall, 3.Request Quotation, 4. Logout
		else if(page.toLowerCase() == "customer") {
			header("Welcome to Prime Event.");
			while(!exit) {
				System.out.println("1. Manage Booking");
				System.out.println("2. Search Hall");
				System.out.println("3. Request Quotation");
				System.out.println("4. Logout");
				System.out.println(" Your choice? [1/2/3/4]");
				try {
					choice = input.nextInt();
					if(choice == 1) {
						displayPage("Manage Booking");
					}	
					else if(choice == 2) {
						displayPage("Search Hall");;
					}
					else if(choice == 3) {
						displayPage("Request Quotation");
						
					}
					else if (choice == 4) {
						System.out.println("You sure you want to exit? [y/n]");
						if(input.nextLine().toLowerCase().trim().equals("y")) {
							System.out.println("Logout Successful. Redirecting to home page");
							controller.logout();
							exit = true;
						}
					}
					else {
						System.out.println("Invalid input. Please enter number between 1-4.\n");
					}
						
					
				}catch(Exception e) {
					System.out.println("Invalid input. Please enter number only.\n");					
				}
			}//End while
		}//End if
			
		
		//Owner home page : 1. Manage Booking, 2. Manage Hall, 3. Manage Discount, 4. Logout
		else if(page.toLowerCase() == "owner") {
			header("Welcome to Prime Event");
			while(!exit) {
				System.out.println("1. Manage Booking");
				System.out.println("2. Manage Hall");
				System.out.println("3. Manage Discount");
				System.out.println("4. Logout");
				System.out.println(" Your choice? [1/2/3/4]");
				try {
					choice = input.nextInt();
					if(choice == 1) {
						displayPage("Manage Booking");
					}	
					else if(choice == 2) {
						displayPage("Manage Hall");;
					}
					else if(choice == 3) {
						displayPage("Manage Discount");	
					}
					else if (choice == 4) {
						System.out.println("You sure you want to exit? [y/n]");
						if(input.nextLine().toLowerCase().trim().equals("y")) {
							System.out.println("Logout Successful. Redirecting to home page");
							controller.logout();
							exit = true;
						}
					}
					else {
						System.out.println("Invalid input. Please enter number between 1-4.\n");
					}
						
					
				}catch(Exception e) {
					System.out.println("Invalid input. Please enter number only.\n");					
				}
			}//End while
		}//End if
		
		//Admin home page : 1. Manage User, 2. Manage Discount, 3. Logout
		else if(page.toLowerCase() == "admin") {
			while(!exit) {
				System.out.println("1. Manage User");
				System.out.println("2. Manage Discount");
				System.out.println("3. Logout");
				System.out.println(" Your choice? [1/2/3]");
				try {
					choice = input.nextInt();
					if(choice == 1) {
						displayPage("Manage User");
					}	
					else if(choice == 2) {
						displayPage("Manage Discount");	
					}
					else if (choice == 3) {
						System.out.println("You sure you want to exit? [y/n]");
						if(input.nextLine().toLowerCase().trim().equals("y")) {
							System.out.println("Logout Successful. Redirecting to home page");
							controller.logout();
							exit = true;
						}
					}
					else {
						System.out.println("Invalid input. Please enter number between 1-4.\n");
					}
						
					
				}catch(Exception e) {
					System.out.println("Invalid input. Please enter number only.\n");					
				}
			}//End while
		}//End if
	}
	
	public void displayPage(String page) {
		int choice = 0;
		PrimeEvent controller = new PrimeEvent();
		Scanner input  = new Scanner(System.in);
		boolean exit = false;
		
		//manage booking
		if(page.toLowerCase().trim().equals("managebooking")) {
			while(!exit) {
				System.out.println("1. Create Booking");
				System.out.println("2. Edit Booking");
				System.out.println("3. Cancel Booking");
				System.out.println("Your choice? [1/2/3]");
				
				try {
					choice = input.nextInt();
					if(choice == 1) {
						controller.createBooking();
						exit = true;
					}	
//					else if(choice == 2) {
//						controller.editBooking();
//						exit = true;
//					}
//					else if (choice == 3) {
//						controller.cancelBooking();
//						exit = true;
//					}
					else {
						System.out.println("Invalid input. Please enter number between 1-4.\n");
					}
						
					
				}catch(Exception e) {
					System.out.println("Invalid input. Please enter number only.\n");					
				}
				
				
			}//end while
		}// end if
		
		//search hall 
		if(page.toLowerCase().trim().equals("searchhall")) {
			boolean next = false;
			float budget = 0;
			int size = 0;
			String function = "";
			
			//budget
			while(!next) {
				System.out.println("What is your budget?");
				try {
					budget = input.nextFloat();
					if(budget > 0) {
						next = true;
					}else {
						System.out.println("Invalid number. Please try again");
					}
				}catch(Exception e) {
					System.out.println("Number only. Please try again.");
				}
			}
			
			//size
			next = false;
			while(!next) {
				System.out.println("How many people do you have?");
				try {
					size = input.nextInt();
					if(size > 0) {
						next = true;
					}else {
						System.out.println("Invalid number. Please try again");
					}
				}catch(Exception e) {
					System.out.println("Number only. Please try again.");
				}
				
			}
						
			//function
			System.out.println("What event are you holding?");
			function = input.nextLine();
			
			controller.searchHall(budget, size, function);
			
			
		}
		
		//request quotation
		if(page.toLowerCase().trim().equals("requestquotation")) {
			
			
		}
		
		//manage hall
		if(page.toLowerCase().trim().equals("managehall")) {
			
		}
		
		//manage discount
		if(page.toLowerCase().trim().equals("managebooking")) {
			
		}
		
		//manage user
		if(page.toLowerCase().trim().equals("manageuser")) {
			
		}
		
	}
	
	public void displayConfirmPage(String page) {
		
	}
	
	private void header(String message) {
		for(int i = 0; i < 35; i++) {
			System.out.print("=");
		}
		System.out.println(message);
		for(int i = 0; i < 35; i++) {
			System.out.print("=");
		}
		
	}

}
