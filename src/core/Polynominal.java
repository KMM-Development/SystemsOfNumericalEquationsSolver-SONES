package core;

import java.util.HashMap;

public class Polynominal
{
	private HashMap<Integer, Double> content = new HashMap<>();
	
	public void addExpression(int powerOfX, double numberNextToX)
	{
		content.compute(powerOfX, (P,N) -> (N==null)? numberNextToX : N+numberNextToX );
	}
	
	public double valueAtX(double x)
	{
		double output = 0;
		for(int power: content.keySet())
		{
			output += content.get(power) * Math.pow(x, power);
		}
		
		
		return output;
	}
	
	
	
	public static Polynominal simpleInterpret(String line)
	{
		String[] split = line.split(" ");
		
		Polynominal pol = new Polynominal();
		
		for(int i = 0; i < split.length; i++)
		{
			pol.addExpression(split.length - 1 - i, Double.parseDouble(split[i]));
		}
		
		return pol;
	}
}
