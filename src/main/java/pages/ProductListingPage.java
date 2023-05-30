package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductListingPage extends BasePage{

    public ProductListingPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnCapsuleBy(String name){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//li[contains(.,'" + name + "') and contains(@class,'track-impression')]"))));
        driver.findElement(By.xpath("//li[contains(.,'" + name + "') and contains(@class,'track-impression')]")).click();
    }
}
