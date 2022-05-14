package numericMethod;

import java.io.IOException;

import core.Matrix;
import core.Program;
import core.ProgramException;
import core.Tools;

public class CalculatingTheDeterminantOfAMatrix extends NumericalMethod
{

	@Override
	protected void begin()
	{
		Matrix matrix;
		try
		{
			Program.print("--------------------------------------------");

			matrix = Tools.requestSquareMatrix();

			Program.print("\nDeterminant of the given matrix\n\n%s\n\nis '%f'.", matrix, matrix.getDeterminant());

			Program.print("--------------------------------------------");
			
		} 
		catch (IOException e)
		{
			Program.print("An unexpected I/O Exception caught. Returning to main menu.");
		}
		catch (ProgramException e)
		{
			Program.print(e.getMessage());
		}

	}

}
