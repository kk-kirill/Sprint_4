import driver.DriverFactory;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.MainPage;
import pageObjects.OrderNotFoundPage;

import static org.junit.Assert.assertTrue;

public class StatusOrderTest {

    @Rule
    public DriverFactory driverFactory = new DriverFactory();


    @Test
    public void orderNotFoundImageDisplayedTest() {
        WebDriver driver = driverFactory.getDriver();

        MainPage mainPage = new MainPage(driver);
        mainPage.openYandexSamokat();
        mainPage.clickOrderStatusButton();
        mainPage.enterOrderNumber("178998");

        OrderNotFoundPage orderNotFoundPage = mainPage.clickOnGoButton();
        assertTrue(orderNotFoundPage.isNotFoundImageDisplayed());
    }

}
