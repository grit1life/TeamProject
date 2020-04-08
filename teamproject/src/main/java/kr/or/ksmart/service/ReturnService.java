package kr.or.ksmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.DocContractForm;
import kr.or.ksmart.mapper.ReturnMapper;

@Service
@Transactional
public class ReturnService {
	@Autowired
	private ReturnMapper returnMapper;
	
	public List<DocContractForm> getReturnList(){
		return returnMapper.getReturnList();
	}
}
