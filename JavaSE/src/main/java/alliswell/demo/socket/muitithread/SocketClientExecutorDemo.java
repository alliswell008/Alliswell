package alliswell.demo.socket.muitithread;


import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SocketClientExecutorDemo {
    public static ExecutorService customerExecutorService = new ThreadPoolExecutor(3, 5, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());


    public static void main (String[]args) {

        //定义Socket类
        Socket socket;
        //定义发送字符串
        try {
            //在端口1314打开连接
            socket = new Socket("127.0.0.1", 9000);
            customerExecutorService.execute(new ReceiveRunner(socket));
            customerExecutorService.execute(new SendRunner(socket));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
