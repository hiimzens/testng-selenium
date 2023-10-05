package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private final By LBL_PRODUCT = By.className("product_label");
    public HomePage(WebDriver driver){
        super(driver);
    }
    public static HomePage INSTANCE;
    public static HomePage getInstance(WebDriver driver){
        if(INSTANCE==null){
            INSTANCE = new HomePage(driver);
        }
        return INSTANCE;
    }
    public String getProductHomePageLabel() {
        return getText(false, LBL_PRODUCT);
    }
}
