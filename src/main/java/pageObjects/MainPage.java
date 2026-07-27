package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class MainPage {

    // локаторы для лого
    private static final By LOGO_SCOOTER = By.className("Header_LogoScooter__3lsAR");
    private static final By LOGO_YANDEX = By.className("Header_LogoYandex__3TSOI");

    // локаторы для кнопок
    private static final By COOKIE_BUTTON = By.className("App_CookieButton__3cvqF");
    private static final By FIRST_ORDER_BUTTON = By.cssSelector(".Header_Nav__AGCXC .Button_Button__ra12g");
    private static final By SECOND_ORDER_BUTTON = By.cssSelector(".Home_FinishButton__1_cWm .Button_Button__ra12g");
    private static final By STATUS_BUTTON = By.className("Header_Link__1TAG7");
    private static final By GO_BUTTON = By.cssSelector(".Header_Button__28dPO");

    private static final By ENTER_FIELD = By.className("Input_Input__1iN_Z");

    private static final By IMPORTANT_QUESTIONS_SECTION = By.xpath("//div[contains(text(), 'Вопросы о важном')]/..");


    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openYandexSamokat() {
        driver.get("https://qa-scooter.praktikum-services.ru/"); // открываем сайт
    }

    public void closeCookie() {
        driver.findElement(COOKIE_BUTTON).click();
    }

    public By getQuestionButton(int index) {
        return By.id("accordion__heading-" + index);
    }

    public By getQuestionPanel(int index) {
        return  By.id("accordion__panel-" + index);
    }

    public void scrollToImportantQuestions() {
        WebElement element = driver.findElement(IMPORTANT_QUESTIONS_SECTION);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }


    //Методы для кнопок
    public void clickQuestionButton(int index) {
        driver.findElement(getQuestionButton(index)).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(getQuestionPanel(index)));
    }

    public FirstOrderFormPage clickFirstOrderButton() {
        driver.findElement(FIRST_ORDER_BUTTON).click();
        return new FirstOrderFormPage(driver);
    }

    public FirstOrderFormPage clickSecondOrderButton() {
        WebElement button = driver.findElement(SECOND_ORDER_BUTTON);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", button);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(button));
        button.click();
        return new FirstOrderFormPage(driver);
    }

    public void clickOrderStatusButton() {
        driver.findElement(STATUS_BUTTON).click();
    }

    public OrderNotFoundPage clickOnGoButton() {
        driver.findElement(GO_BUTTON).click();
        return new OrderNotFoundPage(driver);
    }


    public void enterOrderNumber(String orderNumber) {
        WebElement input = driver.findElement(ENTER_FIELD);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(input));
        input.sendKeys(orderNumber);
    }


    //Методы для лого
    public void clickLogoScooter() {
        driver.findElement(LOGO_SCOOTER).click();
    }
    public void clickLogoYandex() {
        driver.findElement(LOGO_YANDEX).click();
    }

    public String getAnswerText(int index) {
        return driver.findElement(getQuestionPanel(index)).getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public void switchToWindow(String handle) {
        driver.switchTo().window(handle);
    }

}

