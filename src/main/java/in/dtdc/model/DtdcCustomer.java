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

@Entity
@Table(name = "DTDC_CUSTOMER")
public class DtdcCustomer {

	@Id
	@SequenceGenerator(name = "seq_customer",sequenceName = "CUSTOMER_SEQUENCE",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_customer")
	@Column(name = "CUSTID")
	private int customerId;
	private String name;
	private String phone;
	
	@OneToMany(mappedBy = "dtdcCustomer")
	private Set<CustomerAddress> customerAddress;
	
	@OneToOne(mappedBy = "dtdcCustomer")
	private ShipmentBooking shipBooking;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
	public Set<CustomerAddress> getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(Set<CustomerAddress> customerAddress) {
		this.customerAddress = customerAddress;
	}
	public ShipmentBooking getShipBooking() {
		return shipBooking;
	}
	public void setShipBooking(ShipmentBooking shipBooking) {
		this.shipBooking = shipBooking;
	}
	

}
