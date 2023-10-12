package test;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.lang.reflect.Method;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static utils.extentReports.ExtentTestManager.startTest;


public class LoginTest extends BaseTest{
    LoginPage loginPage;
    HomePage homePage;
    @BeforeMethod
    public void beforeLogin(){
        loginPage = LoginPage.getInstance();
        homePage = HomePage.getInstance();
        loginPage.navigateToURL("/v1/index.html");
    }
    @Test(description = "Login successfully by correct data")
    public void loginSuccessfullyByCorrectData(Method method){
        startTest(method.getName(), "Login successfully by correct data");
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();
        String homepageProductTitle = homePage.getProductHomePageLabel();
        assertThat("Verify the homepage header", homepageProductTitle, equalTo("Products"));
    }
    @Test(description = "Login unsuccessfully by wrong password")
    public void loginUnsuccessfullyByWrongPassword(Method method){
        startTest(method.getName(), "Login unsuccessfully by wrong password");
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce_123");
        loginPage.clickLoginButton();
        String homepageProductTitle = "123";
        assertThat("Verify the homepage header", homepageProductTitle, equalTo("Products"));
    }
}
