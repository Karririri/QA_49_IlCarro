package pages;

import data_transfer_object.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class RegistrationPage extends BasePage{

    public RegistrationPage(WebDriver driver) {
        setDriver(driver);
        driver.get("https://ilcarro.web.app/registration");
        PageFactory.initElements
                (new AjaxElementLocatorFactory(driver, 10), this);
    }


    @FindBy(css = "input#name")
    WebElement inputFirstName;

    @FindBy(css = "input#lastName")
    WebElement inputLastName;

    @FindBy(css = "input#email")
    WebElement inputEmail;

    @FindBy(css = "input#password")
    WebElement inputPassword;

    @FindBy(css = "label.checkbox-label")
    WebElement checkboxTerms;

    @FindBy(css = "button[type='submit']")
    WebElement btnRegister;


    public void enterFirstName(String firstName) {
        inputFirstName.clear();
        inputFirstName.sendKeys(firstName);
    }


    public void enterLastName(String lastName) {
        inputLastName.clear();
        inputLastName.sendKeys(lastName);
    }


    public void enterEmail(String email) {
        inputEmail.clear();
        inputEmail.sendKeys(email);
    }


    public void enterPassword(String password) {
        inputPassword.clear();
        inputPassword.sendKeys(password);
    }


    public void agreeToTerms() {
        if (!checkboxTerms.isSelected())
            checkboxTerms.click();
    }


    public void clickRegister() {
        btnRegister.click();
    }


    public void registerUser(User user, String firstName, String lastName) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(user.getEmail());
        enterPassword(user.getPassword());
        agreeToTerms();
        clickRegister();
    }
}
