package katalon;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Form {
    private WebDriver driver;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();

        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();

        // Przejdź do strony formularzaz
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");

    }

    @Test
    public void testFillTheForm() {
        // Znajdź element wprowadzania tekstu na podstawie jego nazwy
        WebElement firstName = driver.findElement(By.id("first-name"));
        if (firstName.isDisplayed()) {
            firstName.sendKeys("Karol");
            firstName.submit();
        } else {
            Assert.fail();
        }

        if(firstName.isEnabled()){
            firstName.sendKeys("Karol");
            firstName.submit();
        } else{
            Assert.fail();
        }
        firstName.clear();
        // Wpisz informacje do wyszukania
        firstName.sendKeys("Karol");

        System.out.println(firstName.getTagName() + " : " + firstName.getAttribute("value"));

        WebElement lastName = driver.findElement(By.id("last-name"));
        if (lastName.isDisplayed()) {
            lastName.sendKeys("Kowalski");
            lastName.submit();
        } else {
            Assert.fail();
        }

        if(lastName.isEnabled()){
            lastName.sendKeys("Kowalski");
            lastName.submit();
        } else{
            Assert.fail();
        }

        lastName.clear();
        lastName.sendKeys("Kowalski");

        System.out.println(lastName.getTagName() + " : " + lastName.getAttribute("value"));

        WebElement gender = driver.findElement(By.name("gender"));
        gender.click();

        System.out.println(gender.getTagName() + " : " + gender.getAttribute("value"));

        WebElement dateOfBirth = driver.findElement(By.id("dob"));
        if (dateOfBirth.isDisplayed()) {
            dateOfBirth.sendKeys("05/22/2010");
            dateOfBirth.submit();
        } else {
            Assert.fail();
        }

        if(dateOfBirth.isEnabled()){
            dateOfBirth.sendKeys("05/22/2010");
            dateOfBirth.submit();
        } else{
            Assert.fail();
        }

        dateOfBirth.clear();
        dateOfBirth.sendKeys("05/22/2010");

        System.out.println(dateOfBirth.getTagName() + " : " + dateOfBirth.getAttribute("value"));

        WebElement address = driver.findElement(By.id("address"));
        if (address.isDisplayed()) {
            address.sendKeys("Prosta 51");
            address.submit();
        } else {
            Assert.fail();
        }

        if(address.isEnabled()){
            address.sendKeys("Prosta 51");
            address.submit();
        } else{
            Assert.fail();
        }
        address.clear();
        address.sendKeys("Prosta 51");

        System.out.println(address.getTagName() + " : " + address.getAttribute("value"));

        WebElement email = driver.findElement(By.id("email"));
        if (email.isDisplayed()) {
            email.sendKeys("karol.kowalski@mailinator.com");
            email.submit();
        } else {
            Assert.fail();
        }

        if(email.isEnabled()){
            email.sendKeys("karol.kowalski@mailinator.com");
            email.submit();
        } else{
            Assert.fail();
        }
        email.clear();
        email.sendKeys("karol.kowalski@mailinator.com");

        System.out.println(email.getTagName() + " : " + email.getAttribute("value"));

        WebElement password = driver.findElement(By.id("password"));
        if (password.isDisplayed()) {
            password.sendKeys("Pass123");
            password.submit();
        } else {
            Assert.fail();
        }

        if(password.isEnabled()){
            password.sendKeys("Pass123");
            password.submit();
        } else{
            Assert.fail();
        }
        password.clear();
        password.sendKeys("Pass123");

        System.out.println(password.getTagName() + " : " + password.getAttribute("value"));

        WebElement company = driver.findElement(By.id("company"));
        if (company.isDisplayed()) {
            company.sendKeys("Coders Lab");
            company.submit();
        } else {
            Assert.fail();
        }

        if(company.isEnabled()){
            company.sendKeys("Coders Lab");
            company.submit();
        } else{
            Assert.fail();
        }
        company.clear();
        company.sendKeys("Coders Lab");

        System.out.println(company.getTagName() + " : " + company.getAttribute("value"));

        WebElement comment = driver.findElement(By.id("comment"));
        if (comment.isDisplayed()) {
            comment.sendKeys("To jest mój pierwszy automat testowy");
            comment.submit();
        } else {
            Assert.fail();
        }

        if(comment.isEnabled()){
            comment.sendKeys("To jest mój pierwszy automat testowy");
            comment.submit();
        } else{
            Assert.fail();
        }
        comment.clear();
        comment.sendKeys("To jest mój pierwszy automat testowy");

        System.out.println(comment.getTagName() + " : " + comment.getAttribute("value"));

        // Prześlij formularz
        comment.submit();

    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
    }
}

