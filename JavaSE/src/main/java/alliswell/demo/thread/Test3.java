package alliswell.demo.thread;

/**
 * 运行看看结果，然后在finally打个断点debug运行看一下结果
 *
 * @author chengxs
 * @date 2020/12/11
 */
public class Test3 {
    public static void main(String[] args) {
        System.out.println(new B().getValue());
    }

    static class A {
        protected int value;

        public A(int v) {
            setValue(v);
        }
        public void setValue(int value) {
            this.value = value;
        }
        public int getValue() {
            try {
                value++;
                return value;
            } catch (Exception e) {
                System.out.println(e.toString());
            } finally {
                // finally语句会在return之前执行
                System.out.println("finally语句：" + this.value);
                this.setValue(value);
                System.out.println(value);
            }
            return value;
        }
    }
    static class B extends A {
        public B() {
            super(5);
            setValue(getValue() - 3);
        }
        @Override
        public void setValue(int value) {
            super.setValue(2 * value);
        }
    }
}