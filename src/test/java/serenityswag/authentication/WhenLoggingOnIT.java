package serenityswag.authentication;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import serenityswag.inventory.InventoryPage;

import static org.assertj.core.api.Assertions.assertThat;
import static serenityswag.authentication.UserEnum.STANDARD_USER;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenLoggingOnIT {

    @Steps
    LoginActions login;

    InventoryPage inventoryPage;

    @Test
    public void usersCanLogOnViaTheHomePage() {
        login.as(STANDARD_USER);

        Serenity.reportThat("The inventory page should be displayed with the correct title",
                () -> assertThat(inventoryPage.getHeading()).isEqualToIgnoringCase("Products"));
    }
}
