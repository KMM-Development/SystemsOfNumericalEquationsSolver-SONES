package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Tools
{
	
	private static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
	
	public static ArrayList<Double> parseLineToArrayOfDoubles(String input)
	{
		String[] split = input.trim().split(" ");
		
		ArrayList<Double> output = new ArrayList<Double>();
		for(String s: split)
		{
			output.add(Double.parseDouble(s)); //TODO obsługa wyjątków
		}

		return output;
	}
	
	public static ArrayList<Double> trimArrayToGivenSize(ArrayList<Double> input, int wantedSize)
	{
		if(input.size() == wantedSize) return input;
		
		ArrayList<Double> output = new ArrayList<>();
		for(int i = 0; i < wantedSize; i++)
		{
			output.add(input.get(i));
		}
		
		return output;
	}
	
	public static void clearScreen(){
		try 
		{
			if (System.getProperty("os.name").contains("Windows"))
			{
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			}
			else
			{
				Runtime.getRuntime().exec("clear");
			}
		}
		catch (Exception e) 
		{ 
			Program.print("Exception while trying to clear screen."); 
			e.printStackTrace(); 
		}
	}
	
	public static void requestEnter()
	{
		System.out.print("Press the ENTER key to continue.");
		try
		{
			consoleReader.readLine();
		} 
		catch (IOException e)
		{
			System.out.print("There was an unexpected I/O exception.");
		}
	}
	
	public static int requestInteger(String requestMessage, int minVal, int maxVal) throws IOException
	{
		int output = requestInteger(requestMessage);
		while(output < minVal || output > maxVal)
		{
			output = 
			requestInteger(
					"Number provided is out of the acceptable scope [%d-%d],\n"
				+	"please provide a correct number: ",
				minVal, maxVal
			);
		}
		return output;
	}
	
	public static int requestInteger(String requestMessage) throws IOException
	{
		System.out.print(requestMessage);
		
		String input = consoleReader.readLine().trim();
		
		int output;
		
		try
		{
			output = Integer.parseInt(input);
		}
		catch(NumberFormatException e)
		{
			Program.print("Your input was not an Integer (\"%s\")\n, please try again.", input);
			return requestInteger(requestMessage);
		}
		
		return output;
	}
	
	public static double requestDouble(String requestMessage) throws IOException
	{
		System.out.print(requestMessage);
		
		String input = consoleReader.readLine().trim();
		
		double output;
		
		try
		{
			output = Double.parseDouble(input);
		}
		catch(NumberFormatException e)
		{
			Program.print("Your input was not a Double (\"%s\")\n, please try again.", input);
			return requestDouble(requestMessage);
		}
		
		return output;
	}
	
	public static ArrayList<Double> requestDoublesToCapacity
	(
			String requestMessage,
			int wantedSize
	) 
	throws IOException
	{
		ArrayList<Double> container = new ArrayList<>();
		
		requestDoublesToCapacity(
				requestMessage,
				container,
				wantedSize
		);
		
		return container;
	}
	
	public static void requestDoublesToCapacity
	(
			String requestMessage, 
			ArrayList<Double> container, 
			int wantedSize
	) 
	throws IOException
	{
		Program.print(requestMessage);
		
		do
		{
			try 
			{
				ArrayList<Double> subcontainer = Tools.parseLineToArrayOfDoubles(consoleReader.readLine());
				container.addAll(subcontainer);
			}
			catch(NumberFormatException n)
			{
				Program.print(
						"Your input in the line above contained at least one non-double value.\n"
					+	"None of the values in the above line were added, please input them again and proceed.\n"
				);
			}
		}
		while(container.size() < wantedSize);
		
		trimArrayToGivenSize(container, wantedSize);
	}
	
	public static Polynominal createPolynominalFromInputLine( String requestMessage ) throws IOException
	{
		ArrayList<Double> container;
		Program.print(requestMessage);
		try
		{
			container = parseLineToArrayOfDoubles(consoleReader.readLine());
		}
		catch(NumberFormatException e)
		{
			Program.print("You have made a mistake, please try again.");
			return createPolynominalFromInputLine(requestMessage);
		}
		return Polynominal.simpleInterpret(container);
	}
	
	public static double absoluteValueOf(double x)
	{
		return x * ( x > 0 ? 1 : -1 );
	}
	
}
