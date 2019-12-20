package in.dtdc.bo;

import java.util.Date;

public class ShipmentStatusBO {

	private String shipmentNo;
	private String source;
	private String destination;
	private Date dateOfBooking;
	private String status;
	
	public String getShipmentNo() {
		return shipmentNo;
	}
	public void setShipmentNo(String shipmentNo) {
		this.shipmentNo = shipmentNo;
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
	public Date getDateOfBooking() {
		return dateOfBooking;
	}
	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ShipmentStatusBO [shipmentNo=" + shipmentNo + ", source=" + source + ", destination=" + destination
				+ ", dateOfBooking=" + dateOfBooking + ", status=" + status + "]";
	}
	
}
