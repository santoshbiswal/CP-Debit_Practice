package in.dtdc.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.dtdc.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

}
