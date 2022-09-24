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
	By state = By.xpath("//div[@id='mat-select-value-1']");
	
	By lstAlabama = By.xpath("//span[contains(text(),'Alabama')]");
	By lstAlaska = By.xpath("//span[contains(text(),'Alaska')]");
}
