package kr.or.ksmart.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.AsRepair;
import kr.or.ksmart.mapper.AsRepairMapper;




@Service
@Transactional
public class AsRepairService {
	
	
	
	@Autowired
	private AsRepairMapper AsRepairMapper;
	
	
	
		//상세보기	
		public AsRepair SelectForUpdate(String repairCode) {
			
			return AsRepairMapper.SelectForUpdate(repairCode);
		}
		
	
}
