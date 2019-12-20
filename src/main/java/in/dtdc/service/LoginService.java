package in.dtdc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.dtdc.command.LoginCommand;
import in.dtdc.exception.UserNotFoundException;
import in.dtdc.model.Login;
import in.dtdc.repo.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository repository;
	
	public Login saveLogin(Login login) {
		
		repository.save(login);
		
		return login;
	}
	
	public Integer validateLogin(LoginCommand command) {
		
		Integer userId = repository.getLoginCount(command.getUsername(), command.getPassword(), command.getUsertype());
		
		if(userId == null) {
			
			throw new UserNotFoundException("Plz Enter Valid Username/Password...");
		}
		
		return userId;
	}
}
