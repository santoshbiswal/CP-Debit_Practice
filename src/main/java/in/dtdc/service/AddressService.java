package in.dtdc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.dtdc.model.Address;
import in.dtdc.repo.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository repository;
	
	public Address saveAddress(Address address) {
		
		repository.save(address);
		
		return address;
	}
}
