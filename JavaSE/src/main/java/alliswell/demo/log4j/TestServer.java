/**
 * @Title: Log4jDemo
 * @Package org.alliswell.demo.log4j
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
package alliswell.demo.log4j;

import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
    public static void main(String[] args) throws IOException {

        ServerSocket socket = new ServerSocket(4560);
        while (true) {
            String configFile = "D:\\alliswell\\server\\gitserver\\Alliswell\\JavaDemo\\src\\main\\resources\\config\\log4j-server.properties";
            PropertyConfigurator.configure(configFile);
            Socket client = socket.accept();
            Thread t = new Thread(new LogRunner(client));
            t.start();
        }
    }
}