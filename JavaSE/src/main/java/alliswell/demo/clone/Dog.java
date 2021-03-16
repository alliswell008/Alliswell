package alliswell.demo.clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * TODO 功能描述
 *
 * @author chengxs
 * @date 2021/3/1
 */
public class Dog implements Serializable {
    A a;

    public Dog(A a) {
        this.a = a;
    }

    public Dog myClone() {
        Dog dog = null;

        try {
            //将对象序列化成为流，因为写在流是对象里的一个拷贝
            //而原始对象扔在存在JVM中，所以利用这个特性可以实现深拷贝
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);

            //将流序列化为对象
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            dog = (Dog) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return dog;
    }
}
