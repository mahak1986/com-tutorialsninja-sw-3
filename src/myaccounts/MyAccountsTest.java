package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;
import java.util.UUID;

public class MyAccountsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    /**
     * Create the class MyAccountsTest
     * 1.1 create method with name "selectMyAccountOptions" it has one parameter name
     * "option" of type string
     * 1.2 This method should click on the options whatever name is passed as parameter.
     * (Hint: Handle List of Element and Select options)
     */
    public void selectMyAccountOptions(String option) {
        List<WebElement> options = driver.findElements(By.xpath("//ul[@class = 'list-inline']//a"));
        for (WebElement list : options) {
            if (option.equalsIgnoreCase(list.getText())) {
                list.click();
                break;
            }
        }
    }

    /**
     * 1. Test name verifyUserShouldNavigateToRegisterPageSuccessfully()
     * 1.1 Clickr on My Account Link.
     * 1.2 Call the method “selectMyAccountOptions” method and pass the parameter
     * “Register”
     * 1.3 Verify the text “Register Account”.
     */
    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
        clickOnElement(By.xpath("//span[text()='My Account']"));
        Thread.sleep(2000);
        selectMyAccountOptions("Register");
        Thread.sleep(2000);
        assertionMethod("Incorrect page", "Register Account", By.xpath("//h1[normalize-space()='Register Account']"));
    }

    /**
     * 2. Test name verifyUserShouldNavigateToLoginPageSuccessfully()
     * 2.1 Clickr on My Account Link.
     * 2.2 Call the method “selectMyAccountOptions” method and pass the parameter
     * “Login”
     * 2.3 Verify the text “Returning Customer”.
     */
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
        clickOnElement(By.xpath("//span[text()='My Account']"));
        Thread.sleep(2000);
        selectMyAccountOptions("Login");
        Thread.sleep(2000);
        assertionMethod("Incorrect message", "Returning Customer", By.xpath("//h2[normalize-space()='Returning Customer']"));
    }

    /**
     * 3. Test name verifyThatUserRegisterAccountSuccessfully()
     * 3.1 Clickr on My Account Link.
     * 3.2 Call the method “selectMyAccountOptions” method and pass the parameter
     * “Register”
     * 3.3 Enter First Name
     * 3.4 Enter Last Name
     * 3.5 Enter Email
     * 3.6 Enter Telephone
     * 3.7 Enter Password
     * 3.8 Enter Password Confirm
     * 3.9 Select Subscribe Yes radio button
     * 3.10 Click on Privacy Policy check box
     * 3.11 Click on Continue button
     * 3.12 Verify the message “Your Account Has Been Created!”
     */
    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        clickOnElement(By.xpath("//span[text()='My Account']"));
        Thread.sleep(2000);
        selectMyAccountOptions("Register");
        Thread.sleep(2000);
        sendTextToElement(By.id("input-firstname"), "Louise");
        sendTextToElement(By.id("input-lastname"), "Higgins");
        //Enter Email address
        final String randomEmail = randomEmail();
        sendTextToElement(By.id("input-email"), randomEmail);
        Thread.sleep(2000);
        sendTextToElement(By.id("input-telephone"), "01234567890");
        Thread.sleep(2000);
        sendTextToElement(By.id("input-password"), "Louise123");
        Thread.sleep(2000);
        sendTextToElement(By.id("input-confirm"), "Louise123");
        Thread.sleep(2000);
        clickOnElement(By.xpath("//label[normalize-space()='Yes']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@name='agree']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@value='Continue']"));
        Thread.sleep(2000);
        assertionMethod("Incorrect page", "Your Account Has Been Created!", By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"));
        /**
         * 3.13 Click on Continue button
         * 3.14 Click on My Account Link.
         * 3.15 Call the method “selectMyAccountOptions” method and pass the parameter
         * “Logout”
         * 3.16 Verify the text “Account Logout”
         * 3.17 Click on Continue button
         */
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
        Thread.sleep(2000);
        selectMyAccountOptions("Logout");
        Thread.sleep(2000);
        assertionMethod("Incorrect page", "Account Logout", By.xpath("//h1[normalize-space()='Account Logout']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
        Thread.sleep(2000);
    }

    /**
     * Test name verifyThatUserShouldLoginAndLogoutSuccessfully()
     * 4.1 Click on My Account Link.
     * 4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
     * 4.3 Enter Email address
     * 4.4 Enter Last Name
     * 4.5 Enter Password
     * 4.6 Click on Login button
     * 4.7 Verify text “My Account”
     */
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        clickOnElement(By.xpath("//span[text()='My Account']"));
        selectMyAccountOptions("Login");
        sendTextToElement(By.id("input-email"), "mahak@gmail.com");
        sendTextToElement(By.id("input-password"),"Mahak123");
        clickOnElement(By.xpath("//input[@value='Login']"));
        assertionMethod("Error message","My Account",By.xpath("//h2[contains(text(),'My Account')]"));
        /**
         * 4.8 Clickr on My Account Link.
         * 4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
         * 4.10 Verify the text “Account Logout”
         * 4.11 Click on Continue button
         */
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        selectMyAccountOptions("Logout");
        assertionMethod("Incorrect info","Account Logout",By.xpath("//h1[contains(text(),'Account Logout')]"));
        clickOnElement(By.xpath("//a[text()='Continue']"));
    }
    private static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@example.com";
    }
    @After
    public void setDown(){

        closeBrowser();
    }
}
