package in.dtdc.bo;

import java.util.Date;

public class SpecificShipmentDetailsBO {

	private String name;
	private String phone;
	private String consgNo;
	private String vasProdCode;
	private String source;
	private String destination;
	private Date bookingDtTime;
	private int price;
	private int quantity;
	private String status;
	private SpecificAddressDetailsBO fromAddress;
	private SpecificAddressDetailsBO toAddress;
	
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
	public String getConsgNo() {
		return consgNo;
	}
	public void setConsgNo(String consgNo) {
		this.consgNo = consgNo;
	}
	public String getVasProdCode() {
		return vasProdCode;
	}
	public void setVasProdCode(String vasProdCode) {
		this.vasProdCode = vasProdCode;
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
	public Date getBookingDtTime() {
		return bookingDtTime;
	}
	public void setBookingDtTime(Date bookingDtTime) {
		this.bookingDtTime = bookingDtTime;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public SpecificAddressDetailsBO getFromAddress() {
		return fromAddress;
	}
	public void setFromAddress(SpecificAddressDetailsBO fromAddress) {
		this.fromAddress = fromAddress;
	}
	public SpecificAddressDetailsBO getToAddress() {
		return toAddress;
	}
	public void setToAddress(SpecificAddressDetailsBO toAddress) {
		this.toAddress = toAddress;
	}
	@Override
	public String toString() {
		return "SpecificShipmentDetailsBO [name=" + name + ", phone=" + phone + ", consgNo=" + consgNo
				+ ", vasProdCode=" + vasProdCode + ", source=" + source + ", destination=" + destination
				+ ", bookingDtTime=" + bookingDtTime + ", price=" + price + ", quantity=" + quantity + ", status="
				+ status + ", fromAddress=" + fromAddress + ", toAddress=" + toAddress + "]";
	}
	
}
