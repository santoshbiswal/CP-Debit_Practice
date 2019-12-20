package in.dtdc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "D_ADDRESS")
public class Address {

	@Id
	@SequenceGenerator(name = "seq_address",sequenceName = "ADDRESS_SEQUENCE",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_address")
	@Column(name = "ADDRESSID")
	private int addressId;
	private String addressLine;
	private String city;
	private String state;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USERID")
	private User user;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
