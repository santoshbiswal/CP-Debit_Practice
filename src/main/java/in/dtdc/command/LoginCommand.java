package in.dtdc.command;

public class LoginCommand {

	private String username;
	private String password;
	private String usertype;
	private int userId;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "LoginCommand [username=" + username + ", password=" + password + ", usertype=" + usertype + ", userId="
				+ userId + "]";
	}
	
	
}
