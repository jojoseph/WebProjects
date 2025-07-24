package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * DriverFactory is a utility class that provides a centralized and consistent way 
 * to initialize, access, and quit the WebDriver instance used throughout the test automation framework.
 *
 * It follows the Singleton design pattern by maintaining a single WebDriver instance 
 * for the current thread/execution context. This ensures that:
 * - Only one browser instance is launched per test class (or thread if extended for parallel execution).
 * - The WebDriver instance is reused wherever required without creating multiple objects.
 */
public class DriverFactory {

    // Static WebDriver instance to ensure it's shared across the test classes.
    private static WebDriver driver;

    /**
     * Initializes the WebDriver instance.
     * - Uses WebDriverManager to automatically manage the ChromeDriver binary (no manual setup needed).
     * - Creates a new instance of ChromeDriver.
     * - Maximizes the browser window.
     *
     * @return Initialized WebDriver instance.
     */
    public static WebDriver initDriver() {
        WebDriverManager.chromedriver().setup(); // Automatically downloads and sets up ChromeDriver
        driver = new ChromeDriver();             // Launches a new Chrome browser instance
        driver.manage().window().maximize();     // Maximizes the browser window
        return driver;
    }

    /**
     * Provides global access to the initialized WebDriver instance.
     * This is useful when you want to use the same driver across various test classes or page objects.
     *
     * @return The current WebDriver instance.
     */
    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * Safely quits the WebDriver instance if it's not null.
     * This is used to clean up the browser session after each test (usually in @AfterMethod or @AfterTest).
     */
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();    // Closes all browser windows and safely ends the WebDriver session
        }
    }
}
