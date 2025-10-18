package ui_tests;

import manager.ApplicationManager;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTests extends ApplicationManager {

    @Test
    public void loginPositiveTest(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("kiririri22@gmail.com", "Abc22@$hgf");
    }


    @Test  //failed
    public void loginPositiveTest_UpperCaseEmail(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("KIRIRIRI22@gmail.com", "Abc22@$hgf");
    }


    @Test
    public void loginPositiveTest_TrimSpacesEmail(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(" kiririri22@gmail.com ", "Abc22@$hgf");
    }


    @Test  //failed
    public void loginPositiveTest_TrimSpacesPassword(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("kiririri22@gmail.com", " Abc22@$hgf ");
    }


    @Test
    public void loginNegativeTest_EmptyEmail(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("", "Abc22@$hgf");
    }


    @Test
    public void loginNegativeTest_SpacesInEmail(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("  ", "Abc22@$hgf");
    }


    @Test
    public void loginNegativeTest_EmailNoAt(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("kiririri22gmail.com", "Abc22@$hgf");
    }


    @Test
    public void loginNegativeTest_EmailInvalidDomain(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("kiririri22@.com", "Abc22@$hgf");
    }


    @Test
    public void loginNegativeTest_EmailMissingLocalPart(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("@gmail.com", "Abc22@$hgf");
    }


    @Test
    public void loginNegativeTest_EmailMissingDomain(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("kiririri22@gmail", "Abc22@$hgf");
    }


    @Test
    public void loginNegativeTest_EmailDoubleAt(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("kiririri22@@gmail.com", "Abc22@$hgf");
    }


    @Test
    public void loginNegativeTest_SpacesInPassword(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("kiririri22@gmail.com", "  ");
    }


    @Test
    public void loginNegativeTest_EmptyPassword(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("kiririri22@gmail.com", "");
    }


    @Test
    public void loginNegativeTest_LowerCasePassword(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("kiririri22@gmail.com", "abc22@$hgf");
    }


    @Test
    public void loginNegativeTest_UpperCasePassword(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("kiririri22@gmail.com", "ABC22@$HGF");
    }


    @Test
    public void loginNegativeTest_WrongPassword(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLoginHeader();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm("kiririri22@gmail.com", "jkl11$@mnb");
    }
}
