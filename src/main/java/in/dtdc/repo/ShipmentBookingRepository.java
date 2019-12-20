package in.dtdc.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.dtdc.model.ShipmentBooking;

@Repository
public interface ShipmentBookingRepository extends CrudRepository<ShipmentBooking, String>{

	@Query("FROM ShipmentBooking s WHERE s.bookingDtTime >= :now and s.bookingDtTime < :tomorrow")
	public List<ShipmentBooking> getBookingDetails(@Param("now") Date now,@Param("tomorrow") Date tomorrow);
	
	@Query(value = "select s.CONSG_NO,s.SOURCE,s.DESTINATION,s.BOOKING_DATE_TIME,d.STATUS from SHIPMENT_BOOKING s , SHIPMENT_DELIVERY d WHERE s.CONSG_NO=:consignmentnumber and d.DELIVERY_CONSG_NO=:consignmentnumber",nativeQuery = true)
	public List<Object[]> getShipmentBookingDetailsByConsgNo(@Param("consignmentnumber") String consignmentnumber);
	
}
