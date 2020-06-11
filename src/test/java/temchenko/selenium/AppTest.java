package temchenko.selenium;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AppTest extends ChromeDriverSettings {

    /**
     * This test is loading page and get the title and comparing with expecting value
     * Expected value is "The world’s leading software development platform · GitHub"
     *
     */
    @Test
    public void testTitleNaming() {
        chromeDriver.get("https://github.com/");
        String expect = "The world’s leading software development platform · GitHub";
        String actual =  chromeDriver.getTitle();
        assertThat(actual, is(expect));
    }

    /**
     * This test load page github.com, go to sign in page and send to the inputs test value keys.
     * Expected result of this test is false, because used incorrect keys values.
     *
     */
    @Test
    public void testIncorrectInputValuesToSignInForm() {
        SignUpPage signUpPage = PageFactory.initElements(chromeDriver, SignUpPage.class);
        signUpPage.open();

        boolean expect = false;

        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("start-of-content"))));
        if(signUpPage.getToggleNavigation().isDisplayed()) {
            signUpPage.getToggleNavigation().click();
        }

        signUpPage.getLoginForm().click();
        signUpPage.sendKeysToLoginForm("test@test.com");
        signUpPage.sendKeysToPasswordForm("test");
        signUpPage.getSubmitButton().click();

        Boolean actual = chromeDriver.findElement(By.className("flex-auto")).isDisplayed();

        assertThat(actual, is(expect));
    }
}
