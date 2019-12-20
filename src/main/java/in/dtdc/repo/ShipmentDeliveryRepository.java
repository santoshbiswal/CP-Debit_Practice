package in.dtdc.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.dtdc.model.ShipmentDelivery;

@Repository
public interface ShipmentDeliveryRepository extends CrudRepository<ShipmentDelivery, Integer>{

	
}
