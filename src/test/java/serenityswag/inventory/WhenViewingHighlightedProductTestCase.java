package serenityswag.inventory;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import serenityswag.authentication.LoginActions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static serenityswag.authentication.UserEnum.STANDARD_USER;

public class WhenViewingHighlightedProductTestCase extends UIInteractionSteps {

    @Steps
    LoginActions login;

    ProductListPageObject productList;

    ProductDetailPageObject productDetail;

    @Test
    public void shouldDisplayHighlightedProductsOnTheWelcomePage() {
        login.as(STANDARD_USER);

        List<String> productsOnDisplay = productList.titles();

        Serenity.reportThat("The inventory page should has 6 products and contains Sauce Labs Backpack",
                () -> assertThat(productsOnDisplay)
                        .hasSize(6)
                        .contains("Sauce Labs Backpack")
        );
    }

    @Test
    public void shouldDisplayCorrectProductDetailsPage() {
        login.as(STANDARD_USER);
        String firstItemName = productList.titles().get(0);

        productList.openProductDetailsFor(firstItemName);

        Serenity.reportThat("The detail product page displayed correct item name and name visible in Alt value",
                () -> {
                    assertThat(productDetail.productName()).isEqualTo(firstItemName);
                    assertThat(productDetail.productImageWithAltValueOf(firstItemName).shouldBeVisible());
                }
        );
    }

    @Test
    public void higlightedProductsShouldDisplayTheCorrespondingImages() {
        login.as(STANDARD_USER);

        List<String> productOnDisplay = productList.titles();

        SoftAssertions softly = new SoftAssertions();
        productOnDisplay.forEach(
                productName -> softly.assertThat(productList.imageTextForProduct(productName)).isEqualTo(productName)
        );
        softly.assertAll();
    }
}
