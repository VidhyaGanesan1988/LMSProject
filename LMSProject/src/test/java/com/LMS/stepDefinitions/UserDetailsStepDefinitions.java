//package com.LMS.stepDefinitions;
//
//import static org.testng.Assert.assertEquals;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//
//import com.LMS.base.BaseClass;
//import com.LMS.context.ScnContext;
//import com.LMS.pageObjects.ManageUser;
//import com.LMS.pageObjects.UserDetails;
//import com.LMS.utilities.ExcelReader;
//import com.LMS.utilities.ReadConfig;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class UserDetailsStepDefinitions extends BaseClass{
//	
//	ReadConfig config;
//	ScnContext cs;
//	
//	public UserDetailsStepDefinitions(ScnContext cs) {
//		this.cs=cs;
//		cs.manageuser = new ManageUser(cs.driver);
//		cs.userdetails = new UserDetails(cs.driver);
//		}
//
//	@When("User clicks Add new user button")
//	public void user_clicks_add_new_user_button() {
//	    cs.manageuser.addnewuserbtn();
//	    cs.logger.info("User clicks Add new user button");
//	}
//
//	@Then("User should see User details window with heading {string}")
//	public void user_should_see_user_details_window_with_heading(String userdetailsheader) {
//		cs.manageuser.userdetailsheader();
//		assertEquals(cs.manageuser.userdetailsheader(),userdetailsheader);
//	    cs.logger.info("User should see User details window with heading User Details");
//	}
//
//	@Then("User should see a button with text {string} in user details window")
//	public void user_should_see_a_button_with_text_in_user_details_window(String cancelbtnTXT) {
//		cs.manageuser.cancelbtntxt();
//		assertEquals(cs.manageuser.cancelbtntxt(),cancelbtnTXT);
//		cs.logger.info("Cancel button displayed");
//	}
//
//	@Given("User is on User details window")
//	public void user_is_on_user_details_window() {
//		if(cs.manageuser.userdetailstxt())
//	    {
//	    	cs.logger.info("User is on User details window");
//	    }else {
//	    	cs.logger.info("User is on Manage User page");
//	    }
//	}
//
//	@When("User clicks cancel button")
//	public void user_clicks_cancel_button() {
//	   cs.manageuser.clickcancelbtn();
//	   cs.logger.info("User clicks cancel button");
//	}
//
//	@Then("User details window should be closed")
//	public void user_details_window_should_be_closed() {
//		if(cs.manageuser.manageusertxt())
//	    {
//	    	cs.logger.info("User details window closed");
//	    }else {
//	    	cs.logger.info("User details window displayed");
//	    }
//	}
//
//	@Then("User should see a cancel\\(x) icon in user details window")
//	public void user_should_see_a_cancel_x_icon_in_user_details_window() {
//	    if(cs.userdetails.Xicondisplay())
//	    {
//	    	cs.logger.info("Cancel (X) Icon is visible");
//	    }else {
//	    	cs.logger.info("Cancel (X) Icon is not visible");
//	    }
//	}
//
//	@When("User clicks cancel\\(X) icon")
//	public void user_clicks_cancel_x_icon() {
//	   cs.userdetails.clickXbtn();
//	}
//
//	@Then("User details dialog box should be closed")
//	public void user_details_dialog_box_should_be_closed() {
//		if(cs.manageuser.manageusertxt())
//	    {
//	    	cs.logger.info("User details dialog box closed");
//	    }else {
//	    	cs.logger.info("User is still on User details dialog box");
//	    }
//	}
//
//	@Then("User should see all the placeholders displayed")
//	public void user_should_see_all_the_placeholders_displayed() {
//		if(cs.userdetails.Displayplaceholders())
//	    {
//	    	cs.logger.info("All placeholders displayed");
//	    }else {
//	    	cs.logger.info("All placeholders not dispalyed");
//	    }
//	}
////Scenario will fail, No dropdown option available(Wrote dummy path)
//	@When("User clicks the drop down icon for state")
//	public void user_clicks_the_drop_down_icon_for_state() {
//	  cs.userdetails.clickstatedropdown();
//	  cs.logger.info("User clicks the drop down icon for state");
//	}
//
//	@Then("User should see drop down menu options for state")
//	public void user_should_see_drop_down_menu_options_for_state() {
//		if(cs.userdetails.displayState1())
//	    {
//	    	cs.logger.info("State dropdown option works");
//	    }else {
//	    	cs.logger.info("State dropdown option not working");
//	    }
//	}
//	
////Scenario will fail, No dropdown option available(Wrote dummy path)
//	@When("User clicks the drop down icon for user role")
//	public void user_clicks_the_drop_down_icon_for_user_role() {
//	   cs.userdetails.clickuserroledropdown();
//	   cs.logger.info("User clicks the drop down icon for user role");
//	}
//
//	@Then("User should see drop down menu options for user role")
//	public void user_should_see_drop_down_menu_options_for_user_role() {
//		if(cs.userdetails.displayuserrole1())
//	    {
//	    	cs.logger.info("User role dropdown option works");
//	    }else {
//	    	cs.logger.info("User role dropdown option not working");
//	    }
//	}
//
////Scenario will fail. User details getting saved with empty details(Wrote dummy codes)
//	@When("User clicks save button with all fields empty")
//	public void user_clicks_save_button_with_all_fields_empty() {
//	    cs.userdetails.clicksubmitbtn();
//	}
//
//	@Then("User should see a message {string}")
//	public void user_should_see_a_message(String errormsg) {
//		cs.userdetails.dispplayerrormsg();
//		assertEquals(cs.manageuser.cancelbtntxt(),errormsg);
//		cs.logger.info("Mandatory Fields cannot be empty message dispplayed");
//	}
//
//	@When("User clicks Save button by entering all valid values from {string} and {int}")
//	public void user_clicks_save_button_by_entering_all_valid_values_from_and(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
//		ExcelReader excelReader = new ExcelReader();
//		List<Map<String,String>> ValidUserDetails = 
//				excelReader.getData(ReadConfig.EXCEL, sheetName);
//		
//		String FirstName = ValidUserDetails.get(rowNumber).get("FirstName");
//		String MiddleName = ValidUserDetails.get(rowNumber).get("MiddleName");
//		String LastName = ValidUserDetails.get(rowNumber).get("LastName");
//		String Emailaddress = ValidUserDetails.get(rowNumber).get("Emailaddress");
//		String Phoneno = ValidUserDetails.get(rowNumber).get("Phoneno");
//		String Address = ValidUserDetails.get(rowNumber).get("Address");
//		String City = ValidUserDetails.get(rowNumber).get("City");
//		String State = ValidUserDetails.get(rowNumber).get("State");
//		String PostalCode = ValidUserDetails.get(rowNumber).get("PostalCode");
//		String Program = ValidUserDetails.get(rowNumber).get("Program");
//		String UGProgram = ValidUserDetails.get(rowNumber).get("UGProgram");
//		String PGProgram = ValidUserDetails.get(rowNumber).get("PGProgram");
//		String Skill = ValidUserDetails.get(rowNumber).get("Skill");
//		String Experience = ValidUserDetails.get(rowNumber).get("Experience");
//		String UserRole = ValidUserDetails.get(rowNumber).get("UserRole");
//		String VisaStatus = ValidUserDetails.get(rowNumber).get("VisaStatus");
//		String Batch = ValidUserDetails.get(rowNumber).get("Batch");
//		String Comments = ValidUserDetails.get(rowNumber).get("Comments");
//		String UserName = ValidUserDetails.get(rowNumber).get("UserName");
//		String Password = ValidUserDetails.get(rowNumber).get("Password");
//		String FieldType = ValidUserDetails.get(rowNumber).get("FieldType");
//		cs.userdetails.sendvaliddetails(FirstName, MiddleName, LastName, Emailaddress, Phoneno, Address, City, State, PostalCode, Program, UGProgram, PGProgram, Skill, Experience, UserRole, VisaStatus, Batch, Comments, UserName, Password, FieldType);
//		cs.userdetails.clicksubmitbtn();
//		cs.logger.info("User enters valid details");
//	}
//
//	@Then("New User Should be Saved")
//	public void new_user_should_be_saved() {
//	    if(cs.userdetails.displayaddedusername())
//		    {
//		    	cs.logger.info("User details added successfully");
//		    }else {
//		    	cs.logger.info("User details not added");
//		    } 	
//	}
//
//	//Scenario should fail. But this gets passed since invalid inputs are accepted in the user details dialog box
//	@When("User clicks Save button by entering invalid values from {string} and {int}")
//	public void user_clicks_save_button_by_entering_invalid_values_from_and(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
//		ExcelReader excelReader = new ExcelReader();
//		List<Map<String,String>> ValidUserDetails = 
//				excelReader.getData(ReadConfig.EXCEL, sheetName);
//		
//		String FirstName = ValidUserDetails.get(rowNumber).get("FirstName");
//		String MiddleName = ValidUserDetails.get(rowNumber).get("MiddleName");
//		String LastName = ValidUserDetails.get(rowNumber).get("LastName");
//		String Emailaddress = ValidUserDetails.get(rowNumber).get("Emailaddress");
//		String Phoneno = ValidUserDetails.get(rowNumber).get("Phoneno");
//		String Address = ValidUserDetails.get(rowNumber).get("Address");
//		String City = ValidUserDetails.get(rowNumber).get("City");
//		String State = ValidUserDetails.get(rowNumber).get("State");
//		String PostalCode = ValidUserDetails.get(rowNumber).get("PostalCode");
//		String Program = ValidUserDetails.get(rowNumber).get("Program");
//		String UGProgram = ValidUserDetails.get(rowNumber).get("UGProgram");
//		String PGProgram = ValidUserDetails.get(rowNumber).get("PGProgram");
//		String Skill = ValidUserDetails.get(rowNumber).get("Skill");
//		String Experience = ValidUserDetails.get(rowNumber).get("Experience");
//		String UserRole = ValidUserDetails.get(rowNumber).get("UserRole");
//		String VisaStatus = ValidUserDetails.get(rowNumber).get("VisaStatus");
//		String Batch = ValidUserDetails.get(rowNumber).get("Batch");
//		String Comments = ValidUserDetails.get(rowNumber).get("Comments");
//		String UserName = ValidUserDetails.get(rowNumber).get("UserName");
//		String Password = ValidUserDetails.get(rowNumber).get("Password");
//		String FieldType = ValidUserDetails.get(rowNumber).get("FieldType");
//		cs.userdetails.sendvaliddetails(FirstName, MiddleName, LastName, Emailaddress, Phoneno, Address, City, State, PostalCode, Program, UGProgram, PGProgram, Skill, Experience, UserRole, VisaStatus, Batch, Comments, UserName, Password, FieldType);
//		cs.userdetails.clicksubmitbtn();
//	}
//
//	@Then("User should see the erorr message {string}")
//	public void user_should_see_the_erorr_message(String string) {
//	   cs.logger.info("User should see the error message invalid input");
//	}
//
//	@When("User clicks the button + Add C\\/O, Apt, Suite, Unit")
//	public void user_clicks_the_button_add_c_o_apt_suite_unit() {
//	    cs.userdetails.clickaddress2();
//	    cs.logger.info("User clicks the button + Add C/O, Apt, Suite, Unit");
//	}
//
//	@Then("User should see {string} option")
//	public void user_should_see_option(String address2txt) {
//		cs.userdetails.displayaddress2();
//		assertEquals(cs.userdetails.displayaddress2(),address2txt);
//		cs.logger.info("Address 2 gets displayed");
//	}
//
//	@When("User clicks postal code input field")
//	public void user_clicks_postal_code_input_field() {
//	    cs.userdetails.clickpostalcode();
//	    cs.logger.info("User clicks postal code input field");
//	}
//
//	@Then("User should see the input number arrows in the postal code input field")
//	public void user_should_see_the_input_number_arrows_in_the_postal_code_input_field() {
//	    cs.logger.info("User should see the input number arrows in the postal code input field");
//	}
//
//}
