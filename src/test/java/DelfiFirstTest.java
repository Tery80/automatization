import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class DelfiFirstTest {
    private final By HOME_PAGE_ARTICLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By PAGE_ARTICLE = By.xpath(".//h1[contains(@class,'d-inline')]");
    private final By PAGE_ARTICLE_COMMENT = By.xpath("//div[contains(@class,'article-title')]/a");
    private final By PAGE_COMMENTS_TITLE = By.xpath("//h1[@class='article-title']");
    @Test
    public void delfiFirstTest() {
        System.setProperty("webdriver.chrome.driver", "d:/temp/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://rus.delfi.lv/");
        List<WebElement> firstArticleTitleList = driver.findElements(HOME_PAGE_ARTICLE);
        String firstArticleTitleText = firstArticleTitleList.get(1).getText();
        firstArticleTitleList.get(1).click();
        WebElement articleTitle = driver.findElement(PAGE_ARTICLE);

        String articleTitleText = articleTitle.getText();
        WebElement articlePageComments = driver.findElement(PAGE_ARTICLE_COMMENT);
        articlePageComments.click();

        WebElement commentsPageTitle = driver.findElement(PAGE_COMMENTS_TITLE) ;
        String commentsTitleText = commentsPageTitle.getText();

        Assertions.assertEquals(firstArticleTitleText, articleTitleText, "titles first page and article page are not equals");
        Assertions.assertEquals(firstArticleTitleText,commentsTitleText, "titles first page and comment page are not equals");
        Assertions.assertEquals(articleTitleText,commentsTitleText, "titles article page and comment page are not equals");
        driver.quit();
    }
}
