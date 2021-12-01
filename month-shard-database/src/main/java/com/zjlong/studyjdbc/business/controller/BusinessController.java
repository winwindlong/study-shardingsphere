package com.zjlong.studyjdbc.business.controller;

import com.zjlong.studyjdbc.business.entity.Goods;
import com.zjlong.studyjdbc.business.entity.UserGoods;
import com.zjlong.studyjdbc.business.mapper.GoodsMapper;
import com.zjlong.studyjdbc.business.mapper.UserGoodsMapper;
import io.shardingsphere.transaction.annotation.ShardingTransactionType;
import io.shardingsphere.transaction.api.TransactionType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@RestController
public class BusinessController {

    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private UserGoodsMapper userGoodsMapper;

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

    /**
     * 分页
     * @param pageSize
     * @return
     */
    @GetMapping("/listUserGoods")
    public List<UserGoods> listUserGoods(@RequestParam(value="pageSize",required=false)Integer pageSize)  {
        return userGoodsMapper.findUserGoods(1, pageSize);
    }

    @GetMapping("/countUserGoods")
    public List<UserGoods> countUserGoods()  {
        return userGoodsMapper.countUserGoods();
    }

    @GetMapping("/saveUserGoods")
    public String saveUserGoods()  {
        UserGoods userGoods = new UserGoods();
        Random random = new Random();
        long id = random.nextInt(200);
        int num = random.nextInt(20);
        int i = random.nextInt(3);
        int j = random.nextInt(2);

        List a = Arrays.asList("01","02","03");
        List b = Arrays.asList("2021","2022");
        int aaa = 1/0;
        userGoods.setGoodsId(id);
        userGoods.setUserId(id);
        userGoods.setGoodsNum(num);
        userGoods.setBuyDate(new Date());
        userGoods.setYearmonth(b.get(j).toString() + a.get(i).toString());
        userGoodsMapper.addUserGoods(userGoods);
        return "成功"+new Date();
    }

    @GetMapping("/transactionSave")
//    @ShardingTransactionType(TransactionType.XA)
    @Transactional
    public String transactionSave() {
        saveGoods();
        saveUserGoods();
        return "成功"+new Date();
    }
}
