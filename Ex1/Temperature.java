/******************************
ID: 204894281

Temperature.java
This java program receives a temperature type and the real temperature in that type,
and then calculates and prints the real temperature in Celsius, Fahrenheit and Kelvin.
*******************************/

import java.util.Scanner;
public class Temperature 
{

	public static void main(String[] args) 
	{
		//CONSTANT1/2 and ABSOLUTE_ZERO_IN_CELSIUS are used to convert between temperatures types(C,F,K)/
		//CONSTANT3 is used to round the final temperatures to two points after the dot.
		final double CONSTANT1 = 5.0/9.0;
		final double CONSTANT2 = 32;
		final double CONSTANT3 = 100;
		final double ABSOLUTE_ZERO_IN_CELSIUS = -273.15;
		String fullUserInput;
		char tempratureType; //From fullUserInput.
		double userTemperature; //From fullUserInput.
		double temperatureInCelsius, temperatureInFahrenheit, temperatureInKelvin; //variables to calculate.
		System.out.println("Choose a temperature type ('C','F','K'),");
		System.out.println("'C' for Celsius");
		System.out.println("'F' for Fahrenheit");
		System.out.println("'K' for Kelvin");
		System.out.println("click on the space key, and then enter the real tempereture and press ENTER: ");
		Scanner scan = new Scanner (System.in);
		fullUserInput = scan.next();
		tempratureType = fullUserInput.charAt(0);
		userTemperature = scan.nextDouble();
		if (tempratureType == 'C')
		{
			temperatureInCelsius = userTemperature;
			temperatureInKelvin = temperatureInCelsius - ABSOLUTE_ZERO_IN_CELSIUS;
			temperatureInFahrenheit = (temperatureInKelvin + ABSOLUTE_ZERO_IN_CELSIUS) / CONSTANT1 + CONSTANT2;
		}
		else if (tempratureType == 'F')
			{
				temperatureInFahrenheit = userTemperature;
				temperatureInCelsius = CONSTANT1 * (temperatureInFahrenheit - CONSTANT2);
				temperatureInKelvin = temperatureInCelsius - ABSOLUTE_ZERO_IN_CELSIUS;
			}
			else
			{
				temperatureInKelvin = userTemperature;
				temperatureInFahrenheit = (temperatureInKelvin + ABSOLUTE_ZERO_IN_CELSIUS) / CONSTANT1 + CONSTANT2;
				temperatureInCelsius = CONSTANT1 * (temperatureInFahrenheit - CONSTANT2);
			}
		System.out.println(Math.round(temperatureInCelsius * CONSTANT3) / CONSTANT3 + " C"); 
		System.out.println(Math.round(temperatureInFahrenheit * CONSTANT3) / CONSTANT3 + " F");
		System.out.println(Math.round(temperatureInKelvin * CONSTANT3) / CONSTANT3 + " K");
		// all temperatures are rounded to 2 points after the dot.
	} // end of method main
} //end of class Temperature
