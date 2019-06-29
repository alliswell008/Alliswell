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

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class LogRunner implements Runnable{
    private static final Logger logger = Logger.getLogger(LogRunner.class);
    private ObjectInputStream ois;

    public LogRunner(Socket client) {
        try {
            this.ois = new ObjectInputStream(client.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            while (true) {
                Object obj= ois.readObject();
                System.out.println(obj.toString());
                LoggingEvent loggingEvent = (LoggingEvent) obj;
                System.out.println(loggingEvent.getMessage());

//                if (loggingEvent.getLevel().equals(Level.ERROR)) {
                logger.error(loggingEvent.getMessage().toString());
//                }
            }
        } catch(java.io.EOFException e) {
            //读取的时候到达尾端抛出的异常，屏蔽掉
        } catch(java.net.SocketException e) {
        } catch(InterruptedIOException e) {
            Thread.currentThread().interrupt();
        } catch(IOException e) {
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}  