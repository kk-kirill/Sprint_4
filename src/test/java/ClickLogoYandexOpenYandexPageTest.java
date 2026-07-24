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
        String originalWindow = mainPage.getWindowHandle();
        mainPage.clickLogoYandex();
        for (String windowHandle : mainPage.getWindowHandles()) {
            if(!windowHandle.equals(originalWindow)) {
                mainPage.switchToWindow(windowHandle);
                break;
            }
        }

        String currentUrl = mainPage.getCurrentUrl();
        assertTrue(currentUrl.contains("dzen"));
    }
}
