package driverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateDriver {
    private WebDriver driver;
    public static CreateDriver INSTANCE;
    public static CreateDriver getInstance(){
        if(INSTANCE == null){
            INSTANCE = new CreateDriver();
        }
        return INSTANCE;
    }
    private CreateDriver(){

    }
    public void setBrowser(String browser){
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser type");
        }
    }
    public WebDriver getDriver(){
        return driver;
    }
}
