package quarkifi;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class testcase3 {
	@Test(priority = 3)
	public void scroll() throws InterruptedException {
		
		ChromeOptions opt  = new ChromeOptions();
		opt.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(opt);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://the-internet.herokuapp.com");
		
		Elements prop = new Elements(driver);
		
		Actions act = new Actions(driver);
		Thread.sleep(1000);

		act.scrollToElement(prop.getScroll()).perform();
		Thread.sleep(1000);
		prop.getScroll().click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int totcount = 2000;        // how many times the loop runs
		int  count= 0;
		long lastcount = (long) js.executeScript("return document.body.scrollHeight");

		while (count < totcount) {
		    // Scroll bottom
		    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		    // Wait for loading
		    Thread.sleep(500);

		    // new scroll
		    long newcount = (long) js.executeScript("return document.body.scrollHeight");

		    if (newcount == lastcount) {
		        // No loading, increace count
		        count++;
		    } else {
		        // loading, update count
		        count = 0;
		        lastcount = newcount;
		    }
		}
	}

}

