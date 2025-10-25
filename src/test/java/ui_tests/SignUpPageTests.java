package ui_tests;

import data_transfer_object.User;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignUpPage;

import static utils.UserFactory.*;

public class SignUpPageTests extends ApplicationManager {

    SignUpPage signUpPage;

    @BeforeMethod
    public void goToSignUpPage(){
        new HomePage(getDriver()).clickBtnSignUpHeader();
        signUpPage = new SignUpPage(getDriver());
    }


    /*@Test
    public void registrationPositiveTest(){
        User user = positiveUser();
        signUpPage.typeLoginForm(user);
        signUpPage.agreeToTerms();
    }*/

    @Test
    public void registrationPositiveTest(){
        SignUpPage signUpPage = new SignUpPage(getDriver());
        User user = User.builder()
                .firstName("Ivan")
                .lastName("Ivanov")
                .email("ivan22@gmail.com")
                .password("Password123!")
                .build();
        signUpPage.typeLoginForm(user);
        signUpPage.agreeToTerms();
        signUpPage.clickRegister();
        Assert.assertTrue(signUpPage.isRegisteredDisplayed());
    }


    @Test  //failed
    public void registrationPositiveTest_UpperCaseEmail(){
        SignUpPage signUpPage = new SignUpPage(getDriver());
        User user = User.builder()
                .firstName("Vasiliy")
                .lastName("Vasiliev")
                .email("VASILIY22@gmail.com")
                .password("Password123!")
                .build();
        signUpPage.typeLoginForm(user);
        signUpPage.agreeToTerms();
        signUpPage.clickRegister();
        Assert.assertTrue(signUpPage.isRegisteredDisplayed());
    }


    @Test
    public void registrationPositiveTest_TrimSpacesEmail(){
        SignUpPage signUpPage = new SignUpPage(getDriver());
        User user = User.builder()
                .firstName("Anton")
                .lastName("Antonov")
                .email(" anton22@gmail.com ")
                .password("Password123!")
                .build();
        signUpPage.typeLoginForm(user);
        signUpPage.agreeToTerms();
        signUpPage.clickRegister();
        Assert.assertTrue(signUpPage.isRegisteredDisplayed());
    }


    @Test
    public void registrationPositiveTest_TrimSpacesPassword(){
        SignUpPage signUpPage = new SignUpPage(getDriver());
        User user = User.builder()
                .firstName("Anna")
                .lastName("Annova")
                .email("annushka22@gmail.com")
                .password(" Password123! ")
                .build();
        signUpPage.typeLoginForm(user);
        signUpPage.agreeToTerms();
        signUpPage.clickRegister();
        Assert.assertTrue(signUpPage.isRegisteredDisplayed());
    }


    @Test
    public void registrationPositiveTest_PasswordMinBorder8Chars(){
        SignUpPage signUpPage = new SignUpPage(getDriver());
        User user = User.builder()
                .firstName("Evgeniy")
                .lastName("Evgeniev")
                .email("evgeniy22@gmail.com")
                .password("Passwo1!")
                .build();
        signUpPage.typeLoginForm(user);
        signUpPage.agreeToTerms();
        signUpPage.clickRegister();
        Assert.assertTrue(signUpPage.isRegisteredDisplayed());
    }


    @Test
    public void registrationNegativeTest_ExistingUser(){
        SignUpPage signUpPage = new SignUpPage(getDriver());
        User user = User.builder()
                .firstName("Ivan")
                .lastName("Ivanov")
                .email("ivan22@gmail.com")
                .password("Password123!")
                .build();
        signUpPage.typeLoginForm(user);
        signUpPage.agreeToTerms();
        signUpPage.clickRegister();
        Assert.assertTrue(signUpPage.isUserAlreadyExistsDisplayed());
    }


    @Test
    public void registrationNegativeTest_EmptyName(){
        SignUpPage signUpPage = new SignUpPage(getDriver());
        User user = User.builder()
                .firstName("")
                .lastName("Egorov")
                .email("egor22@gmail.com")
                .password("Password123!")
                .build();
        signUpPage.typeLoginForm(user);
        signUpPage.agreeToTerms();
        signUpPage.clickRegister();
        Assert.assertFalse(signUpPage.isRegisteredDisplayed());
    }


