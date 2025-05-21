package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//h1[normalize-space()='My Account']")
	WebElement myAccount;
	
	 @FindBy(xpath = "//a[normalize-space()='Affiliate']")
	 WebElement element;
	 
	 @FindBy(xpath = "//li[@class='list-inline-item']//i[@class='fa-solid fa-caret-down']")
	 WebElement dropDown_MyAccount;

	@FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Logout']")
	WebElement link_Logout;
	
	public WebElement getMyAccount()
	{
		return myAccount;
	}
	
	public void clickAddAffiliate() throws InterruptedException
	{
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
		element.click();

	}
	
	public void clickMyAccountDropDown() {
		dropDown_MyAccount.click();
	}

	public void clickLogout() {
		link_Logout.click();
	}
}
