import driver.DriverFactory;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pageObjects.MainPage;
import pageObjects.FirstOrderFormPage;
import pageObjects.SecondOrderFormPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderScooterParameterizedTest {

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    private final boolean isTopButton;
    private final String userName;
    private final String surName;
    private final String addressForDelivery;
    private final String metroStation;
    private final String userPhone;
    private final String deliveryDay;
    private final String rentDuration;
    private final boolean isBlackColor;
    private final String commentForСourier;

    public OrderScooterParameterizedTest(Boolean isTopButton, String userName, String surName, String addressForDelivery,
                                          String metroStation, String userPhone, String deliveryDay,
                                          String rentDuration, boolean isBlackColor, String commentForСourier) {
        this.isTopButton = isTopButton;
        this.userName = userName;
        this.surName = surName;
        this.addressForDelivery = addressForDelivery;
        this.metroStation = metroStation;
        this.userPhone = userPhone;
        this.deliveryDay = deliveryDay;
        this.rentDuration = rentDuration;
        this.isBlackColor = isBlackColor;
        this.commentForСourier = commentForСourier;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {true, "Иван", "Иванов", "переулок Хользунова, 6", "Фрунзенская", "89991002030", "22", "сутки", true, "Прошу не опаздывать"},
                {false, "Пётр", "Петров", "ул. Пушкина, 10", "Сокольники", "89991112233", "25", "двое суток", false, "Без комментариев"}
        };
    }


    @Test
    public void OrderScooter() {
        WebDriver driver = driverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openYandexSamokat();
        mainPage.closeCookie();

        FirstOrderFormPage firstOrderFormPage;
        if (isTopButton) {
            firstOrderFormPage = mainPage.clickFirstOrderButton();
        } else {
            firstOrderFormPage = mainPage.clickSecondOrderButton();
        }

        firstOrderFormPage.enterUserName(userName);
        firstOrderFormPage.enterSurName(surName);
        firstOrderFormPage.enterAddressForDelivery(addressForDelivery);
        firstOrderFormPage.enterMetroStation(metroStation);
        firstOrderFormPage.enterUserPhone(userPhone);

        SecondOrderFormPage secondOrderFormPage = firstOrderFormPage.clickNextButton();

        secondOrderFormPage.enterDeliveryDate(deliveryDay);
        secondOrderFormPage.selectRentDuration(rentDuration);
        if (isBlackColor) {
            secondOrderFormPage.clickBlackColorCheckbox();
        } else {
            secondOrderFormPage.clickGreyColorCheckbox();
        }
        secondOrderFormPage.enterCommentForСourierField(commentForСourier);
        secondOrderFormPage.clickOrderButton();
        secondOrderFormPage.clickConfirmYesButton();
        assertTrue("Окно 'Заказ оформлен' должно появиться",
                secondOrderFormPage.orderSuccessWindowDisplayed());
    }
}
