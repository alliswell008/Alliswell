/**
 * @Title: IfElseDemo.java
 * @Package com.alliswell008.ifelse
 * @Description: ifelse和多if的使用
 * @author org.alliswell
 * @date 2016-11-20 下午2:26:31
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package org.alliswell.demo.ifelsedemo;

/**
 * @ClassName: IfElseDemo
 * @Description: 本程序旨在说明区别：ifelse的多条件语句和多个if条件语句。
 *               分支语句ifelse只会执行第一个满足条件的分支，而if语句会顺序执行
 * @author org.alliswell
 * @date 2016-11-20 下午2:26:31
 *
 */
public class IfElseDemo {
    public static void main(String[] args) {
        String type = "";
        String othFlagStr = "000099990000";

        // ifelse分支语句开始
        if ("9".equals(othFlagStr.substring(4, 5))) {// othFlag[5]=9表示上传立案
            type = "05";
            System.out.println("并列的ifelse语句运行结果：" + type);
        } else if ("9".equals(othFlagStr.substring(5, 6))) {// othFlag[6]=9表示上传赔案
            type = "06";
            System.out.println("并列的ifelse语句运行结果：" + type);
        } else if ("9".equals(othFlagStr.substring(6, 7))) {// othFlag[6]=9表示上传注销/拒赔
            type = "07";
            System.out.println("并列的ifelse语句运行结果：" + type);
        }
        // ifelse分支语句结束

        // if条件语句开始
        if ("9".equals(othFlagStr.substring(4, 5))) {// othFlag[5]=9表示上传立案
            type = "05";
            System.out.println("并列的if语运行结果：" + type);
        }
        if ("9".equals(othFlagStr.substring(5, 6))) {// othFlag[6]=9表示上传赔案
            type = "06";
            System.out.println("并列的if语运行结果：" + type);
        }
        if ("9".equals(othFlagStr.substring(6, 7))) {// othFlag[6]=9表示上传注销/拒赔
            type = "07";
            System.out.println("并列的if语运行结果：" + type);
        }
        // if条件语句结束

        System.out.println("通过此程序说明ifelse只会执行一个ifelse分支语句，而if语句会顺序执行");

    }
}
