import com.sun.xml.internal.bind.v2.TODO;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.xml.bind.SchemaOutputResolver;

public class pkwRifen {
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
        webDriver.get("https://www.pkwteile.de");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='header']/div[3]/div/div[1]/div/span")));
        webDriver.findElement(By.xpath(".//*[@id='header']/div[3]/div/div[1]/div/span")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='login_panel']/div[1]")));
        webDriver.findElement(By.xpath(".//*[@id='login_top_email']")).sendKeys("reifenautotest@test.test");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".inp_text.clickr-target.fake_pass.frmClickr-enabled")));
        webDriver.findElement(By.cssSelector(".inp_text.clickr-target.fake_pass.frmClickr-enabled")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".inp_text.real_pass")));
        webDriver.findElement(By.cssSelector(".inp_text.real_pass")).sendKeys("000000");
        webDriver.findElement(By.xpath(".//*[@id='btn-login-top']/a")).click();
    }
    @Test
        public void addToBasketFromListing (){
        webDriver.get("https://www.pkwteile.de/reifen");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tyres_search']")));
        WebElement searchButton = webDriver.findElement(By.xpath(".//*[@id='tyres_search']"));
        searchButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='8113439']/a")));
        webDriver.findElement(By.xpath(".//*[@id='8113439']/a")).click();
        System.out.println("Add Tires was ok");
        Assert.assertEquals("REIFEN Suche - PKW Reifen günstig online kaufen direkt bei Autoreifen Shop",webDriver.getTitle());

        webDriver.get("https://www.pkwteile.de/reifen/offroadreifen");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tyres_search']")));
        searchButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='12736245']/a")));
        webDriver.findElement(By.xpath(".//*[@id='12736245']/a")).click();
        System.out.println("Add Tires  offroadreifen was ok");
        Assert.assertEquals("REIFEN Suche - Offroad/SUV Reifen günstig online kaufen direkt bei SUV & Offroadreifen Shop",webDriver.getTitle());


        webDriver.get("https://www.pkwteile.de/reifen/transporterreifen");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tyres_search']")));
        searchButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='8339881']/a")));
        webDriver.findElement(By.xpath(".//*[@id='8339881']/a")).click();
        System.out.println("Add Tires transporterreifen - was ok");
        Assert.assertEquals("REIFEN Suche - Transporter\n" +
                " Reifen günstig online kaufen direkt bei LLKW & Transporterreifen Shop",webDriver.getTitle());

        webDriver.get("https://www.pkwteile.de/reifen/motorradreifen");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tyres_search']")));
        searchButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='8089964']/a")));
        webDriver.findElement(By.xpath(".//*[@id='8089964']/a")).click();
        System.out.println("Add Tires motorradreifen- was ok");
        Assert.assertEquals("REIFEN Suche - Motorrad Reifen günstig online kaufen direkt bei Motorradreifen Shop",webDriver.getTitle());














    }
}