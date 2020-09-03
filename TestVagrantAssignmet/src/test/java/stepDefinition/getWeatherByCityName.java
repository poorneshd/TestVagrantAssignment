package stepDefinition;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.junit.Test;

public class getWeatherByCityName {
	
	double temperature;
	
	
	
	
	public double getWeather() {
		
		
		
		RestAssured.baseURI="http://api.openweathermap.org";
		
String Response	=	given().queryParam("q",reusableMethods.holdCityName()).queryParam("appid","7fe67bf08c80ded756e598d6f8fedaea")
		.when().get("/data/2.5/weather").then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js1 = reusableMethods.rawToJson(Response);
		
		Float mainTemp= js1.get("main.temp");
		
		
		
		
		
		
		
		temperature = Math.round(reusableMethods.kelvinToCelcius(mainTemp));
		
		//System.out.println(mainTemp);
		
//		System.out.println(temperature);
		return temperature;
	}

}
