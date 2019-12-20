package in.dtdc.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.dtdc.model.Login;

@Repository
public interface LoginRepository extends CrudRepository<Login, Integer>{

	@Query(value = "SELECT dl.LOGIN_USERID FROM D_LOGIN dl WHERE dl.USERNAME=:username and dl.PASSWORD=:password and dl.USERTYPE=:usertype",nativeQuery = true)
	public Integer getLoginCount(@Param("username") String username,@Param("password") String password,@Param("usertype") String usertype);
}
