package numericMethod;

import java.io.IOException;
import java.util.ArrayList;

import core.Matrix;
import core.Program;
import core.ProgramException;
import core.Tools;

public class SolvingASystemOfNumericalEquations extends NumericalMethod
{

	@Override
	protected void begin() throws IOException, ProgramException
	{
		Program.print("--------------------------------------------");

		Matrix matrix = Tools.requestSquareMatrix();

		double mainDet = matrix.getDeterminant();
		
		if (mainDet == 0)
		{
			Program.print("Determinant of the main matrix is 0, so there is no concrete\n"
					+ "solution to the given System of Numerical Equations.");
			return;
		}

		ArrayList<Double> numbers = 
		Tools.requestDoublesToCapacity(
			String.format(
				"Now please provide a vector of %d solutions to the given Polynominals Matrix.", 
				matrix.rows
			),
			matrix.rows
		);

		Program.print("--------------------------------------------\n%s\n", matrix);

		for (double number : numbers)
		{
			Program.print("%f", number);
		}

		Program.print("\n");

		for (int i = 0; i < matrix.rows; i++)
		{
			Matrix resultMatrix = matrix.clone();
			resultMatrix.setColumn(i, numbers);

			// Program.print("%s\n", resultMatrix);

			double det = resultMatrix.getDeterminant();

			Program.print("x%d = %f / %f = %f\n", i + 1, det, mainDet, det / mainDet);
		}

		Program.print("--------------------------------------------");

	}

}
