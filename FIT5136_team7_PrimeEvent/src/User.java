
public class User {
	private String name;
	private String adress;
	private String phone;
	private String email;
	private String username;
	private String password;
	
	public User()
    {
        // initialise instance variables
    }
	public String getName() {
		return name;
	}
	public String getAdress() {
		return adress;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}