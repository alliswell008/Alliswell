package alliswell.demo.generics;

/**
 * PECS原则（Producer Extends Consumer Super）：
 *
 * <p>频繁往外读取内容的，适合用上界Extends。
 * <p>经常往里插入的，适合用下界Super。
 *
 * @author chengxs
 * @date 2020/5/20
 */
public class Plate<T> {
    private T item;

    public Plate(T t) {
        item = t;
    }

    public void set(T t) {
        item = t;
    }

    public T get() {
        return item;
    }

    public static void main(String[] args) {
        // 装苹果的盘子 NOT-IS-A 装水果的盘子
//        Plate<Fruit> p11=new Plate<Apple>(new Apple()); // error
        // 苹果 IS-A 水果
        Plate<Fruit> p12 = new Plate<Fruit>(new Apple());

        // 装苹果的盘子 IS-A 装水果的盘子
        Plate<? extends Fruit> p21 = new Plate<Apple>(new Apple());
        // 不能存入任何元素
//        p21.set(new Fruit()); // error
//        p21.set(new Apple()); // error
//        p21.set(new Food()); // error

        //读取出来的东西只能存放在Fruit或它的基类里。
        Fruit newFruit1 = p21.get();
        Food newFruit2 = p21.get();
        Object newFruit3 = p21.get();
//        Apple newFruit4=p21.get(); //Error

        System.out.println(p21.get().name);
        System.out.println(newFruit1.name);
        System.out.println(newFruit2.name);


        // 装食物的盘子 IS-A 装水果及其基类的盘子
        Plate<? super Fruit> p31 = new Plate<Food>(new Meat());
        // 装水果的盘子 IS-A 装水果及其基类的盘子
        Plate<? super Fruit> p32 = new Plate<Fruit>(new Apple());


        //存入元素正常
//        p31.set(new Fruit());
//        p31.set(new Apple());
//        p31.set(new Meat()); // error

        //读取出来的东西只能存放在Object类里。
//        Apple newFruit31 = p31.get(); //Error
//        Fruit newFruit32 = p31.get(); //Error
//        Food newFruit33 = p31.get(); //Error
        Object newFruit34 = p31.get();
        System.out.println(((Meat)newFruit34).name);

    }
}