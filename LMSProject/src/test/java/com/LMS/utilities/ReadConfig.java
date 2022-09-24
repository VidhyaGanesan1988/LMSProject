package com.LMS.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
Properties pro;
	
	public ReadConfig () {
	File src = new File ("./Configuration/config.properties");
	
	try {
		FileInputStream fis = new FileInputStream(src);
		pro = new Properties();
		pro.load(fis);
	}catch (Exception e) {
		System.out.println("Exception is " + e.getMessage());
	}
		
	}
	
	public String getUsername() {
		return pro.getProperty("Username");
	}
	
	public String getPassword() {
		return pro.getProperty("Password");
	}

	public String getApplicationURL() {
		String url=pro.getProperty("baseurl");
		return url;
	}
	
	public String getBrowser() {
		return pro.getProperty("browser");
		}
	
}
