package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	    @FindBy (xpath = "//a[@class=' btn-primary']")
        WebElement loginbuttonToNavLoginPage ;
	
	    @FindBy (name = "email")
	    WebElement username ;

	    @FindBy (name = "password")
	    WebElement password ;

	    @FindBy (xpath = "//*[@id='ui']//div/form//div[3]")
	    WebElement loginButton;

	    @FindBy (partialLinkText = "Sign Up")
	    WebElement signupLink ;

	    @FindBy (xpath = "//a[@class= 'brand-name']")
	    WebElement crmLogo ;

	   /* @FindBy (partialLinkText = "Forgot Password?")
	    WebElement forgotPasswordLink ;

	    @FindBy (partialLinkText = "Features")
	    WebElement featuresLink ;

	    @FindBy (partialLinkText = "Customers")
	    WebElement customersLink ;

	    @FindBy (partialLinkText = "Contact")
	    WebElement contactslink ;*/


	// Initializing page objects:

	    public LoginPage(){
	        PageFactory.initElements(driver,this);
	    }
	    
	    public String ValidateLoginPageTitle(){
	        return driver.getTitle();
	    }
	    
	    public boolean ValidateCrmLogo(){
	        return crmLogo.isDisplayed();
	    }
	    
	    public HomePage Login(String Un, String pass){
	    	loginbuttonToNavLoginPage.click();
	    	username.sendKeys(Un);
	    	password.sendKeys(pass);
	    	loginButton.click();
	    	
	    	return new HomePage();
	    }
}

