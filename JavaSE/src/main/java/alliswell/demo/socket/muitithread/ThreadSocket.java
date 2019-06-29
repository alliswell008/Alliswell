package alliswell.demo.socket.muitithread;

import java.io.IOException;
import java.net.Socket;

/**
 * 服务器处理Socket线程
 * @author Administrator
 *
 */
public class ThreadSocket implements Runnable{

    private Socket socket;
    private String serName;
    private String cliName;

    public ThreadSocket(Socket socket, String serName, String cliName){
        this.socket = socket;
        this.serName = serName;
        this.cliName = cliName;
    }

    @Override
    public void run() {

        try {
            Thread threadReader = new Thread(new ThreadReader(socket.getInputStream()));
            threadReader.setName(cliName);
            Thread threadWriter = new Thread(new ThreadWriter(socket.getOutputStream()));
            threadWriter.setName(serName);
            threadReader.start();
            threadWriter.start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
