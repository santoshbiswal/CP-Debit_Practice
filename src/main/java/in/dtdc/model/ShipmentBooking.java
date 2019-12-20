package in.dtdc.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "SHIPMENT_BOOKING")
public class ShipmentBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_seq")
	@GenericGenerator(name = "booking_seq",strategy = "in.dtdc.model.ShipmentNumberCustomKeyGen",
		parameters = {
				@Parameter(name = ShipmentNumberCustomKeyGen.INCREMENT_PARAM, value = "1"),
	            @Parameter(name = ShipmentNumberCustomKeyGen.VALUE_PREFIX_PARAMETER, value = "I"),
	            @Parameter(name = ShipmentNumberCustomKeyGen.NUMBER_FORMAT_PARAMETER, value = "%05d"),
	            @Parameter(name = "sequence_name", value = "booking_sequence"),
	            @Parameter(name = "initial_value", value = "1")						
		})
	@Column(name = "CONSG_NO")
	private String consg_no;
	
	@Column(name = "VAS_PROD_CODE")
	private String vasProdCod;
	private int price;
	
	@Column(name = "BOOKING_DATE_TIME")
	private Date bookingDtTime;
	private String source;
	private String destination;
	private int quantity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CUSTID")
	private DtdcCustomer dtdcCustomer;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CHANNEL_PARTNER_ID")
	private User bookingUser;

	public String getConsg_no() {
		return consg_no;
	}

	public void setConsg_no(String consg_no) {
		this.consg_no = consg_no;
	}

	public String getVasProdCod() {
		return vasProdCod;
	}

	public void setVasProdCod(String vasProdCod) {
		this.vasProdCod = vasProdCod;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getBookingDtTime() {
		return bookingDtTime;
	}

	public void setBookingDtTime(Date bookingDtTime) {
		this.bookingDtTime = bookingDtTime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public DtdcCustomer getDtdcCustomer() {
		return dtdcCustomer;
	}

	public void setDtdcCustomer(DtdcCustomer dtdcCustomer) {
		this.dtdcCustomer = dtdcCustomer;
	}

	public User getBookingUser() {
		return bookingUser;
	}

	public void setBookingUser(User bookingUser) {
		this.bookingUser = bookingUser;
	}
	
	
}
