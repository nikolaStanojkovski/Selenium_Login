import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest {

    private WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = getDriver();
    }

    @Test
    public void shouldOpen() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        Assert.assertTrue(loginPage.isLoaded());
    }

    /*
        Test 1: Login with invalid credentials and check error message
        Test 2: Login with empty username and check error message
        Test 3: Login successfully and check if you are navigated to the homepage
     */

    @Test // Test 1
    public void testInvalidCredentialsLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("Invalid username", "Invalid password");

        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Your username is invalid!\n" +
                "×");
    }

    @Test // Test 2
    public void testEmptyUsernameLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("", "SuperSecretPassword!");
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Your username is invalid!\n" +
                "×");
    }

    @Test // Test 3
    public void testSuccessfulLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("tomsmith", "SuperSecretPassword!");

        // first option
        String message = new SitePage(driver).getLoginMessage();
        Assert.assertEquals(message, "You logged into a secure area!\n" +
                "×");

        // second option
//        Assert.assertTrue(new SitePage(driver).isLoaded());
    }


    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    public WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        return new ChromeDriver();
    }

}
