package kr.or.ksmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatisticsController {
	@GetMapping("/staff/cStatis")
	public String cStatis() {
		return "statis/cStatis";
	}
	@GetMapping("/staff/rStatis")
	public String rStatis() {
		return "statis/rStatis";
	}
}
