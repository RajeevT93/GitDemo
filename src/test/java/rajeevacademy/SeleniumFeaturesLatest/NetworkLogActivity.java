package rajeevacademy.SeleniumFeaturesLatest;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v109.network.Network;
import org.openqa.selenium.devtools.v109.network.model.Request;
import org.openqa.selenium.devtools.v109.network.model.Response;

public class NetworkLogActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Sanjeev Patel\\Downloads\\chromedriver\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		
		
		
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty())); //Based on chrome version
		
		
		devTools.addListener(Network.requestWillBeSent(), request -> 
		{
			
			Request req = request.getRequest();
			//System.out.println(req.getUrl());
		});                 //Request will be sent once page is sent http request
		
		//Events will get fired 
		devTools.addListener(Network.responseReceived(), response -> 
		{
			Response resp = response.getResponse();
			//System.out.println(resp.getUrl());
			
			if(resp.getStatus().toString().startsWith("4")) {
			System.out.println(resp.getUrl()+"is failing with code" +resp.getStatus());
		}
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*=\"library\"]")).click();

	}

}
