package kr.or.ksmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DocShipmentList {

	@GetMapping("/staff/rentalShipList")
	public String rentalShipList() {
		return "docShipment/rentalShipList";
	}
	@GetMapping("/staff/repairShipList")
	public String repairShipList() {
		return "docShipment/repairShipList";
	}
}
