package com.LMS.pageObjects;

public class Home {
	
	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	
	WebDriver driver;
		
	public Home(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()=' LMS - Learning Management System ']")WebElement lmsHeading;
	@FindBy(xpath="//span[text()='Program']")WebElement program;
	@FindBy(xpath="//span[text()='Batch']")WebElement batch;
	@FindBy(xpath="//span[text()='User']")WebElement user;
	@FindBy(xpath="//span[text()='Assignment']")WebElement assignment;
	@FindBy(xpath="//span[text()='Attendance']")WebElement attendance;
	@FindBy(xpath="//span[text()='Logout']")WebElement logout;
	
	public boolean Verify_LMS_Heading()
	{
		return lmsHeading.isDisplayed();
	}
	
	public boolean VerifyProgram()
	{
		return program.isDisplayed();
	}
	
	public boolean VerifyBatch()
	{
		return batch.isDisplayed();
	}
	
	public boolean VerifyUser()
	{
		return user.isDisplayed();
	}
	
	public boolean VerifyAssignment()
	{
		return assignment.isDisplayed();
	}
	
	public boolean VerifyAttendance()
	{
		return attendance.isDisplayed();
	}
	
	public String verifyHomePageTitle()
	{
	return driver.getTitle();
	}
	
	public boolean VerifyLogout()
	{
		return logout.isDisplayed();
	}
	
	public void VerifyLogoutClick()
	{
		logout.click();
	
	}

}
