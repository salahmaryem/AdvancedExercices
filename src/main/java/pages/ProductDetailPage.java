package pages;

import io.cucumber.java.en.But;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage extends BasePage{

    public ProductDetailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "product_addtocart_form")
    private WebElement Button;
    @FindBy(id = "qty")
    private WebElement quantityField;
    @FindBy(id = "product-addtocart-button")
    private WebElement confirm;
    @FindBy(id = "_evidon-accept-button")
    private WebElement handleCookie;
    @FindBy(xpath = "//div[contains(@class,'success message')]/div")
    private WebElement  confirmationMessage;

    public void addProductBy(int quantity){
        Button.click();
        quantityField.sendKeys(String.valueOf(quantity));
        confirm.click();
    }
    public void handleCookie(){
        waitElement(driver,15,handleCookie);
        handleCookie.click();
    }
}
