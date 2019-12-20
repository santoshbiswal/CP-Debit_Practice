package in.dtdc.validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.dtdc.command.RegistrationCommand;

@Component
public class RegistrationValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		if(clazz.isAssignableFrom(RegistrationCommand.class))
			return true;
		
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {

		RegistrationCommand command = (RegistrationCommand) target;
		
		if(command.getAddressLine() == null || command.getAddressLine().isEmpty() || "".equals(command.getAddressLine())){
			
			errors.rejectValue("addressLine", "registration.addressLine");
		}
	}

	
}
