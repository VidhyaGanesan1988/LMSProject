package com.LMS.context;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.LMS.pageObjects.Login;
import com.LMS.pageObjects.ManageUser;
import com.LMS.pageObjects.UserDetails;
import com.LMS.utilities.ReadConfig;

public class ScnContext {

	public final Logger logger = LogManager.getLogger(ScnContext.class.getName());
	public WebDriver driver;
	public String browserName;
	public ReadConfig config;
	public String baseurl;
	public Login login;
	public ManageUser manageuser;
	public UserDetails userdetails;
}
