package kr.or.ksmart.service;

import java.util.ArrayList;
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
	
	public List<DocContractForm> getContractForm(String contractCode){
		List<DocContractForm> list = docContractFormMapper.getContractForm(contractCode);
		
		List<DocContractForm> resultList = new ArrayList<DocContractForm>();
		for(int i=0; i<list.size(); i++) {
			if(i==0) {
				resultList.add(list.get(i));
			}else if(!list.get(i).getContractNo().equals( list.get(i-1).getContractNo() )) {
				if(list.get(i).getSetCode()!=null) {
					resultList.add(list.get(i));
				}else {
					resultList.add(list.get(i));
				}
			}
			if(list.get(i).getSetCode()!=null) {
				DocContractForm form = new DocContractForm();
				form.setSetCode(list.get(i).getSetCode());
				form.setSetGoodsName(list.get(i).getSetGoodsName());  //세트 상품명
				form.setRentalCount(list.get(i).getSetGoodsCount());
				resultList.add(form);
			}
		}
		return resultList;
	}
}
