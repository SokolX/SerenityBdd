package starter.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.Keys;
import starter.pageobjects.SearchForm;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class SearchSteps extends UIInteractionSteps {

    @Step("User searches for '{0}'")
    public void searchForTerm(String searchTerm) {
        find(SearchForm.SEARCH_FIELD).sendKeys(searchTerm);
        find(SearchForm.SEARCH_BUTTON).click();
        withTimeoutOf(Duration.ofSeconds(10))
                .waitFor(presenceOfElementLocated(SearchForm.ARTICLE_HEADINGS));
    }

    @Step("Check the search results")
    public List<String> getSearchResults() {
        return findAll(SearchForm.ARTICLE_HEADINGS).texts();
    }

    @Step("User type 'cucumber'")
    public void byKeyword(String keyword) {
        $("#searchbox_input").sendKeys(keyword, Keys.ENTER);
    }
}
