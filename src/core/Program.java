package core;

import java.io.IOException;

import normalnaNazwa.CalculatingDeterminantOfAMatrix;
import normalnaNazwa.FindingAZeroPositionUsingIncisalMethod;
import normalnaNazwa.FindingAZeroPositionUsingNewtonMethod;
import normalnaNazwa.NormalnaNazwa;
import normalnaNazwa.UsingTrapeziodsToCalculateAreaOfIntegrate;

public class Program 
{

	public static void main(String[] args) 
	{
		try
		{
			NormalnaNazwa n = new FindingAZeroPositionUsingIncisalMethod();
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