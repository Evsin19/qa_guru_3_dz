package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private final String day = ".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)";
    private final SelenideElement
                    month = $(".react-datepicker__month-select"),
                    year = $(".react-datepicker__year-select");
    public void setDate(String day, String month, String year) {
        this.month.selectOption(month);
        this.year.selectOption(year);
        $(String.format(this.day, day)).click();
    }
}
