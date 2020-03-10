package kr.or.ksmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GoodsController {

  @GetMapping("/goodsList")
  public String goodsList() {
    return "goods/goodsList";
  }

}
