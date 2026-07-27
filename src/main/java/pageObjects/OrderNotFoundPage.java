package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderNotFoundPage {

    private WebDriver driver;

    public OrderNotFoundPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By IMAGE_LOCATOR = (By.cssSelector("img[alt='Not found']"));

    public boolean isNotFoundImageDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(IMAGE_LOCATOR));
        return driver.findElement(IMAGE_LOCATOR).isDisplayed();
    }
}
