package core;

import java.io.IOException;

public class Program 
{

	public static void main(String[] args) 
	{
		try
		{
			Solver.calculateAreaOfIntegrateUsingTrapezoids();
		} catch (NumberFormatException | IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	public static void print(Object input, Object... args) 
	{
		System.out.println(Converter.format(Converter.stringify(input), args));
	}

}