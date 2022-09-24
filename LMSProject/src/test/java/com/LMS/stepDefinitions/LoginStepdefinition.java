//package com.LMS.stepDefinitions;
//
//import java.io.IOException;
//
//import org.testng.Assert;
//
//import com.LMS.base.BaseClass;
//import com.LMS.context.ScnContext;
//import com.LMS.pageObjects.Login;
//import com.LMS.utilities.ReadConfig;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class LoginStepdefinition extends BaseClass{
//	
//	ReadConfig config;
//	ScnContext cs;
//	
//	public LoginStepdefinition(ScnContext cs) {
//		this.cs=cs;
//	}
//	
//	@Before
//	public void setUp() {
//		cs.logger.info("Launched browser");
//		cs.driver=init();
//		config=new ReadConfig();
//		cs.login=new Login(cs.driver);
//	}
//	@Given("User is on login page")
//	public void user_is_on_login_page() throws IOException, InterruptedException {
//		cs.driver.get(config.getApplicationURL());
//		cs.logger.info("Application launched");
//		Thread.sleep(2000);
//		
//	}
//
//	@When("User clicks on Login button with entering valid {string} and {string}")
//	public void user_clicks_on_login_button_with_entering_valid_and(String Username, String Password) throws InterruptedException {
//		
//		cs.login.setuser(config.getUsername());
//		Thread.sleep(2000);
//		cs.login.setpassword(config.getPassword());
//		Thread.sleep(2000);
//		cs.login.clickloginbtn();
//		Thread.sleep(2000);
//	}
//
//	@Then("User should land on home page")
//	public void user_should_land_on_home_page() {
//		if (cs.driver.getCurrentUrl().equals("https://lms-frontend-phase2.herokuapp.com/"))
//		{
//			Assert.assertTrue(true);
//			cs.logger.info("User logged successfully");
//		}
//		else 
//		{
//			//captureScreen(driver,"user_should_land_on_home_page");
//			Assert.assertTrue(false);
//			cs.logger.info("login unsuccessful");
//		}
//	}
//
//	@After
//	public void quit() {
//		cs.driver.quit();
//	}
//
//}
