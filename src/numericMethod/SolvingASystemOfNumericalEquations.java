package numericMethod;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
			    
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
			System.out.print("Numbers of Rows in Polynominals Matrix: ");
			rows = Integer.parseInt(br.readLine());
		
			System.out.print("Numbers of Columns in Polynominals Matrix: ");
			columns = Integer.parseInt(br.readLine());
			    
			if(rows != columns) 
			{
				Program.print("Cannot calculate a determinant of non-square matrix,"
						+ " therefore cannot solve the System of Numerical Equations.");
				return;
			}
				
			ArrayList<Double> numbers = new ArrayList<>();
			do
			{
				numbers.addAll(Tools.parseLineToArrayOfDoubles(br.readLine()));
			} while(numbers.size() < rows * columns);
			
			
			Matrix 
				matrix = new Matrix(rows, columns, Tools.trimArrayToGivenSize(numbers, rows * columns));
			
			double mainDet = matrix.getDeterminant();
			if(mainDet == 0)
			{
				Program.print("Determinant of the main matrix is 0, so there is no"
						+ " concrete solution to the given System of Numerical Equations.");
				return;
			}
			
			numbers = new ArrayList<>();
			
			Program.print("Now please provide a vector of %d solutions to the given Polynominals Matrix.", rows);
			
			do
			{
				numbers.addAll(Tools.parseLineToArrayOfDoubles(br.readLine()));
			} while(numbers.size() < rows);
			
			numbers = Tools.trimArrayToGivenSize(numbers, rows);
			
			Program.print("--------------------------------------------");
		
			Program.print("\n%s\n", matrix);
			
			for(double number: numbers)
			{
				Program.print("%f", number);
			}

			Program.print("\n");
			
			for(int i = 0; i < rows; i++)
			{
				Matrix resultMatrix = matrix.clone();
				resultMatrix.setColumn(i, numbers);
				

				//Program.print("%s\n", resultMatrix);
								
				double det = resultMatrix.getDeterminant();

				Program.print("x%d = %f / %f = %f\n", i+1, det, mainDet, det/mainDet);
			}

			Program.print("--------------------------------------------");
		}
		catch(Exception e)
		{
			Program.print("Ding dong something's wrong.");
			e.printStackTrace();
		}
	}

}
