package numericMethod;

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
		   
			rows = Tools.requestInteger("Numbers of Rows in Matrix: ");
	
			columns = Tools.requestInteger("Numbers of Columns in Matrix: ");
		    
			if(rows != columns) 
			{
				Program.print("Cannot calculate a determinant of non-square matrix.");
				return;
			}
			
			ArrayList<Double> numbers = 
			Tools.requestDoublesToCapacity(
					String.format(
							"Please write down %d real numbers being the entries of the matrix.\n"
						+ 	"Use the \"SPACE\" or \"ENTER\" key between each pair of entries.", rows*columns
					), 
					rows*columns
			);
						
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
