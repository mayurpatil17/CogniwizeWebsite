package com.cw.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cw.Pages.CareerPage;
import com.cw.commosActions.BaseTest1;

public class PracticeTest extends BaseTest1 {
	WebDriver driver;
	CareerPage career;
	

	public PracticeTest() throws IOException
	{
		driver=initiliseDriver();
		
	}
	
	@Test
	public void practice() throws InterruptedException
	{
		driver.get(pro.getProperty("baseurl"));
		career = new CareerPage(driver);
		career.CareersLink().click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,2000)");
		career.getAllJobTypeDropdown().click();
		Assert.assertEquals(career.getAllJobTypeOptions().isDisplayed(), true);
		Thread.sleep(3000);
		driver.quit();
	
		
		
	}

}
