package pages.loginpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * HomePage class represents the landing page (home/dashboard) of the application
 * after a successful login. It follows the Page Object Model (POM) structure.
 *
 * Responsibilities:
 * - Encapsulate all interactions and locators related to the home page.
 * - Provide clean methods for verifying UI elements such as headers or dashboard messages.
 */
public class HomePage {

    // WebDriver instance to interact with the browser
    private WebDriver driver;

    // Locator for the header element (e.g., logo or page title)
    // ✅ FIX: This should be a valid XPath only if you're using By.xpath()
    private By header = By.xpath("//*[@id='logo']");

    /**
     * Constructor to initialize the HomePage object with a WebDriver instance.
     * 
     * @param driver The WebDriver passed from the test class or base class
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Fetches the text of the homepage header element.
     * 
     * @return The visible text content of the header element
     */
    public String getHomePageHeaderText() {
        return driver.findElement(header).getText();
    }
}

