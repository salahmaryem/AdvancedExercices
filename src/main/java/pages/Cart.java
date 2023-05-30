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

    public Cart(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void openCart(){
        waitElement(driver,10,openCart);
        openCart.click();
        waitElement(driver,10,cartTitle);
    }
}
