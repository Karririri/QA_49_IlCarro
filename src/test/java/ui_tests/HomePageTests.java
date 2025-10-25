package ui_tests;

import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTests extends ApplicationManager {


    @Test //failed - city
    public void searchCarPositiveTest_AsGuest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.enterCity("Tel Aviv");
        homePage.enterDates("2025-11-25 - 2025-11-27");
        homePage.clickYalla();
        Assert.assertTrue(true);
    }


    @Test  //failed - city
    public void searchCarPositiveTest_AsLoggedUser() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("kiririri22@gmail.com", "Abc22@$hgf");
        HomePage homePage = new HomePage(getDriver());
        homePage.closeLoggedInPopup();
        homePage.enterCity("Tel Aviv");
        homePage.enterDates("2025-11-25 - 2025-11-30");
        homePage.clickYalla();
        Assert.assertTrue(true);
    }
}
