import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegFormTests extends TestBase {

    @Test
     void fillFormTest(){
        // открытие странциы
        open("/automation-practice-form");

        //firstname
        $("[id=firstName]").setValue("Nikita");

        //lastname
        $("[id=lastName]").setValue("Nikita");

        //email
        $("[id=userEmail]").setValue("Nikita@test.test");

        //gender
        $("[id=genterWrapper]").$(byText("Male")).click();

        //mobile
        $("[id=userNumber]").setValue("1234567890");

        //Date of Birth
       $("#dateOfBirthInput").click();
       $(".react-datepicker__month-select").selectOption("January");
       $(".react-datepicker__year-select").selectOption("1991");
       $(".react-datepicker__day--021").click();

        //Subjects
        $("#subjectsInput").setValue("Chemistry").pressEnter();

        //Hobbies
        $("[id=hobbiesWrapper]").$(byText("Sports")).click();

        //Picture
        $("[id=uploadPicture]").uploadFromClasspath("picture.jpg");

        //Current Address
        $("[id=currentAddress]").setValue("123 город Москва");

        //State and City
        $("[id=state]").click();
        $("[id=react-select-3-option-0]").click();
        $("[id=city]").click();
        $("[id=react-select-4-option-0]").click();


        $("[id=submit]").click();

        //ожидаемый результат
        $(".modal-body").shouldHave(
                text("Nikita"),
                text("Nikita"),
                text("Nikita@test.test"),
                text("Male"),
                text("1234567890"),
                text("21 January,1991"),
                text("Chemistry"),
                text("Sports"),
                text("picture.jpg"),
                text("123 город Москва"),
                text("NCR"),
                text("Delhi")
        );

    }
}
