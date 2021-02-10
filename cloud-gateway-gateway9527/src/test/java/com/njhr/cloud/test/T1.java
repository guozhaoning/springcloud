package com.njhr.cloud.test;

import org.junit.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class T1 {
    @Test
    public void test1() {
        //默认时区
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
        //从指定时区获取时间
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now(ZoneId.of("America/New_York"));
    }
}
