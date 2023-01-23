package junit.First;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoQaAutomationPracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {

        String nameFirst = "Alina";
        String nameLast = "Krivosheeva";
        String email = "alina@test.ru";
        String gender = "Female";
        String phone = "9202948284";
        String birthMonth = "January";
        String birthYear = "1999";
        String birthDay = "25";
        String subjects = "Commerce";
        String hobbies = "Reading";
        String picturePath = "images/test.png";
        String pictureName = "test.png";
        String address = "Kaluzhskaja obl, g Borovsk, ul Lenina, d 18, kv 92";
        String state = "Haryana";
        String city = "Karnal";

        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue(nameFirst);
        $("#lastName").setValue(nameLast);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(birthMonth);
        $(".react-datepicker__year-select").selectOption(birthYear);
        $(".react-datepicker__day--0" + birthDay).click();
        $("#subjectsContainer input").setValue(subjects);
        $(".subjects-auto-complete__menu").$(byText(subjects)).click();
        $("#hobbiesWrapper").$(byText(hobbies)).click();
        $("#uploadPicture").uploadFromClasspath(picturePath);
        $("#currentAddress").setValue(address);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);

        $(".table-responsive").shouldHave(text(nameFirst));
        $(".table-responsive").shouldHave(text(nameLast));
        $(".table-responsive").shouldHave(text(email));
        $(".table-responsive").shouldHave(text(gender));
        $(".table-responsive").shouldHave(text(phone));
        $(".table-responsive").shouldHave(text(birthMonth));
        $(".table-responsive").shouldHave(text(birthYear));
        $(".table-responsive").shouldHave(text(birthDay));
        $(".table-responsive").shouldHave(text(subjects));
        $(".table-responsive").shouldHave(text(hobbies));
        $(".table-responsive").shouldHave(text(pictureName));
        $(".table-responsive").shouldHave(text(address));
        $(".table-responsive").shouldHave(text(state));
        $(".table-responsive").shouldHave(text(city));


    }
}
