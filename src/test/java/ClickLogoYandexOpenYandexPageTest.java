import driver.DriverFactory;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.MainPage;

import static org.junit.Assert.assertTrue;

public class ClickLogoYandexOpenYandexPageTest {

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    public void clickLogoYandexOpenYandexPage() {
        WebDriver driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openYandexSamokat();
        String originalWindow = driver.getWindowHandle();
        mainPage.clickLogoYandex();
        for (String windowHandle : driver.getWindowHandles()) {
            if(!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("dzen"));
    }
}
