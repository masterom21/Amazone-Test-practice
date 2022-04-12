package com.amazon.cucumber.steps;

import com.amazon.pages.FindYourProductPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.ProductDescriptionPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Fi;

/** * By Bhoomi
 **/
public class LaptopSteps {
    @Given("^I am on homepage$")
    public void iAmOnHomepage()
    {
        System.out.println("I am on homepage");
    }
    @When("^I enter \"([^\"]*)\"$")
    public void iEnter(String product)
    {
        new HomePage().searchProduct(product);
    }
    @And("^click on search bar$")
    public void clickOnSearchBar()
    {
        new HomePage().clickOnSearch();
    }
    @And("^click on Lenovo check box$")
    public void clickOnLenovoCheckBox()
    {
        new FindYourProductPage().clickOnLenovo();
    }
    @And("^click on the product \"([^\"]*)\" IPS (\\d+) nits, (\\d+)th Intel i(\\d+)-(\\d+)G(\\d+)\\(up to (\\d+)\\.(\\d+)GHz\\) (\\d+)GB RAM, (\\d+)GB SSD, Backlit Keyboard, Fingerprint Reader, Win (\\d+) Pro\"$")
    public void clickOnTheProductIPSNitsThIntelIGUpToGHzGBRAMGBSSDBacklitKeyboardFingerprintReaderWinPro(String laptopLink) throws InterruptedException {
        new FindYourProductPage().setTheProductLaptop(laptopLink);
    }

    @And("^change the quantity to \"([^\"]*)\"$")
    public void changeTheQuantityTo(int qty)
    {
        new ProductDescriptionPage().selectQuantityOfProduct(qty);
    }

    @And("^click on add to cart button$")
    public void clickOnAddToCartButton()
    {
        new ProductDescriptionPage().clickOnAddToCart();
    }

    @Then("^verify the message displayed \"([^\"]*)\"$")
    public void verifyTheMessageDisplayed(String textMsg)
    {
       new ProductDescriptionPage().verifyAddToCartTextSuccessfully(textMsg);
    }

    @And("^click on Nokia check box$")
    public void clickOnNokiaCheckBox()
    {
           new FindYourProductPage().clickOnMobile();
    }

    @And("^click on the product \"([^\"]*)\"$")
    public void clickOnTheProduct(String mobileDescription) throws InterruptedException
    {
        new FindYourProductPage().setTheProductMobile(mobileDescription);

    }

    @Then("^verify  message displayed \"([^\"]*)\"$")
    public void verifyMessageDisplayed(String verifyTextMsg )
    {
        new ProductDescriptionPage().verifyAddToCartTextForMobile(verifyTextMsg);

    }
}
