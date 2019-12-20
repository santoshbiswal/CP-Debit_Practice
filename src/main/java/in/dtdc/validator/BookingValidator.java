package in.dtdc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.dtdc.command.ShipmentBookingCommand;

@Component
public class BookingValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		if(clazz.isAssignableFrom(ShipmentBookingCommand.class))
			return true;
			
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {

		ShipmentBookingCommand command = (ShipmentBookingCommand) target;
		
		if(command.getName() == null || "".equals(command.getName()) || command.getName().isEmpty()) {
			
			errors.rejectValue("name", "booking.name");
		}
	}

	
}
