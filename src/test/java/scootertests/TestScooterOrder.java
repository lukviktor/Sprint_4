package scootertests;

import PageObject.MainOrderPage;
import PageObject.MainOrderStatusPage;
import PageObject.MainPage;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
public class TestScooterOrder extends TestBase{

    @Test
    public void OrderingScooterUpButton() {
        MainPage mainPage = new MainPage(driver);
        MainOrderPage orderPage = new MainOrderPage(driver);
        MainOrderStatusPage statusPage = new MainOrderStatusPage(driver);

        mainPage.clickBtnOrderUp();

        orderPage.completeFormForIsScooterUp();
        orderPage.completeAboutRentUp();
        assertTrue(orderPage.checkHeaderOrderBeenPlaced());
        orderPage.clickBtnStatusOrder();

        statusPage.clickBtnCookies();
        statusPage.orderCancellation();
    }

    @Test
    public void OrderingScooterLowButton() {
        MainPage mainPage = new MainPage(driver);
        MainOrderPage orderPage = new MainOrderPage(driver);
        MainOrderStatusPage statusPage = new MainOrderStatusPage(driver);

        mainPage.clickBtnOrderLow();

        orderPage.completeFormForIsScooterLow();
        orderPage.completeAboutRentLow();
        assertTrue(orderPage.checkHeaderOrderBeenPlaced());
        orderPage.clickBtnStatusOrder();

        statusPage.clickBtnCookies();
        statusPage.orderCancellation();
    }
    @Test

    public void ClickLogoScooterRedirectsMainPage() {
// Проверить: если нажать на логотип «Самоката», попадёшь на главную страницу «Самоката».
        MainPage mainPage = new MainPage(driver);

        mainPage.clickBtnOrderHomelogoScooter();
        assertTrue(mainPage.checkHomeHeader());
    }
}