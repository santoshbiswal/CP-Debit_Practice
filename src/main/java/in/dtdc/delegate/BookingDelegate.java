package in.dtdc.delegate;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.dtdc.command.ShipmentBookingCommand;
import in.dtdc.model.CustomerAddress;
import in.dtdc.model.DtdcCustomer;
import in.dtdc.model.ShipmentBooking;
import in.dtdc.model.User;
import in.dtdc.service.CustomerAddressService;
import in.dtdc.service.DtdcCustomerService;
import in.dtdc.service.ShipmentBookingService;
import in.dtdc.service.UserService;

@Component
public class BookingDelegate {

	@Autowired
	private DtdcCustomerService customerService;
	
	@Autowired
	private CustomerAddressService addressService;
	
	@Autowired
	private ShipmentBookingService bookingService;
	
	@Autowired
	private UserService userService;
	
	public boolean doBooking(ShipmentBookingCommand command) {
	
		//save dtdc customer
		DtdcCustomer dtdcCustomer = extractDtdcCustomerFromShipmentBookingCommand(command);
		DtdcCustomer saveCustomer = customerService.saveCustomer(dtdcCustomer);
		
		//save customer from and to address
		CustomerAddress fromCustomerAddress = extractFromCustomerAddressFromShipmentBookingCommand(command, dtdcCustomer);
		CustomerAddress toCustomerAddress = extractToCustomerAddressFromShipmentBookingCommand(command, dtdcCustomer);
		
		addressService.saveCustomerAddress(fromCustomerAddress);
		addressService.saveCustomerAddress(toCustomerAddress);
		
		ShipmentBooking shipBooking = extractShipmentBookingFromShipmentBookingCommand(command);
		User bookingUser = userService.getUserById(command.getUserId());
		shipBooking.setBookingUser(bookingUser);
		shipBooking.setDtdcCustomer(saveCustomer);
		
		bookingService.saveShipmentBooking(shipBooking);	
		
		return true;
	}
	
	private DtdcCustomer extractDtdcCustomerFromShipmentBookingCommand(ShipmentBookingCommand command) {
		
		DtdcCustomer customer = new DtdcCustomer();
		customer.setName(command.getName());
		customer.setPhone(command.getPhone());
		
		return customer;
	}
	
	private CustomerAddress extractFromCustomerAddressFromShipmentBookingCommand(ShipmentBookingCommand command,DtdcCustomer customer) {
		
		CustomerAddress customerAddress = new CustomerAddress();
		customerAddress.setAddressLine(command.getFromAddressLine());
		customerAddress.setCity(command.getFromCity());
		customerAddress.setState(command.getFromState());
		customerAddress.setAddressType("FROM");
		customerAddress.setDtdcCustomer(customer);
		
		return customerAddress;
	}
	
	private CustomerAddress extractToCustomerAddressFromShipmentBookingCommand(ShipmentBookingCommand command,DtdcCustomer customer) {
		
		CustomerAddress address = new CustomerAddress();
		address.setAddressLine(command.getToAddressLine());
		address.setCity(command.getToCity());
		address.setState(command.getToState());
		address.setAddressType("TO");
		address.setDtdcCustomer(customer);
		
		return address;
	}
	
	private ShipmentBooking extractShipmentBookingFromShipmentBookingCommand(ShipmentBookingCommand command) {
		
		ShipmentBooking booking = new ShipmentBooking();
		booking.setVasProdCod(command.getVasProdCode());
		booking.setSource(command.getSource());
		booking.setDestination(command.getDestination());
		booking.setPrice(command.getPrice());
		booking.setBookingDtTime(new Date());
		booking.setQuantity(command.getQuantity());
		
		return booking;
	}
}