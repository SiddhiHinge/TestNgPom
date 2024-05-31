import com.sun.tools.javac.comp.Check;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CheckoutPom {

    By fullname = By.xpath("//input[@name='address[full_name]']");
    By telephone = By.xpath("//input[@name='address[telephone]']");
    By address = By.xpath("//input[@name='address[address_1]']");
    By city = By.xpath("//input[@name='address[city]']");
    By country = By.xpath("//select[@id='address[country]']/option");
    By province = By.xpath("//select[@id='address[province]']/option");
    By postal = By.xpath("//input[@name='address[postcode]']");
    By payButton = By.xpath("//button/span[text()='Continue to payment']");
    WebDriver webDriver = null;
    WebDriverWait wait = null;

    public CheckoutPom(WebDriver webDriver,WebDriverWait wait){
        this.webDriver = webDriver;
        this.wait = wait;
    }

    public CheckoutPom fillFullName(String fullName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(fullname));
        webDriver.findElement(fullname).sendKeys(fullName);
        return this;
    }

    public CheckoutPom fillTelephone(String phone){
        //wait.until(ExpectedConditions.visibilityOfElementLocated(telephone));
        webDriver.findElement(telephone).sendKeys(phone);
        return this;
    }

    public CheckoutPom fillAddress(String streetAddress){
        webDriver.findElement(address).sendKeys(streetAddress);
        return this;
    }

    public CheckoutPom fillCity(String cityName){
        webDriver.findElement(city).sendKeys(cityName);
        return this;
    }

    public CheckoutPom chooseCountry(String countryName){
        List<WebElement> countryOptions = webDriver.findElements(country);
        for(WebElement option : countryOptions){
            if(option.getText().equalsIgnoreCase(countryName)){
                option.click();
            }
        }
        return this;
    }

    public CheckoutPom chooseProvince(String provinceName){
        List<WebElement> provinceOptions = webDriver.findElements(province);
        for(WebElement option : provinceOptions){
            if(option.getText().equalsIgnoreCase(provinceName)){
                option.click();
            }
        }
        return this;
    }

    public CheckoutPom fillPostalCode(String postalCode){
        webDriver.findElement(postal).sendKeys(postalCode);
        return this;
    }

    public CheckoutPom clickPayment(){
        webDriver.findElement(payButton).click();
        return this;
    }
}
