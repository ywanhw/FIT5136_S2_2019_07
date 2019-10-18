import java.util.ArrayList;
import java.util.Scanner;
/**
 * THis Class is responsible for the interaction between the user and the application.
 * The class is responsible for user interface and accept input from the user.
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
	
	PrimeEvent controller = new PrimeEvent();
	
	/**
	 * Constructor of the UserInterface class
	 */
	public UserInterface() {
		
	}
	
	/**
	 * Display the homepage of the application before logging in
	 */
	public void displayHomePage() {
		 Scanner input = new Scanner(System.in);
         int choice = 0;
         boolean exit = false;
         userType thisType = userType.nan;
		
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
						thisType = controller.login(userName, password);
						if(thisType != userType.nan) {
							displayUserHome(thisType);
							exit = true;					
						}else {
							System.out.println("Invalid information. Try agian.");	
							input.nextLine();
							exit = false;
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
							thisType = controller.register(userData);
							displayUserHome(thisType);
						}
						else if(userData[0].equals("2")) {
							thisType = controller.register(userData);
							displayUserHome(thisType);
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
						exit = false;
					}							
				}catch(Exception e) {
					System.out.println("Invalid input. Please enter number only.\n");
					input.nextLine();
					exit = false;
				}
			}//End while
	}//End displayHomePage
	
	/**
	 * Display the home page depending on the type of user
	 * @param type Enum of the user type, customer, owner and admin.
	 */
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
							displayPage(page.manageBooking, type);
						}	
						else if(choice == 2) {
							displayPage(page.searchHall, type);
						}
						else if(choice == 3) {
							displayPage(page.requestQuotation, type);
							
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
							exit = false;
						}
							
						
					}catch(Exception e) {
						System.out.println("Invalid input. Please enter number only.\n");
						input.nextLine();
						exit = false;
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
							displayPage(page.manageBooking, type);
						}	
						else if(choice == 2) {
							displayPage(page.manageHall, type);
						}
						else if(choice == 3) {
							displayPage(page.manageDiscount, type);	
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
						input.nextLine();
						exit = false;
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
							displayPage(page.manageUser, type);
						}	
						else if(choice == 2) {
							displayPage(page.manageDiscount, type);	
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
							exit = false;
						}
							
						
					}catch(Exception e) {
						System.out.println("Invalid input. Please enter number only.\n");					
					}
				}//End while
				
				break;
			}
		
		}
	}
	
	/**
	 * This method display pages under the hierarchy of o the user home page and accept input from the user.
	 * @param pageName Enum of the name of the page
	 * @param thisType Enum of the type of the user
	 */
	public void displayPage(page pageName, userType thisType) {
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
					System.out.println("4. Exit");
					System.out.println("Your choice? [1/2/3/4]");
					
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
							controller.createBooking(controller.requestQuotation(controller.viewHall(searchResult)));
							exit = true;
							displayUserHome(thisType);
						}
						else if(choice == 4) {
							System.out.println("You sure you want to exit? [y/n]");
							if(input.next().toLowerCase().trim().equals("y")) {
								System.out.println("Exit Successful. Redirecting to previous page");
								displayUserHome(thisType);
							}						
						}
						else {
							System.out.println("Invalid input. Please enter number between 1-4.\n");
							exit = false;
						}
					}catch(Exception e) {
						System.out.println("Invalid input. Please enter number only.\n");	
						input.nextLine();
						exit = false;
					}
					
					
				}//end while
				
				break;
			}//end case Manage Booking
			
			case searchHall:{
				ArrayList<Hall> searchresult = controller.searchHall();
				try {
					int ifReturn = 0;
					while (searchresult.size() == 0) {
						System.out.println("No result find.");
						System.out.println("Press:");
						System.out.println("1.Re-search;2.Redirecting to home page");
						while(true) {
							ifReturn = input.nextInt();
							if (ifReturn == 1) {
								System.out.println("Search:");
								searchresult = controller.searchHall();
								break;								
							}
							else if (ifReturn == 2) {
								break;
							}	
							else {
								System.out.println("Invalid input. Please enter number between 1-2.\n");
								exit = false;
							}
						}
						if (ifReturn == 2) {
							break;
						}	
					}
				}catch(Exception e) {
					System.out.println("Invalid input. Please enter number only.\n");	
				}
				System.out.println("Press enter to return to home.");
				input.nextLine();
				System.out.println("Redirecting to home page");
				displayUserHome(thisType);
				break;
			}//end case search hall
			
			case requestQuotation:{
				ArrayList<Hall> searchResult = controller.searchHall();
				try {
					
						while(searchResult.size() == 0) {
							System.out.println("No result find, please re-search.");
							searchResult = controller.searchHall();
						}		
						controller.requestQuotation(controller.viewHall(searchResult));
						exit = true;

						displayUserHome(thisType);
				}catch(Exception e) {
					System.out.println("Invalid input. Please enter number only.\n");
					input.nextLine();
					exit = false;
				}
				
				break;
			}// end request quotation
			
			case manageHall:{		
				while(!exit) {
					System.out.println("1. Add Hall");
					System.out.println("2. Edit Hall");
					System.out.println("3. Delete Hall");
					System.out.println("4. Exit");
					System.out.println("Your choice? [1/2/3/4]");
					
					try {
						choice = input.nextInt();
						if(choice == 1) {
							String[] hallData = new String[5];
							
//							enter hall name:
//							validation: hall name maximum 15 alphabets
							input.nextLine();
							while(hallData[0] == null || hallData[0].length() >15 ||hallData[0].trim().length()== 0) {
								System.out.println("Hall Name: (Maximum 15 alphabets,)");
								hallData[0] = input.nextLine();
								if(hallData[0].length() >10 ||hallData[0].trim().length()== 0) {
									System.out.println("Please try again: ");
								}
							}
							
//							enter hall address
//							validation: address maximum 50 alphabets
							while(hallData[1] == null || hallData[1].length() >150 ||hallData[1].trim().length()== 0) {
								System.out.println("Address: (Maximum 150 alphabets)");
								hallData[1] = input.nextLine();
								if(hallData[1].length() >150  ||hallData[1].trim().length()== 0) {
									System.out.println("Please try again: ");
								}
							}
							
//							enter hall description
//							validation: description	
							while(hallData[2] == null || hallData[2].length() >500 ||hallData[2].trim().length()== 0) {
								System.out.println("Description: ");
								hallData[2] = input.nextLine();
								if(hallData[2].length() >500 ||hallData[2].trim().length()== 0) {
									System.out.println("Please try again: ");
								}
							}

//							enter hall price
//							validation: price numbers only
							while(hallData[3] == null || hallData[3].length() >10 || isNumeric(hallData[3]) == false ||hallData[3].trim().length()== 0) {
								System.out.println("Price: (Numbers only)");
								hallData[3] = input.nextLine();
								if(hallData[3].length() >10 || isNumeric(hallData[3]) == false  ||hallData[3].trim().length()== 0) {
									System.out.println("Please try again: ");
								}
							}

//							enter hall capacity 
//							validation: capacity numbers only
							while(hallData[4] == null || hallData[4].length() >10 || isNumeric(hallData[4]) == false ||hallData[4].trim().length()== 0) {
								System.out.println("Capacity: (Numbers only)");
								hallData[4] = input.nextLine();
								if(hallData[4].length() >10 || isNumeric(hallData[4]) == false ||hallData[4].trim().length()== 0) {
									System.out.println("Please try again: ");
								}
							}
							
							controller.createHall(hallData);
							displayUserHome(userType.owner);
							exit = true;
						}	
						else if(choice == 2) {
							controller.editHall();
							exit = true;
						}
						else if (choice == 3) {
							controller.deleteHall();
							exit = true;
						}
						else if (choice == 4) {
							System.out.println("You sure you want to exit? [y/n]");
							if(input.next().toLowerCase().trim().equals("y")) {
								System.out.println("Exit Successful. Redirecting to previous page");
								displayUserHome(userType.owner);
								
							}
						}
						else {
							System.out.println("Invalid input. Please enter number between 1-4.\n");
							exit = false;
						}						
					}catch(Exception e) {
						System.out.println("Invalid input. Please enter number only.\n");
						input.nextLine();
						exit = false;
					}			
				}//end while			
			}//end case manage Hall


			}//end switch

		
	}
	
	/**
	 * This method check if the input is numeric.
	 * @param str A string of data that needed to be checked.
	 * @return Boolean, True if it is numeric and false if it is not numeric
	 */
	public static boolean isNumeric(String str){
		for (int i = str.length();--i>=0;){ 
			if (!Character.isDigit(str.charAt(i))){
				return false;
				}
			}
		return true;
	}
	
	/**
	 * The method is responsible for the formatting of the header of each page
	 * @param message A string of message to print out at the header
	 */
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
	
	/**
	 * This method start the application
	 */
	private void start() {
		displayHomePage();
	}
	
	/**
	 * The main method that drive the java compiler
	 * @param args
	 */
	public static void main(String[] args) {
		UserInterface ui = new UserInterface();
		ui.start();
	}

}
