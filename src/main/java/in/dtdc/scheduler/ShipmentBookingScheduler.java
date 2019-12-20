package in.dtdc.scheduler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import in.dtdc.delegate.PopulatePendingShipmentDelegate;

@Component
public class ShipmentBookingScheduler {

	@Autowired
	private PopulatePendingShipmentDelegate delegate;
	
	@Scheduled(cron = "0 33 22 * * ?")
	public void cronJobSch() {

		System.out.println("I am from Sceduler");

		try {
			getTodayBooking();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getTodayBooking() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");

		Date now = sdf.parse(sdf.format(new Date()));
		
		String strDate = sdf.format(new Date());
		System.out.println("NOW :: " + strDate);

		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, 1);
		Date tomorrow = sdf.parse(sdf.format(c.getTime()));
		
		String strDateTomorrow = sdf.format(tomorrow);
		System.out.println("tomorrow :: " + strDateTomorrow);

		delegate.doPopulateIntoDelivery(now, tomorrow);
		
		
	}
}
