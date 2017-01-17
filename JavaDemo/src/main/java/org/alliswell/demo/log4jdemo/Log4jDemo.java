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
package org.alliswell.demo.log4jdemo;

import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.net.SMTPAppender;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @author alliswell008
 * @ClassName: Log4jDemo
 * @Description: 1.配置log4j.properties文件，具体配置参见config/log4j.properties
 *               2.加载log4j.properties文件
 *               3.日志记录
 * @date 2016/12/13 11:09
 */
public class Log4jDemo {

    static Logger logger = Logger.getLogger(Log4jDemo.class);
    private static final org.slf4j.Logger logger2 = LoggerFactory.getLogger(Log4jDemo.class);

    public static void main(String[] args) throws IOException {
        // 绝对路径
//        PropertyConfigurator.configure("D:\\alliswell\\server\\gitserver\\Alliswell\\JavaDemo\\src\\main\\resources\\config\\log4j.properties");
        // 通过user.dir获取绝对路径
        //PropertyConfigurator.configure(System.getProperty("user.dir")+"/JavaDemo/src/main/resources/config/log4j.properties");
        // 通过.获取绝对路径
//        PropertyConfigurator.configure(new File(".").getCanonicalPath() + File.separator + "JavaDemo" + File.separator + "src/main/resources/config/log4j.properties");
//        Logger logger = Logger.getLogger(Log4jDemo.class);
//        logger.debug("debug");
//        logger.error("error");
//        logger.info("info");

//        Logger logger2 = Logger.getLogger("NTlog"); //要和配置文件中设置的名字相同
//        logger2.debug("debug!!!");
//        logger2.info("info!!!");
//        logger2.warn("warn!!!");
//        logger2.error("error!!!");
//        //只有这个错误才会写入2000日志
//        logger2.fatal("fatal!!!");

        //把日志发送到mail
//        sendMailLog4j();
//        String configFile = "D:\\alliswell\\server\\gitserver\\Alliswell\\JavaDemo\\src\\main\\resources\\config\\maillog4j2.properties";
//        sendLog4jByConfigFile(3, configFile);

        //把日志记录到数据库
//        String configFile = "D:\\alliswell\\server\\gitserver\\Alliswell\\JavaDemo\\src\\main\\resources\\config\\jdbclog4j.properties";
//        sendLog4jByConfigFile(3, configFile);

        //把日志发送到远端服务器，远端服务器要进行端口监听
        //运行服务器监听TestServer
//        String configFile = "D:\\alliswell\\server\\gitserver\\Alliswell\\JavaDemo\\src\\main\\resources\\config\\socketlog4j.properties";
//        PropertyConfigurator.configure(configFile);
//        logger2.error("test name:{}");


        System.out.println(null + "");

    }

    /**
     * 测试发送日志邮件
     * Log4j的SMTP的级别默认是ERROR级别，只有调用logger.error("***")方法，才能发送邮件
     */
    public static void sendMailLog4j() {
        SMTPAppender appender = new DefineSMTPAppender();
        try {
            appender.setSMTPUsername("wangyi_cxs@163.com");
            appender.setSMTPPassword("@mm59420!");
            appender.setTo("wangyi_cxs@163.com");
            appender.setFrom("wangyi_cxs@163.com");
            // SMTP服务器 smtp.163.com
            appender.setSMTPHost("smtp.163.com");
            appender.setLocationInfo(true);
            appender.setSubject("Test Mail From Log4J");
//            appender.setLayout(new HTMLLayout());
            // 继承HTMLLayout，重新设置编码方式，解决中文乱码
            appender.setLayout(new DefineLayOut());
            appender.activateOptions();
            // 设置发送邮件的日志级别INFO，默认为ERROR
            // 继承TriggeringEventEvaluator，重写方法isTriggeringEvent
            appender.setThreshold(Level.INFO);
            appender.setEvaluator(new DefineTriggeringEventEvaluator());
            appender.setBufferSize(4);
            logger.addAppender(appender);
            logger.error("测试");
            logger.info("测试");
            logger.debug("测试");
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Printing ERROR Statements", e);
        }
    }

    /**
     * 测试读取配置文件，发送日志邮件
     * @param n ERROR级日志输出次数，每输出一次发送一次邮件
     */
    public static void sendLog4jByConfigFile(int n, String configFile) {
        // 读取Log4j.properties配置文件
        PropertyConfigurator.configure(configFile);
//        PropertyConfigurator.configure(Log4jDemo.class.getResource("/maillog4j.properties"));
        int i = 0;
        while (i < n) {
            i += 1;
            logger.error("Do you received message?");
        }
    }

}
