
package automationtesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.grid.selenium.GridLauncherV3;

public class FirstTest {
	private WebDriver driver;
//Java -jar selenium-server-standalone-3.8.1.jar -role hub -port 1200
	//hub - hjain@Jains:~/Downloads/grid$ Java -jar selenium-server-standalone-3.141.59.jar -role hub -port 1200
	//~/Downloads/grid$ xattr -d com.apple.quarantine chromedriver 
	//node setup java -Dwebdriver.chrome.driver="/Users/hjain/Downloads/grid/chromedriver" -jar selenium-server-standalone-3.8.1.jar -role node -hub http://192.168.0.7:1200/grid/register/

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		
		

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName(BrowserType.CHROME);
		dc.setPlatform(Platform.MAC);
		
		ChromeOptions options = new ChromeOptions();
		options.merge(dc);

//DesiredCapabilities dc = DesiredCapabilities.chrome();
	driver = new RemoteWebDriver(new URL("http://192.168.0.7:1200/wd/hub"), options);	
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
	}

	@AfterClass
	public void afterClass() {
	//	driver.quit();
	}

	@Test
	public void verifySearchButton() throws InterruptedException {
		String searchText = "Google Search";
		WebElement searchButton = driver.findElement(By.name("btnK"));
		String text = searchButton.getAttribute("value");

		Assert.assertEquals(text, searchText, "Google search text not present");
		Thread.sleep(10000);
	}
}

