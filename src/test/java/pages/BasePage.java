package pages;

import driverManager.CreateDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.extentReports.ExtentTestManager;
import utils.log.Log;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static utils.extentReports.ExtentTestManager.getTest;


public class BasePage {
    /******************************** Attributes**************************************************/
    private final int TIMEOUT_IN_SECONDS = Integer.parseInt(System.getProperty("TIMEOUT_IN_SECOND"));
    private final int LONG_TIMEOUT_IN_SECONDS = Integer.parseInt(System.getProperty("LONG_TIMEOUT_IN_SECOND"));

    public WebDriverWait longWait = new WebDriverWait(CreateDriver.getInstance().getDriver(), Duration.ofSeconds(LONG_TIMEOUT_IN_SECONDS));
    public WebDriverWait shortWait = new WebDriverWait(CreateDriver.getInstance().getDriver(), Duration.ofSeconds(TIMEOUT_IN_SECONDS));
    /*********************************** Common methods ******************************************/
    public void navigateToURL(String subDirectoryURL){
        CreateDriver.getInstance().getDriver().get(System.getProperty("BASE_URL")+subDirectoryURL);
    }
    public void maximizeBrowserWindow(){
        CreateDriver.getInstance().getDriver().manage().window().maximize();
    }

    /*********************************** Wait methods ******************************************/

    public WebElement waitForElementToBeVisible(boolean isLongWait, By locator) {
        Log.info("Wait for element to be visible");
        if (isLongWait) {
            return longWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        return shortWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementToBeClickable(boolean isLongWait, By locator){
        Log.info("Wait for element to be clickable");
        if(isLongWait){
            return longWait.until(ExpectedConditions.elementToBeClickable(locator));
        }
        return shortWait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public List<WebElement> waitForPresenceOfAllElementLocatedBy(boolean isLongWait, By locator){
        Log.info("Wait for all element with the same locator to be visible");
        if(isLongWait){
            return longWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        }
        return shortWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

    }
    public Alert waitForAlertToBeVisible (boolean isLongWait){
        Log.info("Wait for alert to be visible");
        if(isLongWait){
            return longWait.until(ExpectedConditions.alertIsPresent());
        }
        else{
            return shortWait.until(ExpectedConditions.alertIsPresent());
        }
    }
    /******************************** Interact with element methods *********************************/
    public String getText(boolean isLongWait, By locator){
        WebElement element = waitForElementToBeVisible(isLongWait, locator);
        Log.info("Get text of element");
        return element.getText();
    }
    public void inputText(boolean isLongWait, By locator, String text){
        WebElement element = waitForElementToBeClickable(isLongWait, locator);
        Log.info("Input text into element");
        element.sendKeys(text);
    }
    public List<String> getListText(boolean isLongWait, By locator,int expectedNumberOfElement){
        List<String> listText = new ArrayList<String>();
        List<WebElement> listWebElement = waitForPresenceOfAllElementLocatedBy(isLongWait, locator);
        if(expectedNumberOfElement > 0){
            for (int i = 0; i < 2; i++) {
                if (listWebElement.size() < expectedNumberOfElement){
                    listWebElement = waitForPresenceOfAllElementLocatedBy(isLongWait, locator);
                }
            }
        }
        for (WebElement element:listWebElement) {
            listText.add(element.getText());
        }
        Log.info("Get list text");
        return listText;
    }
    public void clickElement(boolean isLongWait, By locator){
        Log.info("Click element");
        WebElement element = waitForElementToBeClickable(isLongWait, locator);
        element.click();
    }

    public String getTextOfAlert(boolean isLongWait){
        Log.info("Get text of alert");
        Alert alert = waitForAlertToBeVisible(isLongWait);
        return alert.getText();
    }
    public void clickOKButtonOfAlert(boolean isLongWait) {
        Log.info("Click OK button of alert");
        Alert alert = waitForAlertToBeVisible(isLongWait);
        alert.accept();
    }
}
