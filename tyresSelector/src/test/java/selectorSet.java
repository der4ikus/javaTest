import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class selectorSet {
    static WebDriver driver = new ChromeDriver();
//    static WebDriverWait wait =new WebDriverWait(driver, 10, 10);

    @BeforeTest
    public void setUp() {
//        WebDriverWait wait =new WebDriverWait(driver, 10, 10);
    }

    public static void main(String[] args) throws InterruptedException {
        driver.get("https://www.buycarparts.co.uk/tyres");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        checkSelector();
    }

    @Test
    public static void checkSelector() throws InterruptedException {
        By Season = By.xpath(".//*[@id='form_Season']/option");
        By Width = By.xpath(".//*[@id='form_Width']/option");
        By Height = By.xpath(".//*[@id='form_CrossSections']/option");
        By Diametr = By.xpath(".//*[@id='form_Size']/option");
        By searchBtn = By.xpath(".//*[@id='tyres_search']");
        By toBaskBtn = By.xpath(".//*[(contains(@class, 'basket_btn')) and not(contains(@class, 'not_active'))]");
        By basket= By.xpath(".//*[@id='cart_block_link']");


        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath(".//*[@id='form_Season']")).click();
        List<WebElement> myElement1 = driver.findElements(Season);
        for (WebElement e1 : myElement1) {
            TimeUnit.SECONDS.sleep(1);
            e1.click();

            TimeUnit.SECONDS.sleep(2);
            driver.findElement( By.xpath(".//*[@id='form_Width']")).click();
            List<WebElement> myElement2 = driver.findElements(Width);
            for (WebElement e2 : myElement2) {
                if (!e2.getAttribute("Value").contains("0")) {
                    System.out.println(e2.getAttribute("Value"));
                    TimeUnit.SECONDS.sleep(3);
                } else continue;
                e2.click();

                TimeUnit.SECONDS.sleep(3);

                driver.findElement( By.xpath(".//*[@id='form_CrossSections']")).click();
                List<WebElement> myElement3 = driver.findElements(Height);
                for (WebElement e3 : myElement3) {
                    if (!e3.getAttribute("Value").contains("0")) {
                        System.out.println(e3.getAttribute("Value"));
                        TimeUnit.SECONDS.sleep(3);
                    } else continue;
                    e3.click();
                    TimeUnit.SECONDS.sleep(3);


                    driver.findElement( By.xpath(".//*[@id='form_Size']")).click();
                    List<WebElement> myElement4 = driver.findElements(Diametr);
                    for (WebElement e4 : myElement4) {
                        if (!e4.getAttribute("Value").contains("0")) {
                            System.out.println(e4.getAttribute("Value"));
                            TimeUnit.SECONDS.sleep(3);
                        } else continue;
                        e4.click();
                        TimeUnit.SECONDS.sleep(3);
                        driver.findElement(By.xpath(".//*[@id='tyres_search']")).click();
                        String id = driver.findElement(toBaskBtn).getAttribute("id");
                        System.out.println("id is "+ id);
                        TimeUnit.SECONDS.sleep(3);
                        driver.findElement(toBaskBtn).click();
                        TimeUnit.SECONDS.sleep(3);
                        driver.findElement(basket).click();
                        TimeUnit.SECONDS.sleep(3);

                        String basketId = driver.findElement(By.xpath(".//*[@class='cart-page-listing']/table/tbody/tr[2]")).getAttribute("InnerHTML");

                        System.out.println(id);
                        System.out.println(basketId);
                        Assert.assertEquals(basketId,id);
                        System.out.println("Test passed, ID is "+ id);




                    }
                }
            }

        }


    }
}


