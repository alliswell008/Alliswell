/**
 * 
 */
package alliswell.demo.log4j;

import org.apache.log4j.Logger;

/**
 * @author lpf
 *
 */
public final class UserOperatorFactory {
	private static UserOperatorFactory userOperator;

	private UserOperatorFactory() {

	}

	public static synchronized UserOperatorFactory getInstance() {
		if (null == userOperator) {
			userOperator = new UserOperatorFactory();
		}
		return userOperator;
	}

	public void writeUserLogger(final LoggerModel model) {
		
		CustomThreadPool.execute(new Runnable() {
			
			Logger uLog = Logger.getLogger(Log4jDemo.class);;
			
			@Override
			public void run() {				 
				 uLog.info(model.toString());
			}
		});
	}
}
