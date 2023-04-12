package com.sobay.pages;

import com.sobay.utils.DriverUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsiderHomePage {
    public InsiderHomePage() {

        PageFactory.initElements(DriverUtility.getDriver(),this);

    }


    @FindBy(xpath = "//span[.='More']")
    public WebElement moreLink;

    @FindBy(xpath = "//a[@id='wt-cli-accept-all-btn']")
    public WebElement acceptAllCookies;
    @FindBy(xpath = "//h5[.='Careers']")
    public WebElement careersLink;

}
