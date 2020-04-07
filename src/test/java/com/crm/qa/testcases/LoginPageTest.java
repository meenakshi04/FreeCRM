package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void Setup() {
		initialization();
		LoginPage loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void LoginPageTitleTest() throws Exception {
		String title = loginPage.ValidateLoginPageTitle();
		Thread.sleep(2000);
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
		Thread.sleep(2000);
		System.out.println(title);
	}

	@Test(priority = 2)
	public void validateLogo () throws Exception
	{
		Thread.sleep(2000);
		boolean flg = loginPage.ValidateCrmLogo();
		Assert.assertTrue(flg);
	}

	@Test(priority=3)
	public void LoginTest() throws Exception {
		Thread.sleep(2000);
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
