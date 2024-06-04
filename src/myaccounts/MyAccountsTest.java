package myaccounts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * Create package myaccounts
 * 1. Create the class MyAccountsTest
 * 1.1 create method with name "selectMyAccountOptions" it has one parameter name
 * "option" of type string
 * 1.2 This method should click on the options whatever name is passed as parameter.
 * (Hint: Handle List of Element and Select options)
 *
 * Write the following test
 * 1. Test name verifyUserShouldNavigateToRegisterPageSuccessfully()
 *
 * 1.1 Clickr on My Account Link.
 * 1.2 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Register”
 * 1.3 Verify the text “Register Account”.
 *
 * 2. Test name verifyUserShouldNavigateToLoginPageSuccessfully()
 *
 * 2.1 Clickr on My Account Link.
 * 2.2 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Login”
 * 2.3 Verify the text “Returning Customer”.
 *
 * 3. Test name verifyThatUserRegisterAccountSuccessfully()
 *
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
 * 3.13 Click on Continue button
 *
 * 3.14 Clickr on My Account Link.
 * 3.15 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Logout”
 * 3.16 Verify the text “Account Logout”
 * 3.17 Click on Continue button
 *
 * 4. Test name verifyThatUserShouldLoginAndLogoutSuccessfully()
 *
 * 4.1 Clickr on My Account Link.
 * 4.2 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Login”
 * 4.3 Enter Email address
 * 4.4 Enter Last Name
 * 4.5 Enter Password
 * 4.6 Click on Login button
 * 4.7 Verify text “My Account”
 * 4.8 Clickr on My Account Link.
 * 4.9 Call the method “selectMyAccountOptions” method and pass the parameter
 * “Logout”
 * 4.10 Verify the text “Account Logout”
 * 4.11 Click on Continue button
 */
public class MyAccountsTest extends Utility {
    @Before
    public void setUp() {
        logIn(browser);
    }

    public void selectMyAccountOptions(String option) {
        clickOnElement(By.xpath("//a[normalize-space()='" + option + "']"));
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        //Call the method “selectMyAccountOptions” method and pass the parameter Register
        selectMyAccountOptions("Register");
        //Verify the text “Register Account”.
        Assert.assertEquals("Register Account", getTextFromElement(By.xpath("//h1[normalize-space()='Register Account']")));
    }


    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        //Call the method “selectMyAccountOptions” method and pass the parameter Login
        selectMyAccountOptions("Login");
        //Verify the text “Returning Customer”.
        Assert.assertEquals("Returning Customer", getTextFromElement(By.xpath("//h2[normalize-space()='Returning Customer']")));
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        //Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        selectMyAccountOptions("Register");
        //Enter First Name
        sendTextToElement(By.id("input-firstname"), "Ankita");
        //Enter Last Name
        sendTextToElement(By.id("input-lastname"), "Sangi");
        //Enter Email
        String userName = "" + (int) (Math.random() * Integer.MAX_VALUE);            //Create random username
        String emailID = "User" + userName + "@example.com";
        sendTextToElement(By.id("input-email"), emailID);
        //Enter Telephone
        sendTextToElement(By.id("input-telephone"), "07724567892");
        //Enter Password
        sendTextToElement(By.id("input-password"), "abc123");
        //Enter Password Confirm
        sendTextToElement(By.id("input-confirm"), "abc123");
        //Select Subscribe Yes radio button
        clickOnElement(By.xpath("//label[normalize-space()='Yes']"));
        //Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@name='agree']"));
        //Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));
        //Verify the message “Your Account Has Been Created!”
        Assert.assertEquals("Your Account Has Been Created!", getTextFromElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")));
        //Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
        //Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        //Verify the text “Account Logout”
        selectMyAccountOptions("Logout");
        Assert.assertEquals("Account Logout", getTextFromElement(By.xpath("//div[@id='content']//h1")));
        //Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        //Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        selectMyAccountOptions("Login");
        //Enter Email address
        sendTextToElement(By.id("input-email"), "abc123465@gmail.com");
        //Enter Password
        sendTextToElement(By.id("input-password"), "abc123");
        //Click on Login button
        clickOnElement(By.xpath("//input[@value='Login']"));
        //Verify text “My Account”
        verifyExpectedAndActual(By.xpath("//h2[contains(text(),'My Account')]"),"My Account");
        //Assert.assertEquals("My Account", getTextFromElement(By.xpath("//h2[contains(text(),'My Account')]")));
        //Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        selectMyAccountOptions("Logout");
        //Verify the text “Account Logout”
        Assert.assertEquals("Account Logout", getTextFromElement(By.xpath("//div[@id='content']//h1")));
        //Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
