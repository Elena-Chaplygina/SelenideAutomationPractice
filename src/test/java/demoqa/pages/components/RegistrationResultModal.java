package demoqa.pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegistrationResultModal {
    public void verifyModalAppears
            (String name, String email, String gender, String date, String month, String year, String subjectsFirst,
             String subjectsSecond, String hobbie, String file, String address, String state, String city, String number) {
        //Проверка результата
        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text(name), text(email));//простой вариант
        //вариант через xpath
        $x("//div[@class='modal-body']/div/table/tbody/tr[1]/td[2]").shouldHave(text(name + " Egorov"));
        $x("//div[@class='modal-body']/div/table/tbody/tr[2]/td[2]").shouldHave(text(email));
        $x("//div[@class='modal-body']/div/table/tbody/tr[3]/td[2]").shouldHave(text(gender));
        $x("//div[@class='modal-body']/div/table/tbody/tr[4]/td[2]").shouldHave(text(number));
        $x("//div[@class='modal-body']/div/table/tbody/tr[5]/td[2]").shouldHave(text(date + " " + month + "," + year));
        $x("//div[@class='modal-body']/div/table/tbody/tr[6]/td[2]").shouldHave(text(subjectsFirst + ", " + subjectsSecond));
        $x("//div[@class='modal-body']/div/table/tbody/tr[7]/td[2]").shouldHave(text(hobbie));
        $x("//div[@class='modal-body']/div/table/tbody/tr[8]/td[2]").shouldHave(text(file));
        $x("//div[@class='modal-body']/div/table/tbody/tr[9]/td[2]").shouldHave(text(address));
        $x("//div[@class='modal-body']/div/table/tbody/tr[10]/td[2]").shouldHave(text(state + " " + city));

    }



    public void verifyResult(String key, String value) {
$(".table-responsive").$(byText(key)).parent()
        .shouldHave(text(value));

    }
}