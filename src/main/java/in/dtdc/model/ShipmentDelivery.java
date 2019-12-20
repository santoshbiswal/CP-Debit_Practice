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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SHIPMENT_DELIVERY")
public class ShipmentDelivery {

	@Id
	@SequenceGenerator(name = "seq_delivery",sequenceName = "DELIVERY_SEQUENCE",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_delivery")
	@Column(name = "DELIVERY_ID")
	private int deliveryId;
	
	@Column(name = "DELIVERY_CONSG_NO")
	private String deliveryConsgNo;
	private String status;
	private Date dod;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "DELIVERY_PARTNER_ID")
	private User deliveryUser;

	public int getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}

	public String getDeliveryConsgNo() {
		return deliveryConsgNo;
	}

	public void setDeliveryConsgNo(String deliveryConsgNo) {
		this.deliveryConsgNo = deliveryConsgNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDod() {
		return dod;
	}

	public void setDod(Date dod) {
		this.dod = dod;
	}

	public User getDeliveryUser() {
		return deliveryUser;
	}

	public void setDeliveryUser(User deliveryUser) {
		this.deliveryUser = deliveryUser;
	}
	
}
