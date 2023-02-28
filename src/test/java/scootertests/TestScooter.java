package scootertests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import scootertests.PageObject.MainOrderPage;
import scootertests.PageObject.MainOrderStatusPage;
import scootertests.PageObject.MainPage;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class TestScooter extends TestBase{

    @RunWith(Parameterized.class)
    public static class QuestionsImportant {

        private static WebDriver driver;
        private final String response;
        private final int numberRow;

        public QuestionsImportant(String answer, int numberRow) {
            this.response = answer;
            this.numberRow = numberRow;
        }

        @BeforeClass
        public static void setUp() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("https://qa-scooter.praktikum-services.ru/");
        }

        @Parameterized.Parameters
        public static Object[][] getTestData() {
            MainPage mainPage = new MainPage(driver);
            return new Object[][]{

                    { mainPage.responseActual1, 0},
                    { mainPage.responseActual2, 1},
                    { mainPage.responseActual3, 2},
                    { mainPage.responseActual4, 3},
                    { mainPage.responseActual5, 4},
                    { mainPage.responseActual6, 5},
                    { mainPage.responseActual7, 6},
                    { mainPage.responseActual8, 7}
            };
        }

        @Test
        public void QuestionsImportantDropDownListNoErrors() {

            String xpathQuestion = ".//div[@id='accordion__heading-" + numberRow + "']"; // Поиск вопроса

            WebElement element = driver.findElement(By.xpath(xpathQuestion)); // Скролл до вопроса
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

            driver.findElement(By.xpath(xpathQuestion)).click();
            String actual = driver.findElement(By.xpath( // Получаем текст из раскрывающего вопроса
                            ".//div[@aria-labelledby='accordion__heading-" + numberRow + "']//p"))
                    .getAttribute("textContent");

            assertEquals(response, actual);
        }

        @AfterClass
        public static void tearDown() {
            driver.quit();
        }

    }


    @Test
    public void OrderingScooterPositiveScenarioUpperButtonShowsErrorChromeBrowser() throws InterruptedException {
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
    public void OrderingScooterPositiveScenarioLowButtonShowsErrorChromeBrowser() throws InterruptedException {
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

    public void ClickLogoScooterRedirectsMainPageNoError() {
// Проверить: если нажать на логотип «Самоката», попадёшь на главную страницу «Самоката».
        MainPage mainPage = new MainPage(driver);

        mainPage.clickBtnOrderHomelogoScooter();
        assertTrue(mainPage.checkHomeHeader());
    }

}