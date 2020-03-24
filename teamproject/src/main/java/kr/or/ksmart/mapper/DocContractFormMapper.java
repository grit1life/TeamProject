package kr.or.ksmart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ksmart.domain.DocContractForm;

@Mapper
public interface DocContractFormMapper {

	public List<DocContractForm> getContractList();
}
