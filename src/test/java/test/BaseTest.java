package test;

import driverManager.CreateDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.PropertiesFileUtil;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    @BeforeSuite
    public void beforeSuite() throws IOException {
        Properties properties = PropertiesFileUtil.loadPropertiesFromFile("src/test/resources/test.properties");
        PropertiesFileUtil.appendSystemProperties(properties);
    }
    @BeforeMethod
    public void beforeMethod(){
        String browser = System.getProperty("BROWSER_TYPE");
        if(browser!=null && !browser.isEmpty()) {
            CreateDriver.getInstance().setBrowser(browser);
            driver = CreateDriver.getInstance().getDriver();
        }
        driver.manage().window().maximize();
        driver.get(System.getProperty("BASE_URL"));
    }
    @AfterMethod (alwaysRun = true)
    public void afterMethod(){
        if(driver!=null){
            driver.quit();
        }
    }
}
