package org.alliswell.demo.socketdemo.muitithread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 客户端
 * @author Administrator
 *
 */
public class Client {

    private int port = 9000;
    private String ip="127.0.0.1";
    private static Socket socket;
    private String serName;
    private String cliName;
    public Client(){
        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() throws Exception {

        System.out.println("-----客户端已开启-----");
        System.out.println("请输入客户端名字：");
        Scanner sc = new Scanner(System.in);
        cliName = sc.next();
        socket = new Socket(ip,port);


        // 发送客户端名称
        System.out.println("发送客户端名称：" + cliName);
        OutputStream os = socket.getOutputStream();
        os.write(cliName.getBytes());
        os.flush();

        //接收客户端的名称
        InputStream is = socket.getInputStream();
        try {
            byte[] b = new byte[1024];
            int length = is.read(b);
            serName = new String(b,0,length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("接收服务端的名称：" + serName);
    }

    public void hands() throws Exception{
        Thread threadReader = new Thread(new ThreadReader(socket.getInputStream()), serName);
        Thread threadWriter = new Thread(new ThreadWriter(socket.getOutputStream()));
        threadWriter.setName(cliName);
        threadReader.start();
        threadWriter.start();

    }

    public static void main(String[] args) throws Exception  {
        Client client = new Client();
        client.hands();
    }

}
