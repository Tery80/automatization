import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DelfiPrintAllArticles {
    //print at console all articles

    private final By HOME_PAGE_ARTICLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final Logger LOGGER = LogManager.getLogger(DelfiPrintAllArticles.class);

    @Test
    public void delfiFirstTest() {
        System.setProperty("webdriver.chrome.driver", "d:/temp/chromedriver.exe");
        LOGGER.info("Open windows");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        LOGGER.info("Opening Delfi page");
        driver.get("https://rus.delfi.lv/");


        List<WebElement> articles = driver.findElements(HOME_PAGE_ARTICLE);
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getText().length() != 0)
                System.out.println(i + ": " + articles.get(i).getText());
        }
        driver.quit();
    }
}