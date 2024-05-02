package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080"; // Разрешение браузера
        Configuration.baseUrl = "https://demoqa.com"; // Задать урл
        Configuration.pageLoadStrategy = "eager"; // Параметры загрузки страницы
    }

    @AfterEach
    void afterEach(){
        closeWebDriver();
    }
}
