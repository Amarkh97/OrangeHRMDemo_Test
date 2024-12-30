package LoginPage;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    private WebDriver driver;

    public Login(WebDriver driver){
        this.driver= driver;

    }

    //  web elements and locators
    private By userNameLocator =By.name("username") ;
    private By passwordLocator =By.name("password");
    private By loginButtonLoactor=By.cssSelector(".oxd-button") ;
    private By invalidCredentialsMsg = By.xpath("//p[text()=\"Invalid credentials\"]");
    private By logoutButton = By.linkText("Logout");
    private By requiredMsg =By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[2]/div[1]/span[1]");
    private By loginPageLocator= By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/h5[1]");
    private By dashboardLocator= By.xpath("//header/div[1]/div[1]/span[1]/h6[1]");


//    Entering Login credentials here
    public void logInToApplication(String username, String password){
        Assertions.assertEquals("Login", driver.findElement(getLoginPageLocator()).getText());
        driver.findElement(getUserNameLocator()).sendKeys(username);
        Assertions.assertEquals(true,driver.findElement(getUserNameLocator()).isDisplayed());
        driver.findElement(getPasswordLocator()).sendKeys(password);
        Assertions.assertEquals("password",driver.findElement(getPasswordLocator()).getDomAttribute("type"));

        driver.findElement(getLoginButtonLoactor()).click();
    }


    public By getInvalidCredentialsMsg() {
        return invalidCredentialsMsg;
    }

    public By getLogoutButton() {
        return logoutButton;
    }

    public By getUserNameLocator() {
        return userNameLocator;
    }

    public By getPasswordLocator() {
        return passwordLocator;
    }

    public By getLoginButtonLoactor() {
        return loginButtonLoactor;
    }

    public By getRequiredMsg() {
        return requiredMsg;
    }

    public By getLoginPageLocator() {
        return loginPageLocator;
    }

    public By getDashboardLocator() {
        return dashboardLocator;
    }
}