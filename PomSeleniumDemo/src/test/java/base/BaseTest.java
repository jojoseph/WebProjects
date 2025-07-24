package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.DriverFactory;

/**
 * BaseTest serves as the parent class for all test classes in the automation framework.
 * 
 * It is responsible for managing the WebDriver lifecycle — initializing it before each test method 
 * and quitting it afterward — to ensure a clean browser session for every test execution.
 *
 * By extending this class, individual test classes automatically inherit the setup and teardown logic, 
 * promoting reusability, reducing boilerplate code, and maintaining test isolation.
 *
 * Usage of TestNG annotations (@BeforeMethod and @AfterMethod) ensures that:
 * - A new browser instance is launched before each test method.
 * - The browser is properly closed after each test method.
 */
public class BaseTest {
	

    // WebDriver instance accessible to all subclasses of BaseTest
    protected WebDriver driver;

    /**
     * Initializes the WebDriver before each test method.
     * 
     * This method:
     * - Is annotated with @BeforeMethod, so it runs before every @Test method.
     * - Calls DriverFactory.initDriver() to start a new browser session.
     * - Assigns the WebDriver to the protected 'driver' field, allowing test classes and page objects to use it.
     */
    @BeforeMethod
    public void setup() {
        driver = DriverFactory.initDriver();
    }

    /**
     * Quits the WebDriver after each test method.
     * 
     * This method:
     * - Is annotated with @AfterMethod, so it runs after every @Test method.
     * - Calls DriverFactory.quitDriver() to close the browser and clean up the session.
     * - Prevents resource leaks and ensures no browser instances remain running post-test.
     */
    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}

