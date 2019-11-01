package Pojo_Practice_before_Framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jclass {
	
	static Logger logger = LogManager.getLogger(Log4jclass.class);

	public static void main(String[] args) {
		
		logger.debug("Debug Mode On");
		logger.error("Error mode On");
		logger.fatal("Unknown error mode");
		logger.warn("Warning mode on");
		logger.info("information mode on");
	}

}
