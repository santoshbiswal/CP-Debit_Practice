package in.dtdc.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ShipmentBookingCommand {

	private String name;
	private String phone;
	private String fromAddressLine;
	private String fromCity;
	private String fromState;
	private String toAddressLine;
	private String toCity;
	private String toState;
	private String vasProdCode;
	private String source;
	private String destination;
	private int price;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date bookingDtTime;
	private int quantity;
	private int userId;
	
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
	public String getFromAddressLine() {
		return fromAddressLine;
	}
	public void setFromAddressLine(String fromAddressLine) {
		this.fromAddressLine = fromAddressLine;
	}
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getFromState() {
		return fromState;
	}
	public void setFromState(String fromState) {
		this.fromState = fromState;
	}
	public String getToAddressLine() {
		return toAddressLine;
	}
	public void setToAddressLine(String toAddressLine) {
		this.toAddressLine = toAddressLine;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public String getToState() {
		return toState;
	}
	public void setToState(String toState) {
		this.toState = toState;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "ShipmentBookingCommand [name=" + name + ", phone=" + phone + ", fromAddressLine=" + fromAddressLine
				+ ", fromCity=" + fromCity + ", fromState=" + fromState + ", toAddressLine=" + toAddressLine
				+ ", toCity=" + toCity + ", toState=" + toState + ", vasProdCode=" + vasProdCode + ", source=" + source
				+ ", destination=" + destination + ", price=" + price + ", bookingDtTime=" + bookingDtTime
				+ ", quantity=" + quantity + ", userId=" + userId + "]";
	}
	
}
