package org.alliswell.demo.enumdemo;

public class EnumDemo {

    public static void main(String[] args) {
        System.out.println(State.start);
        System.out.println(State.start.getPrivateValue());
        System.out.println(State.start.getPublicValue());
        // 枚举类是类的内部类时私有的属性也可以直接访问，在外部时私有属性不能直接访问
        System.out.println(State.start.privateValue);
        System.out.println(State.start.publicValue);
    }

    enum State {
        start(1), won(2), running(3), over(4);

        public int publicValue;
        private int privateValue;

        State(int value) {
            this.publicValue = value;
            this.privateValue = value;
        }

        public int getPublicValue() {
            return publicValue;
        }

        public int getPrivateValue() {
            return privateValue;
        }
    }
}



