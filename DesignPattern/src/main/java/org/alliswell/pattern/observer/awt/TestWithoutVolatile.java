package org.alliswell.pattern.observer.awt;

/**
 * Created by Administrator on 2018/2/7.
 */
public class TestWithoutVolatile {
    private static volatile boolean bChanged;

    public static void main(String[] args) throws InterruptedException {
//        new Thread() {
//
//            @Override
//            public void run() {
//                for (;;) {
//                    if (bChanged == !bChanged) {
//                        System.out.println("!=");
//                        System.exit(0);
//                    }
//                }
//            }
//        }.start();
//        Thread.sleep(1);
//        new Thread() {
//
//            @Override
//            public void run() {
//                for (;;) {
//                    bChanged = !bChanged;
//                }
//            }
//        }.start();

        new Thread() {

            @Override
            public void run() {
                for (;;) {
                    TestInstance instance = TestInstance.getInstance();
                    System.out.println(this.getName() + instance);
                }
            }
        }.start();
        Thread.sleep(1);
        new Thread() {

            @Override
            public void run() {
                for (;;) {
                    TestInstance instance = TestInstance.getInstance();
                    System.out.println(this.getName() + instance);
                }
            }
        }.start();
    }

}


class TestVolatile {
    static int i = 0, j = 0;
    static /*synchronized*/ void one() { i++; j++; }
    static /*synchronized*/ void two() {
        System.out.println("i=" + i + " j=" + j + " i == j" + (i == j));
    }
}

class TestInstance {

    private /*volatile*/ static TestInstance instance;

    public static TestInstance getInstance() { //1
        if (instance == null) {                  //2
            synchronized (TestInstance.class) {//3
                if (instance == null) { //4
                    instance = new TestInstance();//5
                }
            }
        }
        return instance;//6
    }
}