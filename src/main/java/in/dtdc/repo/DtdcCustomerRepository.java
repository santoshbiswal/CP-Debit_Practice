package in.dtdc.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.dtdc.model.DtdcCustomer;

@Repository
public interface DtdcCustomerRepository extends CrudRepository<DtdcCustomer, Integer>{

}
