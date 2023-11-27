package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav']//a[normalize-space() = '" + menu + "']"));
        //String expected = menu;
        //String actual = getTextFromElement(By.xpath("//a[contains(text(),'" + menu + "')]"));
        //assertEqualsMethod("Incorrect top menu", expected, actual);
        assertionMethod("menu","menu",(By.xpath("//a[contains(text(),'" + menu + "')]")));
    }

    @Test
    public void verifyPageNavigation() throws InterruptedException {
        selectMenu("Desktops");
        Thread.sleep(2000);
        selectMenu("Laptops & Notebooks");
        selectMenu("Components");
        selectMenu("Tablets");
        Thread.sleep(2000);
        selectMenu("Software");
        selectMenu("Phones & PDAs");
        Thread.sleep(2000);
        selectMenu("MP3 Players");
    }

    /**
     * verifyUserShouldNavigateToDesktopsPageSuccessfully()
     * 1.1 Mouse hover on “Desktops” Tab and click
     * 1.2 call selectMenu method and pass the menu = “Show All Desktops”
     * 1.3 Verify the text ‘Desktops’
     */
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
        //Mouse hover on “Desktops” Tab and click
        mouseHoverToElement(By.xpath("//a[text()='Desktops']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[text()='Desktops']"));
        Thread.sleep(2000);
        //call selectMenu method and pass the menu = “Show All Desktops”
        clickOnElement(By.xpath("//a[text()='Show AllDesktops']"));
        assertionMethod("Incorrect Text", "Desktops", By.xpath("//h2[normalize-space()='Desktops']"));
        closeBrowser();
    }
    /**
     * verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
     * 2.1 Mouse hover on “Laptops & Notebooks” Tab and click
     * 2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
     * 2.3 Verify the text ‘Laptops & Notebooks’
     */
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() throws InterruptedException {
        //Mouse hover on “Laptops & Notebooks” Tab and click
        //Laptops & Notebooks
        mouseHoverToElement(By.xpath("//a[text()='Laptops & Notebooks']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[text()='Laptops & Notebooks']"));
        clickOnElement(By.xpath("//a[text()='Show AllLaptops & Notebooks']"));
        Thread.sleep(2000);
        assertionMethod("Incorrect Text", "Laptops & Notebooks", By.xpath("//h2[normalize-space()='Laptops & Notebooks']"));
        closeBrowser();
    }
    /**
     * verifyUserShouldNavigateToComponentsPageSuccessfully()
     * 3.1 Mouse hover on “Components” Tab and click
     * 3.2 call selectMenu method and pass the menu = “Show All Components”
     * 3.3 Verify the text ‘Components'
     */
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() throws InterruptedException {
        mouseHoverToElement(By.xpath("//a[text()='Components']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[text()='Components']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[text()='Show AllComponents']"));
        Thread.sleep(2000);
        assertionMethod("Incorrect Text", "Components", By.xpath("//h2[normalize-space()='Components']"));
    }
    @After
    public void setDown(){
        closeBrowser();
    }
}

