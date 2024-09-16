package shop.testing;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.id;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://www.automationexercise.com";
    }
    @Test
    void registerUserTest(){
        open("/");
        $("#header").isDisplayed();
//4. Click on 'Signup / Login' button
        $("a[href='/login']").click();
//5. Verify 'New User Signup!' is visible
        $(".signup-form h2").shouldHave(text("New User Signup!"));
//6. Enter name and email address
        $("input[data-qa='signup-name']").setValue("Astana545678");
        $("input[data-qa='signup-email']").setValue("astana122342@gmail.com");
//7. Click 'Signup' button
        $("button[data-qa='signup-button']").click();
//8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        $("h2.title.text-center").shouldHave(text("Enter Account Information"));

//9. Fill details: Title, Name, Email, Password, Date of birth
        $("#id_gender1").click();
        $("input[data-qa='password']").setValue("Anichebe1202");
        $("select[data-qa='days']").selectOption("10");
        $("select[data-qa='months']").selectOption("March");
        $("select[data-qa='years']").selectOption("1994");
//10. Select checkbox 'Sign up for our newsletter!'
        $$("input[type='checkbox']").find(id("newsletter")).click();
        sleep(5000);
//11. Select checkbox 'Receive special offers from our partners!'
        $$("input[type='checkbox']").find(id("optin")).click();
//12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        $("input[data-qa='first_name']").setValue("Zharon");
        $("input[data-qa='last_name']").setValue("Bekov");
        $("input[data-qa='company']").setValue("Luxsoft");
        $("input[data-qa='address']").setValue("Birmingam str 123, Luxsoft, 12545");
        $("input[data-qa='address2']").setValue("London, Hamilton ave 12, Luxsoft, 67766 ");
        $("select[data-qa='country']").selectOption("Singapore");
        $("input[data-qa='state']").setValue("Singapore");
        $("input[data-qa='city']").setValue("Singapore");
        $("input[data-qa='zipcode']").setValue("777777");
        $("input[data-qa='mobile_number']").setValue("123456789");
        sleep(5000);
//13. Click 'Create Account button'
        $("button[data-qa='create-account']").click();

//14. Verify that 'ACCOUNT CREATED!' is visible
        $("h2[data-qa='account-created']").shouldHave(text("Account Created!"));
//15. Click 'Continue' button
        $("a[data-qa='continue-button']").click();
//16. Verify that 'Logged in as username' is visible
//17. Click 'Delete Account' button
//18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
    }

    @Test
    void FilterByBigVilles(){
        open("/");
        $(".HeaderMenu-nav").$(byText("Solutions")).hover();
//        $(".HeaderMenu-wrapper").$(byText("Solutions")).hover();
        $(By.linkText("Enterprise")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));
    }
}
