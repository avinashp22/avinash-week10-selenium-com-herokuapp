/**
 *1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Enter the email to email field.
 * 7. Enter the password to password field.
 * 8. Click on Login Button.
 * 9. Print the current url.
 * 10. Refresh the page.
 * 11. Close the browser.
 *
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ComHerokuapp {


    static String browser = "firefox"; // choose browser
    static WebDriver driver; // declare globally

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }

        String baseURL = "http://the-internet.herokuapp.com/login"; // set base url
        driver.get(baseURL);  // get base url
        driver.manage().window().maximize(); // maximise the window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //give implicit wait to driver

        System.out.println(driver.getTitle()); // print tile
        System.out.println(driver.getCurrentUrl()); // print current url
        System.out.println(driver.getPageSource()); // print page source

        WebElement email = driver.findElement(By.id("username"));    //find email field and enter email by ID
        email.sendKeys("tomsmith");   // type into box, action

        WebElement password = driver.findElement(By.id("password"));       //find password field and enter password by ID
        password.sendKeys("SuperSecretPassword!");    // type into box, action

       // NOT WORKNIG -  WebElement loginLink = driver.findElement(By.className("fa fa-2x fa-sign-in")); // hover to login button
        // NOT WORKNIG - loginLink.click(); // click on link

        // NOT WORKNIG - WebElement loginLink2 = driver.findElement(By.linkText(" Login")); // hover to login button
        // NOT WORKNIG - loginLink2.click(); // click on link

        WebElement loginLink2 = driver.findElement(By.xpath("//*[@id=\"login\"]/button/i")); // hover to login button
        loginLink2.click(); // click on link

        System.out.println(driver.getCurrentUrl()); // print current url

        driver.navigate().refresh(); // refresh url

        driver.quit();  // close browser
    }
}


