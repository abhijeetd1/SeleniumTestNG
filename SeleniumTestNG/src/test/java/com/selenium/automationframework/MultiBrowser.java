package com.selenium.automationframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
 
public class MultiBrowser {
 
	public WebDriver driver;
 
  @Parameters("browser")
 
  @BeforeClass
 
  // Passing Browser parameter from TestNG xml
 
  public void beforeTest(String browser) {
 
	System.out.println("Execution Start ..."+browser);
  // If the browser is Firefox, then do this
 
  if(browser.equalsIgnoreCase("firefox")) {
 
	  driver = new FirefoxDriver();
 
  // If browser is Chrome, then do this	  
 
  }else if (browser.equalsIgnoreCase("chrome")) { 
 
	  // Here I am setting up the path for my IEDriver
 
	  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
 
	  driver = new ChromeDriver();
 
  } 
 
  // Doesn't the browser type, lauch the Website
 
  driver.get("http://store.demoqa.com/products-page/your-account/"); 
 
  }
 
  // Once Before method is completed, Test method will start
 
  @Test public void login() throws InterruptedException {
 
      driver.findElement(By.id("account")).click();
      driver.findElement(By.id("log")).sendKeys("testuser_1");
      driver.findElement(By.id("pwd")).sendKeys("Test@123");
      driver.findElement(By.id("login")).click();

      //FORCE DELAY
      Thread.sleep(8000);
      
      // Print a Log In message to the screen
 
      System.out.println(" Login Successfully !!");
 
 
	}  
 
  @AfterClass public void afterTest() {
 
	  System.out.println("Execution End ...");
		driver.quit();
 
	}
 
}
