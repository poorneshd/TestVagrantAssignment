package stepDefinition;

import io.restassured.path.json.JsonPath;

public class reusableMethods {

	

	
		
		public static JsonPath rawToJson(String Response) {
			
			JsonPath js = new JsonPath(Response);
			
			return js;
		}

		public static double kelvinToCelcius(Float mainTemp) {
			
			
			
		double	tempCelcius= mainTemp-273.15;
		
		return tempCelcius;
			
			
		}
		
		public static String holdCityName() {
			
			String cityName="Patna";
			
			
			return cityName;
			
		}
	}


