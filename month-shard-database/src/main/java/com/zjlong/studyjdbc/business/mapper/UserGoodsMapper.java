package com.zjlong.studyjdbc.business.mapper;

import com.zjlong.studyjdbc.business.entity.Goods;
import com.zjlong.studyjdbc.business.entity.UserGoods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserGoodsMapper {

//    数据分片后使用逻辑表名
    @Insert("insert into user_goods(goods_id, user_id, goods_num, buy_date, yearmonth) values (#{goodsId}, #{userId}, #{goodsNum}, #{buyDate}, #{yearmonth})")
    void addUserGoods(UserGoods userGoods);

    @Select("select * from user_goods limit #{pageNo}, #{pageSize}")
    List<UserGoods> findUserGoods(@Param("pageNo") Integer pageNo,@Param("pageSize") Integer pageSize);

    @Select("select count(*) from user_goods")
    List<UserGoods> countUserGoods();

}
