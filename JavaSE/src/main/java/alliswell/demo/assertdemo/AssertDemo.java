package alliswell.demo.assertdemo;

public class AssertDemo {

    public static void main(String[] args) {

        boolean catchFlag = false;
        try {
            /**
             * 注意：
             * 1.在运行的时候，正常情况下assert是不会生效的，因为运行时assert是关闭的，想要使用，必须在VM启动参数中开启：-enableassertions 或者 -ea
             * 2.assert意为断言的意思，这个关键字可以判断布尔值的结果是否和预期的一样，如果一样就正常执行，否则会抛出AssertionError。
             * 3.AssertionError继承至Error而不是一个Exception，无法被try-catch捕获，程序在抛出AssertionError后直接执行结束。
             * 4.finally语句会在抛出AssertionError之前执行
             */
            assert 1 < 0 == true : "1小于0是false，与预期的true不一致";
        } catch (Exception e) {
            catchFlag = true;
        } finally {
            if (catchFlag) {
                System.out.println("捕获AssertionError");
            } else {
                System.out.println("没有捕获AssertionError");
            }

            // 这里会执行，并且不再抛出之前的AssertionError，程序直接执行结束
            // assert 1 < 0 == true: "新的AssertionError";
        }

        // 这里并不会执行，因为在前面抛出AssertionError时，程序已经执行结束
        assert 1 < 0 == true;
    }
}
