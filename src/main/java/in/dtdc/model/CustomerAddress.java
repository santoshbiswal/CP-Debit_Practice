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
@Table(name = "CUSTOMER_ADDRESS")
public class CustomerAddress {

	@Id
	@SequenceGenerator(name = "seq_address",sequenceName = "CUSTOMER_ADDRESS_SEQUENCE",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_address")
	@Column(name = "ADDRESSID")
	private int addressId;
	
	@Column(name = "A_LINE")
	private String addressLine;
	private String city;
	private String state;
	
	@Column(name = "ADDRESS_TYPE")
	private String addressType;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CUSTID")
	private DtdcCustomer dtdcCustomer;

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

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public DtdcCustomer getDtdcCustomer() {
		return dtdcCustomer;
	}

	public void setDtdcCustomer(DtdcCustomer dtdcCustomer) {
		this.dtdcCustomer = dtdcCustomer;
	}
	
}
