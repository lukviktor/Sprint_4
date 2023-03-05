package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class MainOrderStatusPage {
    private final WebDriver driver;
    public MainOrderStatusPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By btnCookies = By.xpath("//*[@id='rcc-confirm-button']");
    //Соглашаемся с куки

    private final By btnOrderCancellation = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i']");
    // Кнопка отменить заказ
    private final By btnСancel = By.xpath("//*[@id='root']/div/div[2]/div[4]/div[2]/button[2]");
    //Кнопка отменить

    private final By btnGood = By.xpath("//*[@id='root']/div/div[2]/div[4]/div[2]/button");
    // Кнопка хорошо
    //*[@id="root"]/div/div[2]/div[4]/div[2]/button
    private final By btnOrderCencel = By.xpath("//*[@id='root']/div/div[2]/div[4]/div[2]/button");
    //Кнопка хорошо заказ отменен

    public void clickBtnCookies() { // Метод нажатия на кнопку заказать верхняя
        driver.findElement(btnCookies).click();
    }
    // Соглашаемся с куки

    public void orderCancellation() { // Метод отмены заказа

        driver.findElement(btnOrderCancellation).click();
        driver.findElement(btnСancel).click();
        driver.findElement(btnGood).click();
        driver.findElement(btnOrderCencel).click();
    }
}