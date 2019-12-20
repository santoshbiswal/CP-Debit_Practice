package in.dtdc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.dtdc.command.RegistrationCommand;
import in.dtdc.delegate.RegistrationDelegate;
import in.dtdc.validator.RegistrationValidator;

@Controller
public class RegistrationController {

	@Autowired
	private RegistrationDelegate delegate;
	
	@Autowired
	private RegistrationValidator validator;
	
	@GetMapping("/dtdc-registration.htm")
	public String goToRegistration() {
		
		return "registration";
	}
	
	@ModelAttribute("registration")
	public RegistrationCommand emptyCommandObject() {
		
		return new RegistrationCommand();
	}
	
	@PostMapping("/dtdc-registration.htm")
	public String doRegister(@ModelAttribute("registration")RegistrationCommand command,BindingResult errors) {
		
		if(validator.supports(RegistrationCommand.class)) {
			
			validator.validate(command, errors);
			if(errors.hasErrors()) {
				
				return "registration";
			}
		}
		System.out.println("command : "+command);
		delegate.doRegister(command);
		
		return "registration-success";
	}
}
