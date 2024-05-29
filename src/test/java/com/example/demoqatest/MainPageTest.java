package com.example.demoqatest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Using PageLoadStrategy with EAGER strategy in order to skip loading of unwanted page content
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        // We don't need implicit waiting since we using page load strategy
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void visibility() {
        driver.get("https://demoqa.com/dynamic-properties");
        // Creating an object of class By
        By button = By.cssSelector("#visibleAfter");
        // Setting wait time to button be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // After 5 seconds our button would be visible and clickable
        wait.until(ExpectedConditions.elementToBeClickable(button));
        // Checking if our button is displayed on the page
        assertTrue(driver.findElement(button).isDisplayed(), "There's no such button!");
    }

}
