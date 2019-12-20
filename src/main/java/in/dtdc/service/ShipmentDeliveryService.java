package in.dtdc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.dtdc.model.ShipmentDelivery;
import in.dtdc.repo.ShipmentDeliveryRepository;

@Service
public class ShipmentDeliveryService {

	@Autowired
	private ShipmentDeliveryRepository repository;
	
	public ShipmentDelivery saveDelivery(ShipmentDelivery delivery) {
		
		return repository.save(delivery);
	}
}
