package Utils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	/*
	 * Here we are written pre-requitise before execution
	 */
	
	
	private String platformName = null;
	private String environment = null;
	private String appPath = null;
	
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}
	
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
	/**
	 * To Load pre-required parameters for suite level
	 * 
	 * @param platformName - fetching from Test XML file
	 * @param environment    - fetching from Test XML file
	 * 
	 */
	@BeforeSuite(alwaysRun = true)
	@Parameters({"platformName","environment"})
	public void setUp(String platformName, String environment) {
		try {
			
			//Setting the PlatformName
			setPlatformName(platformName);
			
			//Setting the Environment
			setEnvironment(environment);
			
			if(platformName.toLowerCase().equals("chrome")) {
				
			}else if(platformName.toLowerCase().equals("android")){
				
			}else if(platformName.toLowerCase().equals("ios")){
				appPath = System.getProperty("user.dir")+ "src/main/resources/appFiles/apkName.ipa";
			}else {
				Log.message("Please Provide the valid platformName");
			}
			
			System.setProperty("appPath", appPath);
			System.setProperty("platformName", platformName);
			System.setProperty("environment", environment);
			
			
		}catch(Exception e) {
			Log.error("Something went wrong please check... and the error message is "+ e.getMessage());
		}
		
	}
	
	@AfterSuite()
	public void tearDown() {
		
	}
	

}
