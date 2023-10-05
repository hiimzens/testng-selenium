package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By TXT_USERNAME = By.id("user-name");
    private final By TXT_PASSWORD = By.id("password");
    private final By BTN_LOGIN = By.id("login-button");
    public static LoginPage INSTANCE;
    public static LoginPage getInstance(WebDriver driver){
        if(INSTANCE==null){
            INSTANCE = new LoginPage(driver);
        }
        return INSTANCE;
    }
    public LoginPage(WebDriver driver){
        super(driver);
    }
    public void inputUsername(String userName){
        inputText(false, TXT_USERNAME, userName);
    }
    public void inputPassword(String password){
        inputText(false, TXT_PASSWORD, password);
    }
    public void clickLoginButton(){
        clickElement(false,BTN_LOGIN);
    }
}
