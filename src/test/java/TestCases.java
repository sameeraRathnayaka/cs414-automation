import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCases {

    final String url = "https://demo.actitime.com/login.do";
    final String userName = "admin";
    final String password = "manager";

    private ChromeDriver driver;

    @Test
    public void adminLogin() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.get(url);

        this.loginAsAdmin();
    }

    public void loginAsAdmin(){
        driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.name("pwd")).sendKeys(password);
        driver.findElement(By.id("loginButton")).click();
    }

    @Test
    public void userLogin() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.get(url);

        this.loginAsAUser();
    }

    public void loginAsAUser(){
        driver.findElement(By.id("username")).sendKeys("trainee");
        driver.findElement(By.name("pwd")).sendKeys("trainee");
        driver.findElement(By.id("loginButton")).click();
    }

    @Test
    public void loginWithIncorrectCredentials() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.get(url);

        driver.findElement(By.id("username")).sendKeys("zzzz");
        driver.findElement(By.name("pwd")).sendKeys("zzzz");
        driver.findElement(By.id("loginButton")).click();
    }

    @Test
    public void viewMySchedules () {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.get(url);

        this.loginAsAdmin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.urlContains("/user/submit_tt.do"));

        driver.findElement(By.className("productSwitcher")).click();
    }

}