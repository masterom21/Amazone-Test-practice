package com.amazon.pages;

import com.amazon.utility.Utility;
import com.aventstack.extentreports.Status;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import static com.amazon.drivermanager.ManageDriver.driver;

/**
 * By Bhoomi
 **/
public class ProductDescriptionPage extends Utility
{
    private static final Logger log = LogManager.getLogger(ProductDescriptionPage.class.getName());
    public ProductDescriptionPage()
    {
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    //@FindBy(xpath = "//span[@class='a-button-inner']")
    @FindBy(xpath = "//select[@id='quantity']")
    WebElement QuantitySelectLink;

    @CacheLookup
    //@FindBy(xpath = "//span[@class='a-button-inner']//input[@name='submit.add-to-cart']")
    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    WebElement AddToCartButton;

    @CacheLookup
    //@FindBy(xpath = "//span[contains(text(),'Added to Cart')]")
    @FindBy(xpath = "//h4[contains(text(),'Added to Cart')]")
    WebElement AddToCrtTxt;
    @CacheLookup
    //@FindBy(xpath = "//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")
    @FindBy(xpath = "//div[@class='a-section a-spacing-none a-padding-none']//span")
    WebElement addToCartTextMob;

    public void selectQuantityOfProduct(int Qty)
    {
        selectByIndexFromDropDown(QuantitySelectLink, Qty);
        log.info( "Select the quantity" + QuantitySelectLink.toString());
    }

    public void clickOnAddToCart() {

        clickOnElement(AddToCartButton);
        log.info( "Click on add to cart" + AddToCartButton.toString());
    }
    public void verifyAddToCartTextSuccessfully(String msg)
    {
        verifyThatTextIsDisplayed( AddToCrtTxt, msg);
        log.info( "Verifies add to cart text" + AddToCrtTxt.toString());
    }
    public void verifyAddToCartTextForMobile(String verifyTextMsg)
    {
        verifyThatTextIsDisplayed( addToCartTextMob, verifyTextMsg);
        log.info( "Verifies add to cart text" +addToCartTextMob .toString());
    }
}



