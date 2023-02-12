package demoqa.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBox {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        String userName = "Alex Egorov";

        open("/text-box");
        $(".main-header").shouldHave(text("Text Box"));
        $("#userName").setValue(userName);
        $("#userEmail").setValue("AlexEgorov@mail.com");
        $("#currentAddress").setValue("Some address 1");
        $("#permanentAddress").setValue("Other address 1");
        $("#submit").click();
        $("#output").shouldBe(Condition.visible);
        $("#output").$("#name").shouldHave(text(userName));
        $("#output").$("#email").shouldHave(text("AlexEgorov@mail.com"));
        $("#output").$("#currentAddress").shouldHave(text("Some address 1"));
        $("#output").$("#permanentAddress").shouldHave(text("Other address 1"));


//       sleep(5000);


    }
}
