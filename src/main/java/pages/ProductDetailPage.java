package pages;

import io.cucumber.java.en.But;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage extends BasePage{

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(className = "action tocart primary list pdpcart-btn")
    private WebElement Button;
    @FindBy(className = "input-text qty qty-selector-input")
    private WebElement quantityField;
    @FindBy(id = "product-addtocart-button")
    private WebElement confirm;

    public void addProductBy(int quantity){
        waitElement(driver,10, Button);
        Button.click();
        quantityField.sendKeys(String.valueOf(quantity));
        confirm.click();
    }
}
