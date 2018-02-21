import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RstTest {
    private WebDriver webDriver;
    private WebDriverWait wait;



    @BeforeTest
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        wait = new WebDriverWait(webDriver,60);
    }

    @Test
    public void auth() {
        webDriver.get("http://rst.ua/signin/");
        //Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='rst-signin-username']")));
        webDriver.findElement(By.xpath(".//*[@id='rst-signin-username']")).sendKeys("mr.michailstepanov@gmail.com");
        webDriver.findElement(By.xpath(".//*[@id='rst-signin-password']")).sendKeys("Stepanov132652");
        webDriver.findElement(By.xpath(".//*[@id='rst-signin']/article/table/tbody/tr[6]/td/button")).click();
    }

    @Test
    public void update() throws InterruptedException {

        webDriver.findElement(By.xpath(".//*[@id='oldcars-item-list']/div[3]/div[2]/div[1]/a")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" .//*[@id='rst-user-btn-update-free']")));
        webDriver.findElement(By.xpath(" .//*[@id='rst-user-btn-update-free']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='oldcars-item-list']/div[3]/div[2]/div[1]/a")));
        webDriver.findElement(By.xpath(".//*[@id='oldcars-item-list']/div[3]/div[2]/div[1]/a")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" .//*[@id='rst-user-btn-update-free']")));
        webDriver.findElement(By.xpath(" .//*[@id='rst-user-btn-update-free']")).click();


    }
    @After
    public void tearDown() {
        webDriver.quit();
    }
}
