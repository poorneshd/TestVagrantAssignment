package stepDefinition;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class getWeatherNDTV {
	
	
//String cityName;

String TemperatureWeb;
public ErrorCollector error = new ErrorCollector(); 

	
	public  String getWeather() {
		
		String Temp=null;
		String onMap = null;
        //this.cityName="Alwar";
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.ndtv.com/");
		
		driver.findElement(By.linkText("INDIA")).click();
		
		driver.manage().window().maximize();
		
		//String alt=driver.switchTo().window(nameOrHandle)
		
		//System.out.println(alt);
		
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
	String subWindowHandler = null;

	Set<String> handles = driver.getWindowHandles(); // get all window handles
	Iterator<String> iterator = handles.iterator();
	while (iterator.hasNext()){
	    subWindowHandler = iterator.next();
	}
	driver.switchTo().window(subWindowHandler); // switch to popup window

	// Now you are in the popup window, perform necessary actions here
	
	driver.findElement(By.linkText("No Thanks")).click();

	driver.switchTo().window(parentWindowHandler);
	
	
	//driver.getWindowHandle();
	
	//System.out.println(handle);
		
	driver.findElement(By.id("topnav_section")).click();
		
	driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div[1]/div[4]/ul[5]/li[4]/a")).click();
	
	driver.findElement(By.id("searchBox")).sendKeys(reusableMethods.holdCityName());
	
	
	driver.findElement(By.id("searchBox")).sendKeys(Keys.ENTER);
	
	        
	
WebElement city	=driver.findElement(By.id(reusableMethods.holdCityName()));



if(!city.isSelected())
city.click();


driver.findElement(By.id("searchBox")).sendKeys(Keys.ENTER);




List<WebElement> cityNames = driver.findElements(By.className("cityText"));

///System.out.println(cityNames.size());



for(int i=0;i<cityNames.size();i++) {
	
	
	if(cityNames.get(i).getText().equalsIgnoreCase(reusableMethods.holdCityName()))
	{
		
		 onMap = cityNames.get(i).getText();
		
		
		
		break;
		
		
	}
}

try {
Assert.assertEquals(onMap, reusableMethods.holdCityName());

//System.out.println("Assertion Passed");
}

catch(Throwable t) {
	
	System.out.println("On Map Validation Assertion failed");
	
	error.addError(t);
}


		
Temp=driver.findElement(By.xpath("//*[@class='outerContainer' and @title='" + reusableMethods.holdCityName()+ "']/div[1]/span[1]")).getText();

TemperatureWeb= Temp.substring(0, 2);

//System.out.println(this.TemperatureWeb);
		
		return TemperatureWeb;
		
		
		
		
	}

}
