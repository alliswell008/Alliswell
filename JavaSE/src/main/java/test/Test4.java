package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class Test4 {

    static volatile int i = 0;

    static final int j = 0;

    public static void main(String[] args) {
        long st = System.currentTimeMillis();
        fun1();
        long et = System.currentTimeMillis();
        System.out.println(st - et);
    }

    public static void fun() {
        try {
            int bytesum = 0;
            int byteread = 0;

            String newPath = "D:/xyz/2/";
            (new File(newPath)).mkdirs();

            String oldFileStr = "D:/xyz/1/同步住户卡.txt";
            File oldFile = new File(oldFileStr);
            if (oldFile.exists()) {                  //文件存在时
                InputStream inStream = new FileInputStream(oldFileStr);      //读入原文件
                FileOutputStream fs = new FileOutputStream(newPath + "同步住户卡.txt");
                byte[] buffer = new byte[2048];
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread;            //字节数 文件大小
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
                fs.close();
                oldFile.delete();
            }

        }  catch (Exception e) {
            System.out.println("复制单个文件操作出错");
            e.printStackTrace();
        }
    }

    public static void fun1() {

        for(int i=0; i<100000; i++){};
//        for( ; i<100000; i++) {};
        System.out.println(i);
    }
}
