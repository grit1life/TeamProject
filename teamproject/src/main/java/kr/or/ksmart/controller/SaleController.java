package kr.or.ksmart.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ksmart.domain.Staff;
import kr.or.ksmart.service.StaffService;

@Controller
public class SaleController {

	
	@GetMapping("admin/saleInsert")
	public String saleInsert() {
		return "sale/saleInsert";
	}
}
