package com.zjlong.studyjdbc.business.controller;

import com.zjlong.studyjdbc.business.entity.Goods;
import com.zjlong.studyjdbc.business.mapper.GoodsMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.*;

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
        //long id = random.nextInt(200);
        long type = random.nextInt(200);

        List<Date> dateList = new ArrayList<>();
        Calendar c1 = Calendar.getInstance();
        c1.set(2019, 1, 1);

        Calendar c2 = Calendar.getInstance();
        c2.set(2021, 1, 1);
        dateList.add(c1.getTime());
        dateList.add(c2.getTime());
        int dateRd = random.nextInt(2);

        //goods.setGoodsId(id);
        goods.setGoodsName("水" + type);
        goods.setGoodsType(type);
        goods.setSysDate(dateList.get(dateRd));
        goodsMapper.addGoods(goods);
        return "成功"+new Date();
    }
}
