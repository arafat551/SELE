package NEW.Testing;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import capture.capture;
import CRM.CLIENT.client;


public class App {
    public static void main(String[] args) throws InterruptedException {
    	ExtentReports extent = new ExtentReports();
    	ExtentSparkReporter test = new ExtentSparkReporter("Rapport.htm");
    	extent.attachReporter(test);
    	ExtentTest t = extent.createTest("connexion");
    	
    	WebDriver driver = new FirefoxDriver();
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
