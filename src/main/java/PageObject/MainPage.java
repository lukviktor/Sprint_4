package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    public String responseActual1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public String responseActual2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями," +
            " можете просто сделать несколько заказов — один за другим.";
    public String responseActual3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня." +
            " Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру." +
            " Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public String responseActual4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public String responseActual5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по" +
            " красивому номеру 1010.";
    public String responseActual6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — " +
            "даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public String responseActual7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже " +
            "не попросим. Все же свои.";
    public String responseActual8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
    private final By homeHeader = By.xpath("//*[@class='Home_Header__iJKdX']");
    //Элемент главной страницы
    private final By btnOrderHome = By.xpath("//*[@class='Button_Button__ra12g']");
    //Кнопка заказать главной страницы
    private final By logoScooter = By.xpath("//*[@class='Header_LogoScooter__3lsAR']");
    //Логотип самокат


    private final By btnOrderUp = By.xpath("//button[@class='Button_Button__ra12g']");
    // Кнопка заказать верхняя

    private final By btnOrderDown = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // Кнопка заказать нижняя

    public void clickBtnOrderUp() { // Метод нажатия на кнопку заказать верхняя
        driver.findElement(btnOrderUp).click();
    }

    public void clickBtnOrderLow() { // Метод нажатия на кнопку заказать нижняя
        WebElement element = driver.findElement(btnOrderDown);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(btnOrderDown).click();
    }
    public void clickBtnOrderHomelogoScooter() { // Метод нажатия на кнопку заказать верхняя
        driver.findElement(btnOrderHome).click();
        driver.findElement(logoScooter).click();
    }
    public boolean checkHomeHeader() { // Проверка присутствует ли хэдер на странице или мы находимся на главной странице

        return driver.findElement(homeHeader).isDisplayed();
        //Проверить, что появилось всплывающее окно с сообщением об успешном создании заказа.
    }
}