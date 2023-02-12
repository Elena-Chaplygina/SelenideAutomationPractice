package demoqa.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithJavaFakerTests extends TestBase{

    @Test
    void successfulRegistrationTest() {
//        Faker faker = new Faker();
        Faker faker = new Faker(new Locale("it"));

        String firstName = faker.name().firstName(); // Emory
        String lastName = faker.name().lastName(); // Barton
        String userEmail = faker.internet().emailAddress(); // Barton

        String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449
        //Объявление переменных
        String gender = "Male";
        String userNumber = "9001234567";
        String subjectsFirst = "h";
        String subjectsFirstFull = "History";
        String subjectsSecond = "m";
        String subjectsSecondFull = "Maths";
        String hobbie = "Music";
        String fileName = "doc.png";
//        String address = "Lenina st, house 1";
        String state = "Rajasthan";
        String city = "Jaipur";
        String dataOfBirth = "1";
        String monthOfBirth = "May";
        String yearOfBirth = "1996";

        //Настройка окружения
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()"); //jQuery
        executeJavaScript("$('#fixedban').remove()"); //jQuery

        //Заполнение формы
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
//        $(byText(gender)).click();//не очень хороший вариант для локализации на разных языках
        //        $("#gender-radio-1").parent().click(); //один из способов
        $("#genterWrapper").$(byText(gender)).click(); //best
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(yearOfBirth);// если элемент имеет тэг select
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
//        $(".react-datepicker__month-select").selectOptionByValue("6");
        $(".react-datepicker__week").$(byText(dataOfBirth)).click();
//        $(".react-datepicker__day--001:not(.react-datepicker__day--outside-month)").click();//отличный вариант
//        $x("//*[@class='react-datepicker__day--001'][not(contains(@class, 'react-datepicker__day--outside-month'))]").click();//отличный вариант на xpath
        $("#subjectsInput").setValue(subjectsFirst);
        $(".subjects-auto-complete__menu-list").$(byText(subjectsFirstFull)).click();
        $("#subjectsInput").setValue(subjectsSecond);
        $(".subjects-auto-complete__menu-list").$(byText(subjectsSecondFull)).click();
        $("#hobbiesWrapper").$(byText(hobbie)).click();
        $("#uploadPicture").uploadFromClasspath(fileName);
        $("#currentAddress").setValue(streetAddress);
        //1 способ
//        $("#state").click();
//        $("#stateCity-wrapper").$(byText("Rajasthan")).click();
        //2 способ
        $(".css-1wa3eu0-placeholder").click();
        $(".col-md-4.col-sm-12").find(byText(state)).click();
        $(".css-1wa3eu0-placeholder").click();
        $(byText(city)).click();
        $("#submit").click();

        //Проверка результата
        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
//        $(".modal-body").shouldHave(text(userName),text(userEmail));//простой вариант
        //вариант через xpath
        $x("//div[@class='modal-body']/div/table/tbody/tr[1]/td[2]").shouldHave(text(firstName + " " + lastName));
        $x("//div[@class='modal-body']/div/table/tbody/tr[2]/td[2]").shouldHave(text(userEmail));
        $x("//div[@class='modal-body']/div/table/tbody/tr[3]/td[2]").shouldHave(text(gender));
        $x("//div[@class='modal-body']/div/table/tbody/tr[4]/td[2]").shouldHave(text(userNumber));
        $x("//div[@class='modal-body']/div/table/tbody/tr[5]/td[2]").shouldHave(text(dataOfBirth + " " + monthOfBirth + "," + yearOfBirth));
        $x("//div[@class='modal-body']/div/table/tbody/tr[6]/td[2]").shouldHave(text(subjectsFirstFull + ", " + subjectsSecondFull));
        $x("//div[@class='modal-body']/div/table/tbody/tr[7]/td[2]").shouldHave(text(hobbie));
        $x("//div[@class='modal-body']/div/table/tbody/tr[8]/td[2]").shouldHave(text(fileName));
        $x("//div[@class='modal-body']/div/table/tbody/tr[9]/td[2]").shouldHave(text(streetAddress));
        $x("//div[@class='modal-body']/div/table/tbody/tr[10]/td[2]").shouldHave(text(state + " " + city));
        $("#closeLargeModal").click();


    }
}
