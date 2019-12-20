package in.dtdc.bo;

public class SpecificAddressDetailsBO {

	private String addressLine;
	private String city;
	private String state;
	
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
	@Override
	public String toString() {
		return "SpecificAddressDetailsBO [addressLine=" + addressLine + ", city=" + city + ", state=" + state + "]";
	}
	
}
