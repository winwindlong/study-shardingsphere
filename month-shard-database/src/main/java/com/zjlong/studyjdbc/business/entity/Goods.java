package com.zjlong.studyjdbc.business.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Goods implements Serializable {
    private Long goodsId;

    private String goodsName;

    private Long goodsType;

    private Date sysDate;
}
