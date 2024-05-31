import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePom {

    WebDriver webDriver = null;
    WebDriverWait wait = null;
    String path = "//a/span[text()='$$']";

    public HomePom(WebDriver webDriver, WebDriverWait wait){
        this.webDriver = webDriver;
        this.wait = wait;
    }

    public void clickProduct(String productName){
        webDriver.findElement(By.xpath(path.replace("$$",productName)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path.replace("$$",productName))));
        webDriver.findElement(By.xpath(path.replace("$$",productName))).click();
    }

    public void clickShopCategory(String category) {
        webDriver.findElement(By.xpath(path.replace("$$",category))).click();
    }
}
