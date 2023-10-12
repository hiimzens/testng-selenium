package test;

import driverManager.CreateDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.PropertiesFileUtil;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    @BeforeSuite
    public void beforeSuite() throws IOException {
        Properties properties = PropertiesFileUtil.loadPropertiesFromFile("src/test/resources/test.properties");
        PropertiesFileUtil.appendSystemProperties(properties);
    }
    @BeforeTest
    public void beforeMethod(){
        String browser = System.getProperty("BROWSER_TYPE");
        if(browser!=null && !browser.isEmpty()) {
            CreateDriver.getInstance().setBrowser(browser);
            CreateDriver.getInstance().getDriver();
        }
        CreateDriver.getInstance().getDriver().manage().window().maximize();
        CreateDriver.getInstance().getDriver().get(System.getProperty("BASE_URL"));
    }

    @AfterTest(alwaysRun = true)
    public void afterTest(){
        CreateDriver.getInstance().getDriver().quit();
    }
}
