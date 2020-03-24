package kr.or.ksmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.DocContractForm;
import kr.or.ksmart.mapper.DocContractFormMapper;

@Service
@Transactional
public class DocContractFormService {
	
	@Autowired
	private DocContractFormMapper docContractFormMapper;
	
	public List<DocContractForm> getContractList(){
		List<DocContractForm> list = docContractFormMapper.getContractList();
		
		return list;
	}
}
