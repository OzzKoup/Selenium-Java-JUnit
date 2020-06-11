package temchenko.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {
    private WebDriver chromeDriver;
    private WebDriverWait webDriverWait;

    @FindBy(css = "button[type=\"button\"")
    WebElement toggleNavigation;

    @FindBy(id = "login_field")
    private WebElement login;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(css = "[href=\"/login\"]")
    private WebElement loginForm;

    @FindBy(css = "input[type=\"submit\"]")
    private WebElement submitButton;


    public SignUpPage(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
    }

    public void open() {
        chromeDriver.get("https://github.com/");
    }

    public void sendKeysToLoginForm(String value) {
        login.sendKeys(value);
    }

    public void sendKeysToPasswordForm(String passwordValue) {
        password.sendKeys(passwordValue);
    }

    public WebElement getLoginForm() {
        return loginForm;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getToggleNavigation() {
        return toggleNavigation;
    }

}
