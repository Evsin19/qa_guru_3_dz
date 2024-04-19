import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com"; // Задать урл
        Configuration.pageLoadStrategy = "eager"; // Параметры загрузки страницы
    }

    @Test
    void fillFormTests() {
        open("/text-box");
        $("#firstName").setValue("Igor");
        $("#lastName").setValue("Igor19@mail.ru");
        $("#????").setValue("Street 1");
        $("#userNumber").setValue("Street 2");
        $("#????").setValue("Street 2");
        $(".css-1hwfws3").setValue("sfsad");
        $("#???").setValue("sfsad");
        $("#currentAddress").setValue("sfsad");

        $("#output #name").shouldHave(text("Igor"));
        $("#output #email").shouldHave(text("Igor19@mail.ru"));
        $("#output #currentAddress").shouldHave(text("Street 1"));
        $("#output #permanentAddress").shouldHave(text("Street 2"));
    }
}
