package scootertests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObject.MainPage;
import scootertests.Config.MainPageHelp;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CheckerQuestionsGetResponse {

    private static WebDriver driver;
    private final String response;
    public static int numberRow; // Изменили private final на public static и передали ее в MainPage

    public CheckerQuestionsGetResponse(String answer, int numberRow) {
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
    public void QuestionsImportantDropDown() {
        MainPageHelp pageH = new MainPageHelp(driver);
        pageH.searchClickQuestion();
        assertEquals(response, pageH.getTextQuestion());
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}