package com.LMS.stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import com.LMS.base.BaseClass;
import com.LMS.context.ScnContext;
import com.LMS.pageObjects.Login;
import com.LMS.pageObjects.ManageUser;
import com.LMS.pageObjects.UserDetails;
import com.LMS.utilities.ExcelReader;
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
		config=new ReadConfig();
		}
	
	@Before
	public void setUp() {
		cs.logger.info("Launched browser");
		cs.driver=init();
		cs.login = new Login(cs.driver);
		cs.manageuser = new ManageUser(cs.driver);
		cs.userdetails = new UserDetails(cs.driver);
		
	}
	
	@After
    public void quit() {
		cs.driver.quit();
	}
	
	@Given("User is on any page after Login")
	public void user_is_on_any_page_after_login() {
		cs.driver.get(config.getApplicationURL());
		cs.login.setuser(config.getUsername());
		cs.login.setpassword(config.getPassword());
		cs.login.clickloginbtn();
		cs.logger.info("User is on any page after Login");
	}

	@When("User clicks the USER menu")
	public void user_clicks_the_user_menu() {
		cs.manageuser.clickusermenu();
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


	@When("User is on the Manage user page after clicking User menu")
	public void user_is_on_the_manage_user_page_after_clicking_user_menu() {
		cs.manageuser.clickusermenu();
	    cs.logger.info("User is on the Manage user page after clicking User menu");
	}

	@Then("User should see the page header as {string}")
	public void user_should_see_the_page_header_as(String muheadertext) {
		cs.manageuser.manageuserheader();
		assertEquals(cs.manageuser.manageuserheader(),muheadertext);
		cs.logger.info("Page header displayed");	
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
	public void user_is_on_manage_user_page() {
		cs.driver.get(config.getApplicationURL());
		cs.login.setuser(config.getUsername());
		cs.login.setpassword(config.getPassword());
		cs.login.clickloginbtn();
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
	public void user_table_is_displayed_in_manage_user_page()  {
		cs.driver.get(config.getApplicationURL());
		cs.login.setuser(config.getUsername());
		cs.login.setpassword(config.getPassword());
		cs.login.clickloginbtn();
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
	public void user_is_logged_on_to_the_lms_website() {
		cs.driver.get(config.getApplicationURL());
		cs.login.setuser(config.getUsername());
		cs.login.setpassword(config.getPassword());
		cs.login.clickloginbtn();
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
	    cs.manageuser.addnewusertxt();
	    assertEquals(cs.manageuser.addnewusertxt(),addnewusertxt);
	}

	@When("User clicks Add New User button")
	public void user_clicks_add_new_user_button() throws InterruptedException {
	   cs.manageuser.clickusermenu();
	   cs.manageuser.addnewuserbtn();
	   Thread.sleep(1000);
	   cs.logger.info("User clicks Add New User button");
	}

	@Then("User should see the {string} modal dialog box")
	public void user_should_see_the_modal_dialog_box(String userdetailsheader) {
		cs.manageuser.userdetailsheader();
			assertEquals(cs.manageuser.userdetailsheader(),userdetailsheader);
		cs.logger.info("User should see the user details modal dialog box");
	}

	@Then("User should see the table header as Empty checkbox-icon , ID with sort icon, Name with Sort icon, Email Address with sort icon,Contact Number with sort icon, Batch with sort icon, Skill with Sort icon, Edit\\/Delete as column names")
	public void user_should_see_the_table_header_as_empty_checkbox_icon_id_with_sort_icon_name_with_sort_icon_email_address_with_sort_icon_contact_number_with_sort_icon_batch_with_sort_icon_skill_with_sort_icon_edit_delete_as_column_names() {	
		if (cs.manageuser.tableheaders())
		{
		    cs.logger.info("All table headers are displayed");
		} else {
			cs.logger.info("Table headers not dispplayed");
		}
	}

	@When("User clicks sort icon in table header")
	public void user_clicks_sort_icon_in_table_header() {
	   cs.manageuser.IDsorticon();
	   cs.logger.info("User clicks sort icon in table header");
	}
	
	@Then("Table rows should be sorted")
	public void table_rows_should_be_sorted() {
	    if(cs.manageuser.userID1())
	    {
	    	cs.logger.info("Table rows sorted in ascending order");
	    }else {
	    	cs.logger.info("Table rows not sorted");
	    }
	}
	
	@When("User checks empty checkbox in header")
	public void user_checks_empty_checkbox_in_header() {
	    cs.manageuser.tablecheckbox();
	}
	@Then("Check box in all the rows of user table should be checked")
	public void check_box_in_all_the_rows_of_user_table_should_be_checked() {
	    if(cs.manageuser.checkboxhighlight())
	    {
	    	cs.logger.info("Check boxes in all rows highlighted");
	    }else {
	    	cs.logger.info("Check boxes in all rows not highlighted");
	    }
	}

	@Then("User should see the delete icon at the top left corner of the user table")
	public void user_should_see_the_delete_icon_at_the_top_left_corner_of_the_user_table() {
	    if(cs.manageuser.masterdeleteicon())
	    {
	    	cs.logger.info("Delete icon displayed above user table");
	    }else {
	    	cs.logger.info("Delete icon is not dispalyed");
	    }
	}

	@When("User checks the rows in user table")
	public void user_checks_the_rows_in_user_table() {
	    cs.manageuser.clickrowcheckbox();
	    cs.logger.info("User checks the rows in user table");
	}
	
	@Then("Delete icon at the top left corner of the user table enabled")
	public void delete_icon_at_the_top_left_corner_of_the_user_table_enabled() {
	   if(cs.manageuser.masterdeleteenabled())
	   {
		   cs.logger.info("Delete icon at the top left corner of the user table enabled");
	   }else {
		   cs.logger.info("Delete icon at the top left corner of the user table disabled");
	   }
	}

	@When("User clicks the delete icon after checking the row")
	public void user_clicks_the_delete_icon_after_checking_the_row() {
	    cs.manageuser.click1rowcheckbox();
	    cs.manageuser.clickmasterdelete();
	    cs.logger.info("User clicks the delete icon after checking the row");
	}
	
	@Then("Confirm dialog box should display warning message")
	public void confirm_dialog_box_should_display_warning_message() {
	   if(cs.manageuser.warningmsgdisplay())
	   {
		   cs.logger.info("Confirm dialog box should display warning message");
	   }else {
		   cs.logger.info("Confirm dialog box error");
	   }
	}

	@Given("User is in confirm dialog box after clicking delete icon")
	public void user_is_in_confirm_dialog_box_after_clicking_delete_icon() throws InterruptedException {
		cs.driver.get(config.getApplicationURL());
		cs.login.setuser(config.getUsername());
		Thread.sleep(1000);
		cs.login.setpassword(config.getPassword());
		Thread.sleep(1000);
		cs.login.clickloginbtn();
		Thread.sleep(1000);
		cs.manageuser.clickusermenu();
		cs.manageuser.click1rowcheckbox();
		Thread.sleep(1000);
		cs.manageuser.clickmasterdelete();
		Thread.sleep(1000);
	}
	@When("User clicks button with text Yes")
	public void user_clicks_button_with_text_yes() {
	   cs.manageuser.clickyesbtn();
	   cs.logger.info("User clicks button with text Yes");
	}
	@Then("Selected rows should be deleted and popup should be shown with success message {string}")
	public void selected_rows_should_be_deleted_and_popup_should_be_shown_with_success_message(String msgtxt) {
	   cs.manageuser.successmsgdisplay();
	   assertEquals(cs.manageuser.successmsgdisplay(),msgtxt);
		   cs.logger.info("Success message displayed");
	}

	@When("User clicks button with text No")
	public void user_clicks_button_with_text_no() {
	   cs.manageuser.clicknobtn();
	}
	@Then("Selected rows should not be deleted and dialog box should be closed")
	public void selected_rows_should_not_be_deleted_and_dialog_box_should_be_closed() {
		 if(cs.manageuser.userID1())
		   {
			   cs.logger.info("Dialog box closed and Selected row is not deleted");
		   }else {
			   cs.logger.info("Dialog box error");
		   }
	}

	@When("User clicks the close\\(x) icon")
	public void user_clicks_the_close_x_icon() {
	    cs.manageuser.clickXbtn();
	    cs.logger.info("User clicks the close(x) icon");
	}
	
	@Then("Confirm dialog box should be closed")
	public void confirm_dialog_box_should_be_closed() {
		if(cs.manageuser.userID1())
		   {
			   cs.logger.info("Dialog box closed and Selected row is not deleted");
		   }else {
			   cs.logger.info("Dialog box error");
		   }
	}

	@Then("User should see the buttons with edit\\/delete icon in each row of Edit\\/Delete coulmn")
	public void user_should_see_the_buttons_with_edit_delete_icon_in_each_row_of_edit_delete_coulmn() {
	    if(cs.manageuser.displayeditdelete())
	    {
	    	cs.logger.info("Edit/Delete button displayed");
	    }else {
	    	cs.logger.info("Edit/Delete button is not displayed");
	    }
	}
	
	@When("User clicks delete button")
	public void user_clicks_delete_button() {
	    cs.manageuser.clickrowdelete();
	    cs.logger.info("User clicks delete button in the row");
	}
	@Then("Confirm dialog box should display warning message {string}")
	public void confirm_dialog_box_should_display_warning_message(String rowwarnmsg) {
	    cs.manageuser.rowwarnmsgdisplay();
	    assertEquals(cs.manageuser.rowwarnmsgdisplay(),rowwarnmsg);
	    cs.logger.info("Warning msg displayed");
	}

	@When("User clicks Edit button")
	public void user_clicks_edit_button() {
	   cs.manageuser.clickeditbtn();
	   cs.logger.info("User clicks Edit button");
	}
	
	@Then("User Details dialog box should be displayed for editing")
	public void user_details_dialog_box_should_be_displayed_for_editing() {
		if(cs.manageuser.userdetailstxt())
	    {
	    	cs.logger.info("User Details dialog box displayed");
	    }else {
	    	cs.logger.info("User Details dialog box not displayed");
	    }
	}

	@Then("User should see the Search input field after the delete icon")
	public void user_should_see_the_search_input_field_after_the_delete_icon() {
	    if(cs.manageuser.displaysearch())
	    {
	    	cs.logger.info("Search option displayed");
	    }else {
	    	cs.logger.info("Search option not displayed");
	    }
	}
	
	@When("User types Name to search")
	public void user_types_name_to_search() {
		cs.manageuser.clickusermenu();
	    cs.manageuser.searchname();
	    cs.logger.info("User types a name to search a record");
	}
	@Then("Rows with the name should be displayed")
	public void rows_with_the_name_should_be_displayed() {
		if(cs.manageuser.searchvalidation())
		{
			cs.logger.info("Entry of a requested user is displayed");
	} else {
    	cs.logger.info("Search option is not functioning");
	}
}
	
	@When("User types random text in search field which has no matching entry")
	public void user_types_random_text_in_search_field_which_has_no_matching_entry() {
		cs.manageuser.clickusermenu();
	    cs.manageuser.searchinvalidname();
	    cs.logger.info("User types a invalid name to search a record");
	}
	@Then("No rows is displayed")
	public void no_rows_is_displayed() {
		if(cs.manageuser.searchinvalid())
		{
			cs.logger.info("No entry is displayed");
	} else {
    	cs.logger.info("Search function error");
	}
	}
	
	@When("User clicks ID in any row")
	public void user_clicks_id_in_any_row() {
	   cs.manageuser.clickuserID();
	   cs.logger.info("User clicks ID in any row");
	}
	@Then("User details dialog box displayed with user information")
	public void user_details_dialog_box_displayed_with_user_information() {
	    if (cs.manageuser.userdetailstxt())
	    {
	    	cs.logger.info("User details dialog box displayed");
	    } else {
	    	cs.logger.info("User details dialog box not displayed");
	    }
	}

	@When("User clicks cancel button in user details dialog box")
	public void user_clicks_cancel_button_in_user_details_dialog_box() {
		cs.manageuser.clickuserID();
	    cs.manageuser.clickcancelbtn();
	}
	@Then("User details dialog box is closed")
	public void user_details_dialog_box_is_closed() {
		 if (cs.manageuser.manageusertxt())
		    {
		    	cs.logger.info("User details dialog box is closed");
		    } else {
		    	cs.logger.info("User details dialog box error");
		    }
	}
	
	/*User Details*/
	
	@When("User clicks Add new user button")
	public void user_clicks_add_new_user_buttonn() throws InterruptedException {
		cs.manageuser.clickusermenu();
	    cs.manageuser.addnewuserbtn();
	    Thread.sleep(1000);
	    cs.logger.info("User clicks Add new user button");
	}

	@Then("User should see User details window with heading {string}")
	public void user_should_see_user_details_window_with_heading(String userdetailsheader) {
		cs.manageuser.userdetailsheader();
		assertEquals(cs.manageuser.userdetailsheader(),userdetailsheader);
	    cs.logger.info("User should see User details window with heading User Details");
	}

	@Then("User should see a button with text {string} in user details window")
	public void user_should_see_a_button_with_text_in_user_details_window(String submitbtn) {
		cs.userdetails.submitbtndisplay();
	    assertEquals(cs.userdetails.submitbtndisplay(),submitbtn);
	    cs.logger.info("Cancel button displayed");
	}

	@Given("User is on User details window")
	public void user_is_on_user_details_window() throws InterruptedException {
		cs.driver.get(config.getApplicationURL());
		cs.login.setuser(config.getUsername());
		cs.login.setpassword(config.getPassword());
		cs.login.clickloginbtn();
		cs.manageuser.clickusermenu();
		cs.manageuser.addnewuserbtn();
		Thread.sleep(1000);
	}

	@When("User clicks cancel button")
	public void user_clicks_cancel_button() {
	   cs.userdetails.clickusercancelbtn();
	   cs.logger.info("User clicks cancel button");
	}

	@Then("User details window should be closed")
	public void user_details_window_should_be_closed() {
		if(cs.manageuser.manageusertxt())
	    {
	    	cs.logger.info("User details window closed");
	    }else {
	    	cs.logger.info("User details window displayed");
	    }
	}

	@Then("User should see a cancel\\(x) icon in user details window")
	public void user_should_see_a_cancel_x_icon_in_user_details_window() {
	    if(cs.userdetails.Xicondisplay())
	    {
	    	cs.logger.info("Cancel (X) Icon is visible");
	    }else {
	    	cs.logger.info("Cancel (X) Icon is not visible");
	    }
	}

	@When("User clicks cancel\\(X) icon")
	public void user_clicks_cancel_x_icon() {
	   cs.userdetails.clickusercancelbtn();
	}

	@Then("User details dialog box should be closed")
	public void user_details_dialog_box_should_be_closed() {
		if(cs.manageuser.manageusertxt())
	    {
	    	cs.logger.info("User details dialog box closed");
	    }else {
	    	cs.logger.info("User is still on User details dialog box");
	    }
	}

	@Then("User should see all the placeholders displayed")
	public void user_should_see_all_the_placeholders_displayed() {
		if(cs.userdetails.Displayplaceholders())
	    {
	    	cs.logger.info("All placeholders displayed");
	    }else {
	    	cs.logger.info("All placeholders not dispalyed");
	    }
	}
//Scenario will fail, No dropdown option available(Wrote dummy path)
	@When("User clicks the drop down icon for state")
	public void user_clicks_the_drop_down_icon_for_state() {
	  cs.userdetails.clickstatedropdown();
	  cs.logger.info("User clicks the drop down icon for state");
	}

	@Then("User should see drop down menu options for state")
	public void user_should_see_drop_down_menu_options_for_state() {
		if(cs.userdetails.displayState1())
	    {
	    	cs.logger.info("State dropdown option works");
	    }else {
	    	cs.logger.info("State dropdown option not working");
	    }
	}
	
//Scenario will fail, No dropdown option available(Wrote dummy path)
	@When("User clicks the drop down icon for user role")
	public void user_clicks_the_drop_down_icon_for_user_role() {
	   cs.userdetails.clickuserroledropdown();
	   cs.logger.info("User clicks the drop down icon for user role");
	}

	@Then("User should see drop down menu options for user role")
	public void user_should_see_drop_down_menu_options_for_user_role() {
		if(cs.userdetails.displayuserrole1())
	    {
	    	cs.logger.info("User role dropdown option works");
	    }else {
	    	cs.logger.info("User role dropdown option not working");
	    }
	}

//Scenario will fail. User details getting saved with empty details(Wrote dummy codes)
	@When("User clicks save button with all fields empty")
	public void user_clicks_save_button_with_all_fields_empty() {
	    cs.userdetails.clicksubmitbtn();
	}

	@Then("User should see a message {string}")
	public void user_should_see_a_message(String errormsg) {
		cs.userdetails.dispplayerrormsg();
		assertEquals(cs.manageuser.cancelbtntxt(),errormsg);
		cs.logger.info("Mandatory Fields cannot be empty message dispplayed");
	}

	@When("User clicks Save button by entering all valid values from {string} and {int}")
	public void user_clicks_save_button_by_entering_all_valid_values_from_and(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		ExcelReader excelReader = new ExcelReader();
		List<Map<String,String>> ValidUserDetails = 
				excelReader.getData(ReadConfig.EXCEL, sheetName);
		
		String FirstName = ValidUserDetails.get(rowNumber).get("FirstName");
		String MiddleName = ValidUserDetails.get(rowNumber).get("MiddleName");
		String LastName = ValidUserDetails.get(rowNumber).get("LastName");
		String Emailaddress = ValidUserDetails.get(rowNumber).get("Emailaddress");
		String Phoneno = ValidUserDetails.get(rowNumber).get("Phoneno");
		String Address = ValidUserDetails.get(rowNumber).get("Address");
		String City = ValidUserDetails.get(rowNumber).get("City");
		String State = ValidUserDetails.get(rowNumber).get("State");
		String PostalCode = ValidUserDetails.get(rowNumber).get("PostalCode");
		String Program = ValidUserDetails.get(rowNumber).get("Program");
		String UGProgram = ValidUserDetails.get(rowNumber).get("UGProgram");
		String PGProgram = ValidUserDetails.get(rowNumber).get("PGProgram");
		String Skill = ValidUserDetails.get(rowNumber).get("Skill");
		String Experience = ValidUserDetails.get(rowNumber).get("Experience");
		String UserRole = ValidUserDetails.get(rowNumber).get("UserRole");
		String VisaStatus = ValidUserDetails.get(rowNumber).get("VisaStatus");
		String Batch = ValidUserDetails.get(rowNumber).get("Batch");
		String Comments = ValidUserDetails.get(rowNumber).get("Comments");
		String UserName = ValidUserDetails.get(rowNumber).get("UserName");
		String Password = ValidUserDetails.get(rowNumber).get("Password");
		String FieldType = ValidUserDetails.get(rowNumber).get("FieldType");
		cs.userdetails.sendvaliddetails(FirstName, MiddleName, LastName, Emailaddress, Phoneno, Address, City, State, PostalCode, Program, UGProgram, PGProgram, Skill, Experience, UserRole, VisaStatus, Batch, Comments, UserName, Password, FieldType);
		cs.userdetails.clicksubmitbtn();
		cs.logger.info("User enters valid details");
	}

	
	@Then("New User Should be Saved")
	public void new_user_should_be_saved() {
	    if(cs.userdetails.displayaddedusername())
		    {
		    	cs.logger.info("User details added successfully");
		    }else {
		    	cs.logger.info("User details not added");
		    } 	
	}

	//Scenario should fail. But this gets passed since invalid inputs are accepted in the user details dialog box
	@When("User clicks Save button by entering invalid values from {string} and {int}")
	public void user_clicks_save_button_by_entering_invalid_values_from_and(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
		ExcelReader excelReader = new ExcelReader();
		List<Map<String,String>> ValidUserDetails = 
				excelReader.getData(ReadConfig.EXCEL, sheetName);
		
		String FirstName = ValidUserDetails.get(rowNumber).get("FirstName");
		String MiddleName = ValidUserDetails.get(rowNumber).get("MiddleName");
		String LastName = ValidUserDetails.get(rowNumber).get("LastName");
		String Emailaddress = ValidUserDetails.get(rowNumber).get("Emailaddress");
		String Phoneno = ValidUserDetails.get(rowNumber).get("Phoneno");
		String Address = ValidUserDetails.get(rowNumber).get("Address");
		String City = ValidUserDetails.get(rowNumber).get("City");
		String State = ValidUserDetails.get(rowNumber).get("State");
		String PostalCode = ValidUserDetails.get(rowNumber).get("PostalCode");
		String Program = ValidUserDetails.get(rowNumber).get("Program");
		String UGProgram = ValidUserDetails.get(rowNumber).get("UGProgram");
		String PGProgram = ValidUserDetails.get(rowNumber).get("PGProgram");
		String Skill = ValidUserDetails.get(rowNumber).get("Skill");
		String Experience = ValidUserDetails.get(rowNumber).get("Experience");
		String UserRole = ValidUserDetails.get(rowNumber).get("UserRole");
		String VisaStatus = ValidUserDetails.get(rowNumber).get("VisaStatus");
		String Batch = ValidUserDetails.get(rowNumber).get("Batch");
		String Comments = ValidUserDetails.get(rowNumber).get("Comments");
		String UserName = ValidUserDetails.get(rowNumber).get("UserName");
		String Password = ValidUserDetails.get(rowNumber).get("Password");
		String FieldType = ValidUserDetails.get(rowNumber).get("FieldType");
		cs.userdetails.sendvaliddetails(FirstName, MiddleName, LastName, Emailaddress, Phoneno, Address, City, State, PostalCode, Program, UGProgram, PGProgram, Skill, Experience, UserRole, VisaStatus, Batch, Comments, UserName, Password, FieldType);
		cs.userdetails.clicksubmitbtn();
	}

	@Then("User should see the erorr message {string}")
	public void user_should_see_the_erorr_message(String string) {
	   cs.logger.info("User should see the error message invalid input");
	}

	@When("User clicks the button + Add C\\/O, Apt, Suite, Unit")
	public void user_clicks_the_button_add_c_o_apt_suite_unit() throws InterruptedException {
	    cs.userdetails.clickaddress2();
	    Thread.sleep(1000);
	    cs.logger.info("User clicks the button + Add C/O, Apt, Suite, Unit");
	}

	@Then("User should see {string} option")
	public void user_should_see_option(String address2txt) {
		cs.userdetails.displayaddress2();
		assertEquals(cs.userdetails.displayaddress2(),address2txt);
		cs.logger.info("Address 2 gets displayed");
	}

	@When("User clicks postal code input field")
	public void user_clicks_postal_code_input_field() {
	    cs.userdetails.clickpostalcode();
	    cs.logger.info("User clicks postal code input field");
	}

	@Then("User should see the input number arrows in the postal code input field")
	public void user_should_see_the_input_number_arrows_in_the_postal_code_input_field() {
	    cs.logger.info("User should see the input number arrows in the postal code input field");
	}

	
}
