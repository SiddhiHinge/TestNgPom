import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPom {
    WebDriver webDriver = null;
    WebDriverWait wait = null;
    By checkoutPath = By.xpath("//a/span[text()='CHECKOUT']");
    public CartPom(WebDriver webDriver,WebDriverWait wait){
        this.webDriver = webDriver;
        this.wait = wait;
    }

    public CheckoutPom clickCheckout(){
        webDriver.findElement(checkoutPath).click();
        return new CheckoutPom(webDriver,wait);
    }
}
