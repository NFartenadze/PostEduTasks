package org.gui.pages;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Practise extends BaseClass {

    @Test
    public void SearchBags() {
        HomePage homePage = new HomePage();
        homePage.typeInSearchBar("BAG");
        homePage.clickSearch();
        Assert.assertEquals(homePage.getSearchResult().size(), 24);
        homePage.printResultItemTexts();
    }

    @Test
    public void addItemToCart() {
        HomePage homePage = new HomePage();
        homePage.typeInSearchBar("");
    }


}