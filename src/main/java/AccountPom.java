import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPom {
    WebDriver webDriver = null;
    WebDriverWait wait = null;
    By accountPath = By.xpath("//a[@href='/account']");
    By logoutPath = By.xpath("//a[text()='Logout']");
    public AccountPom(WebDriver webDriver,WebDriverWait wait){
        this.webDriver = webDriver;
        this.wait = wait;
    }

    public AccountPom gotoAccount(){
        webDriver.findElement(accountPath).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutPath));
        return this;
    }

    public AccountPom logout() {
        webDriver.findElement(logoutPath).click();
        return this;
    }
}
