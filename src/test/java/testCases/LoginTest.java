package testCases;

import base.AppFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ExcelUtils;

import java.net.MalformedURLException;

public class LoginTest {

    private LoginPage loginPage;

    @BeforeTest
    public void setup() throws MalformedURLException {
        ExcelUtils.readExcelFile();
        AppFactory.initializer();
        loginPage = new LoginPage();
    }

    @Test
    public void verifyUserCreation() throws InterruptedException {
        loginPage.clickCreateAccountButton();
        Assert.assertTrue(loginPage.pageHeader.isDisplayed());
        System.out.println("Email Address Page is Displayed");
        loginPage.enterValidEmailAddress(ExcelUtils.GetCellValue(1, 0));
        loginPage.clickContinueButton();
        Assert.assertTrue((loginPage.createPasswordHeader.isDisplayed()));
        System.out.println("Password Page is Displayed");
        loginPage.enterPassword(ExcelUtils.GetCellValue(1, 1));
        loginPage.enterConfirmPassword(ExcelUtils.GetCellValue(1, 1));
        loginPage.clickSignInButton();
        System.out.println("Creating New User Account");
        Thread.sleep(1000);
    }

    @Test
    public void verifyValidLogin(){
        // Your Code here
    }

    @AfterTest
    public void tearDown() {
        AppFactory.quitDriver();
    }
}
