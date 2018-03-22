package org.alliswell.demo.iodemo;

import java.io.*;

/**
 * Created by Administrator on 2018/3/2.
 */
public class Test {

    public static void main(String[] args) {
//        InputStream is = null;
//        InputStreamReader isr = new InputStreamReader(is);
//
//        OutputStream os = null;
//        OutputStreamWriter osw = new OutputStreamWriter(os);

        outObject();
        inObject();
    }


    public static void outObject() {
        //对象输出流
        ObjectOutputStream objectOutputStream =
                null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("D://obj")));
            objectOutputStream.writeObject(new User("zhangsan", 100));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void inObject() {
        //对象输入流
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(new File("D://obj")));
            User user = (User) objectInputStream.readObject();
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class User implements Serializable {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
