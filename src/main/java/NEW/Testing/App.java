package NEW.Testing;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import capture.capture;
import CRM.CLIENT.client;

import java.text.SimpleDateFormat;
import java.util.Date;

public class App {
    public static void main(String[] args) throws InterruptedException {
    	
        String date = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String maDate ="Rapport" + date + ".html";
        
        ExtentReports extent = new ExtentReports();
    	ExtentSparkReporter test = new ExtentSparkReporter(maDate);
    	extent.attachReporter(test);
    	ExtentTest t = extent.createTest("connexion");
    	
    	 FirefoxOptions options = new FirefoxOptions();
    	 options.addArguments("--headless");
    	
    	WebDriver driver = new FirefoxDriver(options);
    	driver.get("http://kpip.kprimesoft.com/");
   
    	try {
    		
    		WebElement Email = driver.findElement(By.name("email"));
        	Email.sendKeys("kpipemail+arthur@gmail.com");
        	
        	WebElement Pass = driver.findElement(By.name("password"));
        	Pass.sendKeys("@Kprime228");
        	
            Thread.sleep(3000);
        	WebElement Button = driver.findElement(By.className("btn"));
        	Button.click();
        	 capture.screen(driver, "test.png");
        	 t.pass("test de connexion reussit!").addScreenCaptureFromPath("test.png");
    	}
    	catch(Exception e) {
    		t.fail("test de connexion reussit!");
    	}
    	client.run(driver,extent);
    	 extent.flush();
    }
   
    
   
}
