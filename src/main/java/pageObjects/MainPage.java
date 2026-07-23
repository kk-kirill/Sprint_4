package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    // локаторы для лого
    private final By logoScooter = By.className("Header_LogoScooter__3lsAR");
    private final By logoYandex = By.className("Header_LogoYandex__3TSOI");

    // локаторы для кнопок
    private final By cookieButton = By.className("App_CookieButton__3cvqF");
    private final By firstOrderButton = By.cssSelector(".Header_Nav__AGCXC .Button_Button__ra12g");
    private final By secondOrderButton = By.cssSelector(".Home_FinishButton__1_cWm .Button_Button__ra12g");
    private final By statusButton = By.className("Header_Link__1TAG7");
    private final By goButton = By.cssSelector(".Header_Button__28dPO");

    private final By enterField = By.className("Input_Input__1iN_Z");

    private final By importantQuestionsSection = By.xpath("//div[contains(text(), 'Вопросы о важном')]/..");


    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openYandexSamokat() {
        driver.get("https://qa-scooter.praktikum-services.ru/"); // открываем сайт
    }

    public void closeCookie() {
        driver.findElement(cookieButton).click();
    }

    public By getQuestionButton(int index) {
        return By.id("accordion__heading-" + index);
    }

    public By getQuestionPanel(int index) {
        return  By.id("accordion__panel-" + index);
    }

    public void scrollToImportantQuestions() {
        WebElement element = driver.findElement(importantQuestionsSection);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }


    //Методы для кнопок
    public void clickQuestionButton(int index) {
        driver.findElement(getQuestionButton(index)).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(getQuestionPanel(index)));
    }

    public FirstOrderFormPage clickFirstOrderButton() {
        driver.findElement(firstOrderButton).click();
        return new FirstOrderFormPage(driver);
    }

    public FirstOrderFormPage clickSecondOrderButton() {
        WebElement button = driver.findElement(secondOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", button);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(button));
        button.click();
        return new FirstOrderFormPage(driver);
    }

    public void clickOrderStatusButton() {
        driver.findElement(By.className("Header_Link__1TAG7")).click();
    }

    public OrderNotFoundPage clickOnGoButton() {
        driver.findElement(By.cssSelector(".Header_Button__28dPO")).click();
        return new OrderNotFoundPage(driver);
    }


    public void enterOrderNumber(String orderNumber) {
        driver.findElement(By.className("Input_Input__1iN_Z")).sendKeys(orderNumber); // ввод несуществующего заказа
    }


    //Методы для лого
    public void clickLogoScooter() {
        driver.findElement(logoScooter).click();
    }
    public void clickLogoYandex() {
        driver.findElement(logoYandex).click();
    }


    public String getAnswerText(int index) {
        return driver.findElement(getQuestionPanel(index)).getText();
    }
}