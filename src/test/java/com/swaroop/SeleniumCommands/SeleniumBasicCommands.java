package com.swaroop.SeleniumCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumBasicCommands {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.manage().window().maximize();
	}

	@Test
	public void validateLogin() {
		// To identify the elements with which you want to interact with
		WebElement emailInput = driver.findElement(By.cssSelector("#input-email"));
		WebElement passwordInput = driver.findElement(By.cssSelector("#input-password"));
		WebElement loginBtn = driver.findElement(By.cssSelector("input[type='submit']"));

		emailInput.sendKeys("peter@email.com");
		passwordInput.sendKeys("peter123");
		loginBtn.click();

		WebElement myActBanner = driver.findElement(By.cssSelector("#content>h2:first-of-type"));
		Assert.assertTrue(myActBanner.isDisplayed(), "My Account Banner not Displayed, hence login failed");
		String myActText = myActBanner.getText();
		Assert.assertEquals(myActText, "My Account", "My Account Banner Text not as expected");
	}

	@AfterMethod
	public void tearDown() {
//		driver.close();
	}

}
