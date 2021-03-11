
package automationtesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.grid.selenium.GridLauncherV3;

public class FirstTestUsingBrowserStack {
	private WebDriver driver;
	public static final String USERNAME = "harshitjain16";
	public static final String AUTOMATE_KEY = "qsXftBrbp8umtC5Fq2UX";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
        
		caps.setCapability("os", "OS X");
		caps.setCapability("os_version", "Catalina");
		caps.setCapability("browser", "Chrome");
		caps.setCapability("browser_version", "88.0");
		caps.setCapability("name", "harshitjain16's First Test");
		
		driver = new RemoteWebDriver(new URL(URL), caps);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
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