    @Test
    public void registrationNegativeTest_NameSpacesOnly(){
        SignUpPage signUpPage = new SignUpPage(getDriver());
        User user = User.builder()
                .firstName("  ")
                .lastName("Egorov")
                .email("egor22@gmail.com")
                .password("Password123!")
                .build();
        signUpPage.typeLoginForm(user);
        signUpPage.agreeToTerms();
        signUpPage.clickRegister();
        Assert.assertTrue(signUpPage.isRegisteredDisplayed());
    }


    @Test  //failed
    public void registrationNegativeTest_NonEnglishName(){
        SignUpPage signUpPage = new SignUpPage(getDriver());
        User user = User.builder()
                .firstName("Егорый")
                .lastName("Egorov")
                .email("egor22@gmail.com")
                .password("Password123!")
                .build();
        signUpPage.typeLoginForm(user);
        signUpPage.agreeToTerms();
        signUpPage.clickRegister();
        Assert.assertTrue(signUpPage.isRegisteredDisplayed());
    }


    @Test  //failed
    public void registrationNegativeTest_Name54Chars(){
        SignUpPage signUpPage = new SignUpPage(getDriver());
        User user = User.builder()
                .firstName("SergeySergeySergeySergeySergeySergeySergeySergeySergey")
                .lastName("Sergeev")
                .email("sergey22@gmail.com")
                .password("Password123!")
                .build();
        signUpPage.typeLoginForm(user);
        signUpPage.agreeToTerms();
        signUpPage.clickRegister();
        Assert.assertTrue(signUpPage.isRegisteredDisplayed());
    }


    @Test
    public void registrationNegativeTest_EmptyLastName(){
        SignUpPage signUpPage = new SignUpPage(getDriver());
        User user = User.builder()
                .firstName("Igor")
                .lastName("")
                .email("igor22@gmail.com")
                .password("Password123!")
                .build();
        signUpPage.typeLoginForm(user);
        signUpPage.agreeToTerms();
        signUpPage.clickRegister();
        Assert.assertFalse(signUpPage.isRegisteredDisplayed());
    }


    @Test
    public void registrationNegativeTest_LastNameSpacesOnly(){
        SignUpPage signUpPage = new SignUpPage(getDriver());
        User user = User.builder()
                .firstName("Igor")
                .lastName("  ")
                .email("igor22@gmail.com")
                .password("Password123!")
                .build();
        signUpPage.typeLoginForm(user);
        signUpPage.agreeToTerms();
        signUpPage.clickRegister();
        Assert.assertTrue(signUpPage.isRegisteredDisplayed());
    }


    @Test  //failed
    public void registrationNegativeTest_NonEnglishLastName(){
        SignUpPage signUpPage = new SignUpPage(getDriver());
        User user = User.builder()
                .firstName("Igor")
                .lastName("Игорьев")
                .email("igor22@gmail.com")
                .password("Password123!")
                .build();
        signUpPage.typeLoginForm(user);
        signUpPage.agreeToTerms();
        signUpPage.clickRegister();
        Assert.assertTrue(signUpPage.isRegisteredDisplayed());
    }


    @Test  //failed
    public void registrationNegativeTest_LastName54Chars(){
        SignUpPage signUpPage = new SignUpPage(getDriver());
        User user = User.builder()
                .firstName("Gleb")
                .lastName("GlebovGlebovGlebovGlebovGlebovGlebovGlebovGleb")
                .email("gleb22@gmail.com")
                .password("Password123!")
                .build();
        signUpPage.typeLoginForm(user);
        signUpPage.agreeToTerms();
        signUpPage.clickRegister();
        Assert.assertTrue(signUpPage.isRegisteredDisplayed());
    }


    @Test
    public void registrationNegativeTest_EmptyEmail(){
        SignUpPage signUpPage = new SignUpPage(getDriver());
        User user = User.builder()
                .firstName("Alex")
                .lastName("Alexeev")
                .email("")
                .password("Password123!")
                .build();
        signUpPage.typeLoginForm(user);
        signUpPage.agreeToTerms();
        signUpPage.clickRegister();
        Assert.assertTrue(signUpPage.isRegisteredDisplayed());
    }


