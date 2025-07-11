package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.loginpages.HomePage;

/**
 * HomeTest is a TestNG test class that verifies the homepage content
 * after navigating to the TutorialsNinja demo application.
 *
 * It extends BaseTest to inherit WebDriver setup and teardown logic.
 */
public class HomeTest extends BaseTest {

    // Expected text displayed in the homepage header (logo or title)
    private String actualText = "Qafox.com";

    /**
     * This test navigates to the application's homepage and verifies
     * whether the visible header/logo text matches the expected value.
     */
    @Test
    public void getHomeURL() {
        // Launch the application URL
        driver.get("https://tutorialsninja.com/demo/");

        // Initialize HomePage object
        HomePage homePage = new HomePage(driver);

        // Get actual text from the homepage (e.g., logo or title)
        String expectedText = homePage.getHomePageHeaderText();

        // Print the retrieved text to console (for debugging/logging)
        System.out.println("Homepage Header Text: " + expectedText);

        // Validate that the actual and expected texts match
        Assert.assertEquals(expectedText, actualText, "❌ Text does not match!");
    }
}
