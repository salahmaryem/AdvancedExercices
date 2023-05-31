package Cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import pages.Cart;
import pages.ProductDetailPage;
import pages.ProductListingPage;

public class StepsDefsOrder {
    private WebDriver driver;
    private ProductListingPage productListingPage;
    private ProductDetailPage productDetailPage;
    private Cart cart;
    @Before
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

    }
    @Given("User opens the url {string}")
    public void userOpensTheUrl(String url) {
        url = "https://ma.buynespresso.com/ma_fr/cafe/original.html";
        driver.get(url);
        productListingPage = new ProductListingPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        cart = new Cart(driver);
    }

    @When("^User scrolls to  (.+) capsule$")
    public void userScrollsToProductCapsule(String product) {
        productListingPage.clickOnCapsuleBy(product);
    }

    @And("^User adds (.+) units of (.+) capsule to cart$")
    public void userAddsQuantityUnitsOfProductCapsuleToCart(int quantity,String product) {
        productDetailPage.handleCookie();
        productDetailPage.addProductBy(quantity);
    }

    @Then("^Mini cart contains (.+) units of (.+) capsule$")
    public void miniCartContainsQuantityUnitsOfProductCapsule(int quantity,String product) {
        cart.openCart();
        cart.checkElement();
        //Assertions To check that they are being added
        Assert.assertEquals(cart.getProductQuantityFromCart(),String.valueOf(quantity));
        Assert.assertEquals(cart.getProductNameFromCart(),product);
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