    @Test
    public void registrationNegativeTest_EmailSpacesOnly(){
        SignUpPage signUpPage = new SignUpPage(getDriver());
        User user = User.builder()
                .firstName("Alex")
                .lastName("Alexeev")
                .email("  ")
                .password("Password123!")
                .build();
        signUpPage.typeLoginForm(user);
        signUpPage.agreeToTerms();
        signUpPage.clickRegister();
        Assert.assertTrue(signUpPage.isRegisteredDisplayed());
    }


    @Test
    public void registrationNegativeTest_EmailNotAt(){
        SignUpPage signUpPage = new SignUpPage(getDriver());
        User user = User.builder()
                .firstName("Alex")
                .lastName("Alexeev")
                .email("alex22gmail.com")
                .password("Password123!")
                .build();
        signUpPage.typeLoginForm(user);
        signUpPage.agreeToTerms();
        signUpPage.clickRegister();
        Assert.assertTrue(signUpPage.isRegisteredDisplayed());
    }


    @Test
    public void registrationNegativeTest_EmailInvalidDomain(){
        SignUpPage signUpPage = new SignUpPage(getDriver());
        User user = User.builder()
                .firstName("Alex")
                .lastName("Alexeev")
                .email("alex22@.com")
                .password("Password123!")
                .build();
        signUpPage.typeLoginForm(user);
        signUpPage.agreeToTerms();
        signUpPage.clickRegister();
        Assert.assertTrue(signUpPage.isRegisteredDisplayed());
    }


    @Test
    public void registrationNegativeTest_EmailMissingLocalPart(){
        SignUpPage signUpPage = new SignUpPage(getDriver());
        User user = User.builder()
                .firstName("Alex")
                .lastName("Alexeev")
                .email("@gmail.com")
                .password("Password123!")
                .build();
        signUpPage.typeLoginForm(user);
        signUpPage.agreeToTerms();
        signUpPage.clickRegister();
        Assert.assertTrue(signUpPage.isRegisteredDisplayed());
    }


    @Test
    public void registrationNegativeTest_EmailMissingDomain(){
        SignUpPage signUpPage = new SignUpPage(getDriver());
        User user = User.builder()
                .firstName("Alex")
                .lastName("Alexeev")
                .email("alex22@gmail")
                .password("Password123!")
                .build();
        signUpPage.typeLoginForm(user);
        signUpPage.agreeToTerms();
        signUpPage.clickRegister();
        Assert.assertTrue(signUpPage.isRegisteredDisplayed());
    }


    @Test
    public void registrationNegativeTest_EmailDoubleAt(){
        SignUpPage signUpPage = new SignUpPage(getDriver());
        User user = User.builder()
                .firstName("Alex")
                .lastName("Alexeev")
                .email("alex22@@gmail.com")
                .password("Password123!")
                .build();
        signUpPage.typeLoginForm(user);
        signUpPage.agreeToTerms();
        signUpPage.clickRegister();
        Assert.assertTrue(signUpPage.isRegisteredDisplayed());
    }


    @Test
    public void registrationNegativeTest_EmptyPassword(){
        SignUpPage signUpPage = new SignUpPage(getDriver());
        User user = User.builder()
                .firstName("Alex")
                .lastName("Alexeev")
                .email("alex22@gmail.com")
                .password("")
                .build();
        signUpPage.typeLoginForm(user);
        signUpPage.agreeToTerms();
        signUpPage.clickRegister();
        Assert.assertTrue(signUpPage.isRegisteredDisplayed());
    }


    @Test
    public void registrationNegativeTest_PasswordSpacesOnly(){
        SignUpPage signUpPage = new SignUpPage(getDriver());
        User user = User.builder()
                .firstName("Alex")
                .lastName("Alexeev")
                .email("alex22@gmail.com")
                .password("  ")
                .build();
        signUpPage.typeLoginForm(user);
        signUpPage.agreeToTerms();
        signUpPage.clickRegister();
        Assert.assertTrue(signUpPage.isRegisteredDisplayed());
    }


    @Test  //failed
    public void registrationNegativeTest_PasswordTooLong60Chars(){
        SignUpPage signUpPage = new SignUpPage(getDriver());
        User user = User.builder()
                .firstName("Alex")
                .lastName("Alexeev")
                .email("alex22@gmail.com")
                .password("Password1!SuperLongSecurePasswordWithExtraSymbols123!@#Test")
                .build();
        signUpPage.typeLoginForm(user);
        signUpPage.agreeToTerms();
        signUpPage.clickRegister();
        Assert.assertTrue(signUpPage.isRegisteredDisplayed());
    }


