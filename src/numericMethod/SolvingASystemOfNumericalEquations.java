package numericMethod;

import java.util.ArrayList;

import core.Matrix;
import core.Program;
import core.Tools;

public class SolvingASystemOfNumericalEquations extends NumericalMethod
{

	@Override
	public void begin()
	{
		try {
			int columns, rows;
			
			Program.print("--------------------------------------------");
		   
			rows = Tools.requestInteger("Numbers of Rows in Matrix: ");
	
			columns = Tools.requestInteger("Numbers of Columns in Matrix: ");
		   
			if( rows != columns ) 
			{
				Program.print("Cannot calculate a determinant of non-square matrix,"
						+ " therefore cannot solve the System of Numerical Equations.");
				return;
			}

			ArrayList<Double> numbers = 
				Tools.requestDoublesToCapacity(
					String.format(
							"Please write down %d real numbers being the entries of the matrix.\n"
						+ 	"Use the \"SPACE\" or \"ENTER\" key between each pair of entries.", rows*columns
					), 
					rows * columns
			);
	
			Matrix 
				matrix = new Matrix(rows, columns, numbers);
			
			double mainDet = matrix.getDeterminant();
			if( mainDet == 0 )
			{
				Program.print(
							"Determinant of the main matrix is 0, so there is no concrete\n"
						+	"solution to the given System of Numerical Equations.");
				return;
			}
			
			numbers =
			Tools.requestDoublesToCapacity(
						String.format( 
							"Now please provide a vector of %d solutions to the given Polynominals Matrix.", 
							rows 
						), 						
						rows
			);
			
			Program.print( "--------------------------------------------\n%s\n", matrix );
			
			for( double number: numbers )
			{
				Program.print("%f", number);
			}

			Program.print("\n");
			
			for( int i = 0; i < rows; i++ )
			{
				Matrix resultMatrix = matrix.clone();
				resultMatrix.setColumn( i, numbers );
				
				//Program.print("%s\n", resultMatrix);
								
				double det = resultMatrix.getDeterminant();

				Program.print( "x%d = %f / %f = %f\n", i+1, det, mainDet, det/mainDet );
			}

			Program.print( "--------------------------------------------" );
		}
		catch( Exception e )
		{
			Program.print("Ding dong something's wrong.");
			e.printStackTrace();
		}
	}

}
