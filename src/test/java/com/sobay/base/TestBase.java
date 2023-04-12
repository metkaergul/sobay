package com.sobay.base;

import com.sobay.utils.DriverUtility;

public class TestBase {

     public static void setup(){

        DriverUtility.getDriver();

     }

        public static void tearDown(){
            DriverUtility.closeDriver();

        }

}
