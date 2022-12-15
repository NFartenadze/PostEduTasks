package org.gui.pages;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {

    @Test()
    public void SearchBags() {
        HomePage homePage = new HomePage();
        homePage.searchBarType("BAG");
        homePage.clickSearch();
        Assert.assertEquals(homePage.getSearchResult().size(), 24);
        homePage.printResultItemTexts();
    }


}