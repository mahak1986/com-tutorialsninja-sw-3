package laptopsandnotebooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    /**
     * ● Create package laptopsandnotebooks
     * Create the class LaptopsAndNotebooksTest
     * Write the following test
     * 1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
     * 1.1 Mouse hover on Laptops & Notebooks Tab.and click
     * 1.2 Click on “Show All Laptops & Notebooks”
     * 1.3 Select Sort By "Price (High > Low)"
     * 1.4 Verify the Product price will arrange in High to Low order.
     */
    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        mouseHoverToElement(By.xpath("//a[text()='Laptops & Notebooks']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[text()='Laptops & Notebooks']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[text()='Show AllLaptops & Notebooks']"));
        Thread.sleep(2000);
        selectByVisibleText(By.id("input-sort"), "Price (High > Low)");
        Thread.sleep(2000);
        assertionMethod("Products are not in Descending order", "Price (High > Low)", By.xpath("//option[@value='https://tutorialsninja.com/demo/index.php?route=product/category&path=18&sort=p.price&order=DESC']"));
    }

    /**
     * Mouse hover on Laptops & Notebooks Tab and click
     * Click on “Show All Laptops & Notebooks”
     * 2.3 Select Sort By "Price (High > Low)"
     * 2.4 Select Product “MacBook”
     * 2.5 Verify the text “MacBook”
     */
    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {

        mouseHoverToElement(By.xpath("//a[text()='Laptops & Notebooks']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[text()='Laptops & Notebooks']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[text()='Show AllLaptops & Notebooks']"));
        Thread.sleep(2000);
        selectByVisibleText(By.id("input-sort"), "Price (High > Low)");
        clickOnElement(By.xpath("//a[text()='MacBook']"));
        assertionMethod("Incorrect product", "MacBook", (By.xpath("//h1[normalize-space()='MacBook']")));
        Thread.sleep(2000);
        mouseHoverToElement(By.xpath("//span[text()='Currency']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//span[text()='Currency']"));
        Thread.sleep(1000);
        //Mouse hover on £Pound Sterling and click
        mouseHoverToElement(By.xpath("//button[text()='£Pound Sterling']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[text()='£Pound Sterling']"));
        /**
         * 2.6 Click on ‘Add To Cart’ button
         * 2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
         * 2.8 Click on link “shopping cart” display into success message
         * 2.9 Verify the text "Shopping Cart"
         * 2.10 Verify the Product name "MacBook"
         */
        clickOnElement((By.xpath("//button[@id='button-cart']")));

        assertionMethod("Incorrect message", "Success: You have added MacBook to your shopping cart!\n×", By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[text()='shopping cart']"));
        Thread.sleep(1000);
        assertionMethod("Incorrect display", "Shopping Cart  (0.00kg)", By.xpath(("//h1[contains(text(),'Shopping Cart')]")));
        Thread.sleep(1000);
        assertionMethod("Incorrect message", "MacBook", By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
        /**
         * 2.11 Change Quantity "2"
         * 2.12 Click on “Update” Tab
         * 2.13 Verify the message “Success: You have modified your shopping cart!”
         * 2.14 Verify the Total £737.45
         * 2.15 Click on “Checkout” button
         * 2.16 Verify the text “Checkout”
         * 2.17 Verify the Text “New Customer”
         */
        clearTextField(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"));
        sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"), "2");
        clickOnElement(By.xpath("//tr[1]//button[@data-original-title = 'Update']"));
        Thread.sleep(2000);
        assertionMethod("Incorrect Total", "£737.45",
                By.xpath("(//td[contains(text(),'£737.45')])[3]"));
        Thread.sleep(2000);
        clickOnElement((By.xpath("//span[normalize-space()='Checkout']")));
        Thread.sleep(2000);
        assertionMethod("Incorrect page displayed", "Checkout", By.xpath("//h1[normalize-space()='Checkout']"));
        Thread.sleep(2000);
        assertionMethod("Incorrect message", "New Customer", By.xpath("//h2[normalize-space()='New Customer']"));
        /**
         * 2.18 Click on “Guest Checkout” radio button
         * * * 2.19 Click on “Continue” tab
         * 2.20 Fill the mandatory fields
         * 2.21 Click on “Continue” Button
         * 2.22 Add Comments About your order into text area
         * 2.23 Check the Terms & Conditions check box
         * 2.24 Click on “Continue” button
         * 2.25 Verify the message “Warning: Payment method required!”
         */
        clickOnElement(By.xpath("//input[@value='guest']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@id='button-account']"));
        Thread.sleep(2000);
        sendTextToElement(By.id("input-payment-firstname"), "Mahak");
        sendTextToElement(By.id("input-payment-lastname"), "Agarwal");
        sendTextToElement(By.id("input-payment-email"), "mahak@gmail.com");
        sendTextToElement(By.id("input-payment-telephone"), "01234567891");
        Thread.sleep(2000);
        //sendTextToElement(By.id("input-payment-password"),"Mahak@123");
        //sendTextToElement(By.id("Password Confirm"),"Mahak@123");
        sendTextToElement(By.id("input-payment-address-1"), "12 Disney Land");
        sendTextToElement(By.id("input-payment-city"), "London");
        sendTextToElement(By.id("input-payment-postcode"), "DL3 2HL");
        selectByVisibleText(By.id("input-payment-country"), "222");
        selectByVisibleText(By.id("input-payment-zone"), "3553");
        clickOnElement(By.id("button-guest"));
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//textarea[@class = 'form-control']"), "Successful");
        clickOnElement(By.xpath("//input[@type='checkbox']"));
        clickOnElement(By.id("button-payment-method"));
        Thread.sleep(2000);
        assertionMethod("Incorrect page displayed", "Warning: Payment method required!", By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
    }

    @After
    public void setDown() {
        closeBrowser();
    }
}
