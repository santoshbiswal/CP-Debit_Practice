package in.dtdc.ajax;

public class ShipmentBookingSearchCriteria {

	private String shipmentNo;
	private String daterange;
	private String source;
	private String dest;
	private String status;
	
	public String getShipmentNo() {
		return shipmentNo;
	}
	public void setShipmentNo(String shipmentNo) {
		this.shipmentNo = shipmentNo;
	}
	public String getDaterange() {
		return daterange;
	}
	public void setDaterange(String daterange) {
		this.daterange = daterange;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ShipmentBookingSearchCriteria [shipmentNo=" + shipmentNo + ", daterange=" + daterange + ", source="
				+ source + ", dest=" + dest + ", status=" + status + "]";
	}
	
}
