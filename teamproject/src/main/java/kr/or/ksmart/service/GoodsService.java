package kr.or.ksmart.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
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
	private String imgUploadPath;
	
	public String insertGoods(Goods goods) {
		
		// 1 이미지에 새로운 파일명을 부여, 이미지를 등록하지 않았다면 기본 이미지 파일명을 매핑
		if(!goods.getImg().isEmpty()) {
			goods = setConvertImgName(goods);
		} else {
			goods.setConvertImgName("img-not-found.png");
		}
		
		// 2 다음번의 상품코드를 구함
		String goodsCode = goodsMapper.getNextGoodsCode();
		goods.setGoodsCode(goodsCode);
		
		// 3 입력처리
		goodsMapper.insertGoods(goods);
		
		// 4 새로운 이미지가 있다면 저장함
		if(!goods.getImg().isEmpty()) {
			storeImg(goods);
		}
		
		// 5 상품코드를 리턴함
		return goods.getGoodsCode();
	}
	
	public String getConvertValue () {
		
		// UUID를 사용해서 새로운 파일명을 부여
		String convertValue = UUID.randomUUID().toString();
		return convertValue;
	}

	public Goods setConvertImgName (Goods goods) {
		
		MultipartFile img = goods.getImg();
		
		String originImgName = img.getOriginalFilename();
		String fileType = originImgName.substring(originImgName.indexOf("."));
		String convertFileName = getConvertValue() + fileType;
		
		// 원 파일명과 변환 파일명을 객체에 세팅
		goods.setOriginImgName(originImgName);
		goods.setConvertImgName(convertFileName);
		
		return goods;
	}

	public Goods storeImg (Goods goods) {
		
		MultipartFile img = goods.getImg();
		
		try {
			InputStream inputStream = img.getInputStream();
			Files.copy(inputStream, Paths.get(imgUploadPath).resolve(goods.getConvertImgName()));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return goods;
	}
	
	public void removeImg (String goodsCode) {
		
		Goods goods = goodsMapper.getGoods(goodsCode);
		
		// 1 원 파일명이 존재하지 않을 경우 이미지가 없는 파일이므로 파일 삭제를 하지 않음
		if(goods.getOriginImgName() == null) {
			return;
		}
		
		// 2 파일을 삭제함
		try {
			Files.delete(Paths.get(imgUploadPath).resolve(goods.getConvertImgName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Goods> getGoodsList(){
		
		return goodsMapper.getGoodsList();
	}
	
	public Goods getGoods(String goodsCode) {
		
		return goodsMapper.getGoods(goodsCode);
	}
	
	public String updateGoods (Goods goods) {
		
		// 사용자로부터 이미지 입력이 없는 경우 기존 파일 그대로 유지
		if(!goods.getImg().isEmpty()) {
			removeImg(goods.getGoodsCode());
			// 2 새로운 이미지에 새로운 파일명을 부여, 이미지를 업로드 하지 않았다면 기본 이미지 파일명을 매핑
			goods = setConvertImgName(goods);
		}
		
		// 3 수정처리
		goodsMapper.updateGoods(goods);
		
		// 4 새로운 파일명으로 실제 파일이 저장됨
		if(!goods.getImg().isEmpty()) {
			storeImg(goods);
		}
		
		return goods.getGoodsCode();
	}
	
	public int deleteGoods (String goodsCode) {
		
		removeImg(goodsCode);
		
		return goodsMapper.deleteGoods(goodsCode);
	}

}