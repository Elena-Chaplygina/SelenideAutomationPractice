package demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import demoqa.pages.components.RegistrationResultModal;
import demoqa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    public RegistrationResultModal registrationResultModal=new RegistrationResultModal();
    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            lastNameInput = $("#lastName"),
            firstNameInput = $("#firstName"),
            userEmail = $("#userEmail"),
            userGender = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()"); //jQuery
        executeJavaScript("$('#fixedban').remove()"); //jQuery
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;


    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;


    }

    public RegistrationPage setEmail(String value) {
        userEmail.setValue(value);
        return this;


    }

    public RegistrationPage setGender(String value) {
        userGender.$(byText(value)).click();
        return this;


    }

    public RegistrationPage setNumber(String value) {
        userNumber.setValue(value);
        return this;


    }

    public RegistrationPage setBirthDay(String year, String date, String month) {
        dateOfBirthInput.click();
        calendarComponent.setDate(year, date, month);
        return this;


    }

//public RegistrationPage verifyModalAppears
//        (String name, String email, String gender,
//         String date, String month, String year,
//         String subjectsFirst, String subjectsSecond, String hobbie,
//         String file, String address, String state,
//         String city, String number){
//        registrationResultModal.verifyModalAppears(name,  email,  gender,
//                date, month, year,
//                subjectsFirst, subjectsSecond,  hobbie,
//                file,  address,  state,
//                city,  number);
//        return this;
//}public RegistrationPage verifyResult
//        (String key, String value){
//        registrationResultModal.verifyResult(key, value);
//        return this;
//}
    public void clearLastName() {
        lastNameInput.clear();
    }

/*
***SELENIUM
    @FindBy(how=How.XPATH,xpath=".//*[@class='submit']")
    public Button logoutBtn;

 ***SELENIDE
    public SelenideElement logoutBtn=$x(".//*[@class='submit']");
    public SelenideElement logoutBtn=$("submit");
*/
}
