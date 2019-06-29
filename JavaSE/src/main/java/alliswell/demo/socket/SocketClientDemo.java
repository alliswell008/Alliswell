package alliswell.demo.socket;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class SocketClientDemo {

    public static void main (String[]args) {

        //定义Socket类
        Socket s1;

        //定义InputStream类
        InputStream s1In;

        //定义DataInputStream类
        DataInputStream dis;


        //定义发送字符串
        String sendString = "你也好！我是xxx...";

        //得到发送字符串的长度
        int s1lenth = sendString.length();

        //定义OutputStream类
        OutputStream s1out;

        //定义DataOutputStream类
        DataOutputStream dos;

        try {

            while (true) {
            //在端口1314打开连接
            s1 = new Socket("127.0.0.1", 1314);

            //获得socket端口的输入句柄，并从中读取数据
            s1In = s1.getInputStream();
            dis = new DataInputStream(s1In);
            String st = new String(dis.readUTF());
            System.out.println(st);


                //得到与socket相连接的数据流对象
                s1out = s1.getOutputStream();
                dos = new DataOutputStream(s1out);

                //获取控制台输入的内容
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("请输入发送的字符串：");
                sendString = bufferedReader.readLine();
                dos.writeUTF(sendString);

                dos.close();
                s1out.close();
                //操作结束，关闭数据流及socket连接
                dis.close();
                s1In.close();
                s1.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
