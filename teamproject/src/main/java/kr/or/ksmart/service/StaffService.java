package kr.or.ksmart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.Staff;
import kr.or.ksmart.mapper.StaffMapper;

@Service
@Transactional
public class StaffService {
	
	@Autowired
	private StaffMapper staffMapper;
	
	public List<Staff> staffList(Staff staff) {
		List<Staff> staffList = staffMapper.staffList(staff);
		return staffList;
	}
	public List<Staff> staffList() {
		List<Staff> staffList = staffMapper.staffList();
		return staffList;
	}
	
	public String staffLogin(String staffId,String staffPw,HttpSession session) {
		System.out.println("StaffService");
		Staff staff = staffMapper.staffLogin(staffId);
		System.out.println(staff.toString());
		String pw = staff.getStaffPw();
		String result = null;
		
		if(!pw.equals(staffPw)) {
			result = "password불일지";
		}else {
			result = "login성공";
			session.setAttribute("staffId", staffId);
			session.setAttribute("branchName", staff.getBranchName());
			session.setAttribute("staffName", staff.getStaffName());
			session.setAttribute("staffLevel", staff.getStaffLevel());
		}
		System.out.println(result);
		System.out.println("StaffService----end");
		return result;
	}
	
	public Staff staffDetails(String staffCode) {
		return staffMapper.staffDetails(staffCode);
	}
	public List<Staff> staffTransferList(String staffCode) {
		System.out.println("service");
		return staffMapper.staffTransferList(staffCode);
	}
}
