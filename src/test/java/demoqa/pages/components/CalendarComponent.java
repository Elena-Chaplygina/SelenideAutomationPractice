package demoqa.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setDate(String year, String date, String month) {
        $(".react-datepicker__year-select").selectOption(year);// если элемент имеет тэг select
        $(".react-datepicker__month-select").selectOption(month);
//        $(".react-datepicker__week").$(byText(date)).click();
        $(".react-datepicker__day--00" + date +
                ":not(.react-datepicker__day--outside-month)").click();//отличный вариант
    }
}
