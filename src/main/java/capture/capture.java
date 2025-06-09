package capture;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import java.io.File;
import org.openqa.selenium.WebDriver;

public class capture {
	public static void screen(WebDriver driver, String filename) {
		File screenshoot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	screenshoot.renameTo(new File ( "cap", filename) );
		
	}

}
