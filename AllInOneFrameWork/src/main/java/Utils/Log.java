package Utils;

import org.apache.log4j.Logger;

public class Log 
{
private static Logger log = Logger.getLogger(Thread.currentThread().getName());
	
	public static void message(String description) {
		log.info(description);
	}
	
	public static void error(String description) {
		log.error(description);
	}
	
	public static void warn(String description) {
		log.warn(description);
	}
	
	public static void fatal(String description) {
		log.fatal(description);
	}
	
	public static synchronized void beginTestCase(String strTestCaseName) {
		log.info("***************************************************************************************************************************");
		log.info("---------------------------------------Beginning of "+strTestCaseName+"----------------------------------------------------");
		log.info("***************************************************************************************************************************");
	}
	
	public static synchronized void endTestCase(String strTestCaseName) {
		log.info("***************************************************************************************************************************");
		log.info("---------------------------------------Ending of "+strTestCaseName+"----------------------------------------------------");
		log.info("***************************************************************************************************************************"); 
	}


}
