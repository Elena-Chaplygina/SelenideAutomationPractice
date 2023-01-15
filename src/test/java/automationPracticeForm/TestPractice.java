package automationPracticeForm;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.*;

public class TestPractice {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillForm(){
        String userName = "Ivan";
        String lastName="Ivanov";
        String userEmail = "ivanIvanovqaquru@mail.com";
        String userNumber="9001234567";
        String subjects="h";


        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").setValue(userName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(byText("Male")).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1996");
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__day.react-datepicker__day--001").click();
        $("#subjectsInput").setValue(subjects);
        $(".subjects-auto-complete__menu-list").$(byText("History")).click();
//        $("#hobbies-checkbox-2").setSelected(true);







        sleep(3000);

    }
}
