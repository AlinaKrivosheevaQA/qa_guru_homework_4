package homework.lessonFour;

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

        String nameFirst = "Alina",
               nameLast = "Krivosheeva",
               email = "alina@test.ru",
               gender = "Female",
               phone = "9202948284",
               birthMonth = "January",
               birthYear = "1999",
               birthDay = "25",
               subjects = "Commerce",
               hobbies = "Reading",
               picturePath = "images/test.png",
               pictureName = "test.png",
               address = "Kaluzhskaja obl, g Borovsk, ul Lenina, d 18, kv 92",
               state = "Haryana",
               city = "Karnal";

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
