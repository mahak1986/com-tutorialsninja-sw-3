package desktops;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class DesktopsTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    /**
     * Test name verifyProductArrangeInAlphaBaticalOrder()
     * 1.1 Mouse hover on Desktops Tab and click
     * 1.2 Click on “Show All Desktops”
     * 1.3 Select Sort By position "Name: Z to A"
     * 1.4 Verify the Product will arrange in Descending order.
     */
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        mouseHoverToElement(By.xpath("//a[text()='Desktops']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[text()='Desktops']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[@class='see-all']"));
        Thread.sleep(2000);
        selectByVisibleText(By.id("input-sort"), "Name (Z - A)");
        //List<WebElement> items = driver.findElements(By.xpath("//div[@class = 'caption']//a"));
        assertionMethod("Products are not in Descending order", "Name (Z - A)", By.xpath("//option[@value='https://tutorialsninja.com/demo/index.php?route=product/category&path=20&sort=pd.name&order=DESC']"));

    }

    /**
     * Test name verifyProductAddedToShoppingCartSuccessFully()
     * 2.1 Mouse hover on Currency Dropdown and click
     * 2.2 Mouse hover on £Pound Sterling and click
     * 2.3 Mouse hover on Desktops Tab.
     * 2.4 Click on “Show All Desktops”
     * 2.5 Select Sort By position "Name: A to Z"
     */
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //Mouse hover on Currency Dropdown and click
        mouseHoverToElement(By.xpath("//span[text()='Currency']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//span[text()='Currency']"));
        Thread.sleep(1000);
        //Mouse hover on £Pound Sterling and click
        mouseHoverToElement(By.xpath("//button[text()='£Pound Sterling']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[text()='£Pound Sterling']"));
        Thread.sleep(1000);
        mouseHoverToElement(By.xpath("//a[text()='Desktops']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[text()='Show AllDesktops']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//select[@id='input-sort']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//option[text()='Name (A - Z)']"));
        Thread.sleep(1000);

        /**
         * 2.6 Select product “HP LP3065”
         * 2.7 Verify the Text "HP LP3065"
         * 2.8 Select Delivery Date "2023-11-27"
         * 2.9.Enter Qty "1” using Select class.
         * 2.10 Click on “Add to Cart” button
         * 2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
         */
        clickOnElement(By.xpath("//a[text()='HP LP3065']"));
        Thread.sleep(1000);
        assertionMethod("Text are not same", "HP LP3065", By.xpath("//a[normalize-space()='HP LP3065']"));
        Thread.sleep(2000);
        String year = "2027";
        String month = "November";
        String date = "23";
        clickOnElement(By.xpath("//span[@class = 'input-group-btn']//button[@class = 'btn btn-default']")); // open the calendar
        while (true) {
            //inspect April 2021
            String monthYear = getTextFromElement(By.xpath("//div[@class = 'datepicker-days']//th[@class = 'picker-switch']"));
            System.out.println(monthYear);
            String[] a = monthYear.split(" ");
            String mon = a[0];
            String yer = a[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker-days']//th[@class = 'next']"));
            }
        }
        // Select the date
        List<WebElement> allDates = driver.findElements(By.xpath("//tbody/tr/td"));
        for (WebElement dt : allDates) {
            if (dt.getText().equalsIgnoreCase(date)) {
                dt.click();
                break;
            }
            clearTextField(By.id("input-quantity"));
            sendTextToElement(By.id("input-quantity"), "1");
            clickOnElement(By.xpath("//button[@id='button-cart']"));
            assertionMethod("Incorrect Message", "Success: You have added HP LP3065 to your shopping cart!\n×",
                    By.xpath("//div[@class='alert alert-success alert-dismissible']"));
            // * 2.13 Verify the text "Shopping Cart  (1.00kg)"
            assertionMethod("Wrong Text", "Shopping Cart  (1.00kg)",
                    By.xpath("//h1[contains(text(),'Shopping Cart')]"));

            // * 2.14 Verify the Product name "HP LP3065"
            assertionMethod("Incorrect Product Name", "HP LP3065",
                    By.xpath("(//a[contains(text(),'HP LP3065')])[2]"));

            // * 2.15 Verify the Delivery Date "2023-11-27"
            assertionMethod("Incorrect Date", "Delivery Date:2023-11-27",
                    By.xpath("//small[normalize-space()='Delivery Date:2023-11-27']"));

            // * 2.16 Verify the Model "Product 21"
            assertionMethod("Incorrect Model", "Product 21", By.xpath("//td[normalize-space()='Product 21']"));

            // * 2.17 Verify the Total "£74.73"
            assertionMethod("Incorrect Price", "£74.73", By.xpath("(//td[contains(text(),'£74.73')])[4]"));
        }
    }
        @After
        public void setDown() {
            closeBrowser();
        }
    }



