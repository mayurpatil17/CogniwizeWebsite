package com.cw.TestCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cw.Pages.Footerpage;
import com.cw.Pages.HomePage;
import com.cw.commosActions.BaseTest1;
import com.cw.commosActions.BaseTest;
import com.cw.commosActions.BaseTest1;

public class FooterTest extends BaseTest1
{
	WebDriver driver;
	public FooterTest() throws IOException 
	{
		driver=initiliseDriver();
	}
	@Test(groups="Footer") //TC
	public void TC_EmptyBox() throws IOException
	{
		driver.get(pro.getProperty("baseurl"));
		Footerpage footer=new Footerpage(driver);
		footer.getSubscribeButton().click();
		boolean subscribe = footer.getErrormessege().isDisplayed();
		Assert.assertEquals("This field is required.", footer.getErrormessege().getText());
	}  

	//TC03 Check by hovering on the social icon links on the footer of all pages
	@Test(groups="Footer")
	public void TC03_socialIconIsPresent() throws IOException
	{  
		driver.get(pro.getProperty("baseurl"));
		Footerpage footer=new Footerpage(driver);
		boolean List = footer.getSocial_icon().isDisplayed();
		assertTrue(List);

	}

	//TC05-To check the navigation of social icon "Facebook" link present on footer of all pages
	@Test(groups="Footer") 
	public void TC05_facebooklink() throws IOException
	{
		driver.get(pro.getProperty("baseurl"));
		Footerpage footer=new Footerpage(driver);
		footer.getFacebook().click();
		footer.userWindowhandle(driver);
		Assert.assertEquals("https://www.facebook.com/cogniwizeinfosystems",driver.getCurrentUrl());
	}

	//TC06-To check the navigation of social icon "Twitter" link present on footer of all pages
	@Test(groups="Footer")
	public void TC06_twitterlink() throws IOException
	{
		driver.get(pro.getProperty("baseurl"));
		Footerpage footer=new Footerpage(driver);
		footer.getTwitter().click();
		footer.userWindowhandle(driver);
		Assert.assertEquals("https://twitter.com/cogniwize",driver.getCurrentUrl());
	}

	//TC07-To check the navigation of social icon "YouTube" link present on footer of all pages
	@Test(groups="Footer")
	public void TC04_sociallink() throws IOException
	{
		driver.get(pro.getProperty("baseurl"));
		Footerpage footer=new Footerpage(driver);
		footer.getYoutube().click();
		footer.userWindowhandle(driver);
		Assert.assertEquals("Cogniwize Infosystem - YouTube",driver.getTitle());

	}

	//TC08-To check the navigation of social icon "LinkedIn" link present on footer of all pages
	@Test(groups="Footer") 
	public void TC08_Linkedin() throws IOException
	{
		driver.get(pro.getProperty("baseurl"));
		Footerpage footer=new Footerpage(driver);
		footer.getLinkedin().click();
		footer.userWindowhandle(driver);
		Assert.assertEquals("Sign In | LinkedIn",driver.getTitle());
	}

	//TC09-To check the navigation of social icon "Mail" link present on footer of all pages
	@Test(groups="Footer")//window based popup  TC09
	public void TC09_mailonfooter() throws IOException
	{
		driver.get(pro.getProperty("baseurl"));
		Footerpage footer=new Footerpage(driver);
		footer.getMail().click();
	}	


	@Test//(groups = "Smoke") //TC12
	public void TC12_CheckSubscribeButtonClick() throws IOException
	{//driver=initiliseDriver();
		driver.get(pro.getProperty("baseurl"));
			Footerpage footer=new Footerpage(driver);
		footer.getSubscribeButton().click();
		boolean subscribe = footer.getErrormessege().isDisplayed();
		String expected="This field is required.";
		Assert.assertEquals(expected, footer.getErrormessege().getText());

	}

