package quarkifi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Elements {
	
	//Decleration
	@FindBy (linkText = "Dropdown")
	private WebElement Dropdown;
	
	@FindBy (xpath = "//select[@id=\"dropdown\"]")
	private WebElement select;
	
	@FindBy (xpath = "//option[contains(text(),'Option 1')]")
	private WebElement option1;
	
	@FindBy (linkText = "JavaScript Alerts")
	private WebElement alert;
	
	@FindBy (xpath = "//button[contains(text(),'Click for JS Alert')]")
	private WebElement popup;
	
	@FindBy (linkText = "Infinite Scroll")
	private WebElement scroll;
	
	
	
	
	

	//initilazation
	public Elements(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	//getters
	public WebElement getDropdown() {
		return Dropdown;
	}
	
	public WebElement getSelect() {
		return select;
	}

	public WebElement getOption1() {
		return option1;
	}

	public WebElement getAlert() {
		return alert;
	}

	public WebElement getPopup() {
		return popup;
	}

	public WebElement getScroll() {
		return scroll;
	}
	
	
		
}

