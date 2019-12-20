package in.dtdc.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.dtdc.model.CustomerAddress;

@Repository
public interface CustomerAddressRepository extends CrudRepository<CustomerAddress, Integer>{

}
