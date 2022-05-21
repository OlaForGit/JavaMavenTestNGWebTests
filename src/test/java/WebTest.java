import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class WebTest {
    //Test case:
    //1. Open page https://www.99-bottles-of-beer.net/
    //2. Click on BrowseLanguages
    //3. Click on Start
    //4. Verify that user see "Welcome to 99 Bottles of Beer"
    //5. Close Browser

    @Test
    public void testMenuStartTitle() throws InterruptedException {
        //Это подготовительная часть
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Applications/ChromeDriver/chromedriver";
        String url = "https://www.99-bottles-of-beer.net/";
        String expectedResult = "Welcome to 99 Bottles of Beer";
        //expectedResult прописывается в первой части

        //ЭТО ПРЕДВАРИТЕЛЬНАЯ ПОДГОТОВКА К ТЕСТУ
        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        //ЭТО САМИ ТЕСТЫ
        driver.get(url); //это как переходить на страницу
        WebElement menuBrowseLanguages = driver.findElement( //это как искать элемент
                By.xpath(
                    "//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/abc.html']")
        );

        menuBrowseLanguages.click(); //это как кликать на элемент
        sleep(3000); //убирать перед отправкой в гит

        WebElement menuStart = driver.findElement(
                By.xpath(
                    "//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/']")
        );
        menuStart.click();
        sleep(3000); //убирать перед отправкой в гит

        WebElement h2 = driver.findElement(
                By.xpath(
                    "//body/div[@id='wrap']/div[@id='main']/h2")
        );
        String actualResult = h2.getText();//это как считывать текст

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit(); //закрывает пустые страницы

        //Никаких комментариев в ГИТ!!!
    }
}
