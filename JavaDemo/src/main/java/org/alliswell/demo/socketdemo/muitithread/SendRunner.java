/**
 * @Title: Log4jDemo
 * @Package org.alliswell.demo.log4jdemo
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2016/12/13 11:09
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package org.alliswell.demo.socketdemo.muitithread;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SendRunner implements Runnable {
    private static final Logger logger = Logger.getLogger(SendRunner.class);
    private volatile DataOutputStream dos;
    private volatile OutputStream os;
    private volatile int flag = 0;

    public SendRunner(Socket socket) {
        try {
//            this.dos = new DataOutputStream(socket.getOutputStream());
            this.os = socket.getOutputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
//        //定义发送字符串
//        String sendString = "你也好！我是xxx...";
//        //循环运行监听程序，以监视连接请求
//        while (true) {
//            try {
//                if (dos != null) {
//                    if (flag == 0) {
//                        //发送字符串
//                        dos.writeUTF(sendString);
//                        flag++;
//                    } else {
//                        //获取控制台输入的内容
//                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//                        System.out.print("请输入发送的字符串：");
//                        sendString = bufferedReader.readLine();
//                        dos.writeUTF(sendString);
//                    }
//                    dos.flush();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
////                System.out.println("发送线程。。。");
//            }
//        }

        try {
            Scanner sc = new Scanner(System.in);
            while(true){
                System.out.println(Thread.currentThread().getName()+"说：");
                String message = sc.next();
                os.write(message.getBytes());
                os.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}  