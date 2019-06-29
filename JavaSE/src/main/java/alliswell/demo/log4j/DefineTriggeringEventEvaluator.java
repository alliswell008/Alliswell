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

import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.TriggeringEventEvaluator;

/**
 * @author alliswell008
 * @ClassName: Log4jDemo
 * @Description: 1.配置log4j.properties文件，具体配置参见config/log4j.properties
 *               2.加载log4j.properties文件
 *               3.日志记录
 * @date 2016/12/13 11:09
 */
public class DefineTriggeringEventEvaluator implements TriggeringEventEvaluator {

    @Override
    public boolean isTriggeringEvent(LoggingEvent loggingEvent) {
        return loggingEvent.getLevel().isGreaterOrEqual(Level.INFO);
    }
}
