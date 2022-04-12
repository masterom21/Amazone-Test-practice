package com.amazon.pages;

import com.amazon.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.amazon.drivermanager.ManageDriver.driver;

/**
 * By Bhoomi
 **/
public class FindYourProductPage extends Utility
{
    private static final Logger log = LogManager.getLogger(FindYourProductPage.class.getName());
    //Locators brand lenovo checkbox,xpath for all the laptops
    public FindYourProductPage()
    {
        PageFactory.initElements(driver,this);
    }
    @CacheLookup
    //@FindBy(className="a-size-base a-color-base a-text-bold")
    //@FindBy(xpath="//li[@id='p_89/Lenovo']//i[@class='a-icon a-icon-checkbox']")
    //@FindBy(xpath="//div[@id='brandsRefinements']//li[@id='p_89/Lenovo']")
    //@FindBy(xpath="//div[@id='brandsRefinements']/child::ul//li[@id='p_89/Lenovo']")
    //@FindBy(xpath="//span[@class='a-size-base a-color-base a-text-bold']")
    @FindBy(id="p_89/Lenovo")
    WebElement lenovoChkBox;
    //@FindBy(xpath = "//a[@class='s-pagination-item s-pagination-next s-pagination-button s-pagination-separator']")
    //@FindBy(xpath = "//span[@class='s-pagination-strip']//a[@class='s-pagination-item s-pagination-next s-pagination-button s-pagination-separator']")
    //@FindBy(xpath = "//a[@class='s-pagination-item s-pagination-next s-pagination-button s-pagination-separator']")
    //@FindBy(xpath = "//span[@class='s-pagination-strip']//a[6]")
    @CacheLookup
    //@FindBy(xpath = "//li[@id='p_89/Nokia']//i[@class='a-icon a-icon-checkbox']")
    //@FindBy(xpath = "//ul[@class='a-unordered-list a-nostyle a-vertical a-spacing-medium']")
    //@FindBy(xpath = "//ul[@class='a-unordered-list a-nostyle a-vertical a-spacing-medium']//li[@id='p_89/Nokia']")
    @FindBy(id = "p_89/Nokia")
    WebElement nokiaChkBox;
    @CacheLookup
    //@FindBy(linkText = "Next")
    @FindBy(xpath = "//span[@class='s-pagination-strip']//a[4]")
    WebElement nextButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='a-section a-spacing-none s-padding-right-small s-title-instructions-style']//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']//span")
    List<WebElement> laptopList;
    @CacheLookup
    @FindBy(xpath = "//div[@class='a-section a-spacing-none s-padding-right-small s-title-instructions-style']//a")
    List<WebElement> mobileList;
    public void clickOnLenovo()
    {
        javaExecutorScriptExecuteScriptToScrollThePageTillElementFound(lenovoChkBox);
        clickOnElement(lenovoChkBox);
        log.info( "Click on the checkbox"+ lenovoChkBox.toString());
    }
    public void clickOnMobile()
    {
        javaExecutorScriptExecuteScriptToScrollThePageTillElementFound(nokiaChkBox);
        clickOnElement(nokiaChkBox);
        log.info( "Click on the check box" + nokiaChkBox.toString());
    }

    /*public String setLenovoLaptop(String lenovo)
    {
        String lenovoTemp="";
        do {
            for (WebElement singleLaptop : laptopList)
            {
                if (singleLaptop.getText().equalsIgnoreCase(lenovo))
                {
                    System.out.println(singleLaptop.getText());
                    lenovoTemp=singleLaptop+lenovoTemp;
                    break;
                }
            }
            nextButton.click();
            PageFactory.initElements(driver, this);
            return lenovoTemp;
        }while(lenovoTemp!=null) ;

    }*/
    /*public String setLenovoLaptop(String lenovo) throws InterruptedException {
        String lenovoTemp="";
        do
        {
            //lenovoTemp=null;
            for (WebElement singleLaptop : laptopList)
            {
                if (singleLaptop.getText().contains(lenovo))
                {
                    lenovoTemp=singleLaptop.getText();
                    break;
                }
                //Thread.sleep(2000);
            }
            System.out.println(lenovoTemp);
            javaExecutorScriptExecuteScriptToPerformScroll();
            //Thread.sleep(2000);
            //javaExecutorScriptExecuteScriptToScrollThePageTillElementFound(nextButton);
            //nextButton.click();
            javaExecutorScriptExecuteScriptToClick(nextButton);
            Thread.sleep(2000);
            //jvJavaScriptExecutorExecuteASyncScriptPerformingSleep();
            PageFactory.initElements(driver, this);
            Thread.sleep(2000);

            //jvJavaScriptExecutorExecuteASyncScriptPerformingSleep();
            return lenovoTemp;
        }while(lenovoTemp==null) ;
    }*/

    public boolean setTheProductLaptop(String lenovo) throws InterruptedException {
        boolean myBreak=true;
        boolean isDisplayed=false;
        while (myBreak)
        {
            for (WebElement singleLaptop : laptopList)
            {
                if (singleLaptop.getText().equalsIgnoreCase(lenovo))
                {
                    System.out.println(singleLaptop.getText());
                    Thread.sleep(2000);
                    clickOnElement(singleLaptop);
                    Thread.sleep(2000);
                    isDisplayed = true;
                    myBreak = false;
                    break;
                }
            }
            if (myBreak)
            {
                if (!driver.getCurrentUrl().contains("page12"))
                {
                    jvJavaScriptExecutorExecuteASyncScriptPerformingSleep();
                    clickOnElement(nextButton);
                            isDisplayed = true;
                            myBreak = false;
                            break;
                } else
                {
                    isDisplayed = false;
                    myBreak = false;
                }
                PageFactory.initElements(driver, this);
                Thread.sleep(2000);
            }
            log.info("Click on the laptop"+ laptopList.toString());

        }
        //driver.navigate().to("https://www.amazon.com/");
        return isDisplayed;
    }
    public boolean setTheProductMobile(String mobile) throws InterruptedException {
        boolean myBreak=true;
        boolean isDisplayed=false;
        while (myBreak)
        {
            for (WebElement singleMobile : mobileList)
            {
                if (singleMobile.getText().equalsIgnoreCase(mobile))
                {
                    System.out.println(singleMobile.getText());
                    clickOnElement(singleMobile);
                    isDisplayed = true;
                    myBreak = false;
                    break;
                }
            }
            if (myBreak)
            {
                if (!driver.getCurrentUrl().contains("page10"))
                {
                    jvJavaScriptExecutorExecuteASyncScriptPerformingSleep();
                    clickOnElement(nextButton);
                    isDisplayed = true;
                    myBreak = false;
                    break;
                } else
                {
                    isDisplayed = false;
                    myBreak = false;
                }
                PageFactory.initElements(driver, this);
                Thread.sleep(2000);
            }
            log.info("Click on the mobile" +mobileList .toString());
        }
        return isDisplayed;
    }
}
