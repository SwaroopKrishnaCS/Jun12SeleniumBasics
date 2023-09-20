package com.swaroop.SeleniumCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IsSelectedDemo {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		driver.manage().window().maximize();
	}

	@Test
	public void validateIfRadioBtnIsSelected() {

		WebElement yesRadioBtn = driver.findElement(By.cssSelector("div.radio>label>input"));
//		boolean isBtnSelected = yesRadioBtn.isSelected();
//		System.out.println("Before Selection: "+isBtnSelected);
		yesRadioBtn.click();
		boolean isBtnSelected = yesRadioBtn.isSelected();
		System.out.println("After Selection: "+isBtnSelected);

	}

}
