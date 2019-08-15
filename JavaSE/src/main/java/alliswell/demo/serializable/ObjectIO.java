package alliswell.demo.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//创建要写入磁盘的类，这个类需要实现接口 Serializable（可系列化的）
class Student implements Serializable{

    // 在这里保证了serialVersionUID 的唯一性，防止属性变量的临时改变，从而造成写入serialVersionUID与读取serialVersionUID不同
    // RPC远程调用（即跨jvm调用）时此id不一致会导致反序列化失败
    private static final long serialVersionUID = 1L;

    String name ;
    transient String sex; //transient修饰属性，表示暂时的，则这个属性不会被写入磁盘
    transient int age;

    public Student(String name,String sex,int age){
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
}


public class ObjectIO {

    public static final String TEST_DIR_ROOT = "D:\\ObjectIO\\";
    public static final String TEST_DIR_PATH = "aa\\";
    public static final String TEST_FILE_TXT = "objTest.txt";

    /**
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // TODO Auto-generated method stub

        createObj();
        readObj();
    }

    //（一）先写入对象
    public static void createObj() throws IOException {
        //1.创建目标路径
        File dir = new File(TEST_DIR_ROOT + TEST_DIR_PATH );
        if (!dir.isDirectory() && !dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(TEST_DIR_ROOT + TEST_DIR_PATH + TEST_FILE_TXT);
        if (!file.exists()) {
            file.createNewFile();
        }
        //2.创建流通道
        FileOutputStream fos = new FileOutputStream(file);
        //3.创建对象输出流
        ObjectOutputStream objOP = new ObjectOutputStream(fos);
        //4.创建类对象，并初始化
        Student stu = new Student("玛丽苏", "男", 18);
        //5.向目标路径文件写入对象
        objOP.writeObject(stu);
        //6.关闭资源
        objOP.close();
    }

    //再读取对象
    public static void readObj() throws IOException, ClassNotFoundException {
        File file = new File(TEST_DIR_ROOT + TEST_DIR_PATH + TEST_FILE_TXT);
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream objIP = new ObjectInputStream(fis);
        //读取对象数据，需要将对象流强制转换为 要写入对象的类型
        Student stu = (Student)objIP.readObject();
        System.out.println("\n name:"+stu.name+"\n sex:"+stu.sex+"\n age:"+stu.age);
        objIP.close();

        // 读取完毕，删除文件及目录
        File dir = new File(TEST_DIR_ROOT);
        deleteFile(dir);
    }

    // 删除目录及目录中的所有文件
    public static boolean deleteFile(File file) {
        if (!file.exists()) {
            return false;
        }

        // 要删除目录，需先删除目录中的所有文件及目录
        if (file.isDirectory()) {
            File[] subfiles = file.listFiles();
            for (File f : subfiles) {
                deleteFile(f);
            }
        }
        return file.delete();
    }

}

/*打印效果

        name:玛丽苏
        sex:null       //后面的这连个属性使用了 transient修饰
        age:0
        用到方法：writeObject(Object o); //向磁盘写入对象

                readObject(); //读取磁盘的对象，注意这里需要强制类型

        对象输入输出流的使用注意点：
        1.如果想将一个对象写入到磁盘中，那么对象所属的类必须要进行序列化，实现Serializable 接口，Serializable接口没有任何方法 ，是一个标记接口
        2.如果对象所属的类的成员变量发生改变，你在读取原来的对象是就会报错，如果想要解决报错，保证serialVersionUID是唯一。
        3.如果你不想将某些信息存入到磁盘 就可以同过transient关键字修饰成员变量
        4.如果一个类中引用了另外的一个类，那么另外的这个类也要实现Serializable接口。

        如果：
            at java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1184)
            at java.io.ObjectOutputStream.writeObject(ObjectOutputStream.java:348)
        出现这样的异常，说明要写入的类没有实现接口Serializable
        */