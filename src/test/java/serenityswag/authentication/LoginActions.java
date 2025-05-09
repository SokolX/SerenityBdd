package serenityswag.authentication;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;

public class LoginActions extends UIInteractionSteps {

    @Step("Log in as {0}")
    public void as(UserEnum user) {
        openUrl("https://www.saucedemo.com/");

        $("[data-test='username'").sendKeys(user.getUsername());
        $("[data-test='password'").sendKeys(user.getPassword());
        $("[data-test='login-button'").click();
    }
}
