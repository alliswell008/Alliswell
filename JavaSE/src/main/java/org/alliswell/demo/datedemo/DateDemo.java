/**
 * @Title: DateDemo.java
 * @Package org.org.alliswell.demo.datedemo
 * @Description: 日期时间的使用
 * @author org.alliswell
 * @date 2016-11-20 上午11:21:45
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package org.alliswell.demo.datedemo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @ClassName: DateDemo
 * @Description: Java中日期的经常有一下五个方面：
 *               1、创建日期
 *               2、日期格式化显示
 *               3、日期的转换（主要是和字符串之间的相互转换）
 *               4、日期中年、月、日、时、分、秒、星期、月份等获取。
 *               5、日期的大小比较、日期的加减。
 *               6、涉及类：
 *                      java.util.Date、java.text.DateFormat（抽象类）、
 *                      java.text.SimpleDateFormat（DateFormat的直接子类）、
 *                      java.util.Calendar（抽象类）、
 *                      java.util.GregorianCalendar（Calendar的直接子类）
 * @author org.alliswell
 * @date 2016-11-20 上午11:21:45
 */
public class DateDemo {
    public static void main(String[] args) throws ParseException {

        String ctime = "2017-01-03 01:01:01";
        String strYesterday = "";
        Calendar cal   =   Calendar.getInstance();
        cal.add(Calendar.DATE, -1);

        strYesterday = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS").format(cal.getTime());
        System.out.println("------------"+strYesterday);
        System.out.println("------------"+ctime);

        System.out.println("------------=" + getDateDiffValue(ctime, strYesterday, "yyyy-MM-dd HH:mm"));

        // 创建日期：创建有多种方式
        // 创建方式一：
        Date date1 = new Date();
        Date date11 = new Date(1000 * 1438725620L);// long类型转化成Date
        // 创建方式二：
        Date date2 = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").parse("2016-10-19 1:00:00");// String类型转化为Date
        // 格式"yyyy-mm-dd hh:mm:ss EE"解析日期时间"2016-10-19 1:00:00"会异常
//        Date date21 = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss EE").parse("2016-10-19 1:00:00");
        // 创建方式三：
        Date date3 = new Date();
        date3.setTime(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());
        // 创建方式四：
        Calendar calendar = Calendar.getInstance();
        Date date4 = calendar.getTime();
        calendar.setTimeInMillis(1000 * 1438725620L);
        Date date5 = calendar.getTime();

        String strDate2 = "2016-10-19 1:00:00 星期二";
        // 定义日期时间显示格式
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        DateFormat dateFormat2 = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss EE");
        //产生一个指定国家指定长度的日期格式，长度不同，显示的日期完整性也不同
        DateFormat dateFormat3 = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA);
        DateFormat dateFormat4 = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒 EE", Locale.CHINA);
        DateFormat dateFormat5 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss EEEE", Locale.US);

        // 按照日期格式显示，其实也就是将Date类型转化为String类型
        System.out.println("---------");
        System.out.println(dateFormat1.format(date1));
        System.out.println(dateFormat1.format(date11));
        System.out.println(dateFormat1.format(date2));
        System.out.println(dateFormat1.format(date3));
        System.out.println(dateFormat1.format(date4));
        System.out.println(dateFormat1.format(date5));
        System.out.println("---------");
        System.out.println(dateFormat2.format(date1));
        System.out.println(dateFormat2.format(date11));
        System.out.println(dateFormat2.format(date2));
        System.out.println(dateFormat2.format(date3));
        System.out.println(dateFormat2.format(date4));
        System.out.println(dateFormat2.format(date5));
        System.out.println("---------");
        System.out.println(dateFormat3.format(date1));
        System.out.println(dateFormat3.format(date11));
        System.out.println(dateFormat3.format(date2));
        System.out.println(dateFormat3.format(date3));
        System.out.println(dateFormat3.format(date4));
        System.out.println(dateFormat3.format(date5));
        System.out.println("---------");
        System.out.println(dateFormat4.format(date1));
        System.out.println(dateFormat4.format(date11));
        System.out.println(dateFormat4.format(date2));
        System.out.println(dateFormat4.format(date3));
        System.out.println(dateFormat4.format(date4));
        System.out.println(dateFormat4.format(date5));
        System.out.println("---------");
        System.out.println(dateFormat5.format(date1));
        System.out.println(dateFormat5.format(date11));
        System.out.println(dateFormat5.format(date2));
        System.out.println(dateFormat5.format(date3));
        System.out.println(dateFormat5.format(date4));
        System.out.println(dateFormat5.format(date5));
        System.out.println("---------");
        long cTime = System.currentTimeMillis();
        long lTime = System.currentTimeMillis()-1L;
        System.out.println(dateFormat5.format(new Date(cTime)));
        System.out.println(dateFormat5.format(new Date(lTime)));

    }


    private static int getDateDiffValue(String strDate1, String strDate2, String dateFormat) {
        DateFormat df = new SimpleDateFormat(dateFormat);
//        strDate1 = df.format(strDate1);
//        strDate2 = df.format(strDate2);
        int num = 1000 * 3600 * 24;
        if ("yyyy-MM-dd HH:mm".equals(dateFormat)) {
            num = 1000 * 60 * 5;
        }
        Date date1 = new Date();
        Date date2 = new Date();

        try {
            date1 = df.parse(strDate1);
            date2 = df.parse(strDate2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        Date dd = cal.getTime();
        cal.setTime(date2);
        Date dd2 = cal.getTime();

        int days = (int) ((date2.getTime() - date1.getTime()) / num);
        return days;
    }
}
