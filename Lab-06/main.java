import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PracticeSoftwareTestingTests {

    static WebDriver driver;
    static WebDriverWait wait;
    static final String BASE_URL = "https://practicesoftwaretesting.com/";

    @BeforeAll
    static void setUp() {
        // Set path to your chromedriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }

    @Test
    @Order(1)
    void homePage_SortOptions() {
        driver.get(BASE_URL);
        WebElement sortDropdown = driver.findElement(By.id("sort"));
        sortDropdown.click();
        sortDropdown.findElement(By.xpath("//option[contains(text(),'Price: Low to High')]")).click();
        Assertions.assertTrue(driver.getPageSource().contains("Price"));
    }

    @Test
    @Order(2)
    void homePage_FilterByCategory() {
        driver.get(BASE_URL);
        driver.findElement(By.xpath("//label[contains(text(),'Hand Tools')]")).click();
        Assertions.assertTrue(driver.getPageSource().contains("Hand Tool"));
    }

    @Test
    @Order(3)
    void homePage_FilterByBrand() {
        driver.get(BASE_URL);
        driver.findElement(By.xpath("//label[contains(text(),'Brand A')]")).click();
        Assertions.assertTrue(driver.getPageSource().contains("Brand A"));
    }

    @Test
    @Order(4)
    void homePage_SearchBar() {
        driver.get(BASE_URL);
        WebElement search = driver.findElement(By.name("search"));
        search.sendKeys("hammer");
        search.sendKeys(Keys.ENTER);
        Assertions.assertTrue(driver.getPageSource().contains("hammer"));
    }

    @Test
    @Order(5)
    void homePage_PriceRange() {
        driver.get(BASE_URL);
        WebElement minPrice = driver.findElement(By.id("min-price"));
        WebElement maxPrice = driver.findElement(By.id("max-price"));
        minPrice.clear();
        minPrice.sendKeys("10");
        maxPrice.clear();
        maxPrice.sendKeys("50");
        driver.findElement(By.id("apply-price-filter")).click();
        Assertions.assertTrue(driver.getPageSource().contains("$"));
    }

    @Test
    @Order(6)
    void contactPage() {
        driver.get(BASE_URL + "contact");
        driver.findElement(By.id("name")).sendKeys("Jane Doe");
        driver.findElement(By.id("email")).sendKeys("customer@practicesoftwaretesting.com");
        driver.findElement(By.id("message")).sendKeys("This is a test message.");
        driver.findElement(By.id("submit-contact")).click();
        Assertions.assertTrue(driver.getPageSource().contains("Thanks for contacting us"));
    }

    @Test
    @Order(7)
    void loginPage() {
        driver.get(BASE_URL + "login");
        driver.findElement(By.id("email")).sendKeys("customer@practicesoftwaretesting.com");
        driver.findElement(By.id("password")).sendKeys("welcome01");
        driver.findElement(By.id("submit-login")).click();
        Assertions.assertTrue(driver.getPageSource().contains("My account"));
    }

    @Test
    @Order(8)
    void productDetailsPage_AddToCartAndFavorite() {
        driver.get(BASE_URL + "product/hammer"); // example product
        driver.findElement(By.id("increase-quantity")).click();
        driver.findElement(By.id("decrease-quantity")).click();
        driver.findElement(By.id("add-to-cart")).click();
        driver.findElement(By.id("add-to-favorite")).click();
        Assertions.assertTrue(driver.getPageSource().contains("Product added"));
    }

    @Test
    @Order(9)
    void favoritePage_AfterLogin() {
        loginPage(); // ensure logged in
        driver.get(BASE_URL + "favorites");
        Assertions.assertTrue(driver.getPageSource().contains("Favorites"));
    }

    @Test
    @Order(10)
    void profilePage_AfterLogin() {
        loginPage(); // ensure logged in
        driver.get(BASE_URL + "profile");
        Assertions.assertTrue(driver.getPageSource().contains("Jane Doe"));
    }

    @Test
    @Order(11)
    void addToCartAndCheckout_BuyNowPayLater() {
        loginPage();
        driver.get(BASE_URL + "product/hammer");
        driver.findElement(By.id("add-to-cart")).click();
        driver.findElement(By.id("cart")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("payment-method-bnpl")).click();
        driver.findElement(By.id("confirm-order")).click();
        Assertions.assertTrue(driver.getPageSource().contains("Order confirmed"));
    }

    @Test
    @Order(12)
    void addToCartAndCheckout_CreditCard() {
        loginPage();
        driver.get(BASE_URL + "product/hammer");
        driver.findElement(By.id("add-to-cart")).click();
        driver.findElement(By.id("cart")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("payment-method-cc")).click();
        driver.findElement(By.id("cc-number")).sendKeys("4111111111111111");
        driver.findElement(By.id("cc-exp")).sendKeys("12/30");
        driver.findElement(By.id("cc-cvc")).sendKeys("123");
        driver.findElement(By.id("confirm-order")).click();
        Assertions.assertTrue(driver.getPageSource().contains("Order confirmed"));
    }
}
