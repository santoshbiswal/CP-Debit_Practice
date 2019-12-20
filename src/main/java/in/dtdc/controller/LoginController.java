package in.dtdc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.dtdc.command.LoginCommand;
import in.dtdc.exception.UserNotFoundException;
import in.dtdc.service.LoginService;
import in.dtdc.validator.LoginValidator;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	@Autowired
	private LoginValidator validator;

	@GetMapping("/dtdc-login.htm")
	public String goToLogin() {
		
		return "login";
	}
	
	@ModelAttribute("login")
	public LoginCommand createEmptyCommandObject() {
		
		return new LoginCommand();
	}
	
	@PostMapping("/dtdc-login.htm")
	public String doLogin(@ModelAttribute("login") LoginCommand command,BindingResult error,HttpSession session) {
		
		if(validator.supports(LoginCommand.class)) {
			
			validator.validate(command, error);
			
			if(error.hasErrors()) {
				
				return "login";
			}
		}
		
		try {
		
			Integer userId = service.validateLogin(command);
			session.setAttribute("userId", userId);
			
		}catch(UserNotFoundException e) {
			
			error.reject("userId", e.getMessage());
			
			return "login";
		}
		
		if(command.getUsertype().equals("channel-partner")) {
			
			return "channel-partner-dashboard";
			
		}else if(command.getUsertype().equals("delivery-partner")) {
			
			return "delivery-partner-dashboard";
		}
		
		return "registration-success";
	}
	
	@GetMapping("/logout.htm")
	public String doLogout(HttpSession session) {
		
		Integer userId = (Integer) session.getAttribute("userId");
		System.out.println("USERID : "+userId);
		
		session.invalidate();
		
		return "login";
	}
}
