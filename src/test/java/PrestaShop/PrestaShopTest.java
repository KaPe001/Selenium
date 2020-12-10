package PrestaShop;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class PrestaShopTest {
    private WebDriver driver;

    private String getRandomProduct(){
        String[] products = {"mug", "frame", "tshirt", "notebook", "whatever"};

        Random random = new Random();
        int randomInteger = random.nextInt(products.length);
        return products[randomInteger];

    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();

        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();

        // Przejdź do strony PrestaShop
        driver.get("https://prod-kurs.coderslab.pl/index.php");
    }

    @Test
    public void testProductSearch() {
        // Znajdź element wprowadzania tekstu na podstawie jego nazwy
        WebElement element = driver.findElement(By.name("s"));
        element.clear();


        // Wpisz informacje do wyszukania
        element.sendKeys(getRandomProduct());

        // Prześlij formularz
        element.submit();
    }

    @After
    public void tearDown() throws Exception {
        // Zamknij przeglądarkę
        //driver.quit();
    }

}
