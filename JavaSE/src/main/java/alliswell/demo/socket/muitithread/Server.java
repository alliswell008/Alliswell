package alliswell.demo.socket.muitithread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 服务器
 * @author Administrator
 *
 */
public class Server {

    private int duankou = 9000;//端口号
    private ServerSocket server;//声明服务器
    private static Socket socket;//声明客户端
    private String serName;
    private String cliName;
    public Server(){
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * 创建服务器，开始监听
     */
    private void init() throws IOException{
        server = new ServerSocket(duankou);
        System.out.println("------服务器已开启--------");
        System.out.println("请输入服务器名字：");
        Scanner sc = new Scanner(System.in);
        serName = sc.next();

        int sendCount = 0;
        while(true){
            socket = server.accept();

            //接收客户端的名称
            InputStream is = socket.getInputStream();
            try {
                byte[] b = new byte[1024];
                int length = is.read(b);
                cliName = new String(b,0,length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("接收客户端的名称：" + cliName);

            if (sendCount == 0) {

                // 发送客户端名称
                System.out.println("发送服务端名称：" + serName);
                OutputStream os = socket.getOutputStream();
                os.write(serName.getBytes());
                os.flush();
                sendCount = 1;
            }

            hands(socket);
        }
    }


    private void hands(Socket socket) {
        String key = socket.getInetAddress().getHostAddress()+":"+socket.getPort();
        System.out.println("监听到的客户端："+key);
        Thread thread = new Thread(new ThreadSocket(socket, serName, cliName));
        thread.setName(serName);
        thread.start();
    }

    public static void main(String[] args) {
        Server server = new Server();
    }

}