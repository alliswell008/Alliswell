/**
 * @Title: ExceptionDemo.java
 * @Package com.alliswell008.exception
 * @Description: 异常的使用
 * @author alliswell
 * @date 2016-11-20 下午2:03:53
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package org.alliswell.demo.exceptiondemo;

/**
 * @ClassName: ExceptionDemo
 * @Description: 未捕获的异常，其后的代码将不执行,除finally语句块外
 *               此例中在方法fun1()出现异常后方法fun2()未被执行
 *               而方法fun11()出现异常后方法fun12()仍被执行
 * @author alliswell
 * @date 2016-11-20 下午2:03:53
 *
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            fun1();//出现异常处直接处理异常
            fun2();//出现异常处
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                throw new Exception("exception finally");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void fun1() throws Exception {
        try {
            fun11();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        fun12();
    }

    public static void fun2() throws Exception {
        throw new Exception("exception2");
    }

    public static void fun11() {
        try {
            throw new Exception("exception11");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void fun12() throws Exception {
        throw new Exception("exception12");
    }
}
