package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;

import utility.AllMyUtilities;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;

public class NewScript extends  AllMyUtilities{
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void WarmUp() throws FindFailed, InterruptedException {
	  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

  }

  @Test
  public void testUntitledTestCase() throws Exception {
    driver.get("http://automationpractice.com/index.php");
    driver.findElement(By.id("search_query_top")).click();
    driver.findElement(By.id("search_query_top")).clear();
    driver.findElement(By.id("search_query_top")).sendKeys("Printed Dress");
    driver.findElement(By.name("submit_search")).click();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='S'])[1]/following::span[1]")).click();
    
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='$18.40'])[2]/following::span[3]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='$16.40'])[6]/following::span[1]")).click();
    driver.close();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
