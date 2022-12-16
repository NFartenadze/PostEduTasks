package org.gui.pages;

import com.solvd.gui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Practise extends BaseClass {

//    @Test
//    public void SearchBags() {
//        HomePage homePage = new HomePage();
//        homePage.typeInSearchBar("BAG");
//        homePage.clickSearch();
//        Assert.assertEquals(homePage.getSearchResult().size(), 24);
//        homePage.printResultItemTexts();
//    }
//
//    @Test
//    public void addItemToCart() {
//        HomePage homePage = new HomePage();
//        homePage.typeInSearchBar("");
//    }

    @Test
    public void searchBag() {
        HomePage homePage = new HomePage(driver);
        homePage.typeInSearchBar("Bag");
        homePage.clickSearch();
        Assert.assertEquals(homePage.getSearchResult().size(), 24);
    }


}