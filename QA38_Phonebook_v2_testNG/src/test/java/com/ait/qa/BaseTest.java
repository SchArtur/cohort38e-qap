package com.ait.qa;

import core.AppManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;


public class BaseTest {

    protected static AppManager appManager = new AppManager();

    Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @BeforeMethod
    public void startTest(Method m, Object[] p) {
        logger.info("Start test " + m.getName() + " with data: " + Arrays.asList(p));

    }

    @AfterMethod(alwaysRun = true)
    public void stopTest(ITestResult result) {

        if (result.isSuccess()) {
            logger.info("PASSED: " + result.getMethod().getMethodName());
        } else {
            logger.error("FAILED: " + result.getMethod().getMethodName() + " Screenshot: "
                    + appManager.getHomePageHelper().takeScreenshot());
        }
        logger.info("========================================================");
    }

    @BeforeSuite
    public void setUp() {
        appManager.init();
    }


    @AfterSuite(enabled = true)
    public void tearDown() {
        appManager.stop();
    }

}