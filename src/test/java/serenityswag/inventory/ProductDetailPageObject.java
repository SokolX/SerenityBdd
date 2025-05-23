package serenityswag.inventory;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementState;

public class ProductDetailPageObject extends PageObject {

    public String productName() {
        return $(".inventory_details_name").getText();
    }

    public WebElementState productImageWithAltValueOf(String firstName) {
        return $(".inventory_details_container img[alt='" + firstName + "']");
    }
}
