package driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateDriverWait {
    private static final int TIMEOUT_IN_SECONDS = Integer.parseInt(System.getProperty("TIMEOUT_IN_SECOND"));
    private static final int LONG_TIMEOUT_IN_SECONDS = Integer.parseInt(System.getProperty("LONG_TIMEOUT_IN_SECOND"));
    public static CreateDriverWait INSTANCE;
    private CreateDriverWait(){

    }
    public static CreateDriverWait getInstance(){
        if(INSTANCE == null){
            INSTANCE = new CreateDriverWait();
        }
        return INSTANCE;
    }
    public WebDriverWait getLongWait(WebDriver driver){
        return new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT_IN_SECONDS));
    }
    public WebDriverWait getShortWait(WebDriver driver){
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_IN_SECONDS));
    }
}
