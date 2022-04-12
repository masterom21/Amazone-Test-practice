package com.amazon.pages;

import com.amazon.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.amazon.drivermanager.ManageDriver.driver;

/**
 * By Bhoomi
 **/
public class HomePage extends Utility
{
    //Locators search bar send keys laptop, click search btn
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage()
    {
        PageFactory.initElements(driver,this);
    }
    @CacheLookup
    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    WebElement SearchbarLink;

    @CacheLookup
    @FindBy(id = "nav-search-submit-button")
    WebElement searchLink;

    public void searchProduct(String product)
    {
        sendTextToElement(SearchbarLink, product);
        log.info( "Search in the search bar" + SearchbarLink.toString());
    }

    public void clickOnSearch()
    {
        clickOnElement(searchLink);
        log.info( "Click on the search button" + searchLink.toString());
    }
}


