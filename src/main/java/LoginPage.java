import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open(){
        driver.get("https://the-internet.herokuapp.com/login");
    }

    public boolean isLoaded() throws InterruptedException {
        Thread.sleep(8000);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login"))).isDisplayed();
    }

    public void login(String username, String password) throws InterruptedException {
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(username);
        Thread.sleep(2500);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(2500);
        driver.findElement(By.className("radius")).click();
        Thread.sleep(2000);
    }

    public String getErrorMessage(){
        WebElement element = driver.findElement(By.id("flash"));

        return element.getText();
    }

}
