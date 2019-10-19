public class User {
	protected String adress;
	protected String email;
	protected String name;
	protected String password;
	protected String phone;
	protected userType type;
	protected String username;
	
	
	/**
	 * The constructor of the User class
	 * @param type type of user
	 * @param name Actual name of the user
	 * @param adress Address of the user
	 * @param phone Phone number of the user
	 * @param email Email of the user
	 * @param username User name of the user
	 * @param password Password of the user
	 */
	public User(userType type, String name, String adress, String phone, String email, String username, String password)
    {
        // initialise instance variables
		this.type = type;
		this.name = name;
		this.adress = adress;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.password = password;
    }
	
	/**
	 * Return the address of the user
	 * @return a String of the user's address
	 */
	public String getAdress() {
		return adress;
	}
	
	/**
	 * Return the email address of the user
	 * @return a String of the user's email address
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Return the actual name of the user 
	 * @return a String of the user
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Return the password
	 * @return a String of the user's password
	 */
	public String getPassword() {
		return password;
	}
	
	
	/**
	 * Return the phone number of the user
	 * @return a String of the user's phone number
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * Return the type of the user
	 * @return an enum representing the type of the user
	 */
	public userType getType() {
		return type;
	}
	
	/**
	 * Return the username of the user
	 * @return a String of the username 
	 */
	public String getUsername() {
		return username;
	}
	
	/** Set the address of the user
	 * @param adress The address of the user
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	/** Set the email of the user
	 * @param email The email address of the user
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/** Set the actual name of the user
	 * @param name Actual name of the user
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/** Set the password of the user
	 * @param password The password of the user
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/** Set the phone number of the user
	 * @param phone The phone number of the user
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/** Set the user name of the user
	 * @param username The user name of the user
	 */
	public void setUsername(String username) {
		this.username = username;
	}

}

/**
 * The User class is responsible to hold user information. This include name, address, 
 * phone number, email, username and password
 * @author Adrian
 *
 */
enum userType{
	admin, customer, nan, owner
}
