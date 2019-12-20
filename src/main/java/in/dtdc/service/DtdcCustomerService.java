package in.dtdc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.dtdc.model.DtdcCustomer;
import in.dtdc.repo.DtdcCustomerRepository;

@Service
public class DtdcCustomerService {

	@Autowired
	private DtdcCustomerRepository repository;
	
	public DtdcCustomer saveCustomer(DtdcCustomer customer) {
		
		return repository.save(customer);
	}
}
