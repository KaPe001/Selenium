package PrestaShop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class PrestaShopSignIn {
    private WebDriver driver;

    String mail = "coś" + System.currentTimeMillis() + "@gmail.com";
    String password = "cos" + System.currentTimeMillis();

//    public String getRandomBirthday() {
//        String[] date = {"1", "2", "3", "5", "10", "13", "15", "18", "20", "23", "24", "25", "28", "30"};
//        Random random = new Random();
//        int randomInteger = random.nextInt(date.length);
//        return date[randomInteger];
//    }


        @Before
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

            // Uruchom nowy egzemplarz przeglądarki Chrome
            driver = new ChromeDriver();

            // Zmaksymalizuj okno przeglądarki
            driver.manage().window().maximize();

            // Przejdź do strony PrestaShop
            driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&create_account=1");
        }

        @Test
        public void signIn() {

            WebElement gender = driver.findElement(By.name("id_gender"));
            gender.click();

            WebElement firstName = driver.findElement(By.name("firstname"));
            firstName.clear();
            // Wpisz informacje do wyszukania
            firstName.sendKeys("Kasia");

            WebElement lastName = driver.findElement(By.name("lastname"));
            lastName.clear();
            // Wpisz informacje do wyszukania
            lastName.sendKeys("Kowal");

            // Znajdź element wprowadzania tekstu na podstawie jego nazwy
            WebElement email = driver.findElement(By.name("email"));

            // Wpisz informacje do wyszukania
            email.sendKeys(mail);

            WebElement password2 = driver.findElement(By.name("password"));
            password2.sendKeys(password);

            WebElement birthday = driver.findElement(By.name("birthday"));
            birthday.clear();
            // Wpisz informacje do wyszukania
            birthday.sendKeys("12/19/00");

            // Prześlij formularz
            birthday.submit();
        }

        @After
        public void tearDown () throws Exception {
            // Zamknij przeglądarkę
            //driver.quit();
        }

    }
