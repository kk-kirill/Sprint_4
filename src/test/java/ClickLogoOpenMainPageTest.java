import driver.DriverFactory;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.MainPage;

import static org.junit.Assert.assertEquals;

public class ClickLogoOpenMainPageTest {

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    public void clickLogoScooterOpenMainPage() {
        WebDriver driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openYandexSamokat();
        mainPage.clickLogoScooter();
        String currentUrl = mainPage.getCurrentUrl();
        assertEquals("https://qa-scooter.praktikum-services.ru/", currentUrl);
    }
}
