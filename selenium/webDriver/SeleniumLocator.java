package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class SeleniumLocator {

	@BeforeClass
	public void before()
	{

	}
	

	@Test
	public void TC01()
	{
		WebDriver driver;
		driver = new FirefoxDriver();
		driver.get("http://live.demoguru99.com/");
		
		//Using Text link to find element
		driver.findElement(By.linkText("MY ACCOUNT")).click();
		driver.findElement(By.xpath("//button[@title='Login']")).click();
		
		String text = new String();
		text = driver.findElement(By.id("advice-required-entry-email")).getText();
		
		Assert.assertEquals(text,"This is a required field.");
		driver.close();
	}
	
	@Test
	public void TC02()
	{
		WebDriver driver;
		driver = new FirefoxDriver();
		driver.get("http://live.demoguru99.com/");
		
		//Using tagname and attribute to find element 		
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

		driver.findElement(By.id("email")).sendKeys("12345@123.123");
		driver.findElement(By.id("pass")).sendKeys("12345678");
		
		driver.findElement(By.id("send2")).click();
		
		String text = new String();
		text = driver.findElement(By.xpath("//*[@id='advice-validate-email-email']")).getText();
		
		Assert.assertEquals(text,"Please enter a valid email address. For example johndoe@domain.com.");
		
		driver.close();
		
	}
	
	@Test
	public void TC03()
	{
		WebDriver driver;
		driver = new FirefoxDriver();
		driver.get("http://live.demoguru99.com/");
		
		driver.findElement(By.linkText("MY ACCOUNT")).click();
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("123");
		
		driver.findElement(By.id("send2")).click();
		
		String text = new String();
		text = driver.findElement(By.xpath("//*[@id='advice-validate-password-pass']")).getText();
		
		Assert.assertEquals(text,"Please enter 6 or more characters without leading or trailing spaces.");
		
		driver.close();
	}
	
	@Test
	public void TC04()
	{
		WebDriver driver;
		driver = new FirefoxDriver();
		driver.get("http://live.demoguru99.com/");
		
		driver.findElement(By.linkText("MY ACCOUNT")).click();
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("12345678");
		
		driver.findElement(By.id("send2")).click();
		
		String text = new String();
		text = driver.findElement(By.className("error-msg")).getText();
		
		Assert.assertEquals(text,"Invalid login or password.");
		
		driver.close();
	}
	
	
	
	@AfterClass
	public void after()
	{
		WebDriver driver;
		driver = new FirefoxDriver();
		driver.quit();
	}
}