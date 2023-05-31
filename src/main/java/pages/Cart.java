package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart extends BasePage{
    @FindBy(className = "minicart-wrapper")
    private WebElement openCart;
    @FindBy(className = "text")
    private WebElement cartTitle;
    @FindBy(className = "counter-number")
    private WebElement itemQuantity;
    @FindBy(xpath = "//strong[contains(@class,'product-item-name')]/a")
    private WebElement itemName;

    public Cart(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void openCart(){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        openCart.click();

    }
    public String getProductQuantityFromCart(){
        return itemQuantity.getText();
    }
    public String getProductNameFromCart(){
        return itemName.getText();
    }
    public void checkElement(){
        waitElement(driver,10,cartTitle);
        waitElement(driver,10,itemQuantity);
        waitElement(driver,10,itemName);
        System.out.println(itemName.getText());
        System.out.println(itemQuantity.getText());
    }
}
