package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SecondOrderFormPage {

    private static final By deliveryDateField = By.xpath("//input[@placeholder='* Когда привезти самокат']");

    private static final By rentDurationField = By.className("Dropdown-placeholder");

    private static final By blackColorCheckbox = By.xpath("//input[@id='black']");
    private static final By greyColorCheckbox = By.xpath("//input[@id='grey']");

    private static final By commentForСourierField = By.xpath("//input[@placeholder='Комментарий для курьера']");

    private static final By backButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM.Button_Inverted__3IF-i");

    private static final By orderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    private static final By confirmYesButton = By.xpath("//button[text()='Да']");

    private static final By confirmNoButton = By.xpath("//button[text()='Нет']");

    private static final By orderSuccessWindow = By.xpath("//div[contains(@class, 'Order_Modal') and contains(text(), 'Заказ оформлен')]");

    private WebDriver driver;

    public SecondOrderFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterDeliveryDate(String deliveryDay) {
        driver.findElement(deliveryDateField).click(); // клик на поле — календарь открылся
        By dateOption = By.xpath("//div[contains(@class, 'react-datepicker__day') and text()='" + deliveryDay + "' and not(contains(@class, 'outside-month'))]");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(dateOption));
        driver.findElement(dateOption).click();
    }

    public void selectRentDuration(String rentDuration) {
        driver.findElement(rentDurationField).click();
        By rentDurationOption = By.xpath("//div[@class='Dropdown-option' and text()='" + rentDuration + "']");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(rentDurationOption));
        driver.findElement(rentDurationOption).click();
    }

    public void clickBlackColorCheckbox() {
        driver.findElement(blackColorCheckbox).click();
    }

    public void clickGreyColorCheckbox() {
        driver.findElement(greyColorCheckbox).click();
    }

    public void enterCommentForСourierField(String commentForСourier) {
        driver.findElement(commentForСourierField).sendKeys(commentForСourier);
    }

    public void clickBackButton() {
        driver.findElement(backButton).click();
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickConfirmYesButton() {
        driver.findElement(confirmYesButton).click();
    }

    public void clickConfirmNoButton() {
        driver.findElement(confirmNoButton).click();
    }

    public boolean orderSuccessWindowDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(orderSuccessWindow));
        return driver.findElement(orderSuccessWindow).isDisplayed();
    }
}
