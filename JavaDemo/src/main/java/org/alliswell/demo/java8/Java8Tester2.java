package org.alliswell.demo.java8;

public class Java8Tester2 {

    // java8 表达式能引用外层局部变量和全局变量，但不能在 java8 内部修改定义在域外的局部变量，否则会编译错误；
    // 而全局变量是可以在 java8 内部修改的
    static String salutation = "Hello! ";

    public static void main(String args[]){
        GreetingService greetService1 = message ->
                System.out.println(salutation += message);
        greetService1.sayMessage("Runoob");
    }

    interface GreetingService {
        void sayMessage(String message);
    }
}