package alliswell.demo.socket.muitithread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// TODO 多线程实现C/S通信
public class SocketServerExecutorDemo {
    public static ExecutorService customerExecutorService = new ThreadPoolExecutor(3, 5, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

    public static void main(String[] args) {

        int port = 9000;
        //通过1314端口建立连接
        //创建ServerSocket并把传入端口号
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(port);
            //监听端口请求，等待连接
            socket = server.accept();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //循环运行监听程序，以监视连接请求
        while (true) {
            try {
                customerExecutorService.execute(new ReceiveRunner(socket));
                customerExecutorService.execute(new SendRunner(socket));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}