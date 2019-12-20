package in.dtdc.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.dtdc.command.RegistrationCommand;
import in.dtdc.model.Address;
import in.dtdc.model.Login;
import in.dtdc.model.User;
import in.dtdc.service.AddressService;
import in.dtdc.service.LoginService;
import in.dtdc.service.UserService;

@Component
public class RegistrationDelegate {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private LoginService loginService;
	
	public boolean doRegister(RegistrationCommand command) {
		
		User us = extractUserFromRegistrationCommand(command);
		Address add = extractAddressFromRegistrationCommand(command);
		Login log = extractLoginFromRegistrationCommand(command);
		
		User saveUs = userService.saveUser(us);
		log.setUser(us);
		loginService.saveLogin(log);
		
		add.setUser(saveUs);
		addressService.saveAddress(add);
	
		return true;
	}
	
	private Address extractAddressFromRegistrationCommand(RegistrationCommand command) {
		
		Address address = new Address();
		address.setAddressLine(command.getAddressLine());
		address.setCity(command.getCity());
		address.setState(command.getState());
		
		return address;
	}
	
	private User extractUserFromRegistrationCommand(RegistrationCommand command) {
		
		User user = new User();
		user.setName(command.getName());
		user.setPhone(command.getPhone());
		
		return user;
	}
	
	private Login extractLoginFromRegistrationCommand(RegistrationCommand command) {
		
		Login login = new Login();
		login.setUsername(command.getUsername());
		login.setPassword(command.getPassword());
		login.setUserType(command.getUsertype());
		
		return login;
	}
}
