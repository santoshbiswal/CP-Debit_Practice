package in.dtdc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.dtdc.model.CustomerAddress;
import in.dtdc.repo.CustomerAddressRepository;

@Service
public class CustomerAddressService {

	@Autowired
	private CustomerAddressRepository repository;
	
	public CustomerAddress saveCustomerAddress(CustomerAddress customerAddress) {
		
		return repository.save(customerAddress);
	}
}
