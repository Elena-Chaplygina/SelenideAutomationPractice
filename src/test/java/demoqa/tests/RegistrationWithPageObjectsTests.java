package demoqa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationWithPageObjectsTests extends TestBase {


    @Test
    void fillForm() {

        //Объявление переменных
        String userName = "Alex";
        String userEmail = "ivanIvanovqaquru@mail.com";
        String gender = "Male";
        String userNumber = "9001234567";
        String subjectsFirst = "h";
        String subjectsFirstFull = "History";
        String subjectsSecond = "m";
        String subjectsSecondFull = "Maths";
        String hobbie = "Music";
        String fileName = "doc.png";
        String address = "Lenina st, house 1";
        String state = "Rajasthan";
        String city = "Jaipur";
        String dataOfBirth = "1";
        String monthOfBirth = "May";
        String yearOfBirth = "1996";


        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName("Egorov")
                .setEmail(userEmail)
                .setGender(gender)
                .setNumber(userNumber)
                .setBirthDay(yearOfBirth, dataOfBirth, monthOfBirth);


        $("#subjectsInput").setValue(subjectsFirst);
        $(".subjects-auto-complete__menu-list").$(byText(subjectsFirstFull)).click();
        $("#subjectsInput").setValue(subjectsSecond);
        $(".subjects-auto-complete__menu-list").$(byText(subjectsSecondFull)).click();
        $("#hobbiesWrapper").$(byText(hobbie)).click();
        $("#uploadPicture").uploadFromClasspath(fileName);
        $("#currentAddress").setValue(address);
        //1 способ
//        $("#state").click();
//        $("#stateCity-wrapper").$(byText("Rajasthan")).click();
        //2 способ
        $(".css-1wa3eu0-placeholder").click();
        $(".col-md-4.col-sm-12").find(byText(state)).click();
        $(".css-1wa3eu0-placeholder").click();
        $(byText(city)).click();
        $("#submit").click();
        registrationPage.registrationResultModal.verifyModalAppears(userName, userEmail, gender,
                dataOfBirth, monthOfBirth, yearOfBirth,
                subjectsFirstFull, subjectsSecondFull, hobbie,
                fileName, address, state,
                city, userNumber);
        registrationPage.registrationResultModal.verifyResult("Student Name", userName+" Egorov");

        $("#closeLargeModal").click();

    }

    @Test
    void successfulRegistrationTest() {

        String userName = "Alex";
        String userEmail = "ivanIvanovqaquru@mail.com";
        String gender = "Male";
        String userNumber = "9001234567";
        //Настройка окружения
        registrationPage.openPage();

        //Заполнение формы
        registrationPage.setFirstName(userName);
        registrationPage.setLastName("Egorov");
        registrationPage.setEmail(userEmail);
        registrationPage.setGender(gender);
        registrationPage.setNumber(userNumber);

        $("#dateOfBirthInput").click();
//        ....
    }
}
