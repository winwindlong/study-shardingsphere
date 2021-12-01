package com.zjlong.studyjdbc.util;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.*;

public class DateAlgorithm implements PreciseShardingAlgorithm<Date> {

    List<Date> dateList = new ArrayList<>();

    {
        Calendar c1 = Calendar.getInstance();
        c1.set(2021, 1, 1);
        Calendar c2 = Calendar.getInstance();
        c2.set(2022, 1, 1);
        dateList.add(c1.getTime());
        dateList.add(c2.getTime());
    }
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Date> preciseShardingValue) {
        Date date = preciseShardingValue.getValue();
        Iterator<String> iterable = collection.iterator();
        String target = null;
        for (Date s : dateList) {
            target = iterable.next();
            if (date.before(s)) {
                break;
            }
        }
        return target;
    }
}
