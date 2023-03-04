package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainOrderPage {
    private final WebDriver driver;

    public MainOrderPage(WebDriver driver) {
        this.driver = driver;
    }


    private final By nameBox = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/input");
    // Поле имя

    private final By lastNameField = By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    // Поле фамилия

    private final By addressField = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[3]/input");


    // Поле адрес куда привезти
    private final By metroStation = By.xpath("//input[@class='select-search__input']");
    // Поле выбора станции метро


    private final By MetroStationCherkizovo = By.xpath(".//div[@id='root']//div[text()='Черкизовская']");
    // выбор станции метро из placeholder


    private final By phoneField = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[5]/input");
    // Поле телефон
    private final By btnNext = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // Кнопка далее Next button Для кого самокат
    private final By whenBringScooter = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/div[1]/div/input");
    // Когда привезти самокат


    private final By rentalPeriod = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/div[1]/div[1]");
    // поле срока аренды
    private final By timePeriodDays5 = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/div[2]/div[5]");
    // Клик выбора 5 суток
    private final By checkboxColorGrey = By.xpath("//*[@id='grey']");
    // Выбрать цвет самоката серый
    private final By checkboxColorBlack = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[3]/label[1]");
    // Выбрать цвет самоката черный

    private final By comment = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/input");
    //Коммент
    private final By btnOrderFinal = By.xpath("//*[@id='root']/div/div[2]/div[3]/button[2]");
    //Кнопка заказать Про аренду
    private final By btnPlaceAnOrder = By.xpath("//*[@id='root']/div/div[2]/div[5]/div[2]/button[2]");
    // Хотите оформить заказ? Кнопка Да


    private final By headerOrderBeenPlaced = By.xpath("//*[@id='root']/div/div[2]/div[5]/div[1]");
    // Header Заказ оформлен

    private final By btnStatusOrder = By.xpath("//*[@id='root']/div/div[2]/div[5]/div[2]/button");
    // Кнопка просмотреть статус

    public void completeFormForIsScooterUp() { // Метод для заполнения полей блока Для кого самокат
        driver.findElement(nameBox).sendKeys("Иван");
        driver.findElement(lastNameField).sendKeys("Смирнов");
        driver.findElement(addressField).sendKeys("Москва, ул. Куйбышева, д 57");
        driver.findElement(metroStation).click();
        driver.findElement(MetroStationCherkizovo).click();
        driver.findElement(phoneField).sendKeys("79577511250");
        driver.findElement(btnNext).click();
    }

    public void completeAboutRentUp() { // Метод для заполнения полей блока Про аренду
        driver.findElement(whenBringScooter).sendKeys(daysAfter(), Keys.ENTER);
        driver.findElement(rentalPeriod).click();
        driver.findElement(timePeriodDays5).click();
        driver.findElement(checkboxColorGrey).click();
        driver.findElement(comment).sendKeys("Без комментариев !!!");
        driver.findElement(btnOrderFinal).click();
        driver.findElement(btnPlaceAnOrder).click();
    }

    public boolean checkHeaderOrderBeenPlaced() { // Проверка на Заказ оформлен?

        return driver.findElement(headerOrderBeenPlaced).isDisplayed();
        //Проверить, что появилось всплывающее окно с сообщением об успешном создании заказа.
    }

    public void clickBtnStatusOrder() { // Метод нажатия на кнопку заказать верхняя

        driver.findElement(btnStatusOrder).click();
    }

    public void completeFormForIsScooterLow() { // Метод для заполнения полей блока Для кого самокат
        driver.findElement(nameBox).sendKeys("Мирослав");
        driver.findElement(lastNameField).sendKeys("Ли");
        driver.findElement(addressField).sendKeys("Москва");
        driver.findElement(metroStation).click();
        driver.findElement(MetroStationCherkizovo).click();
        driver.findElement(phoneField).sendKeys("+79598741250");
        driver.findElement(btnNext).click();
    }

    public void completeAboutRentLow() { // Метод для заполнения полей блока Про аренду
        driver.findElement(whenBringScooter).sendKeys(daysAfter(), Keys.ENTER);
        driver.findElement(rentalPeriod).click();
        driver.findElement(timePeriodDays5).click();
        driver.findElement(checkboxColorBlack).click();
        driver.findElement(comment).sendKeys("Да какие уж! Кооммеенннтттаааррриии");
        driver.findElement(btnOrderFinal).click();
        driver.findElement(btnPlaceAnOrder).click();
    }

    public String daysAfter() { //Генератор дат в будущее на 5 дней, не могу победить чтоб переходил на следующий месяц
        String daysAfter;
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR, 5);
        Date after = cal.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd");
        daysAfter = formatter.format(after);
        return daysAfter;
    }
}