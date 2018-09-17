package com.qa.Homepage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
	WebDriver driver;
	
	@BeforeMethod
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\workspace\\FreeCrm\\src\\main\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.freecrm.com/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
	}
	
	@Test
	public void VerifyLogin() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Sriswl1981");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Vedik2015");
		driver.findElement(By.xpath("//input[@class='btn btn-small']")).click();
		driver.switchTo().frame(1);
		
		String str=driver.findElement(By.xpath("//html/body/table[1]/tbody/tr[2]/td[1]/div/table/tbody/tr/td[4]/a")).getText();		
		System.out.println(str);
		Assert.assertEquals("  Logout  ", str);
			
	}

	@Test
	public void ContactTest() {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Sriswl1981");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Vedik2015");
		driver.findElement(By.xpath("//input[@class='btn btn-small']")).click();
		driver.switchTo().frame(1);
		driver.findElement(By.xpath("//html/body/table[1]/tbody/tr[3]/td[1]/div/div/ul/li[4]/a")).click();
	}
	
	
	@AfterMethod
	public void TearDown() {
		driver.close();
	
	
}
}