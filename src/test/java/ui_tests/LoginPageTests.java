package ui_tests;

import dto.User;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.RetryAnalyzer;
import utils.TestNGListener;
import utils.enums.HeaderMenuItem;

import java.lang.reflect.Method;

@Listeners(TestNGListener.class)
public class LoginPageTests extends ApplicationManager {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void loginPositiveTest(Method method) {
        User user = User.builder()
                .username("kiririri22@gmail.com")
                .password("Abc22@$hgf")
                .build();
        logger.info("start test " + method.getName() + " with data " + user);
        new HomePage(getDriver()).clickBtnLoginHeader(HeaderMenuItem.LOGIN);
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        logger.error("example error");
        Assert.assertTrue(loginPage.isLoggedDisplayed());
    }


    @Test  // failed
    public void loginPositiveTest_UpperCaseEmail() {
        User user = User.builder()
                .username("KIRIRIRI22@gmail.com")
                .password("Abc22@$hgf")
                .build();
        new HomePage(getDriver()).clickBtnLoginHeader(HeaderMenuItem.LOGIN);
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        Assert.assertTrue(loginPage.isLoggedDisplayed());
    }


    @Test
    public void loginPositiveTest_TrimSpacesEmail() {
        User user = User.builder()
                .username(" kiririri22@gmail.com ")
                .password("Abc22@$hgf")
                .build();

        new HomePage(getDriver()).clickBtnLoginHeader(HeaderMenuItem.LOGIN);
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        Assert.assertTrue(loginPage.isLoggedDisplayed());
    }


    @Test  // failed
    public void loginPositiveTest_TrimSpacesPassword() {
        User user = User.builder()
                .username("kiririri22@gmail.com")
                .password(" Abc22@$hgf ")
                .build();

        new HomePage(getDriver()).clickBtnLoginHeader(HeaderMenuItem.LOGIN);
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        Assert.assertTrue(loginPage.isLoggedIncorrect());
    }


    @Test
    public void loginNegativeTest_EmptyEmail() {
        User user = User.builder()
                .username("")
                .password("Abc22@$hgf")
                .build();

        new HomePage(getDriver()).clickBtnLoginHeader(HeaderMenuItem.LOGIN);
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        Assert.assertTrue(loginPage.isLoggedIncorrect());
    }


    @Test
    public void loginNegativeTest_SpacesInEmail() {
        User user = User.builder()
                .username("  ")
                .password("Abc22@$hgf")
                .build();

        new HomePage(getDriver()).clickBtnLoginHeader(HeaderMenuItem.LOGIN);
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        Assert.assertTrue(loginPage.isLoggedIncorrect());
    }


    @Test
    public void loginNegativeTest_EmailNoAt() {
        User user = User.builder()
                .username("kiririri22gmail.com")
                .password("Abc22@$hgf")
                .build();

        new HomePage(getDriver()).clickBtnLoginHeader(HeaderMenuItem.LOGIN);
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        Assert.assertTrue(loginPage.isLoggedIncorrect());
    }


    @Test
    public void loginNegativeTest_EmailInvalidDomain() {
        User user = User.builder()
                .username("kiririri22@.com")
                .password("Abc22@$hgf")
                .build();

        new HomePage(getDriver()).clickBtnLoginHeader(HeaderMenuItem.LOGIN);
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        Assert.assertTrue(loginPage.isLoggedIncorrect());
    }


    @Test
    public void loginNegativeTest_EmailMissingLocalPart() {
        User user = User.builder()
                .username("@gmail.com")
                .password("Abc22@$hgf")
                .build();

        new HomePage(getDriver()).clickBtnLoginHeader(HeaderMenuItem.LOGIN);
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        Assert.assertTrue(loginPage.isLoggedIncorrect());
    }


    @Test
    public void loginNegativeTest_EmailMissingDomain() {
        User user = User.builder()
                .username("kiririri22@gmail")
                .password("Abc22@$hgf")
                .build();

        new HomePage(getDriver()).clickBtnLoginHeader(HeaderMenuItem.LOGIN);
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        Assert.assertTrue(loginPage.isLoggedIncorrect());
    }


    @Test
    public void loginNegativeTest_EmailDoubleAt() {
        User user = User.builder()
                .username("kiririri22@@gmail.com")
                .password("Abc22@$hgf")
                .build();

        new HomePage(getDriver()).clickBtnLoginHeader(HeaderMenuItem.LOGIN);
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        Assert.assertTrue(loginPage.isLoggedIncorrect());
    }


    @Test
    public void loginNegativeTest_SpacesInPassword() {
        User user = User.builder()
                .username("kiririri22@gmail.com")
                .password("  ")
                .build();

        new HomePage(getDriver()).clickBtnLoginHeader(HeaderMenuItem.LOGIN);
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        Assert.assertTrue(loginPage.isLoggedIncorrect());
    }


    @Test
    public void loginNegativeTest_EmptyPassword() {
        User user = User.builder()
                .username("kiririri22@gmail.com")
                .password("")
                .build();

        new HomePage(getDriver()).clickBtnLoginHeader(HeaderMenuItem.LOGIN);
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        Assert.assertTrue(loginPage.isLoggedIncorrect());
    }


    @Test
    public void loginNegativeTest_LowerCasePassword() {
        User user = User.builder()
                .username("kiririri22@gmail.com")
                .password("abc22@$hgf")
                .build();

        new HomePage(getDriver()).clickBtnLoginHeader(HeaderMenuItem.LOGIN);
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        Assert.assertTrue(loginPage.isLoggedIncorrect());
    }


    @Test
    public void loginNegativeTest_UpperCasePassword() {
        User user = User.builder()
                .username("kiririri22@gmail.com")
                .password("ABC22@$HGF")
                .build();

        new HomePage(getDriver()).clickBtnLoginHeader(HeaderMenuItem.LOGIN);
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        Assert.assertTrue(loginPage.isLoggedIncorrect());
    }


    @Test
    public void loginNegativeTest_WrongPassword() {
        User user = User.builder()
                .username("kiririri22@gmail.com")
                .password("jkl11$@mnb")
                .build();

        new HomePage(getDriver()).clickBtnLoginHeader(HeaderMenuItem.LOGIN);
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginForm(user);
        Assert.assertTrue(loginPage.isLoggedIncorrect());
    }
}