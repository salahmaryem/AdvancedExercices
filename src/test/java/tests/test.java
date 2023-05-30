package tests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Cart;
import pages.ProductDetailPage;
import pages.ProductListingPage;

import java.util.concurrent.TimeUnit;

public class test {
    public WebDriver driver;
    private ProductListingPage productListingPage;
    private ProductDetailPage productDetailPage;
    private Cart cart;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--remote-allow-origins=*");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://ma.buynespresso.com/ma_fr/cafe/original.html");
        productListingPage = new ProductListingPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        cart = new Cart(driver);

    }
    @Test
    public void test(){
        productListingPage.clickOnCapsuleBy("Tokyo");
        productDetailPage.handleCookie();
        productDetailPage.addProductBy(10);
        cart.openCart();
    }
    @AfterClass
    public void tearDown(){
        //driver.quit();
    }
}
