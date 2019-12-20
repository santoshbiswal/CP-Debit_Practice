package in.dtdc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.dtdc.command.ShipmentBookingCommand;
import in.dtdc.delegate.BookingDelegate;
import in.dtdc.validator.BookingValidator;

@Controller
public class ShipmentBookingController {

	@Autowired
	private BookingDelegate delegate;
	
	@Autowired
	private BookingValidator validator;
	
	@GetMapping("/shipment-booking.htm")
	public String goToBooking() {
		
		return "shipment-booking";
	}
	
	@ModelAttribute("booking")
	public ShipmentBookingCommand emptyCommandObject() {
		
		return new ShipmentBookingCommand();
	}
	
	@PostMapping("/shipment-booking.htm")
	public String doBooking(@ModelAttribute("booking") ShipmentBookingCommand command,BindingResult error) {
		
		if(validator.supports(ShipmentBookingCommand.class)) {
			
			validator.validate(command, error);
			
			if(error.hasErrors()) {
				
				return "shipment-booking";
			}
		}
		System.out.println("command : "+command);
		
		delegate.doBooking(command);
		
		return "booking-success";
	}
	
}
