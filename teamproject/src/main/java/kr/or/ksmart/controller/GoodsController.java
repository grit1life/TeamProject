package kr.or.ksmart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ksmart.service.GoodsService;
import kr.or.ksmart.domain.Goods;

@RestController
public class GoodsController {

  @Autowired
  private GoodsService goodsService;

  @PostMapping(value = "/goods")
  public Map<String, Object> insertGoods(Goods goods) {
    return goodsService.insertGoods(goods);
  }

  @GetMapping(value = "/goods", produces = "application/json")
  public List<Goods> getGoodsList() {
    return goodsService.getGoodsList();
  }

  @GetMapping(value = "/goods/{goodsCode}", produces = "application/json")
  public Goods getGoods(@PathVariable(value = "goodsCode") final String goodsCode) {
    return goodsService.getGoods(goodsCode);
  }

  @PutMapping(value = "/goods/{goodsCode}")
  public String updateGoods(Goods goods) {
    return goodsService.updateGoods(goods);
  }

  @DeleteMapping(value = "/goods/{goodsCode}")
  public String deleteGoods(@PathVariable(value = "goodsCode") final String goodsCode) {
    return goodsService.deleteGoods(goodsCode);
  }

}