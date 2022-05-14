package core;

import java.util.ArrayList;
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
	
	public Polynominal getDerivative()
	{
		Polynominal pol = new Polynominal();

		for(int power: content.keySet())
		{
			if(power!=0) pol.addExpression(power - 1, this.content.get(power) * power);
		}
		
		return pol;
	}
	
	public static Polynominal simpleInterpret(ArrayList<Double> input)
	{
		Polynominal pol = new Polynominal();
		
		for(int i = 0; i < input.size(); i++)
		{
			pol.addExpression(input.size() - 1 - i, input.get(i));
		}
		
		return pol;
	}
	
	@Override
	public String toString()
	{
		String output = "";
		
		ArrayList<String> outputs = new ArrayList<>();
		
		content.forEach((i,d) -> {outputs.add(d+"*x^"+i);});
		
		for(String s: outputs)
		{
			output += s+" + ";
		}
		
		return output.substring(0, output.length()-3);
	}
	
}
