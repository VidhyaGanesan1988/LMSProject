package com.LMS.stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;

import com.LMS.base.BaseClass;
import com.LMS.context.ScnContext;
import com.LMS.pageObjects.Login;
import com.LMS.pageObjects.ManageUser;
import com.LMS.utilities.ReadConfig;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManageUserStepdefinition extends BaseClass{
	
	ReadConfig config;
	ScnContext cs;
	
	public ManageUserStepdefinition(ScnContext cs) {
		this.cs=cs;
		
		}
	
	@Before
	public void setUp() {
		cs.logger.info("Launched browser");
		cs.driver=init();
		config=new ReadConfig();
		cs.login = new Login(cs.driver);
		cs.manageuser = new ManageUser(cs.driver);
	}
	
	@After
    public void quit() {
		cs.driver.quit();
	}
	
	@Given("User is on any page after Login")
	public void user_is_on_any_page_after_login() throws InterruptedException {
		cs.driver.get(config.getApplicationURL());
		cs.login.setuser(config.getUsername());
		Thread.sleep(2000);
		cs.login.setpassword(config.getPassword());
		Thread.sleep(2000);
		cs.login.clickloginbtn();
		Thread.sleep(2000);
		cs.logger.info("User is on any page after Login");
	}

	@When("User clicks the USER menu")
	public void user_clicks_the_user_menu() throws Exception {
		cs.manageuser.clickusermenu();
		Thread.sleep(2000);
		cs.logger.info("User clicks the USER menu");
	}
	
	@Then("User should land on Manage user page")
	public void user_should_land_on_manage_user_page() {
	   
		if (cs.driver.getCurrentUrl().equals("https://lms-frontend-phase2.herokuapp.com/user"))
			{
				Assert.assertTrue(true);
				cs.logger.info("User is on Manage user page");
			}
			else 
			{
				Assert.assertTrue(false);
			cs.logger.info("User is not on Manage user page");
		}
	}

	/*@Then("User should see the {string} Manage user page")
	public void user_should_see_the_manage_user_page(String manageusertext) {
		String manageuserTEXT = cs.manageuser.manageuserheader();
		if (manageuserTEXT == manageusertext) {
			assertEquals(manageusertext, manageuserTEXT);
			cs.logger.info("User is on Manage user page");
		} else {
			assertTrue(false);
			cs.logger.info("User is not on Manage user page");
		} 
		
		/*cs.manageuser.addnewuserbtn();
		assertEquals(cs.manageuser.addnewuserbtn(),addnewusertext);
		cs.logger.info("User is on Manage User Page");*/

	
		/*cs.manageuser.manageuserheader();
		assertEquals(cs.manageuser.manageuserheader(),muheadertext);
		cs.logger.info("User is on Manage User Page");*/
	

	@When("User is on the Manage user page after clicking User menu")
	public void user_is_on_the_manage_user_page_after_clicking_user_menu() {
	    cs.logger.info("User is on the Manage user page after clicking User menu");
	}

	@Then("User should see the page header as {string}")
	public void user_should_see_the_page_header_as(String muheadertext) {
		String muheader = cs.manageuser.manageuserheader();
		if (muheadertext == muheader) {
			assertEquals(muheadertext, muheader);
			cs.logger.info("User is on Manage user page ");
		} else {
			assertTrue(false);
			cs.logger.info("User is not on Manage user page");
		}  
	}

	@Then("User should see the pagination controls below data table")
	public void user_should_see_the_pagination_controls_below_data_table() {
		
		if (cs.manageuser.verifypagination())
		{
		    cs.logger.info("Pagination is displayed");
		} else {
			cs.logger.info("Pagination is not displayed");
		}
	}

	@Given("User is on Manage user page")
	public void user_is_on_manage_user_page() throws InterruptedException {
		cs.driver.get(config.getApplicationURL());
		cs.login.setuser(config.getUsername());
		Thread.sleep(2000);
		cs.login.setpassword(config.getPassword());
		Thread.sleep(2000);
		cs.login.clickloginbtn();
		Thread.sleep(2000);
		cs.logger.info("User is on Manage user page");
	}

	@When("Manage user table has more than or equal to five rows")
	public void manage_user_table_has_more_than_or_equal_to_five_rows() {
		cs.manageuser.clickusermenu();
		cs.logger.info("Verifying pagination functionality");
	}

	@Then("Pagination control should be enabled")           
	public void pagination_control_should_be_enabled() {
		if (cs.manageuser.verifypaginator())
		{
		    cs.logger.info("Pagination control enabled");
		} else {
			cs.logger.info("Pagination control disabled");
		}
	}

	@Given("User table is displayed in manage user page")
	public void user_table_is_displayed_in_manage_user_page() throws InterruptedException {
		cs.driver.get(config.getApplicationURL());
		cs.login.setuser(config.getUsername());
		Thread.sleep(2000);
		cs.login.setpassword(config.getPassword());
		Thread.sleep(2000);
		cs.login.clickloginbtn();
		Thread.sleep(2000);
		cs.manageuser.clickusermenu();
		cs.logger.info("User table is displayed in manage user page");
	}

	@When("User cliks next link of pagination")
	public void user_cliks_next_link_of_pagination() {
	    cs.manageuser.nextpagenavigation();
	    cs.logger.info("User clicks next link of pagination");
	}

	//This scenario will fail, since the Manage user page by default has only 4 entries and navigator is disabled
	@Then("Next page with table records should be displayed")
	public void next_page_with_table_records_should_be_displayed() {
		if (cs.manageuser.nextpagedisplay())
		{
		    cs.logger.info("Next page with table records is displayed");
		} else {
			cs.logger.info("Navigation error");
		}
	}

	@When("User cliks previous link of pagination")
	public void user_cliks_previous_link_of_pagination() {
	    cs.manageuser.previouspagenavigation();
	    cs.logger.info("User cliks previous link of pagination");
	}

	//This scenario will fail, since the Manage user page by default has only 4 entries and navigator is disabled
	@Then("Previous page should be displayed")
	public void previous_page_should_be_displayed() {
		if (cs.manageuser.previouspagedisplay())
		{
		    cs.logger.info("Previous page with table records is displayed");
		} else {
			cs.logger.info("Navigation error");
		}
	}

	@Given("User is logged on to the LMS website")
	public void user_is_logged_on_to_the_lms_website() throws InterruptedException {
		cs.driver.get(config.getApplicationURL());
		cs.login.setuser(config.getUsername());
		Thread.sleep(2000);
		cs.login.setpassword(config.getPassword());
		Thread.sleep(2000);
		cs.login.clickloginbtn();
		Thread.sleep(2000);
		cs.logger.info("User is logged on to the LMS website");
	}

	@When("User lands on Manage User page")
	public void user_lands_on_manage_user_page() {
		cs.manageuser.clickusermenu();
		cs.logger.info("User lands on Manage User page");
	}

	@Then("User should see the text {string} below the user table.")
	public void user_should_see_the_text_below_the_user_table(String string) {
		if (cs.manageuser.tableinfodisplay())
		{
		    cs.logger.info("No of entries displayed");
		} else {
			cs.logger.info("No of entries not displayed");
		}
	}

	@Then("User should see the table footer as {string}.")
	public void user_should_see_the_table_footer_as(String string) {
		if (cs.manageuser.tablefooter())
		{
		    cs.logger.info("User details displayed in table footer");
		} else {
			cs.logger.info("User details not displayed");
		}
	}

	@Then("User should see the button with text {string}")
	public void user_should_see_the_button_with_text(String addnewusertxt) {
	    cs.manageuser.addnewuserbtn();
	    assertEquals(cs.manageuser.addnewuserbtn(),addnewusertxt);
	}

	@When("User clicks Add New User button")
	public void user_clicks_add_new_user_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User should see the {string} modal dialog box")
	public void user_should_see_the_modal_dialog_box(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
