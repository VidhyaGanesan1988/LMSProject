package com.LMS.pageObjects;

public class Registration {

	import java.util.List;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.Select;
	public class RegistrationFormPage {
		
		WebDriver driver;
		public RegistrationFormPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="")WebElement heading;
		@FindBy(id="")WebElement firstname;
		@FindBy(id="")WebElement lastname;
		@FindBy(xpath="")WebElement housenumber;
		@FindBy(xpath="")WebElement streetname;
		@FindBy(xpath="")WebElement city;
		@FindBy(xpath="")WebElement state;
		@FindBy(xpath="")WebElement zip;
		@FindBy(xpath="")WebElement bdate;
		@FindBy(xpath="")WebElement phonenumber;
		@FindBy(id="")WebElement username;
		@FindBy(id="")WebElement password;
		@FindBy(id="")WebElement email;
		@FindBy(xpath="")WebElement signup;
		@FindBy(xpath="")WebElement already_have_acc;
		@FindBy(xpath="")WebElement Login;
		
		public boolean verifyHeading()
		{
			return heading.isDisplayed();
		}
		
		public boolean setFirstName(String fname)
		{
			firstname.sendKeys(fname);
			return firstname.isDisplayed();
		}
		
		public void setLastName(String lname)
		{
			lastname.sendKeys(lname);
		}
		
		public void setHouseNumber(String hno)
		{
			housenumber.sendKeys(hno);
		}
		
		public void setStreetName(String street)
		{
			streetname.sendKeys(street);
		}
		
		public void setCity(String ci)
		{
			city.sendKeys(ci);
		}
		
		public void setState(String st)//dropdown
		{
			Select select=new Select(state);
			select.selectByVisibleText(st);
			/*List<WebElement>opt=select.getOptions();
			int size=opt.size();
			for(int i=0;i<size;i++)
			{
				String value=opt.get(i).getText();
				System.out.println(value);
			}*/
			
		}
		
		public void setZip(String z)
		{
			zip.sendKeys(z);
		}
		
		public void setBirthDate(String date)
		{
			bdate.click();
			//selecting a month from dropdown
			Select select=new Select(driver.findElement(By.xpath("")));
			select.selectByVisibleText("");
			
			//selecting a year from dropdown
			Select select1=new Select(driver.findElement(By.xpath("")));
			select1.selectByVisibleText("");
			
			//clicking a day
			driver.findElement(By.xpath("")).click();
		}
		
		public void setPhoneNumber(String phno)
		{
			phonenumber.sendKeys(phno);
		}
		
		public void setUserName(String uname)
		{
			username.sendKeys(uname);
		}
		
		public void setPassword(String pwd)
		{
			password.sendKeys(pwd);
		}
		
		public void setEmail(String mail)
		{
			email.sendKeys(mail);
		}
		
		public boolean verifySignUpbutton()
		{
			return signup.isDisplayed();
		}
		
		public void SignUpButton()
		{
			signup.click();
		}
		
		public void verifyAlready_have_an_account_link()
		{
			already_have_acc.click();
		}
		
		public boolean verify_Login_Button()
		{
			return Login.isDisplayed();
			
		}
		
		public void Login_button_click()
		{
			Login.click();
		}	
	}
}
