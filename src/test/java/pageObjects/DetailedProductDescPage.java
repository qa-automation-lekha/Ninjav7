package pageObjects;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DetailedProductDescPage extends BasePage {
	
	public DetailedProductDescPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='input-option-225']")
	 WebElement element1;
	@FindBy(xpath = "//button[@id='button-cart']")
	WebElement btnAddCart;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement actualMessage;
	
	@FindBy(xpath = "//div[@class=\"btn-group\"]/button[1]")
	WebElement btnWishList;
	
	@FindBy(xpath = "//a[@title='Checkout']//i[@class='fa-solid fa-share']")
	WebElement element2;

	@FindBy(xpath = "//a[@title='Checkout']//i[@class='fa-solid fa-share']")
	WebElement element5;
	
	public void changeDate() throws InterruptedException
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
		Thread.sleep(500);
		
		element1.clear();
	
		LocalDate currentDate = LocalDate.now();
		// System.out.println(currentDate);
		LocalDate deliveryDate = currentDate.plusDays(5);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = deliveryDate.format(formatter);
		element1.sendKeys(formattedDate);
	}
	
	public void addToCart()
	{
		btnAddCart.click();
	}
	
	public void addToWishList()
	{
		btnWishList.click();
	}
	
	public void checkout() throws InterruptedException
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element5);
		Thread.sleep(500);
		element5.click();
		
	}
	
	public WebElement successMsg()
	{
		return actualMessage;
	}
}


