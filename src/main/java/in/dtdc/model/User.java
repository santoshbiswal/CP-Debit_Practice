package in.dtdc.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "D_USER")
public class User {

	@Id
	@SequenceGenerator(name = "seq_user",sequenceName = "USER_SEQUENCE",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_user")
	@Column(name = "USERID")
	private int userId;
	private String name;
	private String phone;
	
	@OneToMany(mappedBy = "user")
	private Set<Address> addresses;
	
	@OneToOne(mappedBy = "user")
	@Cascade(value = CascadeType.SAVE_UPDATE)
	private Login login;
	
	@OneToMany(mappedBy = "bookingUser")
	private Set<ShipmentBooking> booking;
	
	@OneToMany(mappedBy = "deliveryUser")
	private Set<ShipmentDelivery> deliveries;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Set<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public Set<ShipmentBooking> getBooking() {
		return booking;
	}
	public void setBooking(Set<ShipmentBooking> booking) {
		this.booking = booking;
	}
	public Set<ShipmentDelivery> getDeliveries() {
		return deliveries;
	}
	public void setDeliveries(Set<ShipmentDelivery> deliveries) {
		this.deliveries = deliveries;
	}
	
}
