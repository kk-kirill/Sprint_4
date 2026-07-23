import driver.DriverFactory;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.FirstOrderFormPage;
import pageObjects.MainPage;

import static org.junit.Assert.assertEquals;

public class TextErrorOrderScooterFormTest {

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    public void CheckFirstFormError() {
        WebDriver driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openYandexSamokat();
        mainPage.closeCookie();
        mainPage.clickFirstOrderButton();

        FirstOrderFormPage firstOrderFormPage = mainPage.clickFirstOrderButton();

        firstOrderFormPage.enterAddressForDelivery("1");
        firstOrderFormPage.clickNextButton();
        assertEquals("Введите корректное имя", firstOrderFormPage.getNameErrorText());
        assertEquals("Введите корректную фамилию", firstOrderFormPage.getSurNameErrorText());
        assertEquals("Введите корректный адрес", firstOrderFormPage.getAddressErrorText());
        assertEquals("Выберите станцию", firstOrderFormPage.getMetroErrorText());
        assertEquals("Введите корректный номер", firstOrderFormPage.getPhoneErrorText());
    }
}
