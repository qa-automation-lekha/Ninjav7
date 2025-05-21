package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAffiliatePage extends BasePage {
	
	public MyAffiliatePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='input-company']")
	WebElement txtCompany;
	
	@FindBy(xpath = "//input[@id='input-website']")
	WebElement txtWebsite;

	@FindBy(xpath = "//input[@id='input-tax']")
	WebElement txtTaxNum;
	
	@FindBy(xpath = "//input[@id='input-payment-cheque']")
	WebElement element1;
	
	@FindBy(xpath = "//input[@id='input-cheque']")
	WebElement payeeName;
	
	@FindBy(xpath = "//button[normalize-space()='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement SuccessTest;
	
	public void fillTextBoxes(String company,String website,String taxnumber,String payeename) throws InterruptedException
	{
		txtCompany.clear();
		txtCompany.sendKeys(company);
		txtWebsite.clear();
		txtWebsite.sendKeys(website);
		txtTaxNum.clear();
		txtTaxNum.sendKeys(taxnumber);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
		Thread.sleep(500);
		element1.click();
		payeeName.clear();
		payeeName.sendKeys(payeename);
		btnContinue.click();
	}
	
	public boolean successMsg()
	{
		return SuccessTest.isDisplayed();
	}
}
