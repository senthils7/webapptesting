package webtesting;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class webtesting extends capability{
	
	AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void setup() throws MalformedURLException
	{
		//i am calling that method from the capability class and this executes before any test
		driver = capabilities();
		//implicity wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test(enabled=false)
	public void testcase1()
	{
		System.out.println("The browser should open");
		//let me also open an URL
		driver.get("http://www.google.com");
		//i want to interact with the app called google
		//i want to search for IBM
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys("IBM");
		//what this line will do
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
		//i want to scroll and click on IBM - Wikipedia//what should i do
		//webdriver//javascript
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//i am storing the element which i want to click 
		WebElement link = driver.findElement(By.xpath("//*[contains(text(),'IBM - Wikipedia')]"));
		//this line will help you to scroll to that element 
		js.executeScript("arguments[0].scrollIntoView(false);",link);
		//this line will click on the element 
		link.click();


	}
	
	@Test
	public void testcase2()
	{
		driver.get("https://fast.com");
		
	}

}
