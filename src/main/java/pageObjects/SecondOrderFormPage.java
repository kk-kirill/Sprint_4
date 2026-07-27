package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SecondOrderFormPage {

    private static final By DELIVERY_DATE_FIELD = By.xpath("//input[@placeholder='* Когда привезти самокат']");

    private static final By RENT_DURATION_FIELD = By.className("Dropdown-placeholder");

    private static final By BLACK_COLOR_CHECKBOX = By.xpath("//input[@id='black']");
    private static final By GREY_COLOR_CHECKBOX = By.xpath("//input[@id='grey']");

    private static final By COMMENT_FOR_СOURIER_FIELD = By.xpath("//input[@placeholder='Комментарий для курьера']");

    private static final By BACK_BUTTON = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM.Button_Inverted__3IF-i");

    private static final By ORDER_BUTTON = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    private static final By CONFIRM_YES_BUTTON = By.xpath("//button[text()='Да']");

    private static final By CONFIRM_NO_BUTTON = By.xpath("//button[text()='Нет']");

    private static final By ORDER_SUCCESS_WINDOW = By.xpath("//div[contains(@class, 'Order_Modal') and contains(text(), 'Заказ оформлен')]");

    private WebDriver driver;

    public SecondOrderFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterDeliveryDate(String deliveryDay) {
        driver.findElement(DELIVERY_DATE_FIELD).click(); // клик на поле — календарь открылся
        By dateOption = By.xpath("//div[contains(@class, 'react-datepicker__day') and text()='" + deliveryDay + "' and not(contains(@class, 'outside-month'))]");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(dateOption));
        driver.findElement(dateOption).click();
    }

    public void selectRentDuration(String rentDuration) {
        driver.findElement(RENT_DURATION_FIELD).click();
        By rentDurationOption = By.xpath("//div[@class='Dropdown-option' and text()='" + rentDuration + "']");
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(rentDurationOption));
        driver.findElement(rentDurationOption).click();
    }

    public void clickBlackColorCheckbox() {
        driver.findElement(BLACK_COLOR_CHECKBOX).click();
    }

    public void clickGreyColorCheckbox() {
        driver.findElement(GREY_COLOR_CHECKBOX).click();
    }

    public void enterCommentForСourierField(String commentForСourier) {
        driver.findElement(COMMENT_FOR_СOURIER_FIELD).sendKeys(commentForСourier);
    }

    public void clickBackButton() {
        driver.findElement(BACK_BUTTON).click();
    }

    public void clickOrderButton() {
        driver.findElement(ORDER_BUTTON).click();
    }

    public void clickConfirmYesButton() {
        driver.findElement(CONFIRM_YES_BUTTON).click();
    }

    public void clickConfirmNoButton() {
        driver.findElement(CONFIRM_NO_BUTTON).click();
    }

    public boolean orderSuccessWindowDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(ORDER_SUCCESS_WINDOW));
        return driver.findElement(ORDER_SUCCESS_WINDOW).isDisplayed();
    }
}
