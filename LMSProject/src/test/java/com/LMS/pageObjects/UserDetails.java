package com.LMS.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class UserDetails {
	
	public WebDriver ldriver;
	public UserDetails (WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);		
	}

	
	By first_name = By.xpath("//input[@data-placeholder='First name']");
	By middle_name = By.xpath("//input[@data-placeholder='Middle name']");
	By last_name = By.xpath("//input[@data-placeholder='Last name']");
	By email_address = By.xpath("//input[@data-placeholder='Email address']");
    By phone_no = By.xpath("//input[@data-placeholder='Phone no']");
	By address = By.xpath("//textarea[@data-placeholder='Address']");
	By city = By.xpath("//input[@data-placeholder='City']");
	By state = By.xpath("//span[contains(text(),'State')]");
	By postal_code = By.xpath("//input[@data-placeholder='Postal Code']");
	By program = By.xpath("//input[@data-placeholder='Program']");
    By ug_program = By.xpath("//input[@data-placeholder='UG Program']");
	By pg_program = By.xpath("//input[@data-placeholder='PG Program']");
	By skill = By.xpath("//input[@data-placeholder='Skill']");
	By experience = By.xpath("//input[@data-placeholder='Experience']");
	By user_role = By.xpath("//mat-label[contains(text(),'User Role')]");
	By visa_status = By.xpath("//input[@data-placeholder='Visa status']");
	By batch = By.xpath("//input[@data-placeholder='Batch']");
	By comments = By.xpath("//input[@data-placeholder='Comments']");
	By user_name = By.xpath("//input[@data-placeholder='User name']");
	By password = By.xpath("//input[@data-placeholder='Password']");
	By field_type = By.xpath("//input[@data-placeholder='File type']");
	
	By lstAlabama = By.xpath("//span[contains(text(),'Alabama')]");
	By lstAlaska = By.xpath("//span[contains(text(),'Alaska')]");

	By userrole_details = By.xpath("");
	By submit_btn = By.xpath("//span[normalize-space()='Submit']");
	By userdetailserror_msg = By.xpath("");
	By adduser_name1 = By.xpath("//td[contains(text(),'Vidhya')]");
	By address_2 = By.xpath("//span[contains(text(),' + Add C/O, Apt, Suite, Unit ')]");
	By address2_option = By.xpath("//textarea[@data-placeholder='Address 2']");
	By usercancel_btn = By.xpath("//span[normalize-space()='Cancel']");
	By x_icon = By.xpath("//button[@type='button']//span[@xpath='1']");
			
    public boolean Xicondisplay() {
	    return ldriver.findElement(x_icon).isDisplayed();
    }
	
	public void clickXbtn() {
		 ldriver.findElement(x_icon).click();
	}
	
	public boolean Displayplaceholders() {
	      ldriver.findElement(first_name).isDisplayed();
	      ldriver.findElement(middle_name).isDisplayed();
	      ldriver.findElement(last_name).isDisplayed();
	      ldriver.findElement(email_address).isDisplayed();
	      ldriver.findElement(phone_no).isDisplayed();
	      ldriver.findElement(address).isDisplayed();
	      ldriver.findElement(city).isDisplayed();
	      ldriver.findElement(state).isDisplayed();
	      ldriver.findElement(postal_code).isDisplayed();
	      ldriver.findElement(program).isDisplayed();
	      ldriver.findElement(ug_program).isDisplayed();
	      ldriver.findElement(pg_program).isDisplayed();
	      ldriver.findElement(skill).isDisplayed();
	      ldriver.findElement(experience).isDisplayed();
	      ldriver.findElement(user_role).isDisplayed();
	      ldriver.findElement(visa_status).isDisplayed();
	      ldriver.findElement(batch).isDisplayed();
	      ldriver.findElement(comments).isDisplayed();
	      ldriver.findElement(user_name).isDisplayed();
	      ldriver.findElement(password).isDisplayed();
	      ldriver.findElement(field_type).isDisplayed();
	      return true;
	}    
	
	public void clickstatedropdown() {
		ldriver.findElement(state).click();
	}
	
	public boolean displayState1() {
		return ldriver.findElement(lstAlabama).isDisplayed();
	}
	
	public void clickuserroledropdown() {
		ldriver.findElement(user_role).click();
	}
	
	public boolean displayuserrole1() {
		return ldriver.findElement(userrole_details).isDisplayed();
	}

	public void clicksubmitbtn () {
		ldriver.findElement(submit_btn).click();
	}
	
	public boolean submitbtndisplay() {
		return ldriver.findElement(submit_btn).isDisplayed();
	}
	
	public String dispplayerrormsg() {
		return ldriver.findElement(userdetailserror_msg).getText();
	}
	
	//

	
	public void sendvaliddetails (String FirstName, String MiddleName, String LastName, String Emailaddress, String Phoneno, String Address, String City, String PostalCode, String Program, String PGProgram, String Skill, String Experience, String VisaStatus, String Batch, String Comments, String UserName, String Password) {
		ldriver.findElement(first_name).sendKeys(FirstName);
		ldriver.findElement(middle_name).sendKeys(MiddleName);
		ldriver.findElement(last_name).sendKeys(LastName);
		ldriver.findElement(email_address).sendKeys(Emailaddress);
		ldriver.findElement(phone_no).sendKeys(Phoneno);
		ldriver.findElement(address).sendKeys(Address);
		ldriver.findElement(city).sendKeys(City);
		//ldriver.findElement(state).sendKeys(State);
		ldriver.findElement(postal_code).sendKeys(PostalCode);
		ldriver.findElement(program).sendKeys(Program);
		//ldriver.findElement(ug_program).sendKeys(UGProgram);
		ldriver.findElement(pg_program).sendKeys(PGProgram);
		ldriver.findElement(skill).sendKeys(Skill);
		ldriver.findElement(experience).sendKeys(Experience);
		//ldriver.findElement(user_role).sendKeys(UserRole);
		ldriver.findElement(visa_status).sendKeys(VisaStatus);
		ldriver.findElement(batch).sendKeys(Batch);
		ldriver.findElement(comments).sendKeys(Comments);
		ldriver.findElement(user_name).sendKeys(UserName);
		ldriver.findElement(password).sendKeys(Password);
		//ldriver.findElement(field_type).sendKeys(FieldType);
	}
	
	public boolean displayaddedusername() {
		return ldriver.findElement(adduser_name1).isDisplayed();
	}
	
	public void clickaddress2() {
		ldriver.findElement(address_2).click();
	}
	
	public boolean displayaddress2() {
		return ldriver.findElement(address2_option).isDisplayed();
	}
	
	public void clickpostalcode() {
		ldriver.findElement(postal_code).click();
	}

	public void clickusercancelbtn () {
		ldriver.findElement(usercancel_btn).click();
	}
	
	public String usercancelbtntxt() {
		return ldriver.findElement(usercancel_btn).getText();
	}
	
	public void clickuserXbtn() {
		ldriver.findElement(x_icon).click();
	}
}
