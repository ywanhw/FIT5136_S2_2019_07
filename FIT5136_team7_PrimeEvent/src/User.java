/**
 * The User class is responsible to hold user information. This include name, address, 
 * phone number, email, username and password
 * @author Adrian
 *
 */
enum userType{
	customer, owner, admin, nan
}

public class User {
	protected String name;
	protected String adress;
	protected String phone;
	protected String email;
	protected String username;
	protected String password;
	protected userType type;
	
	
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
	 * Return the type of the user
	 * @return an enum representing the type of the user
	 */
	public userType getType() {
		return type;
	}
	
	/**
	 * Return the actual name of the user 
	 * @return a String of the user
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Return the address of the user
	 * @return a String of the user's address
	 */
	public String getAdress() {
		return adress;
	}
	
	/**
	 * Return the phone number of the user
	 * @return a String of the user's phone number
	 */
	public String getPhone() {
		return phone;
	}
	
	
	/**
	 * Return the email address of the user
	 * @return a String of the user's email address
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Return the username of the user
	 * @return a String of the username 
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Return the password
	 * @return a String of the user's password
	 */
	public String getPassword() {
		return password;
	}
	
	/** Set the actual name of the user
	 * @param name Actual name of the user
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/** Set the address of the user
	 * @param adress The address of the user
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	/** Set the phone number of the user
	 * @param phone The phone number of the user
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/** Set the email of the user
	 * @param email The email address of the user
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/** Set the user name of the user
	 * @param username The user name of the user
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/** Set the password of the user
	 * @param password The password of the user
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
