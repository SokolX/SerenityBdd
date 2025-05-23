package serenityswag.inventory;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.findby.By;

import java.util.List;

public class ProductListPageObject extends PageObject {

    public List<String> titles() {
        return findAll(By.className("inventory_item_name")).textContents();
    }

    public void openProductDetailsFor(String itemName) {
        find(By.linkText(itemName)).click();
    }

    public String imageTextForProduct(String productName) {
        return $("//div[@class='inventory_item'][contains(.,'" + productName + "')]//img").getAttribute("alt");
    }
}
