package com.LMS.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ManageUser {
	
	public WebDriver ldriver;
	public ManageUser (WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);		
	}

	By user_menu = By.xpath("//button//span[contains(text(),'User')]");
	//By manageuser_header = By.xpath("//div[contains(text(),' Manage User')]");
	By manageuser_header = By.xpath("//div[normalize-space()='Manage User']");
	By pagination_bottom = By.xpath("//div[@class='p-paginator-bottom p-paginator p-component ng-star-inserted']");
	By first_page = By.xpath("//button[normalize-space()='1']");
	By second_page = By.xpath("//button[normalize-space()='2']");
	By right_paginator = By.xpath("//span[@class='p-paginator-icon pi pi-angle-right']");
	By left_paginator = By.xpath("//span[@class='p-paginator-icon pi pi-angle-left']");
	By table_checkbox = By.xpath("//div[@role='checkbox']");
	By table_info = By.xpath("//span[contains(text(),'Showing 1 to')]");
	By manageuser_footer = By.xpath("//div[contains(text(),' In total there are')]");
	By addnewuser_btn = By.xpath("//span[contains(text(),'Add New User')]");
	By userdetails_header = By.xpath("//span[contains(text(),'User Details')]");
	
	public void clickusermenu() {
		ldriver.findElement(user_menu).click();
	}
	
	public String manageuserheader() {
		return ldriver.findElement(manageuser_header).getText();
	}
	
	public boolean verifypagination() {
		ldriver.findElement(pagination_bottom).isDisplayed();
		return true;
	}
	
	public boolean verifypaginator() {
		ldriver.findElement(right_paginator).isEnabled();
		return true;
	}
	
	public void nextpagenavigation() {
		ldriver.findElement(right_paginator).click();
	}
	
	public void previouspagenavigation() {
		ldriver.findElement(left_paginator).click();
	}
	
	public boolean nextpagedisplay() {
		ldriver.findElement(second_page).isDisplayed();
		return true;
	}
		
	public boolean previouspagedisplay() {
		ldriver.findElement(first_page).isDisplayed();
		return true;
	}
	
	public boolean tableinfodisplay() {
		ldriver.findElement(table_info).isDisplayed();
		return true;
	}
	
	public boolean tablefooter() {
		ldriver.findElement(manageuser_footer).isDisplayed();
		return true;
	}
	
	public String addnewuserbtn() {
		return ldriver.findElement(addnewuser_btn).getText();
		
	}
}
