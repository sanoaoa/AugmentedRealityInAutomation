package utility;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class AllMyUtilities {
	public static WebDriver driver;
	Screen screen = new Screen();
	
public void setUp() throws InterruptedException, FindFailed {
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
	driver.get("https://chrome.google.com/webstore/detail/katalon-recorder-selenium/ljdobmomdgdljniojadhoplhkpialdid");
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.findElement(By.xpath("(//*[@aria-label=\"Add to Chrome\"])[1]")).click();
	Thread.sleep(2000);
	String secondaryWindow = driver.getTitle();
	
	Pattern addExtension = new Pattern(System.getProperty("user.dir")+"//DesignDocs//Config//addExtension.PNG");
	Pattern katalonIcon = new Pattern(System.getProperty("user.dir")+"//DesignDocs//Config//kataLonLaunchIcon.PNG");
	Pattern recordBtn = new Pattern(System.getProperty("user.dir")+"//DesignDocs//Config//recordBtn.PNG");
	
	
	
	screen.click(addExtension);
	//Thread.sleep(8000);
	//System.out.println("first wait");
	//driver.get(baseURL);
	//System.out.println(driver.getTitle());
	
	//Thread.sleep(8000);
	//System.out.println("2nd wait");
	
	for(int i=0;i<=100;i++) {
		Set <String> st = driver.getWindowHandles();
		System.out.println("no of window " +st.size());
			if(st.size()==2) {
				Iterator<String> it = st.iterator();
				String parent = it.next();
				String child = it.next();
				driver.switchTo().window(child);
				break;
				}else {
					System.out.println("in loop "+i);
				Thread.sleep(2000);
		}
	}
	
	
	System.out.println("Child Window title: " +driver.getTitle());
	screen.click(katalonIcon);
	Thread.sleep(2000);
	screen.click(recordBtn);
	Thread.sleep(2000);
	}

public void pageScroll() throws InterruptedException {
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,600)");
	Thread.sleep(2000);
	
}

public void KatalonOperation() throws FindFailed {
	Pattern KatalonInWindowTray = new Pattern(System.getProperty("user.dir")+"//DesignDocs//Config//KatalonInWindowTray.PNG");
	Pattern Stop = new Pattern(System.getProperty("user.dir")+"//DesignDocs//Config//Stop.PNG");
	Pattern Export = new Pattern(System.getProperty("user.dir")+"//DesignDocs//Config//Export.PNG");
	
	Pattern DropDown = new Pattern(System.getProperty("user.dir")+"//DesignDocs//Config//SelectLanguageDropDown.PNG");
	Pattern SelectLanguage = new Pattern(System.getProperty("user.dir")+"//DesignDocs//Config//JavaWebDriverTestNG.PNG");
	Pattern SaveAsFile = new Pattern(System.getProperty("user.dir")+"//DesignDocs//Config//SaveAsFile.PNG");
	
	

	screen.click(KatalonInWindowTray);
	screen.click(Stop);
	screen.click(Export);
	screen.click(DropDown);
	screen.click(SelectLanguage);
	screen.click(SaveAsFile);
}

public void saveTheScript(String filePath) throws FindFailed, InterruptedException {
	
	Pattern SaveToLocation = new Pattern(System.getProperty("user.dir")+"//DesignDocs//Config//SaveToLocation.PNG");
	Pattern SaveButton = new Pattern(System.getProperty("user.dir")+"//DesignDocs//Config//SaveToLocationButton.PNG");
	
	
	screen.click(SaveToLocation); //click on the filepath bar
	screen.type("a", KeyModifier.CTRL); //select all text
	screen.type(Key.BACKSPACE); //type backspace to clear content
	screen.type(filePath);
	screen.type(Key.ENTER);
	screen.type("NewScript");
	Thread.sleep(8000);
	
	
	screen.click(SaveButton);
	
	
}

}

