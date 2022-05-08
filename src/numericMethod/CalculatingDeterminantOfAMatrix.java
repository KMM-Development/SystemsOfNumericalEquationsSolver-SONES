package numericMethod;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import core.Matrix;
import core.Program;
import core.Tools;

public class CalculatingDeterminantOfAMatrix extends NumericalMethod
{

	// TODO obsługa wyjątków
	@Override
	public void begin()
	{
		int columns, rows;
		
		try 
		{
			Program.print("--------------------------------------------");
		    
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
			System.out.print("Numbers of Rows in Matrix: ");
			rows = Integer.parseInt(br.readLine());
	
			System.out.print("Numbers of Columns in Matrix: ");
			columns = Integer.parseInt(br.readLine());
		    
			if(rows != columns) 
			{
				Program.print("Cannot calculate a determinant of non-square matrix.");
				return;
			}
			
			ArrayList<Double> numbers = new ArrayList<>();
			do
			{
				numbers.addAll(Tools.parseLineToArrayOfDoubles(br.readLine()));
			} while(numbers.size() < rows * columns);
						
			Matrix matrix = new Matrix(rows, columns, numbers);
			
			Program.print("\nDeterminant of the given matrix\n\n%s\n\nis '%f'.", matrix, matrix.getDeterminant());
						
			Program.print("--------------------------------------------");
		
		}
		catch(Exception e)
		{
			Program.print("Ding dong something's wrong.");
			e.printStackTrace();
		}
	}

}