    @Test
    public void registrationNegativeTest_PasswordLessBorderMin(){
        SignUpPage signUpPage = new SignUpPage(getDriver());
        User user = User.builder()
                .firstName("Misha")
                .lastName("Miheev")
                .email("misha22@gmail.com")
                .password("Ab1$xyz")
                .build();
        signUpPage.typeLoginForm(user);
        signUpPage.agreeToTerms();
        signUpPage.clickRegister();
        Assert.assertTrue(signUpPage.isRegisteredDisplayed());
    }


    @Test
    public void registrationNegativeTest_PasswordLowerCaseOnly(){
        SignUpPage signUpPage = new SignUpPage(getDriver());
        User user = User.builder()
                .firstName("Misha")
                .lastName("Miheev")
                .email("misha22@gmail.com")
                .password("password!1")
                .build();
        signUpPage.typeLoginForm(user);
        signUpPage.agreeToTerms();
        signUpPage.clickRegister();
        Assert.assertTrue(signUpPage.isRegisteredDisplayed());
    }


    @Test
    public void registrationNegativeTest_PasswordUpperCaseOnly(){
        SignUpPage signUpPage = new SignUpPage(getDriver());
        User user = User.builder()
                .firstName("Misha")
                .lastName("Miheev")
                .email("misha22@gmail.com")
                .password("PASSWORD!1")
                .build();
        signUpPage.typeLoginForm(user);
        signUpPage.agreeToTerms();
        signUpPage.clickRegister();
        Assert.assertTrue(signUpPage.isRegisteredDisplayed());
    }


    @Test
    public void registrationNegativeTest_PasswordNoNumbers(){
        SignUpPage signUpPage = new SignUpPage(getDriver());
        User user = User.builder()
                .firstName("Misha")
                .lastName("Miheev")
                .email("misha22@gmail.com")
                .password("Password!!")
                .build();
        signUpPage.typeLoginForm(user);
        signUpPage.agreeToTerms();
        signUpPage.clickRegister();
        Assert.assertTrue(signUpPage.isRegisteredDisplayed());
    }


    @Test
    public void registrationNegativeTest_PasswordNoSpecialSymbols(){
        SignUpPage signUpPage = new SignUpPage(getDriver());
        User user = User.builder()
                .firstName("Misha")
                .lastName("Miheev")
                .email("misha22@gmail.com")
                .password("Password11")
                .build();
        signUpPage.typeLoginForm(user);
        signUpPage.agreeToTerms();
        signUpPage.clickRegister();
        Assert.assertTrue(signUpPage.isRegisteredDisplayed());
    }


    @Test
    public void registrationNegativeTest_PasswordNoLetters(){
        SignUpPage signUpPage = new SignUpPage(getDriver());
        User user = User.builder()
                .firstName("Misha")
                .lastName("Miheev")
                .email("misha22@gmail.com")
                .password("2@$#*20911")
                .build();
        signUpPage.typeLoginForm(user);
        signUpPage.agreeToTerms();
        signUpPage.clickRegister();
        Assert.assertTrue(signUpPage.isRegisteredDisplayed());
    }


    @Test
    public void registrationNegativeTest_PasswordNonEngLetters(){
        SignUpPage signUpPage = new SignUpPage(getDriver());
        User user = User.builder()
                .firstName("Misha")
                .lastName("Miheev")
                .email("misha22@gmail.com")
                .password("Аб1#ДеЁж")
                .build();
        signUpPage.typeLoginForm(user);
        signUpPage.agreeToTerms();
        signUpPage.clickRegister();
        Assert.assertTrue(signUpPage.isRegisteredDisplayed());
    }


    @Test
    public void registrationNegativeTest_PasswordInvalidSpecialSymbols(){
        SignUpPage signUpPage = new SignUpPage(getDriver());
        User user = User.builder()
                .firstName("Misha")
                .lastName("Miheev")
                .email("misha22@gmail.com")
                .password("Password1]")
                .build();
        signUpPage.typeLoginForm(user);
        signUpPage.agreeToTerms();
        signUpPage.clickRegister();
        Assert.assertTrue(signUpPage.isRegisteredDisplayed());
    }
}
