package rajeevacademy.SeleniumFeaturesLatest;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v109.emulation.Emulation;

public class SetGeoLocation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Sanjeev Patel\\Downloads\\chromedriver\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		//Map <String, Object> coordinates = new HashMap <String, Object> ();
		//coordinates.put("latitude", 40);
		//coordinates.put("longitude",3);
		//coordinates.put("accuracy", 1);
		//driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		devTools.send(Emulation.setGeolocationOverride(Optional.of(40),Optional.of(3),Optional.of(1)));
		//driver.get("https://www.google.com/");
		//driver.findElement(By.name("q")).sendKeys("hotels nearby",Keys.ENTER);
		driver.get("https://mylocation.org/");
		//Thread.sleep(5000);
		//driver.findElements(By.cssSelector(".A9xod")).get(0).click();
		//String text = driver.findElements(By.cssSelector(".ejqbulh8")).get(0).getText();
		//System.out.println(text);
	}


}
