package logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingExample {
	
	private static final Logger logger = LogManager.getLogger(LoggingExample.class);

	public static void main(String[] args) {

		logger.info("Info");
		logger.debug("bug");
		logger.error("error");
		logger.trace("trace");
		logger.fatal("fatal");
		logger.warn("warning");

	}

}
