package com.app;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FirstTest {
    ExtentReports extent;
    ExtentTest test1, test2, test3, test4;

    @BeforeSuite
    public void setup() {
        extent = new ExtentReports("htmlReport.html");
    }

    @Test(priority = 0)
    public void cMethod() {
        test1 = extent.startTest("Test 1", "Test1 Description");
        System.out.println("Method C");
        test1.log(LogStatus.PASS, "Successful");
    }

    @Test(priority = 1)
    public void bMethod() {
        test2 = extent.startTest("Test 2", "Test2 Description");
        System.out.println("Method B");
        test2.log(LogStatus.FAIL, "Failed");
    }

    @Test(priority = -2)
    public void rMethod() {
        System.out.println("Method R");
    }

    @Test(priority = -200, enabled = false)
    public void sMethod() { System.out.println("Method S"); }

    @AfterSuite
    public void tearDown() {
        extent.flush();
    }

}
