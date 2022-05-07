package core;

import java.util.ArrayList;

public class Tools
{
	
	public static ArrayList<Double> parseLineToArrayOfDoubles(String input)
	{
		String[] split = input.split(" ");
		
		ArrayList<Double> output = new ArrayList<Double>();
		for(String s: split)
		{
			output.add(Double.parseDouble(s)); //TODO obsługa wyjątków
		}

		return output;
	}
	
	
	public static double absoluteValueOf(double x)
	{
		return x * ( x > 0 ? 1 : -1 );
	}
	
}