	@Test//TC13
	public void TC13_EmailAddressIsAccessible() throws IOException
	{//driver=initiliseDriver();
		driver.get(pro.getProperty("baseurl"));
		Footerpage footer=new Footerpage(driver);
		footer.getEmail().sendKeys("selenium");
		String expected="selenium";
		footer.getEmail().getAttribute("value");
		Assert.assertEquals(expected,footer.getEmail().getAttribute("value"));
	}
	@Test //TC15
	public void TC15_validEmailId() throws IOException, InterruptedException
	{
		//driver=initiliseDriver();
		driver.get(pro.getProperty("baseurl"));
		Footerpage footer=new Footerpage(driver);
		footer.getEmailid().sendKeys("abc@gmail.com");
		footer.getSubscribeButton().click();
		Thread.sleep(10);
		String actual= footer.getSuccess_messege().getText();
		System.out.println(actual);
		Thread.sleep(10);
		//String expected="Success! Watch your inbox for emails from info@cogniwize.com";

		//Assert.assertEquals(expected,actual);

	}
	@Test //TC16
	public void TC16_enterInValidMailId() throws IOException
	{//driver=initiliseDriver();
		driver.get(pro.getProperty("baseurl"));
		Footerpage footer=new Footerpage(driver);
		footer.getEmail().sendKeys("acd124.com");
		footer.getEmail().click();
		String actual=footer.getEmail().getText();
		System.out.println(actual);
		String expected=footer.getEmail().getText();
//		footer.getEmail().getAttribute("value");
		//assertEquals(actual,expected);
	}

	@Test   //TC17
	public void TC17_emailFieldByKeepingBlank() throws IOException
	{
		driver.get(pro.getProperty("baseurl"));
		Footerpage footer=new Footerpage(driver);
		footer.getSubscribeButton().click();
		boolean subscribe = footer.getErrormessege().isDisplayed();
		String expected="This field is required.";
		String actual=footer.getErrormessege().getText();
		System.out.println(actual);
		Assert.assertEquals(expected,actual);
	}
	 
	@Test(groups="Footer")//(groups = "Smoke") //TC19
	public void TC19_copyrightIsDisplayed() throws IOException
	{
		driver.get(pro.getProperty("baseurl"));
		Footerpage footer=new Footerpage(driver);
		assertEquals(true,footer.getCopyright().isDisplayed());

	}

	//TC20_To check the"Robotic process Automation is clickable or not " in the footer section 
	@Test(groups="Footer") 
	public void TC20_RoboticsProcess() throws IOException {

		driver.get(pro.getProperty("baseurl"));
		Footerpage footer=new Footerpage(driver);
		footer.getRoboticProcess().click();
		String actual=driver.getTitle();
	}

	//TC_21 To check the"Hyper Automation is clickable or not " in the footer section 
	@Test(groups="Footer") 
	public void TC21_HyperAutomation() throws IOException
	{
		driver.get(pro.getProperty("baseurl"));
		Footerpage footer=new Footerpage(driver);
		footer.getHyperAutomation().click();
		Assert.assertEquals(driver.getCurrentUrl(),footer.hyperAutoUrl);
	}

	//TC22_To check the"Testing Automation is clickable or not " in the footer section
	@Test(groups="Footer") 
	public void TC22_TestingAutomation() throws IOException {

		driver.get(pro.getProperty("baseurl"));
		Footerpage footer=new Footerpage(driver);
		footer.getTestingAutomation().click();
		String expTitle=footer.testAutoUrl;
		String actual=driver.getTitle();
		if(expTitle.equalsIgnoreCase(actual))
		{	System.out.println("Passed");

		}
		else {
			System.out.println("Failed");
		}
	}

	//TC23_To check the"Digital Assurance and Testing Services " in the footer section
	@Test(groups="Footer")  
	public void TC23_DigitalAssurance() throws IOException {

		driver.get(pro.getProperty("baseurl"));
		Footerpage footer=new Footerpage(driver);
		footer.getDigitalAssurance().click();
		String expTitle=footer.digitalAssuUrl;
		if(expTitle.equalsIgnoreCase(driver.getTitle())){
			System.out.println("Passed");
		}
		else {
			System.out.println("Failed");
		}
		System.out.println("Actual Title is: " + driver.getTitle());
	}

	//TC24_To check the"Quality Engineering Services" in the footer section 
	@Test(groups="Footer") 
	public void TC24_QualityEnineeringServices() throws IOException {

		driver.get(pro.getProperty("baseurl"));
		Footerpage footer=new Footerpage(driver);
		footer.getQualityEngineeringServices().click();
		Assert.assertEquals(driver.getCurrentUrl(),footer.qualityEnggUrl);

	}
	//TC25_To check the"Test Transformation and Advisory Services" in the footer section 
	@Test(groups="Footer") 
	public void TestTransformationandAdvisoryServices() throws IOException {

		driver.get(pro.getProperty("baseurl"));
		Footerpage footer=new Footerpage(driver);
		footer.getTestTransformationandAdvisoryServices().click();
		Assert.assertEquals(driver.getCurrentUrl(),footer.testTransUrl);



	}


}

