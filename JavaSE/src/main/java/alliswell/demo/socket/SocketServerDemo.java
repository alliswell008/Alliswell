package alliswell.demo.socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerDemo {

    public static void main(String[] args) {

        //定义ServerSocket类
        ServerSocket s = null;

        //定义Socket类
        Socket s1;

        //定义发送字符串
        String sendString = "你好！我是服务端...";

        //得到发送字符串的长度
        int s1lenth = sendString.length();

        //定义OutputStream类
        OutputStream s1out;

        //定义DataOutputStream类
        DataOutputStream dos;

        //定义InputStream类
        InputStream s1In;

        //定义DataInputStream类
        DataInputStream dis;

        //通过1314端口建立连接
        try {
            //创建ServerSocket并把传入端口号
            s = new ServerSocket(1314);

        } catch (Exception e) {
            e.printStackTrace();
        }
        int flag = 0;
        //循环运行监听程序，以监视连接请求
        while (true) {
            try {
                //监听端口请求，等待连接
                s1 = s.accept();

                //得到与socket相连接的数据流对象
                s1out = s1.getOutputStream();
                dos = new DataOutputStream(s1out);


                if (flag == 0) {
                    //发送字符串
                    dos.writeUTF(sendString);
                    flag ++;
                } else {
                    //获取控制台输入的内容
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                    System.out.print("请输入发送的字符串：");
                    sendString = bufferedReader.readLine();
                    dos.writeUTF(sendString);
                }

                //获得socket端口的输入句柄，并从中读取数据
                s1In = s1.getInputStream();
                dis = new DataInputStream(s1In);
                String st = new String(dis.readUTF());
                System.out.println(st);

                dis.close();
                s1In.close();
                //关闭数据流（但不是关闭Socket连接）
                dos.close();
                s1out.close();
                s1.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}