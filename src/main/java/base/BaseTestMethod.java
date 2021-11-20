package base;


import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import io.cucumber.plugin.event.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class BaseTestMethod {

    private String url = Driver.readToDriverProperties("url");


    private WebDriver driver;
    @BeforeClass
    public void beforeTest() {
        driver = Driver.getDriver("chromeDriver");
        driver.manage().window().maximize();
        driver.navigate().to(url);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
    }

    @AfterClass
    public void afterTest(Scenario scenario,String bankaAdi){
        try {
            if(scenario.getStatus()!= Status.PASSED){
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                LocalDateTime myDateObj = LocalDateTime.now();
                System.out.println("Before formatting: " + myDateObj);
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
                FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"/fail_scenario_screenshots/"+driver.getTitle().toLowerCase()+myDateObj.format(myFormatObj)+".png"), true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            driver=Driver.closeDriver();
        }
    }
}
