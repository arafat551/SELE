package CRM.CLIENT;

import capture.capture;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;



public class client {
	public static void run(WebDriver driver, ExtentReports extent) throws InterruptedException {
    	ExtentTest t = extent.createTest("app");
    	
		  driver.get("https://kpip.kprimesoft.com/crm/clients");
		  try {
			  WebElement Ajouer = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/div[4]/div/div[1]/div/div[3]/a[1]"));
			  Thread.sleep(3000);
			  Ajouer.click();
			  
			  WebElement IDS = driver.findElement(By.id("generate_client_id"));
			  IDS.click();
			  
			  WebElement Type_client = driver.findElement(By.xpath("//*[@id=\"client_type\"]"));
			  Type_client.sendKeys("Gonvernement");
			  
			  
			  WebElement Nom = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/form/div[2]/div/div[1]/div[2]/div[1]/div/span"));
			  Nom.click();
			  
			  WebElement Noms = driver.findElement(By.xpath("/html/body/span/span/span[1]/input"));
			  Noms.sendKeys("ALI");
			  Thread.sleep(800);
			  WebElement Nomss = driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li"));
			  Nomss.click();

			  
			  WebElement Address = driver.findElement(By.xpath("//*[@id=\"client_address\"]"));
			  Address.sendKeys("TOGO");
			  
			  WebElement Ville = driver.findElement(By.xpath("//*[@id=\"client_city\"]"));
			  Ville.sendKeys("LOME");
			  
			  WebElement state = driver.findElement(By.xpath("//*[@id=\"client_state\"]"));
			  state.sendKeys("LOME");
			  
			  WebElement Code = driver.findElement(By.xpath("//*[@id=\"client_zip_code\"]"));
			  Code.sendKeys("BP10011");
			  
			  WebElement Pays = driver.findElement(By.xpath("//*[@id=\"client_country\"]"));
			  Pays.sendKeys("Togo");
			  Pays.click();
			 
			  WebElement Nom_contact = driver.findElement(By.xpath("//*[@id=\"client_contact_full_name\"]"));
			  Nom_contact.sendKeys("RAF KONDI");
			  
			  WebElement Tel = driver.findElement(By.xpath("//*[@id=\"client_contact_phone_number\"]"));
			  Tel.sendKeys("97037083");
			  
			  WebElement Email = driver.findElement(By.xpath("//*[@id=\"client_contact_email\"]"));
			  Email.sendKeys("kondi@gmail.com");
			  
			  WebElement Gv = driver.findElement(By.xpath("//*[@id=\"client_government_dept\"]"));
			  Gv.sendKeys("Togolais");
			  
			  WebElement button = driver.findElement(By.cssSelector("#add_clients > div:nth-child(4) > button:nth-child(2)"));
			  button.click();
			  
			  Thread.sleep(3000);
				capture.screen(driver ,"client.png");
		    	t.pass("tout va bien").addScreenCaptureFromPath("client.png");
		  }
		  catch(Exception e) {
			  t.fail("tout va pas  bien du tout ");
		  }
		  
		 
		  extent.flush();
		   
		 driver.quit();
		 
		  
	}
}
