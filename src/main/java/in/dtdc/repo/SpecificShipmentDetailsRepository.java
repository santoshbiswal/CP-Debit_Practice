package in.dtdc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.dtdc.model.ShipmentBooking;

@Repository
public interface SpecificShipmentDetailsRepository extends CrudRepository<ShipmentBooking, String>{

	@Query(value = "SELECT c.NAME,c.PHONE,b.CONSG_NO,b.VAS_PROD_CODE,b.SOURCE,b.DESTINATION,b.BOOKING_DATE_TIME,b.PRICE,b.QUANTITY,d.STATUS,a.A_LINE,a.CITY,a.STATE,a.ADDRESS_TYPE FROM DTDC_CUSTOMER c INNER JOIN SHIPMENT_BOOKING b ON c.CUSTID=b.CUSTID and b.CONSG_NO=:consignmentnumber INNER JOIN CUSTOMER_ADDRESS a ON a.CUSTID=c.CUSTID INNER JOIN SHIPMENT_DELIVERY d ON d.DELIVERY_CONSG_NO=b.CONSG_NO",nativeQuery = true)
	public List<Object[]> getSpecificShipmentDetails(@Param("consignmentnumber") String consignmentnumber);
}
