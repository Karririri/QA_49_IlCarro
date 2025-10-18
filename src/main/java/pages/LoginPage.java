package pages;

import data_transfer_object.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){
        setDriver(driver);
        driver.get("https://ilcarro.web.app/login");
        PageFactory.initElements
                (new AjaxElementLocatorFactory(driver, 10), this);
    }


    @FindBy(css = "input#email")
    WebElement inputEmail;

    @FindBy(css = "input#password")
    WebElement inputPassword;

    @FindBy(css = "button[type='submit']")
    WebElement btnLoginForm;


    public void typeLoginForm(String email, String password) {
        inputEmail.clear();
        inputEmail.sendKeys(email);
        inputPassword.clear();
        inputPassword.sendKeys(password);
        btnLoginForm.click();
    }


    public void typeLoginFormWithUser(User user) {
        inputEmail.clear();
        inputEmail.sendKeys(user.getEmail());
        inputPassword.clear();
        inputPassword.sendKeys(user.getPassword());
        btnLoginForm.click();
    }
}
