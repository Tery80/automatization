package Oop.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseFunction {
    private WebDriver driver;

    public BaseFunction(){
        System.setProperty("webdriver.chrome.driver", "c:/temp/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public List<WebElement> getElementList(By locator){
        return driver.findElements(locator);
    }

    public WebElement getElement(By locator){
        return driver.findElement(locator);
    }

    private Integer convertCommentsToInt(String commentCountString) {
        String commentCountStr = commentCountString.replaceAll("[()]", "");
        return Integer.parseInt(commentCountStr);
    }

    public void closeWebPage(){
        driver.quit();
    }
}