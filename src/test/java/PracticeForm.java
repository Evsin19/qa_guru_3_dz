import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {

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

    @Test
    void fillFormTests() {
        open("/automation-practice-form");
        $("#firstName").setValue("Igor");
        $("#lastName").setValue("Evsin");
        $("#userEmail").setValue("Evsin19@gmail.com");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("0000000000");
        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__year-select]>[value='1998']").click();
        $("[class=react-datepicker__month-select]>[value='9']").click();
        $(".react-datepicker__month .react-datepicker__day--020").click();
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("label[for='hobbies-checkbox-1']").click();
        $("label[for='hobbies-checkbox-2']").click();
        $("#uploadPicture").uploadFromClasspath("file.png");
        $("#currentAddress").setValue("Street 999");
        $("#state").click();
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Karnal").pressEnter();
        $("#submit").click();

    }

}
