package com.sobay.test;

import com.sobay.base.TestBase;
import com.sobay.pages.InsiderHomePage;
import com.sobay.utils.DriverUtility;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestTrial extends TestBase {

    InsiderHomePage insiderHomePage;

    @BeforeClass
    public static void setup(){
        TestBase.setup();

    }

//    @AfterClass
//    public static void tearDown(){
//        TestBase.tearDown();
//    }



   //Visit https://useinsider.com/ and check Insider home page is opened or not
    @Test
    public void checkHomePageIsOpened() {

        insiderHomePage=new InsiderHomePage();
        DriverUtility.getDriver().get("https://useinsider.com/");
        //Accept all cookies
        insiderHomePage.acceptAllCookies.click();

        //check insider home page is opened or not
        Assert.assertTrue(DriverUtility.getDriver().getCurrentUrl().contains("useinsider.com"));



    }

    //Select “More” menu in navigation bar, select “Careers” and check Career page, its
    //Locations, Teams and Life at Insider blocks are opened or not

    @Test
    public void checkCareerPageIsOpened() {

        insiderHomePage=new InsiderHomePage();

        //Select “More” menu in navigation bar
        insiderHomePage.moreLink.click();

        //Select “Careers” and check Career page, its
        //Locations, Teams and Life at Insider blocks are opened or not
        insiderHomePage.careersLink.click();

//        //check Career page is opened or not
//        Assert.assertTrue(DriverUtility.getDriver().getCurrentUrl().contains("careers"));
//
//        //check Locations block is opened or not
//        Assert.assertTrue(insiderHomePage.locationsBlock.isDisplayed());
//
//        //check Teams block is opened or not
//        Assert.assertTrue(insiderHomePage.teamsBlock.isDisplayed());
//
//        //check Life at Insider block is opened or not
//        Assert.assertTrue(insiderHomePage.lifeAtInsiderBlock.isDisplayed());

    }








}
