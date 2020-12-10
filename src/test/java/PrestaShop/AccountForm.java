package PrestaShop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.Random;

public class AccountForm {
    private WebDriver driver;

    public AccountForm() throws ParseException {
    }

    //3 funkcje random, bo random zwraca tylko jedną wartość
    public String getRandomAlias() {
        String[] alias = {"Kacha", "Monia", "Ada", "Basia", "Aga"};
        Random random = new Random();
        int randomInteger = random.nextInt(alias.length);
        String a = alias[randomInteger];
        return a;
    }

    public String getRandomCompany() {
        String[] company = {"xx", "yy", "zz", "oo", "pp", "qq"};
        Random random1 = new Random();
        int randomInteger1 = random1.nextInt(company.length);
        String b = company[randomInteger1];
        return b;
    }

    public String getRandomCity() {
        String[] city = {"Katowice", "Rzeszów", "Warszawa", "Kraków", "Gdańsk"};
        Random random2 = new Random();
        int randomInteger2 = random2.nextInt(city.length);
        String c = city[randomInteger2];
        return c;
    }
    public String getRandomZipCode(){
        String[] zipCode = {"12-222", "11-111", "13-333", "44-444", "55-555"};
        Random random3 = new Random();
        int randomInteger3 = random3.nextInt(zipCode.length);
        String z = zipCode[randomInteger3];
        return z;
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();

        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();

        // Przejdź do strony formularza z adresem
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=address");
    }

    @Test
    public void signIn() {

        WebElement alias = driver.findElement(By.name("alias"));
        alias.clear();
        alias.sendKeys(getRandomAlias()); // funkcje 1 z 3

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.clear();
        // Wpisz informacje do wyszukania
        firstName.sendKeys("Kasia");

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.clear();
        // Wpisz informacje do wyszukania
        lastName.sendKeys("Kowal");

        // Znajdź element wprowadzania tekstu na podstawie jego nazwy
//        WebElement email = driver.findElement(By.name("email"));
//
//        // Wpisz informacje do wyszukania
//        email.sendKeys(mail);
//
//        WebElement password2 = driver.findElement(By.name("password"));
//        password2.sendKeys(password);

        WebElement company = driver.findElement(By.name("company"));
        company.clear();
        // Wpisz informacje do wyszukania
        company.sendKeys(getRandomCompany());

        WebElement address = driver.findElement(By.name("address1"));
        address.clear();
        address.sendKeys("Piekna 51");

        WebElement zip = driver.findElement(By.name("postcode"));
        zip.clear();
        zip.sendKeys(getRandomZipCode());

        WebElement city = driver.findElement(By.name("city"));
        city.clear();
        city.sendKeys(getRandomCity());

        WebElement country = driver.findElement(By.name("id_country"));
        country.click();

        // Prześlij formularz
        country.submit();

    }

    @After
    public void tearDown() throws Exception {
        // Zamknij przeglądarkę
        //driver.quit();
    }

}

