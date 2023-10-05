package test;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class LoginTest extends BaseTest{
    LoginPage loginPage;
    HomePage homePage;
    @BeforeMethod
    public void beforeLogin(){
        loginPage = LoginPage.getInstance(driver);
        homePage = HomePage.getInstance(driver);
        loginPage.navigateToURL("/v1/index.html");
    }
    @Test
    public void loginSuccessfullyByCorrectData(){
        System.out.println(driver);
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();
        String homepageProductTitle = homePage.getProductHomePageLabel();
        assertThat("Verify the homepage header", homepageProductTitle, equalTo("Products"));
    }
}
