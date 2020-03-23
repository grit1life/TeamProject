package kr.or.ksmart.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ksmart.mapper.GoodsMapper;
import kr.or.ksmart.domain.Goods;

@Service
@Transactional
public class GoodsService {
	
	@Autowired
	private GoodsMapper goodsMapper;
	
	@Value("${image.upload.path}")
	private String uploadPath;
	
	// 이미지 업로드
	public Goods store (Goods goods) {
		List<MultipartFile> files = goods.getFile();
		for (MultipartFile file : files) {
			String originFileName = file.getOriginalFilename();
			String fileType = originFileName.substring(originFileName.indexOf("."));
			String convertFileName = getConvertValue() + fileType;
			
			goods.setOriginFileName(originFileName);
			goods.setConvertFileName(convertFileName);
			try {
				InputStream inputStream = file.getInputStream();
				Files.copy(inputStream, Paths.get(uploadPath).resolve(convertFileName));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		return goods;
	}
	
	// 업로드 시 기존 파일명에서 새로운 파일명 생성
	public String getConvertValue () {
		String uuid = UUID.randomUUID().toString();
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int date = cal.get(Calendar.DATE);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int milSec = cal.get(Calendar.MILLISECOND);
		String convertValue = ""+uuid+year+month+date+hour+milSec;
		
		return convertValue;
	}
	
	//	상품 Create
	public Map<String, Object> insertGoods(Goods goods) {
		
		// 유효성 검사 먼저 유효성 검사 후에 괜찮으면 밑에 로직 아니면 if문으로 감싸서 바로 리턴시킬 수 있게
		Map<String, Object> resultMap = new HashMap<>();
		
		// 이미지 업로드 처리
		goods = store(goods);
		
		// 상품 코드 처리
		String goodsCode = goodsMapper.getNextGoodsCode();
		goods.setGoodsCode(goodsCode);
		
		// 실제 처리
		goodsMapper.insertGoods(goods);
		
		// 결과값 처리
		resultMap.put("goodsCode", goodsCode);
		
		return resultMap;
	}
	
	//	상품 전체 Read
	public List<Goods> getGoodsList(){
		return goodsMapper.getGoodsList();
	}
	
	// 상품 개별 Read
	public Goods getGoods(String goodsCode) {
		return goodsMapper.getGoods(goodsCode);
	}
	
	// 상품 Update
	public String updateGoods (Goods goods) {
		int insertResult = goodsMapper.updateGoods(goods);
		String resultMsg;
		
		if(insertResult > 0) {
			resultMsg = "update successed";
		} else {
			resultMsg = "update failed";
		}
		
		return resultMsg;
	}
	
	// 상품 Delete
	public String deleteGoods (String goodsCode) {
		int insertResult = goodsMapper.deleteGoods(goodsCode);
		String resultMsg;
		
		if(insertResult > 0) {
			resultMsg = "delete successed";
		} else {
			resultMsg = "delete failed";
		}
		
		return resultMsg;
	}

}