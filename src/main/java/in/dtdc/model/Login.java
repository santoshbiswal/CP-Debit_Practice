package in.dtdc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "D_LOGIN")
public class Login {

	@Id
	@Column(name = "LOGIN_USERID",unique = true,nullable = false)
	@GeneratedValue(generator = "gen")
	@GenericGenerator(name = "gen",strategy = "foreign",parameters = {@Parameter(name="property",value = "user")})
	private int loginId;
	private String username;
	private String password;
	private String userType;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private User user;

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
