package kr.or.ksmart.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ksmart.domain.DocContractForm;
import kr.or.ksmart.domain.Pagination;
import kr.or.ksmart.mapper.DocContractFormMapper;

@Service
@Transactional
public class DocContractFormService {
	
	@Autowired
	private DocContractFormMapper docContractFormMapper;
	
	public List<DocContractForm> getContractSchedulerList(){
		return docContractFormMapper.getContractSchedulerList();
	}
	
	public Pagination<List<DocContractForm>> getContractList(int currentPage){
		int cnt = docContractFormMapper.getContractListCnt();
		int column = (currentPage-1)*10;
		List<DocContractForm> list = docContractFormMapper.getContractList(column);
		
		Pagination<List<DocContractForm>> pagination = new Pagination<List<DocContractForm>>
								(list, currentPage, cnt);
		
		return pagination;
	}
	public Pagination<List<DocContractForm>> getContractSearchList(int currentPage, DocContractForm docContractForm){
		int cnt = docContractFormMapper.getContractSearchListCnt(docContractForm);
		int column = (currentPage-1)*10;
		docContractForm.setColumn(column);
		
		List<DocContractForm> list = docContractFormMapper.getContractSearchList(docContractForm);
		
		Pagination<List<DocContractForm>> pagination = new Pagination<List<DocContractForm>>
							(list, currentPage, cnt);
		
		return pagination;
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
