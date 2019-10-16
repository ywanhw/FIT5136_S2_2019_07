import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Adrian
 *
 */

enum homePage{
	home, customer, owner, admin
}

enum page{
	manageBooking, searchHall, requestQuotation, manageHall, manageDiscount, manageUser
}

enum hallPage{
	createHall, editHall, deleteHall
}

enum bookingPage{
	createBooking, editBooking, cancelBooking
}


public class UserInterface {
	
	User currentUser;
	PrimeEvent controller = new PrimeEvent();
	
	public UserInterface() {
		
	}
	
	public void displayHomePage() {
		 Scanner input = new Scanner(System.in);
         int choice = 0;
         boolean exit = false;
		
		//header
		header("Welcome to PrimeEvent");

		//Home page before log in : 1.Login, 2.Register, 3.Exit
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
						String userName = input.next();
						System.out.println("Password:");
						String password = input.next();	
						currentUser = controller.login(userName, password);
						if(currentUser != null) {
							displayUserHome(currentUser.getType());
							exit = true;					
						}else {
							System.out.println("Invalid information. Try agian.");	
						}
						
					}
					else if(choice == 2) {
						header("Register");
						String [] userData = new String[8];
						System.out.println("Are you a 1.Customer or a 2.Hall owner? [1/2]");
						userData[0] = input.next();
						System.out.println("Name:");
						userData[1] = input.next();
						System.out.println("Adress:");
						userData[2] = input.next();
						System.out.println("Phone Number:");
						userData[3] = input.next();
						System.out.println("Email:");
						userData[4] = input.next();
						System.out.println("User Name:");
						userData[5] = input.next();
						System.out.println("Password:");
						userData[6] = input.next();
						
						if (userData[0].equals("1")){
							System.out.println("Do you have concession? [y/n]");
							if(input.next().equals("y")) {
								userData[7] = "true";
							}else {
								userData[7] = "false";
							}
							currentUser = controller.register(userData);
							displayUserHome(currentUser.getType());
						}
						else if(userData[0].equals("2")) {
							currentUser = controller.register(userData);
							displayUserHome(currentUser.getType());
						}
						exit = true;
					}
					else if(choice == 3) {
						System.out.println("You sure you want to exit? [y/n]");
						if(input.next().toLowerCase().trim().equals("y")) {
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
	}//End displayHomePage
	
	public void displayUserHome(userType type) {
		boolean exit = false;
		int choice = 0;
		Scanner input = new Scanner(System.in);
		switch(type) {
			case customer:{
				//Customer home page : 1. Manage Booking, 2.Search Hall, 3.Request Quotation, 4. Logout
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
							displayPage(page.manageBooking);
						}	
						else if(choice == 2) {
							displayPage(page.searchHall);;
						}
						else if(choice == 3) {
							displayPage(page.requestQuotation);
							
						}
						else if (choice == 4) {
							System.out.println("You sure you want to exit? [y/n]");
							if(input.next().toLowerCase().trim().equals("y")) {
								System.out.println("Logout Successful. Redirecting to home page");
								controller.logout();
								displayHomePage();
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
			
				break;
			}//End case customer
			
			case owner:{
				//Owner home page : 1. Manage Booking, 2. Manage Hall, 3. Manage Discount, 4. Logout
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
							displayPage(page.manageBooking);
						}	
						else if(choice == 2) {
							displayPage(page.manageHall);;
						}
						else if(choice == 3) {
							displayPage(page.manageDiscount);	
						}
						else if (choice == 4) {
							System.out.println("You sure you want to exit? [y/n]");
							if(input.next().toLowerCase().trim().equals("y")) {
								System.out.println("Logout Successful. Redirecting to home page");
								controller.logout();
								displayHomePage();
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
			
				break;
			}
			case admin:{
				while(!exit) {
					System.out.println("1. Manage User");
					System.out.println("2. Manage Discount");
					System.out.println("3. Logout");
					System.out.println(" Your choice? [1/2/3]");
					try {
						choice = input.nextInt();
						if(choice == 1) {
							displayPage(page.manageUser);
						}	
						else if(choice == 2) {
							displayPage(page.manageDiscount);	
						}
						else if (choice == 3) {
							System.out.println("You sure you want to exit? [y/n]");
							if(input.next().toLowerCase().trim().equals("y")) {
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
				
				break;
			}
		
		}
	}
	
	public void displayPage(page pageName) {
		int choice = 0;
		Scanner input  = new Scanner(System.in);
		boolean exit = false;
		
		//manage booking
		switch(pageName) {
			case manageBooking:{
				while(!exit) {
					System.out.println("1. Create Booking");
					System.out.println("2. Edit Booking");
					System.out.println("3. Cancel Booking");
					System.out.println("Your choice? [1/2/3]");
					
					try {
						choice = input.nextInt();
						if(choice == 1) {
							System.out.println("Press enter to find the hall you want to book:");
							input.nextLine();
							ArrayList<Hall> searchResult = controller.searchHall();
							while(searchResult.size() == 0) {
								System.out.println("No result find, please re-search.");
								searchResult = controller.searchHall();
							}						
							System.out.println("Choice the hall from 0 to " + (searchResult.size()- 1));
							
							controller.createBooking();
							exit = true;
							displayUserHome(currentUser.getType());
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
				
				break;
			}//end case Manage Booking
			
			case searchHall:{
				controller.searchHall();
				System.out.println("Press enter to return to home.");
				input.next();
				System.out.println("Redirecting to home page");
				displayUserHome(currentUser.getType());
				break;
			}//end case search hall
			
			case requestQuotation:{
				//controller.requestQuotation();
				break;
			}// end request quotation
			
			case manageHall:{		
				while(!exit) {
					System.out.println("1. Add Hall");
					System.out.println("2. Edit Hall");
					System.out.println("3. Delete Hall");
					System.out.println("Your choice? [1/2/3]");
					
					try {
						choice = input.nextInt();
						if(choice == 1) {
							String[] hallData = new String[5];
							System.out.println("Hall Name: ");
							hallData[0] = input.next();
							System.out.println("Address: ");
							hallData[1] = input.next();							
							System.out.println("Description");
							hallData[2] = input.next();		
							System.out.println("Price: ");
							
							hallData[3] = input.next();
							System.out.println("Capacity: ");
							hallData[4] = input.next();
							
							
							controller.createHall(hallData);
							displayUserHome(currentUser.getType());
							exit = true;
						}	
						else if(choice == 2) {
							controller.editHall();
							exit = true;
						}
//						else if (choice == 3) {
//							controller.cancelBooking();
//							exit = true;
//						}
						else {
							System.out.println("Invalid input. Please enter number between 1-4.\n");
						}						
					}catch(Exception e) {
						System.out.println("Invalid input. Please enter number only.\n");					
					}			
				}//end while			
			}//end case manage Hall
		
		
		}//end switch

		
	}
	
	public void displayManageHall(hallPage page) {
		
	}
	
	public void displayConfirmPage(String page) {
		
	}
	
	private void header(String message) {
		for(int i = 0; i < 35; i++) {
			System.out.print("=");
		}
		System.out.println();
		System.out.println(message);
		for(int i = 0; i < 35; i++) {
			System.out.print("=");
		}
		System.out.println();
		
	}
	
	private void start() {
		displayHomePage();
	}
	
	public static void main(String[] args) {
		UserInterface ui = new UserInterface();
		ui.start();
	}

}
