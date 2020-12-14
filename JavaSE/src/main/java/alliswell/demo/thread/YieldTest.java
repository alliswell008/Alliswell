package alliswell.demo.thread;

/**
 * yield方法使当前线程进入就绪状态，使其与其他就绪状态的线程重新争夺执行机会。
 * 因此执行的机会可能会被重新获得，也可能会被其他线程获得，致使yield方法并不能保证一定会把执行机会让给其他线。
 *
 * @author chengxs
 * @date 2020/12/10
 */
public class YieldTest {
    public static void main(String[] args) throws InterruptedException {
        MyYieldThread t1 = new MyYieldThread("t1");
        MyYieldThread t2 = new MyYieldThread("t2");

        // 设置线程的优先级，就绪状态中的线程，优先级高的线程并不一定会最先执行，只是最先执行的概率会大些。
        // 当t1的优先级大于t2的优先级时，若优先级高的一定会先执行，则预期结果：t1会先于t2执行完成，
        // 实际结果：t1执行完成前存在t2执行，同时t1的执行分布靠前一些（优先执行）
        t1.setPriority(7);
        t2.setPriority(5);

        t1.start();
        /** join的作用参见{@link JoinTest}，它可以屏蔽掉yield方法的作用*/
//        t1.join();
        t2.start();
    }
}

class MyYieldThread extends Thread {
    MyYieldThread(String s) {
        super(s);
    }

    @Override
    public void run() {
        for (int i = 0; i <= 30; i++) {
            System.out.println(getName() + ":" + i);
            if (("t1").equals(getName())) {
                if (i == 0) {
                    // 使当前线程从运行状态变为就绪状态
                    yield();
                }
            }
        }
    }

}
