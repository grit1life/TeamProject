package kr.or.ksmart.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import kr.or.ksmart.domain.Customer;
import kr.or.ksmart.service.GradeService;

@Component
public class GradeScheduler {
	
	@Autowired
	private GradeService gradeService;
	
    @Scheduled(cron = "0 0 0 1 * *") 	
	public void updateGrade() {
		List<Customer> list = gradeService.getCustomerList();
		for(int i=0; i<list.size(); i++ ) {
			String customerId = list.get(i).getCustomerId();
			gradeService.updateGrade(customerId);
		}
		gradeService.insertGradeRecord();
	}
}
