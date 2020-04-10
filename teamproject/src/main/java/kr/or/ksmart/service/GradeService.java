package kr.or.ksmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.Customer;
import kr.or.ksmart.mapper.GradeMapper;

@Service
@Transactional
public class GradeService {
	
	@Autowired
	private GradeMapper gradeMapper;
	
	public List<Customer> getCustomerList(){
		return gradeMapper.getCustomerList();
	}
	
	public void updateGrade(String customerId) {
		String grade = gradeMapper.divideGrade(customerId);
		if(grade != null) {
			gradeMapper.updateGrade(customerId, grade);
		}
	}
	public void insertGradeRecord() {
		gradeMapper.insertGradeRecord();
	}
}
