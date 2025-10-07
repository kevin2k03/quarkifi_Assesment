package quarkifi;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class testcase2 {
	@Test(priority = 2)
	public void popup() throws InterruptedException {
		
		ChromeOptions opt  = new ChromeOptions();
		opt.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(opt);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://the-internet.herokuapp.com");
		
		Elements prop = new Elements(driver);
		
		Actions act = new Actions(driver);
		Thread.sleep(1000);

		act.scrollToElement(prop.getAlert()).perform();
		Thread.sleep(1000);

		prop.getAlert().click();
		
		prop.getPopup().click();
		
		
		Alert pop = driver.switchTo().alert();
		Thread.sleep(1000);

		pop.accept();
		Thread.sleep(1000);

		driver.close();
	}

}
