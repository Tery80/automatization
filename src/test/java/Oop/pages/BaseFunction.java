package Oop.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseFunction {
    private WebDriver driver;
    String HOME_PAGE = "delfi.lv";
    private WebDriverWait wait;
    public BaseFunction(){
        System.setProperty("webdriver.chrome.driver", "c:/temp/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,10);
    }

    public void openUrl(String url) {
        if ((!url.startsWith("http"))&&(!url.startsWith("https"))){
            url = "https" + url;
        }
        driver.get(url);
    }

    public List<WebElement> getElementList(By locator){
        // Logger
        // check for empty list

        return driver.findElements(locator);
    }

    public WebElement getElement(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    private Integer convertCommentsToInt(String commentCountString) {
        String commentCountStr = commentCountString.replaceAll("[()]", "");
        return Integer.parseInt(commentCountStr);
    }
    public void openHomePage(){
        openUrl(HOME_PAGE);
    }
    public void click (WebElement webElement){
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public void closeWebPage(){
        driver.quit();
    }
}