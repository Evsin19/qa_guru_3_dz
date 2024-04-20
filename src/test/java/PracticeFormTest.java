import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

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
        $("label[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFromClasspath("file.png");
        $("#currentAddress").setValue("Street 999");
        $("#state").click();
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Karnal").pressEnter();
        $("#submit").click();


        $(".table-responsive").shouldHave(text("Igor Evsin"));
        $(".table-responsive").shouldHave(text("Evsin19@gmail.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("0000000000"));
        $(".table-responsive").shouldHave(text("20 October,1998"));
        $(".table-responsive").shouldHave(text("English"));
        $(".table-responsive").shouldHave(text("Sports, Music"));
        $(".table-responsive").shouldHave(text("Haryana Karnal"));
        $(".table-responsive").shouldHave(text("Street 999"));
        $(".table-responsive").shouldHave(text("file.png"));

    }

}
