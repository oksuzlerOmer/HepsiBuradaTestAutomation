package Factory;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {


	public enum DriverType
	{CHROME,FIREFOX,EDGE};

	public static RemoteWebDriver createDriver(DriverType type) {
		switch(type) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver","C:\\Users\\omarr\\eclipse-workspace\\HepsiBuradaBDDTest06102021\\src\\test\\resources\\drivers\\chromedriver.exe");
			return new ChromeDriver();
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver","C:\\Users\\omarr\\eclipse-workspace\\HepsiBuradaBDDTest06102021\\src\\test\\resources\\drivers\\geckodriver.exe");
			return new FirefoxDriver();
		case EDGE:
			System.setProperty("webdriver.msedge.driver","C:\\Users\\omarr\\eclipse-workspace\\HepsiBuradaBDDTest06102021\\src\\test\\resources\\drivers\\msedge.exe");
			return new EdgeDriver();
		default: 
			System.setProperty("webdriver.chrome.driver","C:\\Users\\omarr\\eclipse-workspace\\HepsiBuradaBDDTest06102021\\src\\test\\resources\\drivers\\chromedriver.exe");
			return new ChromeDriver();
		}
	}



}
