package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.extentReports.ExtentTestManager;

import static utils.extentReports.ExtentTestManager.getTest;

public class LoginPage extends BasePage {
    private final By TXT_USERNAME = By.id("user-name");
    private final By TXT_PASSWORD = By.id("password");
    private final By BTN_LOGIN = By.id("login-button");
    public static LoginPage INSTANCE;
    public static LoginPage getInstance(){
        if(INSTANCE==null){
            INSTANCE = new LoginPage();
        }
        return INSTANCE;
    }
    public LoginPage(){
    }
    public void inputUsername(String userName){
        getTest().info("Input username: " + userName);
        inputText(false, TXT_USERNAME, userName);
    }
    public void inputPassword(String password)
    {
        getTest().info("Input password");
        inputText(false, TXT_PASSWORD, password);
    }
    public void clickLoginButton(){
        getTest().info("Click login button");
        clickElement(false,BTN_LOGIN);
    }
}
