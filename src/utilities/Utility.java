package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class Utility extends BaseTest {

    /**
     * This method will click on any element, whatever locator you are passing
     */
    public void clickOnElement(By by) {

        driver.findElement(by).click();
    }

    /**
     * This method will return title
     */
    public String getTitle(String title) {
        driver.getTitle();
        return title;
    }

    /**
     * This method will clear text field
     */
    public void clearTextField(By by) {
        driver.findElement(by).clear();

    }

    /**
     * This method will send text to element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {

        return driver.findElement(by).getText();
    }

    public void getSizeFromElement(By by) {

        driver.findElement(by).getSize();
    }

    /**
     * This method will verify the expected and actual result
     */
    public void assertionMethod(String message, String expected, By by) {
        String actual = getTextFromElement(by);
        Assert.assertEquals(" ", expected, actual);
    }



    //************************* Alert Methods *****************************************************

    /**
     * This method will switch to alert
     */
    public void switchToAlert() {

        driver.switchTo().alert();
    }

    /**
     * This method will accept
     */
    public void acceptAlert() {

        driver.switchTo().alert().accept();
    }

    /**
     * This method will get text alert
     */
    public void getTextAlert() {

        driver.switchTo().alert().getText();
    }

    public void dismissAlert() {

        driver.switchTo().alert().dismiss();
    }

    //Alert is an interface , creating object alert, telling driver to switch to alert
    public String sendKeysAlert(String key) {
        driver.switchTo().alert().sendKeys(key);
        return (key);
    }

    //*************************** Select Class Methods ***************************************//
    public void selectByValueFromDropDown(By by, String value) {
        WebElement dropDown = driver.findElement(by);
        //Create the object of select class
        Select select = new Select(dropDown);
        select.selectByValue(value);
    }

    public void selectByVisibleText(By by, String value) {
        WebElement dropDown = driver.findElement(by);
        //Create the object of select class
        Select select = new Select(dropDown);
        select.selectByVisibleText(value);
    }

    public void selectByIndex(By by, int value) {
        WebElement dropDown = driver.findElement(by);
        //Create the object of select class
        Select select = new Select(dropDown);
        select.selectByIndex(value);
    }

    public void selectByAllOptionsFromDropDown(By by) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        List<WebElement> allSelectOptions = select.getAllSelectedOptions();
    }
//*************************** Action Methods ***************************************//


    /**
     * This method will hover mouse on element
     */

    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
        //actions.moveToElement(driver.findElement(by)).moveToElement(driver.findElement(by1)).click().build().perform();
    }

    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
        // actions.moveToElement(driver.findElement(by)).moveToElement(driver.findElement(by1)).click().build().perform();
    }
}


