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
	By manageuser_header = By.xpath("//div[contains(text(),'Manage User')]");
	//By manageuser_header = By.xpath("//div[normalize-space()='Manage User']");
	By pagination_bottom = By.xpath("//div[@class='p-paginator-bottom p-paginator p-component ng-star-inserted']");
	By first_page = By.xpath("//button[normalize-space()='1']");
	By second_page = By.xpath("//button[normalize-space()='2']");
	By right_paginator = By.xpath("//span[@class='p-paginator-icon pi pi-angle-right']");
	By left_paginator = By.xpath("//span[@class='p-paginator-icon pi pi-angle-left']");
	By table_checkbox = By.xpath("//div[@role='checkbox']");
	By table_info = By.xpath("//span[contains(text(),'Showing 1 to')]");
	By manageuser_footer = By.xpath("//div[contains(text(),' In total there are')]");
	By addnewuser_btn = By.xpath("//span[contains(text(),'Add New User')]");
	By userdetails_header = By.xpath("//div//span[contains(text(),'User Details')]");
	By ID_header = By.xpath("//th[@psortablecolumn='user_id']");
	By Name_header = By.xpath("//th[@psortablecolumn='firstName']");
	By Email_header = By.xpath("//th[@psortablecolumn='emailAddress']");
	By Phone_header = By.xpath("//th[@psortablecolumn='phoneNumber']");
	By Batch_header = By.xpath("//th[@psortablecolumn='batch']");
	By Skill_header = By.xpath("//th[@psortablecolumn='skill']");
	By Edit_del_header = By.xpath("//th[contains(text(),' Edit / Delete')]");
	By first_userid = By.xpath("//span[contains(text(),'U001')]");
	By highlight_userids = By.xpath("//div[@role='checkbox']");
	By table_deleteIcon = By.xpath("//button[@class='p-button-danger p-button p-component p-button-icon-only']");
	//By first_checkbox = By.xpath("//div[@role='checkbox'][@xpath='1']");
	
	By first_checkbox = By.xpath("//body[1]/app-root[1]/app-user[1]/div[1]/mat-card[1]/mat-card-content[1]/p-table[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/p-tablecheckbox[1]/div[1]/div[2]");
	By warning_msg = By.xpath("//span[contains(text(),'Confirm')]");
	By yes_btn = By.xpath("//span[contains(text(),'Yes')]");
	By success_msg = By.xpath("//div[contains(text(),'Successful')]");
	By no_btn = By.xpath("//span[contains(text(),'No')]");
	By x_btn = By.xpath("//span[contains(text(),'No')]");
	By row_deletebtn = By.xpath("//button[@class='p-button-rounded p-button-danger p-button p-component p-button-icon-only']");
	By row_warnmsg = By.xpath("//span[contains(text(),'Are you sure you want to delete John  Dove?')]");
	By edit_btn = By.xpath("//span[@class='p-button-icon pi pi-pencil']");
	By search_option = By.xpath("//input[@placeholder='Search...']");
	By table_secondinfo = By.xpath("//span[contains(text(),'Showing 1 to 1 of 1 entries')]");
	By table_thirdinfo = By.xpath("//span[contains(text(),'Showing 0 to 0 of 0 entries')]");
	By cancel_btn = By.xpath("//span[contains(text(),'Cancel')]");
	
	
	public void clickusermenu() {
		ldriver.findElement(user_menu).click();
	}
	
	public String manageuserheader() {
		return ldriver.findElement(manageuser_header).getText();
	}
	
	public boolean manageusertxt() {
		return ldriver.findElement(manageuser_header).isDisplayed();
	}
	
	public boolean verifypagination() {
		return ldriver.findElement(pagination_bottom).isDisplayed();
	}
	
	public boolean verifypaginator() {
		return ldriver.findElement(right_paginator).isEnabled();
	}
	
	public void nextpagenavigation() {
		ldriver.findElement(right_paginator).click();
	}
	
	public void previouspagenavigation() {
		ldriver.findElement(left_paginator).click();
	}
	
	public boolean nextpagedisplay() {
		return ldriver.findElement(second_page).isDisplayed();
	}
		
	public boolean previouspagedisplay() {
		return ldriver.findElement(first_page).isDisplayed();
	}
	
	public boolean tableinfodisplay() {
		ldriver.findElement(table_info).isDisplayed();
		return true;
	}
	
	public boolean tablefooter() {
		return ldriver.findElement(manageuser_footer).isDisplayed();
	}
	
	public String addnewusertxt() {
		return ldriver.findElement(addnewuser_btn).getText();
	}
	
	public void addnewuserbtn() {
		ldriver.findElement(addnewuser_btn).click();
	}
	
	public String userdetailsheader() {
		return ldriver.findElement(userdetails_header).getText();
	}
	
	public boolean userdetailstxt () {
		return ldriver.findElement(userdetails_header).isDisplayed();
	}
	
	public boolean tableheaders() {
		ldriver.findElement(table_checkbox).isDisplayed();
		ldriver.findElement(ID_header).isDisplayed();
		ldriver.findElement(Name_header).isDisplayed();
		ldriver.findElement(Email_header).isDisplayed();
		ldriver.findElement(Phone_header).isDisplayed();
		ldriver.findElement(Batch_header).isDisplayed();
		ldriver.findElement(Skill_header).isDisplayed();
		ldriver.findElement(Edit_del_header).isDisplayed();
		return true;
	}
		
	public void IDsorticon() {
		ldriver.findElement(ID_header).click();
	}
	
	public boolean userID1() {
		return ldriver.findElement(first_userid).isDisplayed();
	}
	
	public void tablecheckbox() {
		ldriver.findElement(table_checkbox).click();
	}
	
	public boolean checkboxhighlight() {
		return ldriver.findElement(highlight_userids).isDisplayed();
	}
	
	public boolean masterdeleteicon() {
		return ldriver.findElement(table_deleteIcon).isDisplayed();
	}
	
	public void clickrowcheckbox() {
		 ldriver.findElement(highlight_userids).click();
	}
	
	public boolean masterdeleteenabled() {
		return ldriver.findElement(table_deleteIcon).isEnabled();
	}
	
	public void click1rowcheckbox() {
		ldriver.findElement(first_checkbox).click();
	}
	
	public void clickmasterdelete() {
		ldriver.findElement(table_deleteIcon).click();
	}
	
	public boolean warningmsgdisplay() {
		return ldriver.findElement(warning_msg).isDisplayed();
	}
	
	public void clickyesbtn() {
		ldriver.findElement(yes_btn).click();
	}
	
	public String successmsgdisplay() {
		return ldriver.findElement(success_msg).getText();
	}
	
	public void clicknobtn() {
	    ldriver.findElement(no_btn).click();
	}
	
	public void clickXbtn() {
		ldriver.findElement(x_btn).click();
	}
	
	public boolean displayeditdelete (){
		return ldriver.findElement(Edit_del_header).isDisplayed();
	}
	
	public void clickrowdelete () {
		 ldriver.findElement(row_deletebtn).click();		
	}
	
	public String rowwarnmsgdisplay() {
		return ldriver.findElement(row_warnmsg).getText();
	}
	
	public void clickeditbtn () {
		ldriver.findElement(edit_btn).click();
	}
	
	public boolean displaysearch() {
		return ldriver.findElement(search_option).isDisplayed();
	}
	
	public void searchname() {
		ldriver.findElement(search_option).sendKeys("Smith");
	}
	
	public boolean searchvalidation() {
		return ldriver.findElement(table_secondinfo).isDisplayed();
	}
	
	public void searchinvalidname() {
		ldriver.findElement(search_option).sendKeys("bbb");
	}
	
	public boolean searchinvalid() {
		return ldriver.findElement(table_thirdinfo).isDisplayed();
	}
	
	public void clickuserID() {
		ldriver.findElement(first_userid).click();
	}
	
	public void clickcancelbtn() {
		ldriver.findElement(cancel_btn).click();
	}
	
	public boolean cancelbtntxt() {
		return ldriver.findElement(cancel_btn).isDisplayed();
	}
}
