package core;

import java.util.ArrayList;
import java.util.Arrays;

import numericMethod.CalculatingTheDeterminantOfAMatrix;
import numericMethod.FindingAZeroPositionUsingIncisalMethod;
import numericMethod.FindingAZeroPositionUsingNewtonMethod;
import numericMethod.NumericalMethod;
import numericMethod.SolvingASystemOfNumericalEquations;
import numericMethod.CalculatingPolynominalIntegralUsingTrapeziods;

public class Program 
{

	private static String buildMenuString(ArrayList<NumericalMethod> methods)
	{
		String 
			menuOutput = Tools.DOUBLE_BELT+"\n";
		
		int index = 0;
		
		for(NumericalMethod method: methods)
		{
			menuOutput += String.format("%d.%s\n", ++index, method.getReadableClassNameAsSentence());
		}
		
		menuOutput += "0. Exit.\n"+Tools.DOUBLE_BELT+"\nYour choice: ";
		
		return menuOutput;
	}
	
	public static void main(String[] args) 
	{
		try
		{
			while(true) {
				Tools.clearScreen();
				
				ArrayList<NumericalMethod> methods = 
				new ArrayList<>(
					Arrays.asList(
						new CalculatingTheDeterminantOfAMatrix(),
						new FindingAZeroPositionUsingIncisalMethod(),
						new FindingAZeroPositionUsingNewtonMethod(),
						new SolvingASystemOfNumericalEquations(),
						new CalculatingPolynominalIntegralUsingTrapeziods()
					)
				);					
						
				int choice = Tools.requestInteger(buildMenuString(methods), 0, methods.size());
				
				if(choice == 0) 
					System.exit(0);
				else 
					methods.get(choice-1).safeBegin();
				
				Tools.requestEnter();
			}
		} 
		catch (Exception e)
		{
			print("Unexpected exception caught in main.");
			e.printStackTrace();
		}
		
	}
		
	public static void print(Object input, Object... args) 
	{
		System.out.println(
			Tools.format(
				Tools.stringify(input), 
				args
			)
		);
	}

}