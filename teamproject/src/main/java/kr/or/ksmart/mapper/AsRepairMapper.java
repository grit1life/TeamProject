package kr.or.ksmart.mapper;

import kr.or.ksmart.domain.AsRepair;

public interface AsRepairMapper {
	
	
			//수리현황 업데이트(값가져오기)
			public AsRepair SelectForUpdate(String repairCode);

}
