package com.zjlong.studyjdbc.business.mapper;

import com.zjlong.studyjdbc.business.entity.Goods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsMapper {

//    数据分片后使用逻辑表名
    @Insert("insert into goods0(goods_id, goods_name, goods_type, sys_date) values (#{goodsId}, #{goodsName}, #{goodsType}, #{sysDate})")
    void addGoods(Goods goods);

    @Select("select * from goods0")
    List<Goods> findGoods();
}
