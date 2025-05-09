package serenityswag.authentication;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;

public class LoginActions extends UIInteractionSteps {

    @Step("Log in as {0}")
    public void as(UserEnum user) {
        openUrl("https://www.saucedemo.com/");

        $("[data-test='username'").sendKeys(user.getUsername());
        //find(By.id("[data-test='username'")).sendKeys(user.getUsername()); //by id
        //find("#user-name").sendKeys(user.getUsername()); //by id
        //find(By.name("user-name")).sendKeys(user.getUsername()); //by name
        //find("[name=user-name]").sendKeys(user.getUsername()); //by name
        $("[data-test='password'").sendKeys(user.getPassword());
        $("[data-test='login-button'").click();
    }
}
