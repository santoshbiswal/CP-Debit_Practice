package in.dtdc.ajax;

public class ShipmentBookingResponse {

	private String shipmentNo;
	private String source;
	private String destination;
	private String dateOfBooking;
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
	public String getDateOfBooking() {
		return dateOfBooking;
	}
	public void setDateOfBooking(String dateOfBooking) {
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
		return "ShipmentBookingResponse [shipmentNo=" + shipmentNo + ", source=" + source + ", destination="
				+ destination + ", dateOfBooking=" + dateOfBooking + ", status=" + status + "]";
	}
}
