import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class N11_UrunEkleme {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testN11Scenario() throws InterruptedException {
        driver.get("https://www.n11.com");

        String expectedPageTitle = "n11 - 10 Üzerinden 11'lik Alışveriş Deneyimi";
        String actualPageTitle = driver.getTitle();

        Assert.assertEquals(expectedPageTitle, actualPageTitle);

        WebElement aranacakUrun = driver.findElement(By.id("searchData"));
        aranacakUrun.sendKeys("Samsung S23 Ultra", Keys.ENTER);

        String aramaSonucu = driver.findElement(By.className("resultText")).getText();
        System.out.println("aramaSonucu = " + aramaSonucu);
        String expectedResultText = "Samsung S23 Ultra için 2,299 sonuç bulundu.";
        System.out.println("aramaSonucu = " + aramaSonucu + "expectedResultText = " + expectedResultText);
        Assert.assertEquals(expectedResultText, aramaSonucu);
        System.out.println("expectedResultText = " + expectedResultText);

        Thread.sleep(2000);
        driver.navigate().back();

        Thread.sleep(2000);
        driver.navigate().forward();

    }


}
