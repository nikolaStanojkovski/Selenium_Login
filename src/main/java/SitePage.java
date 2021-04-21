import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SitePage extends BasePage {

    public SitePage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        // String message = driver.findElement(By.className("flash")).getText();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("icon-lock"))).isDisplayed();
    }

}
