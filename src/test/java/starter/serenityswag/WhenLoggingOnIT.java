package starter.serenityswag;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenLoggingOnIT extends UIInteractionSteps {

    @Test
    public void usersCanLogOnViaTheHomePage() {
        //driver.get("https://www.saucedemo.com/");
        openUrl("https://www.saucedemo.com/");

        //driver.findElement(By.cssSelector("[data-test='username'")).sendKeys("standard_user");
        //driver.findElement(By.cssSelector("[data-test='password'")).sendKeys("secret_sauce");
        //driver.findElement(By.cssSelector("[data-test='login-button'")).click();

        $("[data-test='username'").sendKeys("standard_user");
        $("[data-test='password'").sendKeys("secret_sauce");
        $("[data-test='login-button'").click();

        //assertThat(driver.findElement(By.cssSelector(".title")).getText()).isEqualToIgnoringCase("Products");
        assertThat($(".title").getText()).isEqualToIgnoringCase("Products");
    }
}
