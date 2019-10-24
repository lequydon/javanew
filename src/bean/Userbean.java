package bean;

public class Userbean {
	private String Email;
	private String password;
	public String getEmail() {
		return Email;
	}
	public String getPassword() {
		return password;
	}
	public Userbean(String email, String password) {
		super();
		Email = email;
		this.password = password;
	}
}
