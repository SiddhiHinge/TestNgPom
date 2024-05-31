import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPom {
    WebDriver webDriver = null;
    WebDriverWait wait = null;
    By qtyXpath = By.xpath("//input[@name='qty']");
    String sizeXpath = "//ul[contains(@class,'variant-option-list')]//a[text()='$$']";
    String colourXpath = "//ul[contains(@class,'variant-option-list')]//a[text()='$$']";
    By addToCartPath = By.xpath("//button/span[text()='ADD TO CART']");
    By viewCartPath = By.xpath("//a[@class='add-cart-popup-button']");
    public ProductPom(WebDriver webDriver, WebDriverWait wait){
        this.webDriver = webDriver;
        this.wait = wait;
    }

    public ProductPom fillQty(String qty) throws InterruptedException {
        webDriver.findElement(qtyXpath).clear();
        webDriver.findElement(qtyXpath).sendKeys(qty);
        Thread.sleep(3000);
        return this;
    }

    public ProductPom selectSize(String size) throws InterruptedException {
        webDriver.findElement(By.xpath(sizeXpath.replace("$$",size))).click();
        Thread.sleep(3000);
        return this;
    }

    public ProductPom selectColour(String colour) throws InterruptedException {
        webDriver.findElement(By.xpath(colourXpath.replace("$$",colour))).click();
        Thread.sleep(3000);
        return this;
    }

    public ProductPom clickAddToCart() {
        webDriver.findElement(addToCartPath).click();
        return this;
    }

    public CartPom viewCartPopup(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'toast-mini-cart')]")));
        webDriver.findElement(viewCartPath).click();
        return new CartPom(webDriver,wait);
    }
}
