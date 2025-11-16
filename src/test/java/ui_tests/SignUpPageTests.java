package ui_tests;

import dto.User;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignUpPage;
import utils.TestNGListener;

import static utils.UserFactory.*;

@Listeners(TestNGListener.class)
public class SignUpPageTests extends ApplicationManager {

    SignUpPage signUpPage;

    @BeforeMethod
    public void goToSignUpPage(){
        new HomePage(getDriver()).clickBtnSignUpHeader();
        signUpPage = new SignUpPage(getDriver());
    }


    @Test
    public void registrationPositiveTest(){
        User user = positiveUser();
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextDialogContainerPresent());
    }


    @Test
    public void registrationPositiveTest_UpperCaseFirstName(){
        User user = positiveUser();
        user.setFirstName(user.getFirstName().toUpperCase());
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextDialogContainerPresent());
    }


    @Test
    public void registrationPositiveTest_TrimSpacesFirstName() {
        User user = positiveUser();
        user.setFirstName(" " + user.getFirstName() + " ");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextDialogContainerPresent());
    }


    @Test
    public void registrationPositiveTest_TrimSpacesPassword() {
        User user = positiveUser();
        user.setPassword(" " + user.getPassword() + " ");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextDialogContainerPresent());
    }


    @Test
    public void registrationPositiveTest_PasswordMinBorder8Chars() {
        User user = positiveUser();
        user.setPassword("Passwo1!");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextDialogContainerPresent());
    }


    @Test
    public void registrationNegativeTest_ExistingUser() {
        User user = User.builder()
                .firstName("Ivan")
                .lastName("Ivanov")
                .username("ivan22@gmail.com")
                .password("Password123!")
                .build();
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextInErrorPresent("User already exists"));
    }


    @Test
    public void registrationNegativeTest_EmptyName() {
        User user = User.builder()
                .firstName("")
                .lastName("Egorov")
                .username("egor22@gmail.com")
                .password("Password123!")
                .build();
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextInErrorPresent("Name is required"));
    }


    @Test
    public void registrationNegativeTest_NameSpacesOnly() {
        User user = positiveUser();
        user.setFirstName("  ");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextInErrorPresent("Name is required"));
    }


    @Test
    public void registrationNegativeTest_NonEnglishName() {
        User user = positiveUser();
        user.setFirstName("Егорый");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextInErrorPresent("Non English letters"));
    }


    @Test
    public void registrationNegativeTest_Name54Chars() {
        User user = positiveUser();
        user.setFirstName("SergeySergeySergeySergeySergeySergeySergeySergeySergey");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextInErrorPresent("Name is too long"));
    }


    @Test
    public void registrationNegativeTest_EmptyLastName() {
        User user = positiveUser();
        user.setFirstName("Igor");
        user.setLastName("");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextInErrorPresent("Last name is required"));
    }


    @Test
    public void registrationNegativeTest_LastNameSpacesOnly() {
        User user = positiveUser();
        user.setFirstName("Igor");
        user.setLastName("  ");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextInErrorPresent("Last name is required"));
    }


    @Test
    public void registrationNegativeTest_NonEnglishLastName() {
        User user = positiveUser();
        user.setFirstName("Igor");
        user.setLastName("Игорьев");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextInErrorPresent("Non English letters"));
    }


    @Test
    public void registrationNegativeTest_LastName54Chars() {
        User user = positiveUser();
        user.setFirstName("Gleb");
        user.setLastName("GlebovGlebovGlebovGlebovGlebovGlebovGlebovGleb");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextInErrorPresent("Last name is too long"));
    }


    @Test
    public void registrationNegativeTest_EmptyEmail() {
        User user = positiveUser();
        user.setFirstName("Alex");
        user.setLastName("Alexeev");
        user.setUsername("");
        user.setPassword("Password123!");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextInErrorPresent("Email is required"));
    }


    @Test
    public void registrationNegativeTest_EmailSpacesOnly() {
        User user = positiveUser();
        user.setFirstName("Alex");
        user.setLastName("Alexeev");
        user.setUsername("  ");
        user.setPassword("Password123!");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextInErrorPresent("Email is required"));
    }


    @Test
    public void registrationNegativeTest_EmailNotAt() {
        User user = positiveUser();
        user.setFirstName("Alex");
        user.setLastName("Alexeev");
        user.setUsername("alex22gmail.com");
        user.setPassword("Password123!");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextInErrorPresent("Invalid email"));
    }


    @Test
    public void registrationNegativeTest_EmailInvalidDomain() {
        User user = positiveUser();
        user.setFirstName("Alex");
        user.setLastName("Alexeev");
        user.setUsername("alex22@.com");
        user.setPassword("Password123!");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextInErrorPresent("Invalid email"));
    }


    @Test
    public void registrationNegativeTest_EmailMissingLocalPart() {
        User user = positiveUser();
        user.setFirstName("Alex");
        user.setLastName("Alexeev");
        user.setUsername("@gmail.com");
        user.setPassword("Password123!");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextInErrorPresent("Invalid email"));
    }


    @Test
    public void registrationNegativeTest_EmailMissingDomain() {
        User user = positiveUser();
        user.setFirstName("Alex");
        user.setLastName("Alexeev");
        user.setUsername("alex22@gmail");
        user.setPassword("Password123!");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextInErrorPresent("Invalid email"));
    }


    @Test
    public void registrationNegativeTest_EmailDoubleAt() {
        User user = positiveUser();
        user.setFirstName("Alex");
        user.setLastName("Alexeev");
        user.setUsername("alex22@@gmail.com");
        user.setPassword("Password123!");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextInErrorPresent("Invalid email"));
    }


    @Test
    public void registrationNegativeTest_EmptyPassword() {
        User user = positiveUser();
        user.setFirstName("Alex");
        user.setLastName("Alexeev");
        user.setUsername("alex22@gmail.com");
        user.setPassword("");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextInErrorPresent("Password is required"));
    }


    @Test
    public void registrationNegativeTest_PasswordSpacesOnly() {
        User user = positiveUser();
        user.setFirstName("Alex");
        user.setLastName("Alexeev");
        user.setUsername("alex22@gmail.com");
        user.setPassword("  ");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextInErrorPresent("Password is required"));
    }


    @Test
    public void registrationNegativeTest_PasswordTooLong60Chars() {
        User user = positiveUser();
        user.setFirstName("Alex");
        user.setLastName("Alexeev");
        user.setUsername("alex22@gmail.com");
        user.setPassword("Password1!SuperLongSecurePasswordWithExtraSymbols123!@#Test");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextInErrorPresent("Password is too long"));
    }


    @Test
    public void registrationNegativeTest_PasswordLessBorderMin() {
        User user = positiveUser();
        user.setFirstName("Misha");
        user.setLastName("Miheev");
        user.setUsername("misha22@gmail.com");
        user.setPassword("Ab1$xyz");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextInErrorPresent("Password is too short"));
    }


    @Test
    public void registrationNegativeTest_PasswordLowerCaseOnly() {
        User user = positiveUser();
        user.setFirstName("Misha");
        user.setLastName("Miheev");
        user.setUsername("misha22@gmail.com");
        user.setPassword("password!1");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextInErrorPresent("Password must contain uppercase letters"));
    }


    @Test
    public void registrationNegativeTest_PasswordUpperCaseOnly() {
        User user = positiveUser();
        user.setFirstName("Misha");
        user.setLastName("Miheev");
        user.setUsername("misha22@gmail.com");
        user.setPassword("PASSWORD!1");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextInErrorPresent("Password must contain lowercase letters"));
    }


    @Test
    public void registrationNegativeTest_PasswordNoNumbers() {
        User user = positiveUser();
        user.setFirstName("Misha");
        user.setLastName("Miheev");
        user.setUsername("misha22@gmail.com");
        user.setPassword("Password!!");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextInErrorPresent("Password must contain numbers"));
    }


    @Test
    public void registrationNegativeTest_PasswordNoSpecialSymbols() {
        User user = positiveUser();
        user.setFirstName("Misha");
        user.setLastName("Miheev");
        user.setUsername("misha22@gmail.com");
        user.setPassword("Password11");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextInErrorPresent("Password must contain special symbols"));
    }


    @Test
    public void registrationNegativeTest_PasswordNoLetters() {
        User user = positiveUser();
        user.setFirstName("Misha");
        user.setLastName("Miheev");
        user.setUsername("misha22@gmail.com");
        user.setPassword("2@$#*20911");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextInErrorPresent("Password must contain letters"));
    }


    @Test
    public void registrationNegativeTest_PasswordNonEngLetters() {
        User user = positiveUser();
        user.setFirstName("Misha");
        user.setLastName("Miheev");
        user.setUsername("misha22@gmail.com");
        user.setPassword("Аб1#ДеЁж");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextInErrorPresent("Password must contain only English letters"));
    }


    @Test
    public void registrationNegativeTest_PasswordInvalidSpecialSymbols() {
        User user = positiveUser();
        user.setFirstName("Misha");
        user.setLastName("Miheev");
        user.setUsername("misha22@gmail.com");
        user.setPassword("Password1]");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        signUpPage.clickBtnYalla();
        Assert.assertTrue(signUpPage.isTextInErrorPresent("Password contains invalid special symbol"));
    }
}