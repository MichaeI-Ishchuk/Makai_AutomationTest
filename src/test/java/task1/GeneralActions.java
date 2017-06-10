package task1;




import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.SourceType;
import task1.utils.Properties;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {
    private WebDriver driver;
    private WebDriverWait wait;
    private int i=0;

    private  By dataCheck = By.cssSelector(".calendar-cont");
    private  By nextMonth = By.cssSelector(".ui-datepicker-next.ui-corner-all");
    private  By dateIn = By.xpath("//a[@class=\"ui-state-default\" and text()=\"7\"]");
    private  By dateOut = By.xpath("//a[@class=\"ui-state-default\" and text()=\"15\"]");

    private  By dataCheck2 = By.cssSelector(".calendar_field");
    private  By nextMonth2 = By.cssSelector(".ui-datepicker-next.ui-corner-all");

    public List<String> list = new ArrayList<>();

    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);

    }


    public void urlCheck(String url,String fileName) throws Exception {

        driver.navigate().to(url);

        getscreenshot(fileName);



    }
    public void urlCheckByData(String url,String fileName) throws Exception {

        driver.navigate().to(url);
        waitForContentLoad(dataCheck);
        List<WebElement> list = driver.findElements(this.dataCheck);
        WebElement chechIn = list.get(0);
        chechIn.click();
        WebElement nextMonth = driver.findElement(this.nextMonth);
        nextMonth.click();
        WebElement dateIn = driver.findElement(this.dateIn);
        dateIn.click();
        waitForContentLoad(dateOut);
        WebElement dateOut = driver.findElement(this.dateOut);
        dateOut.click();
        getscreenshot(fileName);

      }

    public void urlCheckOtherByData(String url,String fileName) throws Exception {

        driver.navigate().to(url);
        waitForContentLoad(dataCheck2);
        List<WebElement> list = driver.findElements(this.dataCheck2);
        WebElement chechIn = list.get(0);
        chechIn.click();
        WebElement nextMonth = driver.findElement(this.nextMonth2);
        nextMonth.click();
        WebElement dateIn = driver.findElement(this.dateIn);
        dateIn.click();
        waitForContentLoad(dateOut);
        WebElement dateOut = driver.findElement(this.dateOut);
        dateOut.click();
        getscreenshot(fileName);

    }


    /**
     * Waits until page loader disappears from the page
     */
    public void waitForContentLoad(By locator) {

        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void getscreenshot(String fileName) throws Exception
    {
        list.add((driver.manage().window().getSize()).toString());
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            if (i==1) {int size=fileName.length();
            fileName=fileName.substring(0,size-4)+i+".png";

        }

        FileUtils.copyFile(scrFile, new File(fileName));
        i++;
    }
}
