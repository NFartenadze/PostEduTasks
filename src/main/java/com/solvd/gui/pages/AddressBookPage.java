package com.solvd.gui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddressBookPage extends AbstractPage {
    @FindBy(xpath = "")
    private WebElement addressTitleField;
    @FindBy(xpath = "")
    private List<WebElement> country;

    @FindBy(xpath = "")
    private WebElement firstName;
    @FindBy(xpath = "")
    private WebElement lastName;
    @FindBy(xpath = "")
    private WebElement streetNumber;
    @FindBy(xpath = "")
    private WebElement companyInfo;
    @FindBy(xpath = "")
    private WebElement city;
    @FindBy(xpath = "")
    private WebElement postalCode;
    @FindBy(xpath = "")
    private WebElement state;
    @FindBy(xpath = "")
    private WebElement phoneNumber;
    @FindBy(xpath = "")
    private WebElement saveButton;

    @FindBy(xpath = "")
    private WebElement backToMyAccountButton;


    public AddressBookPage(WebDriver driver) {
        super(driver);
    }
}
