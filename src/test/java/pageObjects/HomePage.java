package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath = "//i[@class='fa-solid fa-user']")
	WebElement link_MyAccount;
	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement link_Login;
	
	@FindBy(xpath = "//img[@title='Your Store']")
	WebElement logoOpenCart;
	
	@FindBy(xpath = "//a[normalize-space()='Laptops & Notebooks']")
	WebElement tab_LapAndTab;
	@FindBy(xpath = "//a[normalize-space()='Show All Laptops & Notebooks']")
	WebElement show_AllLapAndTab;
	
	public void clickMyAccount()
	{
		link_MyAccount.click();
	}
	
	public void clickLogin()
	{
		link_Login.click();
	}	
	
	public void clickLogoOpenCart()
	{
		logoOpenCart.click();
	}	
	
	public void clickLapAndTab()
	{
		tab_LapAndTab.click();
	}
	
	public void clickAllLapAndTab()
	{
		show_AllLapAndTab.click();
	}
}
