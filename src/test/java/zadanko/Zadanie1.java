package zadanko;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadanie1 {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();

        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();

        // Przejdź do Bing
        driver.get("https://pl.wikipedia.org/");
    }

    @Test
    public void testBingSearch() {
        // Znajdź element wprowadzania tekstu na podstawie jego nazwy
//        WebElement element = driver.findElement(By.id("main-page-column1"));
        // Wyczyść teskst zapisany w elemencie
        String element = driver.findElement(By.id("main-page-content")).getTagName();
        System.out.println(element);

        // Wpisz informacje do wyszukania
//        element.sendKeys("Mistrzostwa Świata w piłce nożnej 2018");
//
//        // Prześlij formularz
//        element.sendKeys(Keys.ENTER);
    }

    @After
    public void tearDown() throws Exception {
        // Zamknij przeglądarkę
        //driver.quit();
    }

}