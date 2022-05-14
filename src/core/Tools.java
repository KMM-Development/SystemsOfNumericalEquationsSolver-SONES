package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Tools
{
	
	private static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
	
	public static ArrayList<Double> parseLineToArrayOfDoubles(String input)
	throws NumberFormatException, NullPointerException
	{
		String[] split = deleteAdditionalSpaces(input).split(" ");
		
		ArrayList<Double> output = new ArrayList<Double>();
		for(String s: split)
		{
			if(s.isEmpty()) continue;
			output.add(Double.parseDouble(s));
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
		        System.out.print("\033[H\033[2J");
		        System.out.flush();
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
				String.format(
					"Number provided is out of the acceptable scope [%d-%d],\n"
				+	"please provide a correct number: ", minVal, maxVal
				),
				minVal, maxVal
			);
		}
		return output;
	}
	
	public static int requestInteger(String requestMessage) throws IOException
	{
		System.out.print(requestMessage);
		
		String input = deleteAdditionalSpaces(consoleReader.readLine());
		
		int output;
		
		try
		{
			output = Integer.parseInt(input);
		}
		catch(NumberFormatException e)
		{
			Program.print("Your input was not an Integer (\"%s\"),\n please try again.", input);
			return requestInteger(requestMessage);
		}
		
		return output;
	}
	
	public static double requestDouble(String requestMessage) throws IOException
	{
		System.out.print(requestMessage);
		
		String input = deleteAdditionalSpaces(consoleReader.readLine());
		
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
				String message;
				Program.print(
						"Your input in the line above contained at least one non-double value. (%s)\n"
					+	"None of the values in the above line were added, please input them again and proceed.\n", 
						(message = n.getMessage()).substring(message.indexOf(':')+2)
				);
			}
		}
		while(container.size() < wantedSize);
		
		trimArrayToGivenSize(container, wantedSize);
	}
	
	public static Polynominal createPolynominalFromInputLineWithStandardMessage() throws IOException
	{
		return createPolynominalFromInputLine(
				"Write down the numbers standing next to the powers of x in the descending order,\n"
			+	"down to the one next to x^0. (for example, y = x^2 + 2x + 3 would be written down as '1 2 3')\n"
			+	"Use the \"SPACE\" key between each pair of numbers.\n"
		);
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
	
	public static Matrix requestSquareMatrix()
	throws IOException, ProgramException
	{
		int rows = Tools.requestInteger("Numbers of Rows in Matrix: ");
		
		int columns = Tools.requestInteger("Numbers of Columns in Matrix: ");
	   
		if( rows != columns ) 
		{

			throw new ProgramException("Cannot calculate a determinant of non-square matrix.");
		}

		ArrayList<Double> numbers = 
			Tools.requestDoublesToCapacity(
				String.format(
						"Please write down %d real numbers being the entries of the matrix.\n"
					+ 	"Use the \"SPACE\" or \"ENTER\" key between each pair of entries.", rows*columns
				), 
				rows * columns
		);

		return new Matrix(rows, columns, numbers);
	}
	
	private static String deleteAdditionalSpaces(String input)
	{
		return input.replace("[ ][ ]+", " ");
	}
	
	public static double absoluteValueOf(double x)
	{
		return x * ( x > 0 ? 1 : -1 );
	}
	
}
