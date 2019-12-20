package in.dtdc.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.dtdc.model.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer>{

}
