import LoginPage.Login;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Login_test {
    private WebDriver driver;
    private Login loginPage;




    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        loginPage = new Login(driver);

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void correctUidCorrectPassword() {


        loginPage.logInToApplication("admin", "admin123");
        Assertions.assertEquals("Dashboard",driver.findElement(loginPage.getDashboardLocator()).getText());
        driver.findElement(By.cssSelector(".bi-caret-down-fill")).click();
        driver.findElement(loginPage.getLogoutButton()).click();
    }

    @Test
    public void correctUidWrongPassword() {

       loginPage.logInToApplication("admin", "admin1234");
       Assertions.assertEquals("Invalid credentials", driver.findElement(loginPage.getInvalidCredentialsMsg()).getText());
    }

    @Test
    public void blankUidBlankPassword() {

        loginPage.logInToApplication("", "");
        Assertions.assertEquals("Required", driver.findElement(loginPage.getRequiredMsg()).getText());
    }

    @Test
    public void anyUidBlankPassword() {

        loginPage.logInToApplication("xyz", "");
        Assertions.assertEquals("Required", driver.findElement(loginPage.getRequiredMsg()).getText());
    }

}
