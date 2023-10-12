package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.extentReports.ExtentTestManager.getTest;

public class HomePage extends BasePage {
    private final By LBL_PRODUCT = By.className("product_label");
    public static HomePage INSTANCE;
    public static HomePage getInstance(){
        if(INSTANCE==null){
            INSTANCE = new HomePage();
        }
        return INSTANCE;
    }
    public String getProductHomePageLabel() {
        getTest().info("Get home page label");
        return getText(false, LBL_PRODUCT);
    }
}
