    package pageObjects;

    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;

    import java.time.Duration;

    public class FirstOrderFormPage {

        // локаторы для полей
        private static final By NAME_FIELD = By.xpath("//input[@placeholder='* Имя']");
        private static final By SURNAME_FIELD = By.xpath("//input[@placeholder='* Фамилия']");
        private static final By ADDRESS_FIELD = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
        private static final By METRO_STATION_FIELD = By.xpath("//input[@placeholder='* Станция метро']");
        private static final By PHONE_FIELD = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

        //локаторы для кнопок
        private static final By NEXT_BUTTON = By.cssSelector(".Button_Middle__1CSJM");

        // локаторы для ошибок полей
        private static final By NAME_ERROR = By.xpath("//div[text()='Введите корректное имя']");
        private static final By SUR_NAME_ERROR = By.xpath("//div[text()='Введите корректную фамилию']");
        private static final By ADDRESS_ERROR = By.xpath("//div[text()='Введите корректный адрес']");
        private static final By METRO_ERROR = By.xpath("//div[text()='Выберите станцию']");
        private static final By PHONE_ERROR = By.xpath("//div[text()='Введите корректный номер']");


        private WebDriver driver;

        public FirstOrderFormPage(WebDriver driver) {
            this.driver = driver;
        }


        //методы для полей
        public void enterUserName(String userName) {
            driver.findElement(NAME_FIELD).sendKeys(userName);
        }

        public void enterSurName(String surName) {
            driver.findElement(SURNAME_FIELD).sendKeys(surName);
        }

        public void enterAddressForDelivery(String addressForDelivery) {
            driver.findElement(ADDRESS_FIELD).sendKeys(addressForDelivery);
        }

        public void enterMetroStation(String metroStation) {
            driver.findElement(METRO_STATION_FIELD).click();
            driver.findElement(METRO_STATION_FIELD).sendKeys(metroStation);
            By stationOption = By.xpath("//div[@class='Order_Text__2broi' and text()='" + metroStation + "']");
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(stationOption));
            driver.findElement(stationOption).click();
        }

        public void enterUserPhone(String userPhone) {
            driver.findElement(PHONE_FIELD).sendKeys(userPhone);
        }


        //методы для кнопок
        public SecondOrderFormPage clickNextButton() {
            driver.findElement(NEXT_BUTTON).click();
            return new SecondOrderFormPage(driver);
        }


        //методы для ошибок полей
        public String getNameErrorText() {
            return driver.findElement(NAME_ERROR).getText();
        }

        public String getSurNameErrorText() {
            return driver.findElement(SUR_NAME_ERROR).getText();
        }

        public String getAddressErrorText() {
            return driver.findElement(ADDRESS_ERROR).getText();
        }

        public String getMetroErrorText() {
            return driver.findElement(METRO_ERROR).getText();
        }

        public String getPhoneErrorText() {
            return driver.findElement(PHONE_ERROR).getText();
        }
    }
