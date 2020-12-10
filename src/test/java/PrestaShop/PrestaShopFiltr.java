package PrestaShop;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrestaShopFiltr {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php?id_category=2&controller=category");
    }

    @Test
    public void testingFilters() {
//        WebElement category = driver.findElement(By.xpath("//label"));
//        category.click();

        //kliknęło, teraz skrypt, który sprawdzi, czy dobre wartości

        WebElement price = driver.findElement(By.cssSelector("li:nth-child(5) input"));
        price.click();
        if(price.isSelected()){
            System.out.println("Price is selected");
        } else{
            Assert.fail();
        }
    }

    @After
    public void tearDown() throws Exception {
        // Zamknij przeglądarkę
        //driver.quit();
    }
}
