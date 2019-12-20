package in.dtdc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.dtdc.model.User;
import in.dtdc.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public User saveUser(User user) {
		
		repository.save(user);
		
		return user;
	}
	
	public User getUserById(Integer userId) {
		
		Optional<User> optional = repository.findById(userId);
		
		User ob = null;
		if(optional.isPresent()) {
			
			ob = optional.get();
		}
		
		return ob;
	}
}
