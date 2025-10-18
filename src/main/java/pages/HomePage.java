package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

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


    public void clickBtnLoginHeader() {
        btnLoginHeader.click();
    }


    public void clickBtnSignUpHeader() {
        btnSignUpHeader.click();
    }


    public void enterCity(String city) {
        inputCity.clear();
        inputCity.sendKeys(city);
    }


    public void enterDates(String dates) {
        inputDates.clear();
        inputDates.sendKeys(dates);
    }


    public void clickYalla() {
        btnYalla.click();
    }
}
