package stepDefinition;

import org.junit.Test;
import org.testng.Assert;

public class weatherComparator {
	
	
	
	
	
	@Test

	public  static void main(String[]Args)
	
	{
		
		
	  getWeatherByCityName api = new getWeatherByCityName();
	  
	  getWeatherNDTV web = new getWeatherNDTV();
	  
	  
	 int tempWeb = Integer.parseInt(web.getWeather());
	 
	 int tempApi = (int)api.getWeather();
	
	  
	  //String tempNDTV = web.TemperatureWeb;
	  
	 System.out.println("Temperature from NDTV WebPage is" + " " + tempWeb);
	 
	 System.out.println("Temperature from API is" + " " + tempApi);
	 
	 if(tempWeb < tempApi)
	 {
		 
	 
	 
	 int variance =(tempApi-tempWeb) ;
	  
	  
	 
	  if(variance <= 2) 
	  {
		  
		  System.out.println("Temperature from Web and API matches with acceptable variance of" + " " + variance);
		  
	  } 
	  
	 // System.out.println("Temperature from Web and API matches");

	  else
	  {
		  
		  System.out.println("Temperature from Web and API doest not matches variance is out of acceptable" + " " + variance);
		  
	  } 
	  
	 
	 }
	 else {
		 
		 int variance =(tempWeb - tempApi) ;
		  
		  
		 
		  if(variance <= 2) 
		  {
			  
			  System.out.println("Temperature from Web and API matches with acceptable variance of" + " " + variance);
			  
		  } 
		  
		 // System.out.println("Temperature from Web and API matches");

		  else
		  {
			  
			  System.out.println("Temperature from Web and API doest not matches variance is out of acceptable" + " " + variance);
			  
		  } 

	 }	 
		
	}

}
