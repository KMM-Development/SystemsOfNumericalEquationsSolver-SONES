package core;

import java.io.IOException;

import numericMethod.CalculatingDeterminantOfAMatrix;
import numericMethod.FindingAZeroPositionUsingIncisalMethod;
import numericMethod.FindingAZeroPositionUsingNewtonMethod;
import numericMethod.NumericalMethod;
import numericMethod.SolvingASystemOfNumericalEquations;
import numericMethod.UsingTrapeziodsToCalculateAreaOfIntegrate;

public class Program 
{

	public static void main(String[] args) 
	{
		try
		{
			NumericalMethod n = new CalculatingDeterminantOfAMatrix();
			n.begin();
		} 
		catch (Exception e)
		{
			print("Something caught in main");
			e.printStackTrace();
		}
		
	}
		
	public static void print(Object input, Object... args) 
	{
		System.out.println(Converter.format(Converter.stringify(input), args));
	}

}