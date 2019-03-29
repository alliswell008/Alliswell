package org.alliswell.demo.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

//@FunctionalInterface
//public interface Supplier<T> {
//    T get();
//}

class Car {
    String name = "aaa";

    public Car() {

    }

    public Car(String name) {
        this.name = name;
    }

    //Supplier是jdk1.8的接口，这里和lamda一起使用了
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.name);
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.name);
    }

    public void repair() {
        System.out.println("Repaired " + this.name);
    }

}

public class Java8Tester5 {
    public static void main(String[] args) {
        //构造器引用：它的语法是Class::new，或者更一般的Class< T >::new实例如下：

        final Car car = Car.create( Car::new );
        List< Car > cars = Arrays.asList( car );
        System.out.println(cars);
        cars.forEach(System.out::println);

        final Car car1 = Car.create(Car::new);
        cars = Arrays.asList( car1 );
        cars.forEach(System.out::println);
        //静态方法引用：它的语法是Class::static_method，实例如下：

        cars.forEach( Car::collide );
        //特定类的任意对象的方法引用：它的语法是Class::method实例如下：

        cars.forEach( Car::repair );
        //特定对象的方法引用：它的语法是instance::method实例如下：

        final Car police = Car.create( Car::new );
        cars.forEach( police::follow );
    }
}
