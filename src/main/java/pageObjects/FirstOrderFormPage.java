    package pageObjects;

    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;

    import java.time.Duration;

    public class FirstOrderFormPage {

        // локаторы для полей
        private final By nameField = By.xpath("//input[@placeholder='* Имя']");
        private final By surnameField = By.xpath("//input[@placeholder='* Фамилия']");
        private final By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
        private final By metroStationField = By.xpath("//input[@placeholder='* Станция метро']");
        private final By phoneField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

        //локаторы для кнопок
        private final By nextButton = By.cssSelector(".Button_Middle__1CSJM");

        // локаторы для ошибок полей
        private final By nameError = By.xpath("//div[text()='Введите корректное имя']");
        private final By surNameError = By.xpath("//div[text()='Введите корректную фамилию']");
        private final By addressError = By.xpath("//div[text()='Введите корректный адрес']");
        private final By metroError = By.xpath("//div[text()='Выберите станцию']");
        private final By phoneError = By.xpath("//div[text()='Введите корректный номер']");


        private WebDriver driver;

        public FirstOrderFormPage(WebDriver driver) {
            this.driver = driver;
        }


        //методы для полей
        public void enterUserName(String userName) {
            driver.findElement(nameField).sendKeys(userName);
        }

        public void enterSurName(String surName) {
            driver.findElement(surnameField).sendKeys(surName);
        }

        public void enterAddressForDelivery(String addressForDelivery) {
            driver.findElement(addressField).sendKeys(addressForDelivery);
        }

        public void enterMetroStation(String metroStation) {
            driver.findElement(metroStationField).click();
            driver.findElement(metroStationField).sendKeys(metroStation);
            By stationOption = By.xpath("//div[@class='Order_Text__2broi' and text()='" + metroStation + "']");
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(stationOption));
            driver.findElement(stationOption).click();
        }

        public void enterUserPhone(String userPhone) {
            driver.findElement(phoneField).sendKeys(userPhone);
        }


        //методы для кнопок
        public SecondOrderFormPage clickNextButton() {
            driver.findElement(nextButton).click();
            return new SecondOrderFormPage(driver);
        }


        //методы для ошибок полей
        public String getNameErrorText() {
            return driver.findElement(nameError).getText();
        }

        public String getSurNameErrorText() {
            return driver.findElement(surNameError).getText();
        }

        public String getAddressErrorText() {
            return driver.findElement(addressError).getText();
        }

        public String getMetroErrorText() {
            return driver.findElement(metroError).getText();
        }

        public String getPhoneErrorText() {
            return driver.findElement(phoneError).getText();
        }
    }
