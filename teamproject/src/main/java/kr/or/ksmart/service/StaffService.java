package kr.or.ksmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ksmart.domain.Staff;
import kr.or.ksmart.mapper.StaffMapper;

@Service
public class StaffService {
	
	@Autowired
	private StaffMapper staffMapper;
	
	public List<Staff> staffList() {
		List<Staff> staffList = staffMapper.staffList();
		return staffList;
	}
}
