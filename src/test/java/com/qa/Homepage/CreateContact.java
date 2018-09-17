//Author Name:  Srinivas Tutta

package com.qa.Homepage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateContact {
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
	public void CreateContactTest() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Sriswl1981");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Vedik2015");
		driver.findElement(By.xpath("//input[@class='btn btn-small']")).click();
		driver.switchTo().frame(1);

		WebElement Ele1=driver.findElement(By.xpath("//html/body/table[1]/tbody/tr[3]/td[1]/div/div/ul/li[4]/a"));
		WebElement Ele2=driver.findElement(By.xpath("html/body/table[1]/tbody/tr[3]/td[1]/div/div/ul/li[4]/ul/li[1]/a"));
		
		Actions act=new Actions(driver);
		act.moveToElement(Ele1).moveToElement(Ele2).click().build().perform();
		
		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Jonny");
		driver.findElement(By.xpath("//input[@id='surname']")).sendKeys("Walker");
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='contactForm']/table/tbody/tr[1]/td/input[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='navmenu']/ul/li[4]/a")).click();
		Thread.sleep(3000);
		WebElement Table=driver.findElement(By.xpath(".//*[@id='vContactsForm']/table"));
		
		List<WebElement> trs=Table.findElements(By.tagName("tr"));
				
		for (WebElement tr : trs) {
			List<WebElement> td=tr.findElements(By.tagName("td"));
			for (WebElement tds : td) {
			   if (tds.getText().contains("Walker"))
			   {
		        	System.out.println("Created Contact has been updated on the list.  Test Passed");
			   }
			  
	}}		}
             		
	
	@AfterMethod
	public void TearDown() {
   driver.close();
	
	}}
