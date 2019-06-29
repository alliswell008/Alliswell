/**
 * @Title: Log4jDemo
 * @Package org.a.demo.log4j
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
package alliswell.demo.socket.muitithread;

import org.apache.log4j.Logger;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ReceiveRunner implements Runnable{
    private static final Logger logger = Logger.getLogger(ReceiveRunner.class);
    private volatile DataInputStream dis;
    private volatile InputStream is;

    public ReceiveRunner(Socket socket) {
        try {
//            this.dis = new DataInputStream(socket.getInputStream());
            this.is = socket.getInputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
//        //循环运行监听程序，以监视连接请求
//        try {
//            while (true) {
//                if (dis != null) {
//                    String st = new String(dis.readUTF());
//                    System.out.println("接收：" + st);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
////                System.out.println("接收线程。。。");
//        }
        try {
            while(true){
                byte[] b = new byte[1024];
                int length = is.read(b);
                String message = new String(b,0,length);
                System.out.println(Thread.currentThread().getName()+":"+message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // InputStream接收处理的效率更高，不会出现发送消息后对端接收不到消息
        // 不使用线程池时还不会出现上面说的情况
        // 所以可能跟InputStream和DataInputStream无关，而跟线程池有关
    }
}  