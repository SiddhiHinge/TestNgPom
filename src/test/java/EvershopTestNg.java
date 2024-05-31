import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class EvershopTestNg {
    ChromeOptions chrome = new ChromeOptions();
    WebDriver webDriver;
    WebDriverWait wait;

    @BeforeClass
    public void basicSetup() throws MalformedURLException {
        chrome = new ChromeOptions();
        webDriver = new RemoteWebDriver(new URL("http://localhost:4444"),chrome);
        wait = new WebDriverWait(webDriver,Duration.ofSeconds(5));
    }

    @Parameters({"username","password"})
    @Test
    public void login(String username, String password) {
        LoginPom loginPom = new LoginPom(webDriver);
        loginPom.getLogin().fillEmail(username).fillPass(password).clickSignIn();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'button')]/span[text()='Shop women']")));
    }

    @Parameters({"productName"})
    @Test
    public void findProductPage(String productName){
        HomePom homePom = new HomePom(webDriver,wait);
        homePom.clickProduct(productName);
    }

    @Parameters({"size","colour","qty"})
    @Test
    public void addItemFromPDP(String size, String colour, String qty) throws InterruptedException {
        ProductPom productPom = new ProductPom(webDriver,wait);
        productPom.fillQty(qty)
        .selectSize(size)
        .selectColour(colour)
        .clickAddToCart().viewCartPopup().clickCheckout();
    }

    @Parameters({"fullName","phone","streetAddress","cityName","countryName","provinceName","postalCode"})
    @Test
    public void addAddressInCheckout(String fullName, String phone, String streetAddress,String cityName,String countryName,String provinceName,String postalCode) throws InterruptedException {
        CheckoutPom checkoutPom = new CheckoutPom(webDriver,wait);
        checkoutPom.fillFullName(fullName).fillTelephone(phone).fillAddress(streetAddress).fillCity(cityName).chooseCountry(countryName).chooseProvince(provinceName).fillPostalCode(postalCode).clickPayment();
    }

    @Parameters({"button"})
    @Test
    public void addItemFromShop(String button){
        HomePom homePom = new HomePom(webDriver,wait);
        homePom.clickShopCategory(button);
    }

    @Test
    public void logout(){
        AccountPom accountPom = new AccountPom(webDriver,wait);
        accountPom.gotoAccount().logout();
    }

    /*@AfterClass
    public void closeSetup() {
        webDriver.quit();
    }*/
}
