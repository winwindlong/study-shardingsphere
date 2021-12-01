package com.zjlong.studyjdbc.business.controller;

import com.zjlong.studyjdbc.business.entity.Goods;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.zjlong.studyjdbc.business.mapper.GoodsMapper;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
public class BusinessController {

    @Resource
    private GoodsMapper goodsMapper;

    @RequestMapping("/index.htm")
    @ResponseBody
    public String index() {
        return "HELLO";
    }

    @GetMapping("/listGoods")
    public List<Goods> listGoods()  {
      return goodsMapper.findGoods();
    }

    @GetMapping("/save")
    public String saveGoods()  {
        Goods goods = new Goods();
        Random random = new Random();
        long id = random.nextInt(200);
        goods.setGoodsId(id);
        goods.setGoodsName("水" + id);
        goods.setGoodsType(6l);
        goods.setSysDate(new Date());
        goodsMapper.addGoods(goods);
        return "成功"+new Date();
    }
}
