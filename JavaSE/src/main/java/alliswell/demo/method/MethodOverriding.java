package alliswell.demo.method;

/**
 * 方法重写(Overriding Method)
 */
public class MethodOverriding {
    public static void main(String[] args) {
        Dog hd = new HomeDog("阿黄");
//        hd.desc();
        hd.desc("barking");

        int a = 5, b = 10;
        hd.swap(a, b);
        System.out.println("a=" + a + ",b=" + b);

        String as = "5", bs = "10";
        hd.swap(as, bs);
        System.out.println("as=" + as + ",bs=" + bs);

        Dog ad = new HomeDog("阿黄"), bd = new HomeDog("小黑");
        hd.swap(ad, bd);
        System.out.println("ad=" + ad.name + ",bd=" + bd.name);

        ad.staticFun();
        ((HomeDog) ad).staticFun();
    }
}


//基类
class Dog {
    protected String name;

    public Dog(String name) {
        this.name = name;
        System.out.println("Dog:这是一只狗，它的名字是" + this.name);
    }

    protected void desc() {
        System.out.println("I'm a dog");
    }

    //重载
    protected void desc(String action) {
        System.out.println("The dog is " + action);
    }

    // 静态方法
    public static void staticFun() {
        System.out.println("静态方法不能被子类重写");
    }

    void swap(int x, int y) {
        int temp = x;
        x = y;
        y = temp;
    }

    void swap(String x, String y) {
        String temp = x;
        x = y;
        y = temp;
    }

    void swap(Dog x, Dog y) {
        String temp = x.name;
        x.name = y.name;
        y.name = temp;
    }
}


//子类
class HomeDog extends Dog {
    public HomeDog(String name) {
        super(name);
        System.out.println("HomeDog:这是一只狗，它的名字是" + this.name);
    }

    // 重写父类的方法
    @Override
    public void desc() {
        System.out.println("这是一只狗，它的名字是" + this.name);
    }

    // 隐藏父类静态方法
    public static void staticFun() {
        System.out.println("静态方法不能被子类重写，只能被子类隐藏");
    }
}
