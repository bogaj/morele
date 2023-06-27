package tests;

import org.testng.annotations.Test;
import pageObjects.SearchEnginePage;
import pageObjects.TopMenuPage;

public class SearchEngineTests extends TestBase {

    @Test(priority = 5)
    public void searchEngineTests() {
        TopMenuPage topMenuPage = new TopMenuPage();
        String searchText = "Laptop";
        topMenuPage.typeToSearchEngineFieldAndConfirmByEnter(searchText);

        SearchEnginePage searchEnginePage = new SearchEnginePage();
        searchEnginePage.searchResultListCompareToSearch(searchText);

    }
}

