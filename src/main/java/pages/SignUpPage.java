package pages;

import data_transfer_object.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SignUpPage extends BasePage{

    public SignUpPage(WebDriver driver) {
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

    @FindBy(id = "terms-of-use")
    WebElement checkboxInput;

    @FindBy(css = "label.checkbox-label")
    WebElement checkboxLabel;

    @FindBy(css = "button[type='submit']")
    WebElement btnRegister;

    @FindBy(xpath = "//h2[text()='Registered']")
    WebElement popUpTextRegistered;

    @FindBy(xpath = "//h2[text()='User already exists']")
    WebElement popUpTextUserExists;


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
        if (!checkboxInput.isSelected()) {
            Actions actions = new Actions(driver);
            actions.moveToElement(checkboxInput).click().perform();
            pause(10);
        }
    }


   /* public void clickCheckBoxWithActions(){
        Actions actions = new Actions(driver);
        actions.moveToElement(checkboxTerms, -50, 0).click().perform();
    }*/


    public void clickRegister() {
        btnRegister.click();
    }


    public void registerUser(User user, String firstName, String lastName) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(user.getEmail());
        enterPassword(user.getPassword());
        agreeToTerms();
        //clickCheckBoxWithActions();
        clickRegister();
    }


    public void typeLoginForm(User user) {
        inputFirstName.sendKeys(user.getFirstName());
        inputLastName.sendKeys(user.getLastName());
        inputEmail.sendKeys(user.getEmail());
        inputPassword.sendKeys(user.getPassword());
    }


    public boolean isRegisteredDisplayed() {
        return elementIsDisplayed(popUpTextRegistered);
    }


    public boolean isUserAlreadyExistsDisplayed() {
        return elementIsDisplayed(popUpTextUserExists);
    }
}
