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

public class StepsDefsOrder {
    private WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ma.buynespresso.com/ma_fr/cafe/original.html");
    }
    @Given("User opens the url {string}")
    public void userOpensTheUrl(String arg0) {
    }

    @When("^User scrolls to  (.+) capsule$")
    public void userScrollsToProductCapsule() {
    }

    @And("^User adds (.+) units of (.+) capsule to cart$")
    public void userAddsQuantityUnitsOfProductCapsuleToCart() {
    }

    @Then("^Mini cart contains (.+) units of (.+) capsule$")
    public void miniCartContainsQuantityUnitsOfProductCapsule() {
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
