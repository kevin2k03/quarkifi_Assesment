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
		int totcount = 2000;        // Max retries after no height change before exit
		int  count= 0;
		long lastcount = (long) js.executeScript("return document.body.scrollHeight");

		while (count < totcount) {
		    // Scroll to bottom
		    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		    // Wait for content to load (adjust wait time as needed)
		    Thread.sleep(500);

		    // Get new scroll height
		    long newcount = (long) js.executeScript("return document.body.scrollHeight");

		    if (newcount == lastcount) {
		        // No new content loaded, increase try counter
		        count++;
		    } else {
		        // New content loaded, reset try counter and update lastHeight
		        count = 0;
		        lastcount = newcount;
		    }
		}
	}

}
