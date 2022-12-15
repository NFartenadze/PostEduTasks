package org.gui.pages;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {

    @Test()
    public void SearchBags() {
        homePage.searchBarType("BAG");
        homePage.clickSearch();
        Assert.assertEquals(homePage.getSearchResult().size(), 24);
//            homePage.getSearchResult();
        homePage.printResultItemTexts();
    }


}