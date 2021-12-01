package com.zjlong.studyjdbc.business.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserGoods implements Serializable {
    private Long userGoodsId;

    private Long goodsId;

    private Long userId;

    private int goodsNum;

    private Date buyDate;

    private String yearmonth;
}
