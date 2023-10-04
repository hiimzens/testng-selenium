package pages;

import driverManager.CreateDriver;
import driverManager.CreateDriverWait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class BasePage {

    public WebDriver driver = CreateDriver.getInstance().getDriver();
    public WebDriverWait longWait = CreateDriverWait.getInstance().getLongWait(driver);
    public WebDriverWait shortWait = CreateDriverWait.getInstance().getShortWait(driver);

    /*********************************** Wait methods ************************8******************/

    public WebElement waitForElementToBeVisible(boolean isLongWait, By locator) {
        if (isLongWait) {
            return longWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        return shortWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementToBeClickable(boolean isLongWait, By locator){
        if(isLongWait){
            return longWait.until(ExpectedConditions.elementToBeClickable(locator));
        }
        return shortWait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public List<WebElement> waitForPresenceOfAllElementLocatedBy(boolean isLongWait, By locator){

        if(isLongWait){
            return longWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        }
        return shortWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

    }
    public Alert waitForAlertToBeVisible (boolean isLongWait){
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
        return element.getText();
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
        return listText;
    }
    public void clickElement(boolean isLongWait, By locator){
        WebElement element = waitForElementToBeClickable(isLongWait, locator);
        element.click();
    }

    public String getTextOfAlert(boolean isLongWait){
        Alert alert = waitForAlertToBeVisible(isLongWait);
        return alert.getText();
    }
    public void clickOKButtonOfAlert(boolean isLongWait) {
        Alert alert = waitForAlertToBeVisible(isLongWait);
        alert.accept();
    }
}
