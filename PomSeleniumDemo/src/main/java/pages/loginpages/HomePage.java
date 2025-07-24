package pages.loginpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
    private By header = By.xpath("/html/body/div[2]/form/p[3]");
    private By radioNo = By.id("no");
    private By buttoncheck = By.id("buttoncheck"); 
    private By nameList = By.className("container");
   
    

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
    
    public void setRadioNo() {
    	radioNo.findElement(driver).click();
    }
    public void clickButton() {
    	buttoncheck.findElement(driver).click();
    }
    public void getElementsonsite(){
    	List<WebElement> elements = driver.findElements(nameList);
    	System.out.println(elements);
    	
    }
}

