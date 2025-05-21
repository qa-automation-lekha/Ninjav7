package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPwd;
	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement btnLogin;
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setPwd(String pwd)
	{
		txtPwd.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
}
