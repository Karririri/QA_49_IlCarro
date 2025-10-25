package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        setDriver(driver);
        driver.get("https://ilcarro.web.app/search");
        PageFactory.initElements
                (new AjaxElementLocatorFactory(driver, 10), this);
    }


    @FindBy(css = "a[href^='/login']")
    WebElement btnLoginHeader;

    @FindBy(css = "a[href^='/registration']")
    WebElement btnSignUpHeader;

    @FindBy(css = "input[formcontrolname='city']")
    WebElement inputCity;

    @FindBy(css = "#dates")
    WebElement inputDates;

    @FindBy(css = "button[type='submit']")
    WebElement btnYalla;

    @FindBy(css = "button.positive-button")
    private WebElement loggedInPopupOkButton;


    public void clickBtnLoginHeader() {
        btnLoginHeader.click();
    }


    public void clickBtnSignUpHeader() {
        btnSignUpHeader.click();
    }


    public void enterCity(String city) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(inputCity));
        inputCity.clear();
        inputCity.sendKeys(city);
    }


    public void enterDates(String dates) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(inputDates));
        inputDates.clear();
        inputDates.sendKeys(dates);
    }


    public void clickYalla() {
        btnYalla.click();
    }


    public void closeLoggedInPopup() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(loggedInPopupOkButton));
            loggedInPopupOkButton.click();
        } catch (Exception e) {
            System.out.println("Pop-up 'Logged In' didn't appear");
        }
    }
}
