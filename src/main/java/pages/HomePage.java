package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        setDriver(driver);
        driver.get("https://ilcarro.web.app/search");
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//a[text()=' Log in ']")
    WebElement btnLoginHeader;

    @FindBy(xpath = "//a[text()=' Sign up ']")
    WebElement btnSignUpHeader;

    @FindBy(id = "city")
    WebElement inputCity;

    @FindBy(id = "dates")
    WebElement inputDates;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnYalla;

    @FindBy(xpath = "//button[@aria-label='Choose month and year']")
    WebElement calendarBtnYear;

    public void clickBtnLoginHeader() {
        btnLoginHeader.click();
    }


    public void clickBtnSignUpHeader() {
        btnSignUpHeader.click();
    }


    public void typeSearchForm(String city, LocalDate dateFrom, LocalDate dateTo) {
        inputCity.sendKeys(city);
        String dates = dateFrom.getMonthValue() + "/" + dateFrom.getDayOfMonth() + "/" + dateFrom.getYear()
                + " - " + dateTo.getMonthValue() + "/" + dateTo.getDayOfMonth() + "/" + dateTo.getYear();
        inputDates.sendKeys(dates);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector(\"button[type='submit']\").removeAttribute(\"disabled\")");
        clickWait(btnYalla, 3);
    }


    public void typeSearchFormWOJS(String city, LocalDate dateFrom, LocalDate dateTo) {
        inputCity.sendKeys(city);

        String dates = dateFrom.getMonthValue() + "/" + dateFrom.getDayOfMonth() + "/" + dateFrom.getYear()
                + " - " + dateTo.getMonthValue() + "/" + dateTo.getDayOfMonth() + "/" + dateTo.getYear();
        inputDates.sendKeys(dates);
        btnYalla.click();
    }


    private void typeCalendar(LocalDate date) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        calendarBtnYear.click();
        String year = String.valueOf(date.getYear());
        WebElement btnYear = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//td[@aria-label='" + year + "']")));
        btnYear.click();
        String month = date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        WebElement btnMonth = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//td[@aria-label='" + month + " " + year + "']")));
        btnMonth.click();
    }


    private void selectDay(LocalDate date) {
        String ariaLabel = date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH)
                + " " + date.getDayOfMonth() + ", " + date.getYear();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dayBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='sat-datepicker-0']//*[@aria-label='" + ariaLabel + "']")));
        dayBtn.click();
    }


    public void clickYalla() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector(\"button[type='submit']\").removeAttribute(\"disabled\")");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(btnYalla)).click();
    }


    public void typeSearchFormCalendar(String city, LocalDate dateFrom, LocalDate dateTo) {
        inputCity.sendKeys(city);
        inputDates.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(calendarBtnYear));
        typeCalendar(dateFrom);
        selectDay(dateFrom);
        typeCalendar(dateTo);
        selectDay(dateTo);
        clickYalla();
    }
}