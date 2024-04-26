package com.ait.qa.phonebookTests;

import com.ait.qa.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class HomePageTests extends BaseTest {

    @BeforeMethod
    void precondition() {
        if (appManager.getUserHelper().isSignOutPresent()) {
            appManager.getUserHelper().clickOnSignOutButton();
        }
    }

    @Test(description = "Переход на Home", groups = {"Positive"})
    void test1() {
        appManager.getHomePageHelper().clickOnHomeLink();
        appManager.getHomePageHelper().checkHomeComponentIsPresent();
    }
}
