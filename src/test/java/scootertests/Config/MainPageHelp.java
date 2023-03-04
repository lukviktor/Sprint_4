package scootertests.Config;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import scootertests.CheckerQuestionsGetResponse;

public class MainPageHelp {
    WebDriver driver;

    public MainPageHelp(WebDriver driver) {
        this.driver = driver;
    }
    public void searchClickQuestion() { // Метод нажатия вопросы

        String xpathQuestion = ".//div[@id='accordion__heading-" + CheckerQuestionsGetResponse.numberRow + "']";
        // Поиск вопроса

        WebElement element = driver.findElement(By.xpath(xpathQuestion)); // Скролл до вопроса
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

        driver.findElement(By.xpath(xpathQuestion)).click();
    }

    public String getTextQuestion() {
        String actual = driver.findElement(By.xpath( // Получаем текст из раскрывающего вопроса
                        ".//div[@aria-labelledby='accordion__heading-"
                                + CheckerQuestionsGetResponse.numberRow + "']//p"))
                .getAttribute("textContent");

        return actual;
    }
}