package org.alliswell.demo.java8;

import java.time.ZonedDateTime;
import java.time.ZoneId;

public class Java8Tester10 {
    public static void main(String args[]){
        Java8Tester10 java8tester = new Java8Tester10();
        java8tester.testZonedDateTime();
    }

    public void testZonedDateTime(){

        // 获取当前时间日期
        ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
        System.out.println("date1: " + date1);

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);

        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当期时区: " + currentZone);
    }
}