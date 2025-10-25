package ui_tests;

import data_transfer_object.User;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTests extends ApplicationManager {

   /* @Test
    public void loginPositiveTestLomBok(){
        User user = User.builder()
                .email("kiririri22@gmail.com")
                .password("Abc22@$hgf")
                .build();
        new HomePage(getDriver()).clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginFormWithUser(user);
        Assert.assertTrue(loginPage.isLoggedDisplayed());
    } */


    /*@Test
    public void loginNegativeTestLomBokWrongPassword(){
        User user = User.builder()
                .email("kiririri22@gmail.com")
                .password("abc2266hgf")
                .build();
        new HomePage(getDriver()).clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginFormWithUser(user);
        Assert.assertTrue(loginPage.isLoggedIncorrect());
    } */


    @Test
    public void loginPositiveTest(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("kiririri22@gmail.com", "Abc22@$hgf");
        Assert.assertTrue(loginPage.isLoggedDisplayed());
    }


    @Test  //failed
    public void loginPositiveTest_UpperCaseEmail(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("KIRIRIRI22@gmail.com", "Abc22@$hgf");
        Assert.assertTrue(loginPage.isLoggedDisplayed());
    }


    @Test
    public void loginPositiveTest_TrimSpacesEmail(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(" kiririri22@gmail.com ", "Abc22@$hgf");
        Assert.assertTrue(loginPage.isLoggedDisplayed());
    }


    @Test  //failed
    public void loginPositiveTest_TrimSpacesPassword(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("kiririri22@gmail.com", " Abc22@$hgf ");
        Assert.assertTrue(loginPage.isLoggedIncorrect());
    }


    @Test
    public void loginNegativeTest_EmptyEmail(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("", "Abc22@$hgf");
        Assert.assertTrue(loginPage.isLoggedIncorrect());
    }


    @Test
    public void loginNegativeTest_SpacesInEmail(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("  ", "Abc22@$hgf");
        Assert.assertTrue(loginPage.isLoggedIncorrect());
    }


    @Test
    public void loginNegativeTest_EmailNoAt(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("kiririri22gmail.com", "Abc22@$hgf");
        Assert.assertTrue(loginPage.isLoggedIncorrect());
    }


    @Test
    public void loginNegativeTest_EmailInvalidDomain(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("kiririri22@.com", "Abc22@$hgf");
        Assert.assertTrue(loginPage.isLoggedIncorrect());
    }


    @Test
    public void loginNegativeTest_EmailMissingLocalPart(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("@gmail.com", "Abc22@$hgf");
        Assert.assertTrue(loginPage.isLoggedIncorrect());
    }


    @Test
    public void loginNegativeTest_EmailMissingDomain(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("kiririri22@gmail", "Abc22@$hgf");
        Assert.assertTrue(loginPage.isLoggedIncorrect());
    }


    @Test
    public void loginNegativeTest_EmailDoubleAt(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("kiririri22@@gmail.com", "Abc22@$hgf");
        Assert.assertTrue(loginPage.isLoggedIncorrect());
    }


    @Test
    public void loginNegativeTest_SpacesInPassword(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("kiririri22@gmail.com", "  ");
        Assert.assertTrue(loginPage.isLoggedIncorrect());
    }


    @Test
    public void loginNegativeTest_EmptyPassword(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("kiririri22@gmail.com", "");
        Assert.assertTrue(loginPage.isLoggedIncorrect());
    }


    @Test
    public void loginNegativeTest_LowerCasePassword(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("kiririri22@gmail.com", "abc22@$hgf");
        Assert.assertTrue(loginPage.isLoggedIncorrect());
    }


    @Test
    public void loginNegativeTest_UpperCasePassword(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("kiririri22@gmail.com", "ABC22@$HGF");
        Assert.assertTrue(loginPage.isLoggedIncorrect());
    }


    @Test
    public void loginNegativeTest_WrongPassword(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("kiririri22@gmail.com", "jkl11$@mnb");
        Assert.assertTrue(loginPage.isLoggedIncorrect());
    }
}
