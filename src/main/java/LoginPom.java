import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPom {

    WebDriver webDriver = null;
    By email = By.name("email");
    By password = By.xpath("//input[@name='password']");
    By signInButton = By.xpath("//button[@type='submit']");

    public LoginPom(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public LoginPom getLogin(){
        webDriver.get("https://demo.evershop.io/account/login");
        return this;
    }

    public LoginPom fillEmail(String userEmail){
        webDriver.findElement(email).sendKeys(userEmail);
        return this;
    }

    public LoginPom fillPass(String userPass){
        webDriver.findElement(password).sendKeys(userPass);
        return this;
    }

    public LoginPom clickSignIn(){
        webDriver.findElement(signInButton).click();
        return this;
    }
}
