package in.dtdc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/dtdc-dashboard.htm")
	public String showHomePage() {
		
		return "dtdc-dashboard";
	}
}
