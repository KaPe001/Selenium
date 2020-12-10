package PrestaShop;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;

public class PrestaShopCart {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php?id_category=6&controller=category");
    }

    @Test
    public void testingCart() {
        //pick first product
        WebElement pillow = driver.findElement(By.cssSelector("article:nth-child(4)"));
        pillow.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //add to cart - worked before i added another product
        WebElement submit = driver.findElement(By.className("add-to-cart"));
        submit.click();

//        if (pillow.isSelected()) {
//            System.out.println("Pillow is in the selected");
//        } else {
//            Assert.fail();
//        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //continue shopping - continue shopping button doesn't work
        WebElement button = driver.findElement(By.className("btn"));
        button.submit();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //switch to the art
        WebElement art = driver.findElement(By.cssSelector("#category-9 a"));
        art.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //pick second product
        WebElement frame = driver.findElement(By.cssSelector("article:nth-child(2)"));
        frame.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        //add to cart
        WebElement submit2 = driver.findElement(By.className("add-to-cart"));
        submit2.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //test passes but doesn't lead to the checkout
        WebElement checkout = driver.findElement(By.className("btn-primary"));
        checkout.submit();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement cart = driver.findElement(By.xpath("//div[@class='header']"));
        cart.click();

        //find number of products and compere to the number of products tested (2)
        WebElement productqty = driver.findElement(By.className("js-subtotal"));
//        WebElement product1 = driver.findElement(By.cssSelector("article:nth-child(3)"));
//        WebElement product2 = driver.findElement(By.cssSelector("article:nth-child(2)"));
        int prodqty = Integer.parseInt(productqty.getText().substring(0, 1));

        if (prodqty == 2) {
            System.out.println("Ilość produktów w koszyku to: " + prodqty);
        } else System.out.println("Ilość produktów w koszyku niepoprawna: " + prodqty);

        String prod1 = pillow.getText();
        String prod2 = frame.getText();
        System.out.println("Produkty w koszyku: " + prod1 + ", " + prod2);

        WebElement product2qty = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li[2]/div/div[3]/div/div[2]/div/div[1]/div/input"));
        int prod2qty = Integer.parseInt(product2qty.getAttribute("value"));
        if (prod2qty == 1) {
            System.out.println("Ilość produktów " + prod1 + " poprawna: " + prod2qty);
        } else System.out.println("Ilość produktów " + prod2 + " niepoprawna: " + prod2qty);
    }

        @After
        public void tearDown() throws Exception {
            // Zamknij przeglądarkę
            //driver.quit();
        }
    }
