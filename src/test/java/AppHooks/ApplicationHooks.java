/**
 * 
 */
package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * 
 */
public class ApplicationHooks {
	
	private DriverFactory driverFactory;
	private WebDriver webDriver;
	private ConfigReader configReader;
	public Properties prop;
	
	
	@Before(order=0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
	}
	
	@Before(order=1)
	public void launch_browser() {
		String browserName= prop.getProperty("browser");
		driverFactory= new DriverFactory();
		webDriver= driverFactory.init_driver(browserName);
	}
	
	@After(order=0)
	public void quit_browser() {
		webDriver.quit();
	}
	
	@After(order=1)
	public void tearDown(Scenario sc) {
		if(sc.isFailed()) {
			// Then i have give a logic of ScreenShot here.
			String screenShotName= sc.getName().replace(" ", "_");
			// if we wont take in bytes then it will create issues in CI/CD pipelines.
			byte[] source_path= ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BYTES);
			// this will auto attach the screenshot to extent reports as well.
			sc.attach(source_path, "image/png", screenShotName);
		}
		
	}

}
